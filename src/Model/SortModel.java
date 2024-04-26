package Model;
import View.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SortModel {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/db_g";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";

    private static final int NUMBERS_COUNT = 5000;
    private static final int MAX_NUMBER = 1000000;
    private static final int DISPLAY_COUNT = 20;

    public static int[] numbers;
    public static String playername;

    public static void M_Sort_number() {
        Welcome w = new Welcome();
        playername = w.returnPlayerName();

        numbers = generateRandomNumbers();//generate random numbers
        Map<String, Long> sortTimes = measureSortTimes(numbers);//measure sort times
        Model.Database.D_Sort_saveSortTimes(playername,sortTimes);//save sort times
        //saveSortTimesToDatabase(sortTimes);   
    }
    
    //save player response to database
   public static boolean M_Sort_saveResponse(int guessedIndex1, int guessedIndex2, boolean resstatus1, boolean resstatus2) {
    String palyer_name=playername;
    boolean success = Model.Database.D_Sort_saveResponse(palyer_name,guessedIndex1, guessedIndex2, resstatus1, resstatus2);
    return success;
    }
   


    
    //get sorted values
    public static int[] M_Sort_displayValues() {
       return numbers;
   }


    // Helper method to generate random numbers
    private static int[] generateRandomNumbers() {
        Random random = new Random();
        int[] numbers = new int[NUMBERS_COUNT];
        for (int i = 0; i < NUMBERS_COUNT; i++) {
            numbers[i] = random.nextInt(MAX_NUMBER) + 1;
        }
        return numbers;
    }

    //sorting algorithm calling method
  private static Map<String, Long> measureSortTimes(int[] randomNumbers) {
    Map<String, Long> sortTimes = new HashMap<>();
    sortTimes.put("Bubble Sort", measureSortTime(Arrays.copyOf(randomNumbers, randomNumbers.length), SortingAlgorithms::bubbleSort));
    sortTimes.put("Insertion Sort", measureSortTime(Arrays.copyOf(randomNumbers, randomNumbers.length), SortingAlgorithms::insertionSort));
    sortTimes.put("Merge Sort", measureSortTime(Arrays.copyOf(randomNumbers, randomNumbers.length), SortingAlgorithms::mergeSort));
    sortTimes.put("Radix Sort", measureSortTime(Arrays.copyOf(randomNumbers, randomNumbers.length), SortingAlgorithms::radixSort));
    sortTimes.put("Shell Sort", measureSortTime(Arrays.copyOf(randomNumbers, randomNumbers.length), SortingAlgorithms::shellSort));
    sortTimes.put("Quick Sort", measureSortTime(Arrays.copyOf(randomNumbers, randomNumbers.length), SortingAlgorithms::quickSort));
    sortTimes.put("Tim Sort", measureSortTime(Arrays.copyOf(randomNumbers, randomNumbers.length), SortingAlgorithms::timSort));
    return sortTimes;
}

    // Function to measure the time taken for sorting
    private static long measureSortTime(int[] numbers, SortFunction sortFunction) {
        long startTime = System.nanoTime();
        sortFunction.sort(numbers);
        long endTime = System.nanoTime();
        return endTime - startTime;
    }



  
 //sort interface
    private interface SortFunction {
        void sort(int[] numbers);
    }
}

//sorting algorithms include class
class SortingAlgorithms {

 //bubble sort
     public static void bubbleSort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // Swap numbers[j] and numbers[j + 1]
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

     //insertion sort
       public static void insertionSort(int[] numbers) {
        int n = numbers.length;
        for (int i = 1; i < n; ++i) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
            }
            numbers[j + 1] = key;
        }
    }

       //merge sort
    public static void mergeSort(int[] numbers) {
    mergeSortHelper(numbers, 0, numbers.length - 1);
   }

public static void mergeSortHelper(int[] numbers, int left, int right) {
    if (left < right) {
        int middle = (left + right) / 2;
        mergeSortHelper(numbers, left, middle);
        mergeSortHelper(numbers, middle + 1, right);
        merge(numbers, left, middle, right);
    }
}

public static void merge(int[] numbers, int left, int middle, int right) {
    int n1 = middle - left + 1;
    int n2 = right - middle;
    int[] L = new int[n1];
    int[] R = new int[n2];
    for (int i = 0; i < n1; ++i)
        L[i] = numbers[left + i];
    for (int j = 0; j < n2; ++j)
        R[j] = numbers[middle + 1 + j];
    int i = 0, j = 0;
    int k = left;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            numbers[k] = L[i];
            i++;
        } else {
            numbers[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1) {
        numbers[k] = L[i];
        i++;
        k++;
    }
    while (j < n2) {
        numbers[k] = R[j];
        j++;
        k++;
    }
}

//radix sort
public static void radixSort(int[] numbers) {
    int max = Arrays.stream(numbers).max().getAsInt();
    for (int exp = 1; max / exp > 0; exp *= 10)
        countingSort(numbers, exp);
}

//counting sort
public static void countingSort(int[] numbers, int exp) {
    int n = numbers.length;
    int[] output = new int[n];
    int[] count = new int[10];
    Arrays.fill(count, 0);
    for (int number : numbers)
        count[(number / exp) % 10]++;
    for (int i = 1; i < 10; i++)
        count[i] += count[i - 1];
    for (int i = n - 1; i >= 0; i--) {
        output[count[(numbers[i] / exp) % 10] - 1] = numbers[i];
        count[(numbers[i] / exp) % 10]--;
    }
    for (int i = 0; i < n; i++)
        numbers[i] = output[i];
}

//shell sort
public static void shellSort(int[] numbers) {
    int n = numbers.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i += 1) {
            int temp = numbers[i];
            int j;
            for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap)
                numbers[j] = numbers[j - gap];
            numbers[j] = temp;
        }
    }
}

//quick sort
public static void quickSort(int[] numbers) {
    quickSortHelper(numbers, 0, numbers.length - 1);
}

public static void quickSortHelper(int[] numbers, int low, int high) {
    if (low < high) {
        int pi = partition(numbers, low, high);
        quickSortHelper(numbers, low, pi - 1);
        quickSortHelper(numbers, pi + 1, high);
    }
}

public static int partition(int[] numbers, int low, int high) {
    int pivot = numbers[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
        if (numbers[j] <= pivot) {
            i++;
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }
    int temp = numbers[i + 1];
    numbers[i + 1] = numbers[high];
    numbers[high] = temp;
    return i + 1;
}

//tim sort
public static void timSort(int[] numbers) {
    Arrays.sort(numbers);
}

    // Define other sorting algorithms similarly
}