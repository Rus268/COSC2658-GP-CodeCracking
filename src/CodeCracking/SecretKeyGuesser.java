package CodeCracking;

import utility.GuessString;

public class SecretKeyGuesser {
    private SecretKey SecretKey;
    private GuessString guessSet;
    private char[] guessOptions = {'R', 'M', 'I', 'T'}; // All possible characters in the secret key

    public SecretKeyGuesser(){
        this.SecretKey = new SecretKey();
    }

    public void start() { 
        int previousMatch = 0;
        // Initial guess key with equal distribution of characters but the first 8 characters are locked down
        String guessKey = "RMITRMITMITRMITR";

        
        while (true) {

            int matched = SecretKey.guess(guessKey);
            // Break the loop when the correct key is found.
            if (matched == 16) {
                System.out.println("The correct key is: " + guessKey);
                break;
            } else if (matched > previousMatch) {
                previousMatch = matched;
                // Split the guessKey into two halves
                guessKey = newGuess(guessKey, i, 0)
                // Guess with the first half and the second half
                // Update the guessKey based on which half had more matches
            } else {
                guessKey = updateGuess(guessKey, matched);
            }
        }
    }

    // Generate a new guess that ensure 
    // TODO: add check to ensure that the guessKey is not the same as the previous guessKey
    public String newGuess(String guessKey, int i, int j) {
        String subString = guessKey.substring(i, j);
        String newGuess = "";
    }

    // Generate a string with a specific character lock down
    // TODO: add check to ensure that the guessKey is not the same as the previous guessKey
    public String updateGuess(String guessKey, int match) {
        // Update the guessKey based on the number of matches
        // Lock down the characters that are correct
        // 
        // Randomly select characters for the remaining characters
        return guessKey;
    }
}