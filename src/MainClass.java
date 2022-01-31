public class MainClass {
    public static void main(String[] args) {
        int[] numbersArray = {9, 6, 7, 3, 1, 4, 8, 5, 2, 0};
        String sentence = "Are Elements Consecutive";
        ConsecutiveCheck consecutiveCheck = new ConsecutiveCheck(numbersArray);
        ReverseWords reverseWords = new ReverseWords(sentence);

        System.out.println(sentence + ": " + (consecutiveCheck.isArrayConsecutiveAndUnique() ? "Yes" : "No"));
        System.out.println("Original Sentence: " + sentence);
        System.out.println("Reversed Sentence: " + reverseWords.reverseWords(" "));
    }
}
