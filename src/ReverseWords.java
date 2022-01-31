public class ReverseWords {
    private final String sentence;

    public ReverseWords(String sentence) {
        this.sentence = sentence;
    }

    public String reverseWords(String delimiter) {
        String[] splitSentence = sentence.split(delimiter);
        String reversedSentence = "";
        for (String item : splitSentence) {
            for (int i = item.length() - 1; i >= 0; i--) {
                reversedSentence += item.charAt(i);
            }
            reversedSentence += delimiter;
        }
        return reversedSentence;
    }
}
