package ru.job4j.pool;

import java.util.Objects;

public class RolColSum {
    public static class Sums {
        private final int rowSum;
        private final int colSum;
        /* Getter and Setter */

        public Sums(int rowSum, int colSum) {
            this.rowSum = rowSum;
            this.colSum = colSum;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Sums sums = (Sums) o;
            return rowSum == sums.rowSum && colSum == sums.colSum;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rowSum, colSum);
        }

    }

    public static Sums[] sum(int[][] matrix) {
        Sums[] rsl = new Sums[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            rsl[i] = getSums(matrix, i);
        }
        return rsl;
    }

    private static Sums getSums(int[][] array, int index) {
        int rowSum = 0;
        int colSum = 0;
        for (int i = 0; i < array.length; i++) {
            rowSum += array[index][i];
            colSum += array[i][index];
        }
        return new Sums(rowSum, colSum);
    }

/*
    private static CompletableFuture<Sums> getTask(int[][] matrix, int index) {
        return CompletableFuture.supplyAsync(() -> getSums(matrix, index));
    }

 */
}
