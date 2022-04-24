import java.util.Scanner;

public class fib {
    public static long[][] ident_matrix(int n) {
        long[][] I = new long[n][n];
        for (int i = 0; i < I.length; i++) {
            I[i][i] = 1;
        }
        return I;
    }

    public static long[][] mult_matrix(long[][] A, long[][] B) {
        if (A.length != B[0].length) {
            throw new ArithmeticException("Matrix are incorrect");
        }
        long[][] mult = new long[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int u = 0; u < B[0].length; u++) {
                for (int j = 0; j < B.length; j++) {
                    mult[i][u] += A[i][j] * B[j][u];
                }
            }
        }
        return mult;
    }

    public static long[][] pow_matrix(long[][] x, int n, long[][] I) {
        long[][] y;
        if (n == 0) {
            return I;
        } else if (n == 1) {
            return x;
        } else {
            y = pow_matrix(x, n / 2, I);
            y = mult_matrix(y, y);
            if (n % 2 == 1) {
                y = mult_matrix(x, y);
            }
            return y;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите порядкоывый номер (меньше, либо равный 93) числа Фибоначчи, до которого будет продолжаться вывод:");
        int n = in.nextInt();
        long[][] x = {{1, 1}, {1, 0}};
        if (n < 1) {
            throw new ArithmeticException("Номер должен быть больше, либо равен 1.");
        }
        for (int i = 1; i <= n; i++) {
            long[][] f = pow_matrix(x, i - 1, ident_matrix(2));
            System.out.print(f[1][0] + " ");
        }
    }
}
