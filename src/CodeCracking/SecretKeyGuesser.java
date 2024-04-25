package CodeCracking;

import utility.GuessString;

public class SecretKeyGuesser {
    SecretKey SecretKey;
    private boolean[] correctKey; // Record the correct character to reduce the number of guesses

    public SecretKeyGuesser(){
        this.SecretKey = new SecretKey();
        this.correctKey = new boolean[16];
    }

    public void start() {
        // Initialise the initial guess to find the number of R, M, I, and T
        // This should help us to reduce the frequency of guesses
        String allRString = "R".repeat(16);
        String allMString = "M".repeat(16);
        String allIString = "I".repeat(16);

        // Guess the string with all R to get the number of R
        int Rmatch = SecretKey.guess(allRString);
        if (Rmatch == 16) {
            return;
        }

        // Guess the string with all M to get the number of M
        int Mmatch = SecretKey.guess(allMString);
        if (Mmatch == 16) {
            return;
        }

        // Guess the string with all I to get the number of I
        int Imatch = SecretKey.guess(allIString);
        if (Imatch == 16) {
            return;
        }

        // Minus the number of matches from the total number of characters to get the number of T
        int Tmatch = 16 - Rmatch - Mmatch - Imatch;

        // Since we know the number of R, M, I, and T, we can generate a guess that has the same number of R, M, I, and T but likely in wrong positions
        GuessString guessKey = new GuessString(firstGuess(Rmatch, Mmatch, Imatch, Tmatch));
        int match = SecretKey.guess(guessKey.toString());
        int previousMatch = match;
        
        // Loop through the guess string to find the correct key
        for (int i = 0; i < 16; i++) {
            // Guess the string to reveal the number of correct characters
            // Since all the characters are correct we just need to focus on shifting the characters to the correct position
            for (int j = i + 1; j < 16; j++) {
                // If the character is already correct or the character is the same as the character at the current position, then we can skip this character
                if (correctKey[j] || guessKey.getCharacter(i) == guessKey.getCharacter(j)){
                    continue;
                }
                guessKey.swap(i, j);
                match = SecretKey.guess(guessKey.toString());
                // If the number of correct characters is 16, then the correct key is found and we can print it out
                if (match == 16) {
                    System.out.println("The correct key is: " + guessKey.toString());
                    return;
                }
                // If the number of correct characters increases, then we need to update the guessOption since this is the correct character
                // If the number of correct characters is decrease then the previous guess was correct and we need to shift the characters back and record the correct character
                if (match > previousMatch) {
                    correctKey[i] = true;
                    // If the match increase by 2, then we have already found the correct character for two positions and we can record the correct character
                    if (match - previousMatch == 2) {
                        correctKey[j] = true;
                    }
                } else {
                    guessKey.swap(i, j);
                    previousMatch = match;
                }
            }
        }
    }

    // Generate a initial guess
    public String firstGuess(int R, int M, int I, int T) {
        // Generate a string with certain number of R, M, I, and T
        String guessKey = "";
        for (int i = 0; i < R; i++) {
            guessKey += "R";
        }
        for (int i = 0; i < M; i++) {
            guessKey += "M";
        }
        for (int i = 0; i < I; i++) {
            guessKey += "I";
        }
        for (int i = 0; i < T; i++) {
            guessKey += "T";
        }
        return guessKey;
    }

    public static void main(String[] args) {
        SecretKeyGuesser secretKeyGuesser = new SecretKeyGuesser();
        secretKeyGuesser.start();
    }
}