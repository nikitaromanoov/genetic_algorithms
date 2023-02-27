package lab2;

import org.uncommons.watchmaker.framework.EvolutionaryOperator;
import org.uncommons.watchmaker.framework.FitnessEvaluator;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class MyMutation implements EvolutionaryOperator<double[]> {
    public List<double[]> apply(List<double[]> population, Random random) {
        // initial population
        // need to change individuals, but not their number!
        for (int i = 0; i < Math.floor(population.size()/8); i++) {
            int index = ThreadLocalRandom.current().nextInt(0, population.size());
            double[] news = population.get(index);
            for (int j = 0; j < Math.floor(news.length/8); j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, news.length);
                // System.out.println(randomNum);
                //news[randomNum] = ThreadLocalRandom.current().nextDouble(-5, 5);
                double change = ThreadLocalRandom.current().nextDouble(-0.5, 0.5);
                if (news[randomNum] + change > 5) {
                    news[randomNum] = 5;
                } else if (news[randomNum] + change < -5) {
                    news[randomNum] = -5;
                } else {
                    news[randomNum] = news[randomNum] + change;
                }
            }
            population.set(index, news);
            //System.out.println(Arrays.toString(news));
        }
        for (int i = 0; i < Math.floor(population.size()/16); i++) {
            int index = ThreadLocalRandom.current().nextInt(0, population.size());
            double[] news = population.get(index);
            for (int j = 0; j < Math.floor(news.length/2); j++) {
                int randomNum = ThreadLocalRandom.current().nextInt(0, news.length);
                news[randomNum] = ThreadLocalRandom.current().nextDouble(-5, 5);
            }
            population.set(index, news);
        }



        // your implementation:

        //result population
        return population;
    }
}
