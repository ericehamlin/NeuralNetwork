package com.odiousenterprises.ai.neuralnetwork;

/**
 * Created by erichamlin on 10/4/14.
 */
public class StepActivationFunction extends ActivationFunction {
    private Float threshold;

    public StepActivationFunction(Float threshold) {
        this.threshold = threshold;
    }

    public StepActivationFunction() {
        this(0F);
    }

    Float calculate(Float weightedSum) {
        if (weightedSum > threshold) {
            return 1.0F;
        }
        else {
            return 0F;
        }
    }
}
