package sunrise.matrix;

import java.util.Random;

public final class SMatrix {
    private static Random random = new Random();
    public final int COLUMNS, ROWS;
    private double[][] values;

    private SMatrix(double[][] values) {
        if(values.length == 0) {
            COLUMNS = 0;
            ROWS = 0;
            this.values = new double[0][0];

            return;
        }

        ROWS = values.length;
        COLUMNS = values[0].length;
        this.values = new double[ROWS][COLUMNS];

        for(int i = 0; i < ROWS; i++) {
            int longestColumn = COLUMNS > values[i].length ? COLUMNS : values[i].length;

            for(int j = 0; j < longestColumn; j++) {
                this.values[i][j] = values[i][j];
            }
        }
    }

    public static SMatrix getInstance(double[][] values) {
        return new SMatrix(values);
    }

    public static SMatrix getRandomInstance(int rows, int columns) {
        double[][] values = new double[rows][columns];

        for(int i = 0; i < values.length; i++) {
            for(int j = 0; j < values[i].length; j++) {
                values[i][j] = random.nextDouble();
            }
        }

        return new SMatrix(values);
    }

    public static SMatrix add(SMatrix m1, SMatrix m2) throws MatrixSizeException {
        if(m1.ROWS != m2.ROWS || m1.COLUMNS != m2.COLUMNS) {
            throw new MatrixSizeException("Operation \"add\" cannot be applied between matrices of size "
                    + m1.ROWS + " by " + m1.COLUMNS + " and " + m2.ROWS + " by " + m2.COLUMNS);
        }

        double[][] newValues = new double[m1.ROWS][m1.COLUMNS];
        for(int i = 0; i < m1.ROWS; i++) {
            for(int j = 0; j < m1.COLUMNS; j++) {
                newValues[i][j] = m1.values[i][j] + m2.values[i][j];
            }
        }

        return new SMatrix(newValues);
    }

    public static SMatrix subtract(SMatrix m1, SMatrix m2) throws MatrixSizeException {
        if(m1.ROWS != m2.ROWS || m1.COLUMNS != m2.COLUMNS) {
            throw new MatrixSizeException("Operation \"subtract\" cannot be applied between matrices of size "
                    + m1.ROWS + " by " + m1.COLUMNS + " and " + m2.ROWS + " by " + m2.COLUMNS);
        }

        double[][] newValues = new double[m1.ROWS][m1.COLUMNS];
        for(int i = 0; i < m1.ROWS; i++) {
            for(int j = 0; j < m1.COLUMNS; j++) {
                newValues[i][j] = m1.values[i][j] - m2.values[i][j];
            }
        }

        return new SMatrix(newValues);
    }

    public static SMatrix multiply(SMatrix m1, SMatrix m2) throws MatrixSizeException {
        if(m1.COLUMNS != m2.ROWS) {
            throw new MatrixSizeException("Operation \"multiply\" cannot be applied between matrices of size "
                    + m1.ROWS + " by " + m1.COLUMNS + " and " + m2.ROWS + " by " + m2.COLUMNS);
        }

        double[][] newValues = new double[m1.ROWS][m2.COLUMNS];
        for(int i = 0; i < m1.ROWS; i++) {
            for(int j = 0; j < m2.COLUMNS; j++) {
                double sum = 0;

                for(int k = 0; k < m1.COLUMNS; k++) {
                    sum += m1.values[i][k] * m2.values[k][j];
                }

                newValues[i][j] = sum;
            }
        }

        return new SMatrix(newValues);
    }

    public String toString() {
        String s = "[";

        for(int i = 0; i < ROWS; i++) {
            s += "(";

            for(int j = 0; j < COLUMNS; j++) {
                s += values[i][j];

                if(j != COLUMNS - 1) {
                    s += ", ";
                }
            }

            s += ")";

            if(i != ROWS - 1) {
                s += ",\n";
            }
        }

        return s + "]";
    }
}