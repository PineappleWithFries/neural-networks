package sunrise.network.layer;

import sunrise.math.SActivationFunction;
import sunrise.math.SMatrixFunction;
import sunrise.matrix.MatrixSizeException;
import sunrise.matrix.SMatrix;

public class SLayer implements SMatrixFunction {
    public SMatrix weights;
    public SActivationFunction function;

    public SLayer(int inputSize, int outputSize, SActivationFunction function) {
        this.weights = SMatrix.getRandomInstance(inputSize, outputSize);
        this.function = function;
    }

    public SMatrix process(SMatrix input) throws MatrixSizeException {
        return SMatrix.multiply(input, weights);
    }
}
