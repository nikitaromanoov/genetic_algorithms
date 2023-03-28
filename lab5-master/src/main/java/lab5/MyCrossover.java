package lab5;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MyCrossover extends AbstractCrossover<double[]> {
    protected MyCrossover() {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int i, Random random) {
        ArrayList children = new ArrayList();
        double[] child = new double[p1.length];
        double alpha = 0.5;
        for (int j = 1; j < p1.length; j++) {
            if (ThreadLocalRandom.current().nextInt(0, 2) == 0){
                child[j] = p2[j];
            } else {
                child[j] = alpha * p2[j] +p1[j] * (1 - alpha);
            }
        }

        children.add(child);
        return children;
    }
}
