package components;

import Ultility.ArrayList;

public class SecretKey {
    private String correctKey;
    private int counter;

    public SecretKey(String inputCorrectKey) {
        // for the real test, your program will not know this
        correctKey = inputCorrectKey;
        counter = 0;
    }

    public int guess(String guessedKey) {
        if (counter >= 16) {
            System.out.println("Number of guesses: " + counter);
            return -1;
        }
        counter++;
        // validation
        if (guessedKey.length() != correctKey.length()) {
            return -1;
        }
        int matched = 0;
        for (int i = 0; i < guessedKey.length(); i++) {
            char c = guessedKey.charAt(i);
            if (c != 'R' && c != 'M' && c != 'I' && c != 'T') {
                return -1;
            }
            if (c == correctKey.charAt(i)) {
                matched++;
            }
        }
        if (matched == correctKey.length()) {
            System.out.println("Number of guesses: " + counter);
        }
        return matched;
    }

    public ArrayList<Integer> correctPosition(String guessedKey) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int index = 0;
        for (int i = 0; i < guessedKey.length(); i++) {
            char c = guessedKey.charAt(i);
            if (c == correctKey.charAt(i)) {
                result.insertAt(index, i);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SecretKeyGuesser guessy = new SecretKeyGuesser();
        guessy.start();
    }
}