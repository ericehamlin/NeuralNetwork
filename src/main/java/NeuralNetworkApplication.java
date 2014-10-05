import com.odiousenterprises.ai.neuralnetwork.LayeredNeuralNetwork;
import com.odiousenterprises.ai.neuralnetwork.NeuralNetwork;

import java.util.*;
/**
 * Created by erichamlin on 10/4/14.
 */
public class NeuralNetworkApplication {
    public static void main(String[] args) {
        NeuralNetwork nn = new LayeredNeuralNetwork(new int[]{3,3,1});
        nn.runIteration(Arrays.<Float>asList( new Float[]{2F, 3F, 4F} ));
    }
}
