package com.vs;

public class CommonCharacters {
    private final String s1, s2, s3;

    public CommonCharacters(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }

    /**
     * Returns all common characters within class initialized String, This method is case-sensitive
     *
     * @return returns commonCharacters as a string.
     */
    public String getCommonCharacters() {
        return getCommonCharacters(false);
    }

    /**
     * Returns all common characters within class initialized String
     *
     * @param ignoreCase - indicates if we should ignore case while checking for common characters
     * @return returns commonCharacters as a string. If ignoreCase is true returns common characters string in lowercase format.
     */
    public String getCommonCharacters(boolean ignoreCase) {
        StringBuilder returnValue = new StringBuilder();
        for (char value1 : s1.toCharArray()) {
            for (char value2 : s2.toCharArray()) {
                if ((ignoreCase && String.valueOf(value1).equalsIgnoreCase(String.valueOf(value2))) || (value1 == value2)) {
                    for (char value3 : s3.toCharArray()) {
                        if ((ignoreCase && String.valueOf(value1).equalsIgnoreCase(String.valueOf(value3))) || (value1 == value3))
                            returnValue.append(value1);
                    }
                }
            }
        }
        return ignoreCase ? returnValue.toString().toLowerCase() : returnValue.toString();
    }
}
