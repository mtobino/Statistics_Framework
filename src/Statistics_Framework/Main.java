package Statistics_Framework;

public class Main {

    public static void main(String[] args){
        SimulationTemplate coinSim = new CoinSimulation();
        SimulationTemplate diceSim = new DiceSimulation();

        // arguments -> [boolean consecutive, boolean tracked face, int amount, int trials]
        Object[] coinArguments = {true, true, 10, 20};

        // arguments -> [int amount of dice, int trials, int first sum, int second sum]
        Object[] diceArguments = {2, 500, 4, 8}; // if second sum = -1, tracks rolls to reach first sum

        Problems problems = new Problems();
        coinSim.simulate(problems.coinProblem(), coinArguments); // consecutive 10 heads
        System.out.println();
        diceSim.simulate(problems.diceProblem(), diceArguments); // roll 4 before 8
    }
}
