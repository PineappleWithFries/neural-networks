package sunrise.math;

public enum SBaseActivations implements SActivationFunction {
    Sigmoid;

    public double process(double input) {
        switch(this) {
            case Sigmoid:
                double eToTheX = Math.pow(Math.E, input);
                return eToTheX / (eToTheX + 1);
            default:
                return -1;
        }
    }

    public double processDerivative(double input) {
        switch(this) {
            case Sigmoid:
                double eToTheX = Math.pow(Math.E, input);
                double sigmoid = eToTheX / (eToTheX + 1);
                return sigmoid * (1 - sigmoid);
            default:
                return -1;
        }
    }
}
