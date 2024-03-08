package Statistics_Framework;

import java.util.function.Function;
public class Main {

    public static void main(String[] args) {
        SimulationTemplate coinSimulation = new CoinSimulation();
        SimulationTemplate diceSimulation = new DiceSimulation();


        Main main = new Main();
        coinSimulation.simulate(main.getTenCoinsInARowTrial(), "On average, how many coin tosses till I get 10 heads in a row?", 500);
        System.out.println();
        diceSimulation.simulate(main.getCompSumOfFourBeforeEightTrial(), "What is the probability I roll a dice computational sum of 4 before an 8?", 500, true);
        System.out.println();
        coinSimulation.simulate(main.getCompSumOfFourWithCoinTrial(), "On average, how many coin tosses till I get a computational sum of 4 if heads is equal to 1 and tails is equal to -1?");
    }


    /**
     * This method answers the following
     * question from Canvas and implements it using the framework :
     * "Repeatedly toss a fair coin until you observe 10 consecutive heads.
     * Compute the average number of tosses needed until the run of 10 heads is obtained.
     * @return
     */
    public Function<CoinGeneratorBehavior, Double> getTenCoinsInARowTrial(){
        return(coinGeneratorBehavior -> {
            double average = 0;
            int tosses = 0;
            int heads = 0;
            while (heads < 10) {
                if(coinGeneratorBehavior.generate()) { // true = heads
                    heads++;
                } else { // false = tails
                    heads = 0;
                }
                tosses++;
            }
            //tossesTaken[i] = tosses;
            average += tosses;
            return average;
        });
    }

    /**
     * This method answers the following
     * question from Canvas and implements it using the framework :
     * "Roll a pair of fair 6-sided dice until their sum is either 4 or 8.
     * Compute the probability that you get a 4 before you get an 8"
     * @return
     */
    public Function<DiceGeneratorBehavior, Double> getCompSumOfFourBeforeEightTrial(){
        return (diceGenerator -> {
            double fourCount = 0;
            int roll;

                do {
                    roll = diceGenerator.generate() + diceGenerator.generate();
                } while (roll != 4 && roll != 8);
                if(roll == 4) { fourCount++; }

            return fourCount;
        });

    }

    /**
     * This method below demonstrates the usage
     * of implementing this framework for a problem outside of
     * what is asked to be found in the Canvas Problems #1 and #2
     * @return
     */
    public Function<CoinGeneratorBehavior, Double> getCompSumOfFourWithCoinTrial(){
        return (coinGeneratorBehavior -> {
            int tossSum = 0;
            boolean sumIsFour = false;
            double tosses = 0;
            while(!sumIsFour)
            {
                // if the coin was heads, add one, otherwise subtract one
                tossSum += coinGeneratorBehavior.generate() ? 1 : -1;
                sumIsFour = tossSum == 4;
                tosses++;
            }
            return tosses;
        });
    }
}
