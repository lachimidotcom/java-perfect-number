//6
//28
//496
//8128
//33550336
//8589869056
//137438691328

import java.util.Scanner;
import java.util.stream.IntStream;

public class PerfectNumber {
    // Method 1: Straightforward approach
    public static boolean isPerfectNumber(int number) {
        int sum = 1; // Start with 1 because it's always a divisor
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number && number != 1; // 1 is not considered a perfect number
    }

    // Method 2: Optimized approach
    public static boolean isPerfectNumberOptimized(int number) {
        if (number == 1) return false; // 1 is not a perfect number

        int sum = 1;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                sum += i;
                if (i != number / i) {
                    sum += number / i;
                }
            }
        }
        return sum == number;
    }

    // Recursive method to find the sum of proper divisors
    static boolean isPerfectUsingRecursion(long num, long i, long sum) {
        if (i > num / 2) {
            return sum == num;
        }
        if (num % i == 0) {
            sum += i;
        }
        return isPerfectUsingRecursion(num, i + 1, sum);
    }
	
	// Method using Java Streams
    public static boolean isPerfectNumberStreams(int number) {
        return number > 1 && IntStream.rangeClosed(1, number / 2)
                                       .filter(i -> number % i == 0)
                                       .sum() == number;
    }
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
		
		System.out.println("Iterator: " + number + " Is perfect number? " + isPerfectNumber(number));
        System.out.println("Optimized: " + number + " Is perfect number? " + isPerfectNumberOptimized(number));
        System.out.println("Recursion: " + number + " Is perfect number? " + isPerfectUsingRecursion(number, 1, 0));
		System.out.println("Streams: " + number + " Is perfect number? " + isPerfectNumberStreams(number));
    }
}
