package sunrise.math;

import sunrise.matrix.MatrixSizeException;
import sunrise.matrix.SMatrix;

public interface SMatrixFunction {

    public SMatrix process(SMatrix input) throws MatrixSizeException;
}
