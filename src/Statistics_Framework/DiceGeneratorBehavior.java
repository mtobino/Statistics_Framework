package Statistics_Framework;

import java.util.Random;

/**
 * The dice implementation of the generator interface
 */
public class DiceGeneratorBehavior implements GeneratorBehavior<Integer> {
    // needs a random object to run
    private final Random rand = new Random();

    /**
     * Generates a random integer value to represent a dice roll.
     *
     * @return  an integer between 1 and 6.
     */
    public Integer generate() { return rand.nextInt(1,7); }
}
