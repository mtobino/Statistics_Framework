package Statistics_Framework;

/**
 * Dice Simulation implementation of the Simulation template.
 * Simulates the probability that you get a 4 before an 8.
 */
public class Sum4or8Simulation extends SimulationTemplate{
    private GeneratorBehavior<Integer> diceGenerator;
    private int fourCount;
    private final int TIMES_TO_RUN = 500;

    @Override
    public void setup() {
        diceGenerator = new DiceGeneratorBehavior();
        fourCount = 0;
    }

    @Override
    public void run() {
        int roll;
        for(int i = 0; i < TIMES_TO_RUN; i++) {
            do {
                roll = diceGenerator.generate();
            } while (roll != 4 && roll != 8);
            if(roll == 4) { fourCount++; }
        }
    }

    @Override
    public void displayResults() {
        System.out.println("Probability of rolling a 4 before an 8: " +
                ( (double) fourCount / (double) TIMES_TO_RUN * 100.0) + "%"
        );
    }
}
