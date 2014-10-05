package com.odiousenterprises.ai.neuralnetwork;

/**
 * Created by erichamlin on 10/4/14.
 */
interface Receiver {
    void receiveInput(Sender sender, Float inputValue);
}
