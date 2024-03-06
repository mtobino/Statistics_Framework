package Statistics_Framework;

import java.util.function.Function;
public class Main {

    public static void main(String[] args) {
        SimulationTemplate coinSimulation = new CoinSimulation();
        SimulationTemplate diceSimulation = new DiceSimulation();


        Main main = new Main();
        coinSimulation.simulate(main.getTenCoinsInARow(), "On average, how many coin tosses till I get 10 heads in a row?");
        System.out.println();
        diceSimulation.simulate(main.getCompSumOfFourBeforeEight(), "What is the probability I roll a dice computational sum of 4 before an 8?");
        System.out.println();
        coinSimulation.simulate(main.getCompSumOfFourWithCoin(), "On average, how many coin tosses till I get a computational sum of 4 if heads is equal to 1 and tails is equal to -1?");
    }


    /**
     * This method answers the following
     * question from Canvas and implements it using the framework :
     * "Repeatedly toss a fair coin until you observe 10 consecutive heads.
     * Compute the average number of tosses needed until the run of 10 heads is obtained.
     * @return
     */

    public Function<CoinGeneratorBehavior, Answer<Integer>> getTenCoinsInARow(){
        return (generatorBehavior -> {
            final int TIMES_TO_RUN = 20;
            int[] tossesTaken = new int[TIMES_TO_RUN];
            int average = 0;

            int tosses, heads;
            for(int i = 0; i < TIMES_TO_RUN; i++){
                tosses = 0;
                heads = 0;
                while (heads < 10) {
                    if(generatorBehavior.generate()) { // true = heads
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

            return new Answer<>(average);
        });
    }

    /**
     * This method answers the following
     * question from Canvas and implements it using the framework :
     * "Roll a pair of fair 6-sided dice until their sum is either 4 or 8.
     * Compute the probability that you get a 4 before you get an 8"
     * @return
     */
    public Function<DiceGeneratorBehavior, Answer<Double>> getCompSumOfFourBeforeEight(){
        return (diceGenerator -> {
            int fourCount = 0;
            final int TIMES_TO_RUN = 500;

            int roll;
            for(int i = 0; i < TIMES_TO_RUN; i++) {
                do {
                    roll = diceGenerator.generate() + diceGenerator.generate();
                } while (roll != 4 && roll != 8);
                if(roll == 4) { fourCount++; }
            }

            return new Answer<>(( (double) fourCount / (double) TIMES_TO_RUN * 100.0));
        });

    }

    /**
     * This method below demonstrates the usage
     * of implementing this framework for a problem outside of
     * what is asked to be found in the Canvas Problems #1 and #2
     * @return
     */

    public Function<CoinGeneratorBehavior, Answer<Integer>> getCompSumOfFourWithCoin(){
        return (coinGeneratorBehavior -> {
            final int TIMES_TO_RUN = 30;
            int[] tossesTaken = new int[TIMES_TO_RUN];
            int average = 0;

            // if heads add 1, if tails - 1
            int tossSum;
            for(int i = 0; i < TIMES_TO_RUN; i++)
            {
                tossSum = 0;
                boolean sumIsFour = false;
                int tosses = 0;
                while(!sumIsFour)
                {
                    // if the coin was heads, add one, otherwise subtract one
                    tossSum += coinGeneratorBehavior.generate() ? 1 : -1;
                    sumIsFour = tossSum == 4;
                    tosses++;
                }
                tossesTaken[i] = tosses;
                average += tosses;
            }
            average /= TIMES_TO_RUN;

            System.out.print("Tosses taken to reach a Computational Sum of 4: { ");
            for(int i = 0; i < TIMES_TO_RUN; i++) {
                if (i < TIMES_TO_RUN - 1) { System.out.print(tossesTaken[i] + ", ");
                } else { System.out.println(tossesTaken[i] + " }"); }
            }
            return new Answer<>(average);
        });

    }
}
