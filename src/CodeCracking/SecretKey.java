package src;

public class SecretKey {
    private String correctKey;
    private int counter;

    public SecretKey() {
        // For the real test, this is not know
        correctKey =  "RRRRRRRRRMITRMIT";
        counter  = 0;
    }

    // This function is to help give a number of guessked key
    public int guess(String guessedKey) {
        counter ++;
        // validation the string lenght
        if (guessedKey.length() != correctKey.length()) {
            return -1;
        }

        int matched = 0;
        for (int i = 0; i < guessedKey.length(); i++) {
            char c = guessedKey.charAt(i);
            if (c != 'R' && c != 'M' && c != 'I' && c != 'T') {
                return -1;
            }
            if (c == correctKey.charAt(i)){
                matched++;
            }
        }
        if (matched == correctKey.length()) {
            System.out.println("Number of guesses: "+ counter);
        }
        return matched;
    }

    public static void main(String[] args) {
        new SecretKeyGuesser().start();
    }
}