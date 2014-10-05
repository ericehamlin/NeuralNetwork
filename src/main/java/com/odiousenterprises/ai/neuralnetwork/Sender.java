package com.odiousenterprises.ai.neuralnetwork;

/**
 * Created by erichamlin on 10/4/14.
 */
interface Sender {
    void sendOutput(Float outputValue);

    void registerReceiver(Receiver receiver);
}
