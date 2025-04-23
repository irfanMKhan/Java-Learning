package com.topic;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ab {

//    public static int numTrees(int n) {
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//
//        // Compute dp[i] for i = 2 to n
//        for (int nodes = 2; nodes <= n; nodes++) {
//            for (int root = 1; root <= nodes; root++) {
//                dp[nodes] += dp[root - 1] * dp[nodes - root];
//            }
//        }
//
//        return dp[n];
//    }

    private static long binomialCoefficient(int N) {
        long result = 1;
        // Use the multiplicative formula to compute C(2N, N)
        for (int i = 0; i < N; i++) {
            result *= (2 * N - i); // Numerator: (2N) * (2N-1) * ... * (N+1)
            result /= (i + 1);     // Denominator: 1 * 2 * ... * N
        }
        return result;
    }

    // Function to compute the Nth Catalan number
    public static long catalanNumber(int N) {
        if (N < 0) return 0; // Invalid input
        long binomial = binomialCoefficient(N);
        return binomial / (N + 1); // C(N) = C(2N, N) / (N + 1)
    }

    public static void main(String[] args) {
        int n = 4;
//        System.out.println("Number of unique BSTs for n = " + n + " is: " + numTrees(n)); // Output: 42

        System.out.println("Number of unique BSTs for n = " + n + " is: " + catalanNumber(n));
    }

}
