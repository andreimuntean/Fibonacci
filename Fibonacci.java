// Computes the nth Fibonacci number whilst illustrating
// the effectiveness of dynamic programming.
// Arguments: none.
public class Fibonacci
{
    // Defines the variables required for dynamic programming.
    private static int[] fibonacci;
    private static int fibonacciLength;

    // Records the number of steps needed to compute an answer.
    private static int steps;

    private static void initialize()
    {
        fibonacci = new int[1048576];
        fibonacci[0] = 1;
        fibonacci[1] = 1;
        fibonacciLength = 2;
    }

    // The dynamically programmed version of the Fibonacci method.
    private static int fibonacci(int n)
    {
        ++steps;

        if (n >= fibonacciLength)
        {
            fibonacci[n] = fibonacci(n - 1) + fibonacci(n - 2);
            fibonacciLength = n + 1;
        }

        return fibonacci[n];
    }

    // The classical Fibonacci method.
    private static int slowFibonacci(int n)
    {
        ++steps;

        if (n < 2)
        {
            return 1;
        }
        else
        {
            return slowFibonacci(n - 1) + slowFibonacci(n - 2);
        }
    }

    public static void main(String[] args)
    {
        initialize();
        
        while (true)
        {
            // Reads the user input.
            String input = System.console().readLine();
            int n = Integer.parseInt(input);

            // Resets the number of steps and runs the classical Fibonacci method.
            steps = 0;
            System.out.println("fibonacci(" + n + ") = "
                               + slowFibonacci(n - 1) + " (" + steps + " steps)");

            // Resets the number of steps and runs the improved Fibonacci method.
            steps = 0;
            System.out.println("[OPTIMIZED] fibonacci(" + n + ") = "
                               + fibonacci(n - 1) + " (" + steps + " steps)");
        }
    }
}