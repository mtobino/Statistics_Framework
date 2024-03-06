package Statistics_Framework;

import java.util.function.Function;

public class DiceSimulation extends SimulationTemplate{
    @Override
    public void setup() {
        generatorBehavior = new DiceGeneratorBehavior();
    }
}
