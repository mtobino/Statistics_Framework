package Statistics_Framework;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
public class Main {

    public static void main(String[] args){
        SimulationTemplate coinSimulation = new CoinSimulation();
        SimulationTemplate diceSimulation = new DiceSimulation();

        Main main = new Main();
        coinSimulation.simulate(main.getFunction1());
        diceSimulation.simulate((main.getFunction2()));

    }

    public Function<GeneratorBehavior<Boolean>, Answer> getFunction1(){
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

            System.out.print("Tosses taken to reach 10 heads: { ");
            for(int i = 0; i < TIMES_TO_RUN; i++) {
                if (i < TIMES_TO_RUN - 1) { System.out.print(tossesTaken[i] + ", ");
                } else { System.out.println(tossesTaken[i] + " }"); }
            }
            return new Answer(average);
        });
    }

    public Function<GeneratorBehavior<Integer>, Answer> getFunction2(){
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

            System.out.println("Probability of rolling a 4 before an 8: " +
                    ( (double) fourCount / (double) TIMES_TO_RUN * 100.0) + "%"
            );
            return new Answer(( (double) fourCount / (double) TIMES_TO_RUN * 100.0));
        });

    }
}
