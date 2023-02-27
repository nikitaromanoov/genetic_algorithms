package lab2;

import org.uncommons.watchmaker.framework.factories.AbstractCandidateFactory;
import java.lang.Math;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class MyFactory extends AbstractCandidateFactory<double[]> {

    private int dimension;

    public MyFactory(int dimension) {
        this.dimension = dimension;
    }

    public double[] generateRandomCandidate(Random random) {
        double[] solution = new double[dimension];
        for (int i = 0; i < solution.length; i++) {
            solution[i] = ThreadLocalRandom.current().nextDouble(-5, 5);
            // double randomNum = ThreadLocalRandom.current().nextInt(1, 3+1);
            // ThreadLocalRandom.current().nextDouble(-5, 5);
        }
        // x from -5.0 to 5.0

        // your implementation:

        return solution;
    }
}

