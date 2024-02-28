package Statistics_Framework;

import java.util.function.Function;

public class DiceSimulation extends SimulationTemplate{
    private GeneratorBehavior<Integer> diceGenerator;

    @Override
    public void setup() {
        diceGenerator = new DiceGeneratorBehavior();
    }

    @Override
    public void run(Function function) {
        answer = (Answer) function.apply(diceGenerator);

    }

    @Override
    public void displayResults() {
        System.out.println("The Answer to your function was: " + answer.getAnswer());
    }
}
