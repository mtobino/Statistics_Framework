package Statistics_Framework;

// import java.util.function.Function;
import java.util.function.BiFunction;

/**
 * Dice Simulation implementation of the Simulation template
 */
public class DiceSimulation extends SimulationTemplate{
    private GeneratorBehavior<Integer> diceGenerator;

    @Override
    public void setup() {
        diceGenerator = new DiceGeneratorBehavior();
    }

    @Override
    public void run(BiFunction function, Object[] args) {
        answer = (Answer) function.apply(diceGenerator, args);
    }

    @Override
    public void displayResults() {
        System.out.println("The Answer to your function was: " + answer.getAnswer());
    }
}
