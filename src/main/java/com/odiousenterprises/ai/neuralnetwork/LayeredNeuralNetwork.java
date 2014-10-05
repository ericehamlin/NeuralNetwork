package com.odiousenterprises.ai.neuralnetwork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by erichamlin on 10/4/14.
 */
public class LayeredNeuralNetwork
        extends NeuralNetwork
        implements Receiver, Sender {

    private List<List<Neuron>> layers = new ArrayList<>();

    public LayeredNeuralNetwork(int[] layerDimensions) {
        // layered neural network
        for (int i = 0; i<layerDimensions.length; i++) {
            int layerDimension = layerDimensions[i];
            List<Neuron> layer = new ArrayList<>();
            for (int j = 0; j < layerDimension; j++) {
                Neuron neuron = new Neuron();
                if (i==0) {
                    neuron.addSender(this);
                }
                else {
                    for (Neuron prevLayerNeuron : layers.get(i - 1)) {
                        neuron.addSender(prevLayerNeuron);
                    }
                }
                if (i == layerDimensions.length - 1) {
                    neuron.registerReceiver(this);
                }
                layer.add(neuron);
            }
            layers.add(i, layer);
        }
    }

    /**
     *
     * @param input
     * @return
     */
    public void runIteration(List<Float> input) {
        int i = 0;
        for (Float f : input) {
            Neuron inputNeuron = layers.get(0).get(i);
            inputNeuron.receiveInput(this, f);
            i++;
        }
    }

    /**
     *
     * @param s
     * @param v
     */
    @Override
    public void receiveInput(Sender s, Float v) {
        System.out.printf("Sender %s Value %f \n", s.toString(), v);
    }


    @Override
    public void sendOutput(Float outputValue) {
    }

    /**
     *
     * @param r
     */
    @Override
    public void registerReceiver(Receiver r) {

    }
}
