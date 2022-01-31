public class ConsecutiveCheck {
    private int[] numbersArray;

    public ConsecutiveCheck(int[] numbersArray) {
        this.numbersArray = numbersArray;
    }

    /**
     * Create a method in a Java class that accepts an array of numbers as a parameter.
     * If the array of numbers can be rearranged so that they’re consecutive numbers where no number appears twice, return true.
     * If this isn’t possible, return false. The array can be of any size.
     */
    public boolean isArrayConsecutiveAndUnique() {
        int[] sortedArray = new int[numbersArray.length];

        for (int i = 0; i < sortedArray.length; i++) {
            int minimumElement = getMinimumElement(numbersArray);
            numbersArray = deleteElement(numbersArray, minimumElement);
            sortedArray[i] = minimumElement;
        }

        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i] != sortedArray[0] + i) {
                return false;
            }
        }
        return true;
    }

    private int getMinimumElement(int[] numbersArray) {
        int minValue = numbersArray[0];

        for (int element : numbersArray) {
            if (element <= minValue) {
                minValue = element;
            }
        }

        return minValue;
    }

    private int[] deleteElement(int[] numbersArray, int elementToDelete) {
        int[] modifiedArray = new int[numbersArray.length - 1];
        int modifiedArrayIndex = 0;

        for (int element : numbersArray) {
            if (element != elementToDelete) {
                modifiedArray[modifiedArrayIndex] = element;
                modifiedArrayIndex++;
            }
        }
        return modifiedArray;
    }
}
