import java.util.*;
public class Knapsack {
    public static int knapSack(int W, int[] weights, int[] values, int items) {
        int[][] table = new int[items + 1][W + 1];
        for (int i = 0; i <= items; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    table[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    table[i][w] = Math.max(values[i - 1] + table[i - 1][w - weights[i - 1]], table[i - 1][w]);
                } else {
                    table[i][w] = table[i - 1][w];
                }
            }
        }
        return table[items][W];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter values of items (space-separated): ");
        String valuesInput = sc.nextLine();
        String[] valuesArray = valuesInput.split(" ");
        int[] values = new int[valuesArray.length];
        for (int i = 0; i < valuesArray.length; i++) {
            values[i] = Integer.parseInt(valuesArray[i].trim());
        }
        System.out.print("Enter weights of items (space-separated): ");
        String weightsInput = sc.nextLine();
        String[] weightsArray = weightsInput.split(" ");
        int[] weights = new int[weightsArray.length];
        for (int i = 0; i < weightsArray.length; i++) {
            weights[i] = Integer.parseInt(weightsArray[i].trim());
        }
        System.out.print("Enter Knapsack Capacity: ");
        int W = sc.nextInt();
        int n = values.length;
        int maxProfit = knapSack(W, weights, values, n);
        System.out.println("Maximum profit that can be achieved: " + maxProfit);
        sc.close();
    }
}

// Enter values of items (space-separated): 60 100 120
// Enter weights of items (space-separated): 10 20 30
// Enter Knapsack Capacity: 50


//Explanation:
// Items: 3 items with values and weights:

// Item 1: Value = 60, Weight = 10
// Item 2: Value = 100, Weight = 20
// Item 3: Value = 120, Weight = 30
// Knapsack capacity: 50

// Optimal Solution:
// The optimal solution is to include:
// Item 2 (Value = 100, Weight = 20) and
// Item 3 (Value = 120, Weight = 30).
// These two items fit into the knapsack with a total value of 220 (100 + 120) and a total weight of 50 (20 + 30), which is the maximum value that can be achieved without exceeding the knapsack's capacity.

// So, the maximum profit the knapsack can hold is 220.