import java.util.Scanner;

public class FibonacciCalculator {
    
    // Recursive method to calculate the nth Fibonacci number
    // This method calls itself to calculate each Fibonacci number in the sequence
    public static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2); // e.g F(0)=0,F(1)=1,F(2)=1,F(3)=2.
        // therefore to calculate F(3)=F(2)+F(1). i.e (n-1)+(n-2).
    }

    // Recursive method to count the number of steps taken by the recursive Fibonacci calculation
    public static int stepCountRecursion(int n) {
        if (n <= 1) return 1; //If n <= 1,function returns 1. This means when n is 0 or 1, only one step is needed
        return stepCountRecursion(n - 1) + stepCountRecursion(n - 2);
    }

    // Method to print the Fibonacci series up to the nth number using recursion
    // Calls the recursive fibonacci() function for each number up to n to print the full series
    public static void printFibonacciSeriesRecursion(int n) {
        for (int i = 0; i <= n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }
    
    //---------------------------------------------------------------------------------------------------------------------------

    // Iterative method to calculate the nth Fibonacci number (NON RECURSIVE)
    // Uses a loop instead of recursion, making it more efficient for larger values of n
    public static int fibonacciIteration(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
    

    public static int stepCountIteration(int n) {
        int count = 0; //counter is there to stepcount which gets incrementsed every time inside for loop
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            count++;
        }
        return count;
    }
    
    // Method to print the Fibonacci series up to the nth number using iteration
    // Generates the series using an iterative approach and then prints each number up to n
    public static void printFibonacciSeriesIteration(int n) {
        int[] fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for (int i = 0; i <= n; i++) //for printing
        {
            System.out.print(fib[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of Fibonacci numbers to calculate: ");

        // Recursive calculation and step count
        int n = scanner.nextInt();
        int stepsRecursion = stepCountRecursion(n);
        System.out.println("Fibonacci Recursion: " + fibonacci(n));
        System.out.println("Fibonacci Recursion Steps: " + stepsRecursion);
        System.out.println("Fibonacci Series (Recursion): ");
        printFibonacciSeriesRecursion(n);
        
        // Non-Recursive (Iterative) calculation and step count
        int stepsIteration = stepCountIteration(n);
        System.out.println("Fibonacci Iteration (non Recursive): " + fibonacciIteration(n));
        System.out.println("Fibonacci Iteration Steps (non Recursive): " + stepsIteration);
        System.out.println("Fibonacci Series (Iteration)(non Recursive): ");
        printFibonacciSeriesIteration(n);
    }
    
}

/*
Sample Output:
Enter the number of Fibonacci numbers to calculate: 10
Fibonacci Recursion: 55
Fibonacci Recursion Steps: 89 // total recursive calls needed to calculate the Fibonacci number
Fibonacci Series (Recursion): 
0 1 1 2 3 5 8 13 21 34 55 
Fibonacci Iteration (non Recursive): 55
Fibonacci Iteration Steps (non Recursive): 9
Fibonacci Series (Iteration)(non Recursive): 
0 1 1 2 3 5 8 13 21 34 55
*/


//Basically There are two things in this code snippet - Finding fibonacci series by recursive approach inside which the function gets called inside function
//And the second appraoch used is - Non Recursive i.e Iterative approach in whihc for loop is used instead of recursive calls.
//The iterative loop is considered to be more effective as it makes use of Linear complexity 0(n)
//while the Recursive approach uses the Exponentail complexity of o(2^n).