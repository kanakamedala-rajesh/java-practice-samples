package com.vs;

public class MyString {
    private final String myString;

    public MyString(String myString) {
        this.myString = myString;
    }

    /**
     * Provides index of given character within constructor initialized string
     *
     * @param character - character index to check for
     * @return returns index of character if present else returns -1
     */
    public int indexOf(char character) {
        int indexValue = -1;
        for (int i = 0; i < myString.length(); i++) {
            if (myString.charAt(i) == character) {
                indexValue = i;
                break;
            }
        }
        return indexValue;
    }

    /**
     * Provides index of given character within constructor initialized string.
     * ignoreCase param can be used to indicated if character case should be ignored while validating
     * <p>
     * Note: ignoreCase param is considered only if provided character is an alphabet[A-Z a-z]
     * ASCII Table Reference: https://www.asciitable.com/
     *
     * @param character  - character position to check for
     * @param ignoreCase - indicates if character case should be ignored
     * @return returns index of character if present else returns -1
     */
    public int indexOf(char character, boolean ignoreCase) {
        int indexValue = -1;
        for (int i = 0; i < myString.length(); i++) {
            boolean isLetter = ((character >= 65 && character <= 90) || (character >= 97 && character <= 122));
            boolean isCapital = isLetter && character <= 90;
            if (myString.charAt(i) == character || (isLetter && ignoreCase && isCapital ? (myString.charAt(i) == character + 32) : myString.charAt(i) == character - 32)) {
                indexValue = i;
                break;
            }
        }
        return indexValue;
    }
}
