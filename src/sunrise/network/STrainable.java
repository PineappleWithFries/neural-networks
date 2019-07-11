package sunrise.network;

import sunrise.math.SMatrixFunction;
import sunrise.matrix.SMatrix;

public interface STrainable extends SMatrixFunction {
    public void train(SMatrix input, SMatrix expectedOutput);
}
