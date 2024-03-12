package Statistics_Framework;

import java.util.function.Function;

public class Trial {
    private Function<GeneratorBehavior, Double> trial;

    public Trial(Function<GeneratorBehavior, Double> trial){
        this.trial = trial;
    }

    public Function<GeneratorBehavior, Double> getTrial() {
        return trial;
    }
    public Double runTrial(GeneratorBehavior generatorBehavior){
        return trial.apply(generatorBehavior);
    }
}
