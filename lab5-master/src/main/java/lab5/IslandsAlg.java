package lab5;

import org.uncommons.watchmaker.framework.*;
import org.uncommons.watchmaker.framework.islands.IslandEvolution;
import org.uncommons.watchmaker.framework.islands.IslandEvolutionObserver;
import org.uncommons.watchmaker.framework.islands.RingMigration;
import org.uncommons.watchmaker.framework.operators.EvolutionPipeline;
import org.uncommons.watchmaker.framework.termination.GenerationCount;
import org.uncommons.watchmaker.framework.selection.RankSelection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class IslandsAlg {

    public static void main(String[] args) {
        long t1 = System.nanoTime();
        int dimension = 100; // dimension of problem
        int complexity = 4; // fitness estimation time multiplicator
        int populationSize = 50; // size of population
        int generations = 1000; // number of generations

        Random random = new Random(); // random

        CandidateFactory<double[]> factory = new MyFactory(dimension); // generation of solutions

        ArrayList<EvolutionaryOperator<double[]>> operators = new ArrayList<EvolutionaryOperator<double[]>>();
        operators.add(new MyCrossover()); // Crossover
        operators.add(new MyMutation()); // Mutation
        EvolutionPipeline<double[]> pipeline = new EvolutionPipeline<double[]>(operators);

        SelectionStrategy<Object> selection = new RankSelection(); // Selection operator

        FitnessEvaluator<double[]> evaluator = new MultiFitnessFunction(dimension, complexity); // Fitness function


        RingMigration migration = new RingMigration();
        IslandEvolution<double[]> island_model = new IslandEvolution<double[]>(
                2, migration, factory, pipeline,evaluator, selection, random); // your model;

        island_model.addEvolutionObserver(new IslandEvolutionObserver() {
            public void populationUpdate(PopulationData populationData) {
                double bestFit = populationData.getBestCandidateFitness();
                System.out.println("Epoch " + populationData.getGenerationNumber() + ": " + bestFit);
                System.out.println("\tEpoch best solution = " + Arrays.toString((double[])populationData.getBestCandidate()));
            }

            public void islandPopulationUpdate(int i, PopulationData populationData) {
                double bestFit = populationData.getBestCandidateFitness();
                System.out.println("Island " + i);
                System.out.println("\tGeneration " + populationData.getGenerationNumber() + ": " + bestFit);
                System.out.println("\tBest solution = " + Arrays.toString((double[])populationData.getBestCandidate()));
            }
        });

        TerminationCondition terminate = new GenerationCount(generations);
        island_model.evolve(populationSize, 1, 100, 2, terminate);
        long t2 = System.nanoTime();
        long t = t2 - t1;
        System.out.println(t / 1000000);
    }
}
