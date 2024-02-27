package Statistics_Framework;

import java.util.function.Function;

/**
 * Coin Simulation implementation of the Simulation template.
 * Simulates how many tosses it takes to get 10 consecutive heads.
 */
public class TenHeadsSimulation extends SimulationTemplate {
    private GeneratorBehavior<Boolean> coinGenerator;
    private int[] tossesTaken;
    private int average;
    private final int TIMES_TO_RUN = 20;

    @Override
    public void setup() {
        coinGenerator = new CoinGeneratorBehavior();
        tossesTaken = new int[TIMES_TO_RUN];
        average = 0;
    }

    @Override
    public void run() {
        int tosses, heads;
        for(int i = 0; i < TIMES_TO_RUN; i++){
            tosses = 0;
            heads = 0;
            while (heads < 10) {
                if(coinGenerator.generate()) { // true = heads
                    heads++;
                } else { // false = tails
                    heads = 0;
                }
                tosses++;
            }
            tossesTaken[i] = tosses;
            average += tosses;
        }
        average /= TIMES_TO_RUN;
    }

    @Override
    public void displayResults() {
        System.out.print("Tosses taken to reach 10 heads: { ");
        for(int i = 0; i < TIMES_TO_RUN; i++) {
            if (i < TIMES_TO_RUN - 1) { System.out.print(tossesTaken[i] + ", ");
            } else { System.out.println(tossesTaken[i] + " }"); }
        }
        System.out.println("Average tosses taken: " + average);
    }
}
