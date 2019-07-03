package sunrise.matrix;

import java.util.Random;

public class SMatrix {
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

        COLUMNS = values.length;
        ROWS = values[0].length;
        this.values = new double[COLUMNS][ROWS];

        for(int i = 0; i < COLUMNS; i++) {
            int longestRow = ROWS > values[COLUMNS].length ? ROWS : values[ROWS].length;

            for(int j = 0; j < longestRow; j++) {
                values[i][j] = values[i][j];
            }
        }
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

    public static SMatrix getColumnInstance(double[] columnValues) {
        double[][] values = new double[1][columnValues.length];

        values[0] = columnValues;

        return new SMatrix(values);
    }

    public static SMatrix getRowInstance(double[] rowValues) {
        double[][] values = new double[rowValues.length][1];

        for(int i = 0; i < values.length; i++) {
            values[i][0] = rowValues[i];
        }

        return new SMatrix(values);
    }

    public static SMatrix getRandomInstance(int columns, int rows) {
        double[][] values = new double[columns][rows];

        for(int i = 0; i < values.length; i++) {
            for(int j = 0; j < values[i].length; j++) {
                values[i][j] = random.nextDouble();
            }
        }

        return new SMatrix(values);
    }
}