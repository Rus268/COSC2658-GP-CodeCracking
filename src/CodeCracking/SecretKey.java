package CodeCracking;

public class SecretKey {
    private String correctKey;
    private int counter;

    public SecretKey() {
        // For the real test, this is not know
        // Adding additional test cases to test the code
        correctKey =  "RRRRRRRRRMITRMIT";
        // correctKey =  "RRRRRRRRRMITRMMT";
        // correctKey =  "RRRIIRRRRMITRMIT";
        // correctKey =  "RRRRRRRRRRRRRRRR";
        // correctKey =  "RMITRMITRMITRMIT";
        // correctKey =  "RMITMITRTRMITIMR";
        // correctKey =  "TMTMTMTMTMTMTMTM";
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
            // check if the string is outside of the possible characters
            if (c != 'R' && c != 'M' && c != 'I' && c != 'T') {
                return -1;
            }
            if (c == correctKey.charAt(i)){
                matched++;
            }
        }
        // Print out number of guesses when the correct key is found. 
        if (matched == correctKey.length()) {
            System.out.println("Number of guesses: "+ counter);
        }
        return matched;
    }

    public static void main(String[] args) {
        SecretKeyGuesser secretKeyGuesser = new SecretKeyGuesser();
        secretKeyGuesser.start();
    }
}