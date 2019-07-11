package sunrise.tests;

import sunrise.matrix.MatrixSizeException;
import sunrise.matrix.SMatrix;

public class SMatrixTest {
    public static void main(String args[]) throws MatrixSizeException {

        double[][] values = new double[2][];
        double[] inter1 = {2, 3};
        double[] inter2 = {4, 6};
        values[0] = inter1;
        values[1] = inter2;

        double[][] testValues = {{1, 2}, {3, 4}};
        SMatrix matrix = SMatrix.getInstance(testValues);
        System.out.println(SMatrix.multiply(matrix, matrix));
    }
}
