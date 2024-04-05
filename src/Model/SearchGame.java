/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SearchGame {
    
    // Generate random numbers between 1 to 1000000
   public static int[] generateRandomNumbers(int count) {
        int[] numbers = new int[count];
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            numbers[i] = rand.nextInt(1000000) + 1;
        }
        Arrays.sort(numbers); // Sort the array for search algorithms that require sorted input
        return numbers;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // Jump Search
    public static int jumpSearch(int[] arr, int target) {
        int n = arr.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < target) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n) {
                return -1;
            }
        }
        while (arr[prev] < target) {
            prev++;
            if (prev == Math.min(step, n)) {
                return -1;
            }
        }
        if (arr[prev] == target) {
            return prev;
        }
        return -1;
    }

    // Exponential Search
    public static int exponentialSearch(int[] arr, int target) {
        int n = arr.length;
        if (arr[0] == target) {
            return 0;
        }
        int i = 1;
        while (i < n && arr[i] <= target) {
            i *= 2;
        }
        return Arrays.binarySearch(arr, i / 2, Math.min(i, n), target);
    }

    // Fibonacci Search
    public static int fibonacciSearch(int[] arr, int target) {
        int n = arr.length;
        int fibMMinus2 = 0;
        int fibMMinus1 = 1;
        int fibM = fibMMinus1 + fibMMinus2;
        while (fibM < n) {
            fibMMinus2 = fibMMinus1;
            fibMMinus1 = fibM;
            fibM = fibMMinus1 + fibMMinus2;
        }
        int offset = -1;
        while (fibM > 1) {
            int i = Math.min(offset + fibMMinus2, n - 1);
            if (arr[i] < target) {
                fibM = fibMMinus1;
                fibMMinus1 = fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
                offset = i;
            } else if (arr[i] > target) {
                fibM = fibMMinus2;
                fibMMinus1 -= fibMMinus2;
                fibMMinus2 = fibM - fibMMinus1;
            } else {
                return i;
            }
        }
        if (fibMMinus1 == 1 && arr[offset + 1] == target) {
            return offset + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = generateRandomNumbers(5000);
        Random rand = new Random();
        int targetIndex = rand.nextInt(numbers.length); // Select a random index as target
        int targetValue = numbers[targetIndex]; // Get the target value

        // Generate random indices for the options
        int[] optionIndices = new int[4];
        optionIndices[0] = targetIndex - 1 >= 0 ? targetIndex - 1 : 0;
        optionIndices[1] = targetIndex;
        optionIndices[2] = targetIndex + 1 < numbers.length ? targetIndex + 1 : numbers.length - 1;
        optionIndices[3] = targetIndex + 2 < numbers.length ? targetIndex + 2 : numbers.length - 1;

        // Shuffle the indices
        for (int i = 0; i < optionIndices.length; i++) {
            int randomIndex = rand.nextInt(optionIndices.length);
            int temp = optionIndices[i];
            optionIndices[i] = optionIndices[randomIndex];
            optionIndices[randomIndex] = temp;
        }

        // Display the game interface with randomized options
        System.out.println("Welcome to the Search Game!");
        System.out.println("A random number between 1 and 1000000 has been selected.");
        
        System.out.println("Our Target is " + targetValue);
        
        System.out.println("Can you predict the index of the target value?");
        
        System.out.println("Our Target is " + targetIndex);
        
        
        System.out.println("Your options are:");
        System.out.println("A) Index " + optionIndices[0]);
        System.out.println("B) Index " + optionIndices[1]);
        System.out.println("C) Index " + optionIndices[2]);
        System.out.println("D) Index " + optionIndices[3]);

        // Prompt user for input
        System.out.print("Enter your choice (A, B, C, or D): ");
        String userChoice = scanner.nextLine().toUpperCase();

        // Validate user input and check if it matches the target index
        switch (userChoice) {
            case "A":
                if (optionIndices[0] == targetIndex) {
                    System.out.println("Congratulations! You've correctly predicted the index.");
                } else {
                    System.out.println("Sorry, wrong choice!");
                }
                break;
            case "B":
                if (optionIndices[1] == targetIndex) {
                    System.out.println("Congratulations! You've correctly predicted the index.");
                } else {
                    System.out.println("Sorry, wrong choice!");
                }
                break;
            case "C":
                if (optionIndices[2] == targetIndex) {
                    System.out.println("Congratulations! You've correctly predicted the index.");
                } else {
                    System.out.println("Sorry, wrong choice!");
                }
                break;
            case "D":
                if (optionIndices[3] == targetIndex) {
                    System.out.println("Congratulations! You've correctly predicted the index.");
                } else {
                    System.out.println("Sorry, wrong choice!");
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }

        long startTime, endTime;
        int result;

        // Binary Search
        startTime = System.nanoTime();
        result = binarySearch(numbers, targetValue);
        endTime = System.nanoTime();
        System.out.println("\nBinary Search:");
        System.out.println("Result: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds.");

        // Jump Search
        startTime = System.nanoTime();
        result = jumpSearch(numbers, targetValue);
        endTime = System.nanoTime();
        System.out.println("\nJump Search:");
        System.out.println("Result: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds.");

        // Exponential Search
        startTime = System.nanoTime();
        result = exponentialSearch(numbers, targetValue);
        endTime = System.nanoTime();
        System.out.println("\nExponential Search:");
        System.out.println("Result: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds.");

        // Fibonacci Search
        startTime = System.nanoTime();
        result = fibonacciSearch(numbers, targetValue);
        endTime = System.nanoTime();
        System.out.println("\nFibonacci Search:");
        System.out.println("Result: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " nanoseconds.");

        // Determine the best search method
        String bestMethod = "";
        long binaryTime = endTime - startTime;
        long jumpTime = endTime - startTime;
        long exponentialTime = endTime - startTime;
        long fibonacciTime = endTime - startTime;
        
        long minTime = Math.min(Math.min(binaryTime, jumpTime), Math.min(exponentialTime, fibonacciTime));
        if (minTime == binaryTime) {
            bestMethod = "Binary Search";
        } else if (minTime == jumpTime) {
            bestMethod = "Jump Search";
        } else if (minTime == exponentialTime) {
            bestMethod = "Exponential Search";
        } else {
            bestMethod = "Fibonacci Search";
        }

        System.out.println("\nThe best search method is: " + bestMethod);
        
    }
}
