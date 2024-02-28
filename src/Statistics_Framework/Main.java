package Statistics_Framework;

import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
public class Main {

    public static void main(String[] args){
        SimulationTemplate sim = new CoinSimulation();
//        Predicate<String> pred = (p) -> p.equals("yerr");
//        Consumer<Integer> sum = (t) -> t = t + 1;
//
//        Function<GeneratorBehavior, Answer> func = (f) -> new Answer<>(f.generate());// I am thinking we switch from predicates to functions to capture the return values that Dr. Baliga wants.
        Main main = new Main();
        sim.simulate(main.getFunction1());
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
}
