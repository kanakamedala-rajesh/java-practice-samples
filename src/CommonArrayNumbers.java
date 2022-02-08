import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. Find all common numbers in a array if no common  numbers or 0 is common number print -1
 * 2. Find the smallest common number.
 * 3. If smallest number >10 add all digits in number.
 * 4. Print largest to the smallest numbers matching smallest number value in descending order.
 * (if smallest number is 3 in array print 3 numbers, if smallest number is more than array size print all numbers in array)
 */
public class CommonArrayNumbers {
    public static int array1Size, array2Size;
    public static int[] array1, array2;

    public static void main(String[] args) {
        System.out.println("Starting program");
        initializeArrays();

        System.out.println("Provided Array 1: " + Arrays.toString(array1));
        System.out.println("Provided Array 2: " + Arrays.toString(array2));

        // Task 1: Find all common numbers in arrays if no common numbers or 0 is the common number print -1
        int[] commonElements = getCommonElements();
        if (commonElements.length == 0) {
            System.out.println("No Common Elements: -1");
        } else {
            System.out.println("CommonArray: " + Arrays.toString(commonElements));
        }

        // Task 2: Find the smallest common number.
        int smallestNumber = getSmallestNumber(commonElements);
        System.out.println("Smallest Number: " + smallestNumber);

        // Task 3: if smallest number not single digit add all digits in that number.
        int sum = getSumOfDigits(smallestNumber);
        System.out.println("Smallest number sum: " + ((sum == 0) ? "smallest number is single digit" : sum));

        // Task 4: Print largest to the smallest numbers matching smallest number value in descending order.
        // (if smallest number is 3 in array print 3 numbers, if smallest number is more than array size print all numbers in array)
        printArrayInDescendingOrder(smallestNumber);
    }

    /**
     * Print given number of elements in both arrays in Descending Order.
     *
     * @param numberOfElementsToPrint -  number of elements to print
     */
    private static void printArrayInDescendingOrder(int numberOfElementsToPrint) {
        Arrays.sort(array1);
        Arrays.sort(array2);

        System.out.println("Task 4 Array 1: ");
        printSpecifiedElements(numberOfElementsToPrint, array1);

        System.out.println("Task 4 Array 2: ");
        printSpecifiedElements(numberOfElementsToPrint, array2);
    }

    /**
     * Prints given number of elements in provide array
     *
     * @param array                   - array elements to print
     * @param numberOfElementsToPrint -  number of elements to print
     */
    private static void printSpecifiedElements(int numberOfElementsToPrint, int[] array) {
        if (array.length > numberOfElementsToPrint) {
            int arrayIndex = array.length - 1;
            while (numberOfElementsToPrint > 0) {
                System.out.print(array[arrayIndex] + " ");
                arrayIndex--;
                numberOfElementsToPrint--;
            }
            System.out.println("");
        } else {
            for (int i = array.length - 1; i >= 0; i--) {
                System.out.print(array[i] + " ");
            }
            System.out.println("");
        }
    }

    /**
     * Calculate Sum of digits in given number
     *
     * @param number - number to find sum of digits
     * @return sum of digits in given number, returns 0 if number is single digit
     */
    private static int getSumOfDigits(int number) {
        int sum = 0;
        if (number >= 10) {
            while (number > 0) {
                sum += number % 10;
                number /= 10;
            }
        }
        return sum;
    }

    /**
     * Finds the smallest number in given array.
     *
     * @param array - array param
     * @return returns smallest number in given array
     */
    private static int getSmallestNumber(int[] array) {
        Arrays.sort(array);
        return array[0];
    }

    /**
     * Find all common numbers in arrays
     *
     * @return returns Common elements array
     */
    private static int[] getCommonElements() {
        int[] tmpCommonArray = new int[Math.max(array1Size, array2Size)];
        int commonArrayIndex = 0;
        for (int array1Element : array1) {
            for (int array2Element : array2) {
                if (array1Element == array2Element) {
                    tmpCommonArray[commonArrayIndex] = array1Element;
                    commonArrayIndex++;
                    break;
                }
            }
        }

        int[] commonArray = new int[commonArrayIndex];
        for (int i = 0; i < commonArrayIndex; i++) {
            commonArray[i] = tmpCommonArray[i];
        }
        return commonArray;
    }

    /**
     * Reads input from user and stores them to arrays
     */
    private static void initializeArrays() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array 1 size: ");
        array1Size = sc.nextInt();
        array1 = new int[array1Size];
        System.out.println("Enter Elements in array 1: ");
        for (int i = 0; i < array1Size; i++) {
            array1[i] = sc.nextInt();
        }

        System.out.println("Enter Array 2 size: ");
        array2Size = sc.nextInt();
        array2 = new int[array2Size];
        System.out.println("Enter Elements in array 1: ");
        for (int i = 0; i < array2Size; i++) {
            array2[i] = sc.nextInt();
        }
    }
}
