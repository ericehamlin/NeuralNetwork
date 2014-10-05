package com.odiousenterprises.ai.neuralnetwork;

import java.lang.Math;

/**
 * Created by erichamlin on 10/4/14.
 */
public class SigmoidActivationFunction extends ActivationFunction {

    Float p = 1.0F;

    public SigmoidActivationFunction(Float p) {
        this.p = p;
    }

    Float calculate(Float weightedSum) {
        double sigmoidResult = 1 / ( 1 + Math.exp( (double)(-weightedSum/p) ) );
        return (float)sigmoidResult;
    }
}
