package com.odiousenterprises.ai.neuralnetwork;

import java.util.*;
/**
 * Created by erichamlin on 10/4/14.
 */
public class Neuron implements Sender, Receiver {
    private Map<Sender, Float> inputWeights = new HashMap<>();
    private Map<Sender, Float> inputValues = new HashMap<>();
    private List<Receiver> receivers = new ArrayList<>();

    private ActivationFunction activationFunction;

    private Float bias;

    public Neuron() {
        this(1.0F);
    }

    public Neuron(Float bias) {
        this(bias, new StepActivationFunction());
    }

    public Neuron(Float bias, ActivationFunction activationFunction) {
        this.bias = bias;
        this.activationFunction = activationFunction;
    }


    void addSender(Sender inputNeuron, Float inputWeight) {
        inputWeights.put(inputNeuron, inputWeight);
        inputNeuron.registerReceiver(this);
    }

    void addSender(Sender inputNeuron) {
        addSender(inputNeuron, 1.0F);
    }

    /**
     *
     * @param receiver
     */
    @Override
    public void registerReceiver(Receiver receiver) {
        receivers.add(receiver);
    }

    /**
     *
     * @param inputNeuron
     * @param inputValue
     */
    @Override
    public void receiveInput(Sender inputNeuron, Float inputValue) {
        inputValues.put(inputNeuron, inputValue);
        if (isInputComplete()) {
            Float outputValue = calculateOutput();
            sendOutput(outputValue);
        }
    }

    /**
     *
     * @param outputValue
     */
    @Override
    public void sendOutput(Float outputValue) {
        for (Receiver receiver : receivers) {
            receiver.receiveInput(this, outputValue);
        }
    }

    /**
     *
     * @return
     */
    private Float calculateOutput() {
        Float weightedSum = 0F;
        for (Map.Entry<Sender, Float> inputWeightEntry :  inputWeights.entrySet()) {
            weightedSum += inputWeightEntry.getValue() * inputValues.get(inputWeightEntry.getKey());
        }
        return calculateActivationValue(weightedSum);
    }

    /**
     *
     * @param weightedSum
     * @return
     */
    private Float calculateActivationValue(Float weightedSum) {

        return activationFunction.calculate(weightedSum);
    }

    /**
     *
     * @return
     */
    private boolean isInputComplete() {

        return inputValues.size() == inputWeights.size();
    }
}
