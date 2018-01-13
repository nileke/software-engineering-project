import java.util.Random;

public class Run {

    public static void main(String[] args) {

        SimulationModel simModel = new SimulationModel(10000);
        new WindowView(simModel);

    }
}
