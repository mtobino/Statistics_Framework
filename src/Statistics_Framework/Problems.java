package Statistics_Framework;

import java.util.function.BiFunction;

public class Problems {

    // BiFunction for variety of problems based on original problem.
    public BiFunction<GeneratorBehavior<Boolean>, Object[], Answer> coinProblem() {
        return (coinGenerator, args) -> {
            boolean consecutive = (boolean) args[0]; // Needs to land on side consecutively
            boolean trackedFace = (boolean) args[1]; // True = heads, False = tails
            int amount = (int) args[2]; // Amount of times coin needs to land on specified side
            int trials = (int) args[3]; // Number of trials to be run

            int[] tossesTaken = new int[trials];

            int tosses, side, average = 0;
            for (int i = 0; i < trials; i++) {
                tosses = 0;
                side = 0;

                while (side < amount) {
                    if (consecutive) {
                        if (coinGenerator.generate()) { // true = heads
                            if (trackedFace) side++;
                            if (!trackedFace) side = 0;
                        } else { // false = tails
                            if (trackedFace) side = 0;
                            if (!trackedFace) side++;
                        }
                    } else {
                        if (coinGenerator.generate()) { // true = heads
                            if (trackedFace) side++;
                        } else { // false = tails
                            if (!trackedFace) side++;
                        }
                    }
                    tosses++;
                }

                tossesTaken[i] = tosses;
                average += tosses;
            }

            average /= trials;

            System.out.print("Tosses taken to reach result: { ");
            for(int i = 0; i < trials; i++) {
                if (i < trials - 1) { System.out.print(tossesTaken[i] + ", ");
                } else { System.out.println(tossesTaken[i] + " }"); }
            }

            return new Answer(average);
        };
    }

    // BiFunction for variety of problems based on original problem
    public BiFunction<GeneratorBehavior<Integer>, Object[], Answer> diceProblem() {
        return (diceGenerator, args) -> {
            int dice = (int) args[0]; // Amount of dice being rolled
            int trials = (int) args[1]; // Amount of trials to be run
            int sum1 = (int) args[2]; // First sum, trial runs until sum is reached
            int sum2 = (int) args[3]; // Second sum for reaching sum first; if -1, only first sum

            // check if sums are too small for amount of dice
            if (dice > sum1 || (dice > sum2 && sum2 != -1)) {
                System.out.println("One of the sums inputted is too low for the amount of dice to roll.");

                return new Answer(-1);
            }

            // no second sum to compare to
            int roll, tosses = 0, average = 0;
            if (sum2 == -1) {
                for (int i = 0; i < trials; i++) {
                    do {
                        roll = 0;
                        for (int j = 0; j < dice; j++) {
                            roll += diceGenerator.generate();
                        }
                        tosses++;
                    } while (roll != sum1);
                    average += tosses;
                }

                average /= trials;

                System.out.println("Average rolls to reach " + sum1 + ": " + average);

                return new Answer(average);
            } else {
                int sumCount = 0;
                for (int i = 0; i < trials; i++) {
                    do {
                        roll = 0;
                        for (int j = 0; j < dice; j++) {
                            roll += diceGenerator.generate();
                        }
                    } while (roll != sum1 && roll != sum2);
                    if (roll == sum1) sumCount++;
                }

                System.out.println("Probability of rolling a " + sum1 + " before a "
                        + sum2 + ": "
                        + ( (double) sumCount / (double) trials * 100.0) + "%"
                );

                return new Answer(( (double) sumCount / (double) trials * 100.0));
            }
        };
    }
}
