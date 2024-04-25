package CodeCracking;

import utility.GuessString;

public class SecretKeyGuesser {
    SecretKey SecretKey;
    private int maxIterations = 1000000;
    private int iteration = 0;

    public SecretKeyGuesser(){
        this.SecretKey = new SecretKey();
    }

    public void start() {
        // We can use 3 guesses to find the number of R, M, I, and T
        // This should help us to reduce the frequency of guesses
        String allRString = "R".repeat(16);
        String allMString = "M".repeat(16);
        String allIString = "I".repeat(16);

        // Guess the string with all R to get the number of R
        int Rmatch = SecretKey.guess(allRString);
        if (Rmatch == 16) {
            System.out.println("The correct key is: " + allRString);
            return;
        }

        // Guess the string with all M to get the number of M
        int Mmatch = SecretKey.guess(allMString);
        if (Mmatch == 16) {
            System.out.println("The correct key is: " + allMString);
            return;
        }

        // Guess the string with all I to get the number of I
        int Imatch = SecretKey.guess(allIString);
        if (Imatch == 16) {
            System.out.println("The correct key is: " + allIString);
            return;
        }

        // Minus the number of matches from the total number of characters to get the number of T
        int Tmatch = 16 - Rmatch - Mmatch - Imatch;
        if (Tmatch == 16) {
            System.out.println("The correct key is: " + "T".repeat(16));
            return;
        }

        // Since we know the number of R, M, I, and T, we can generate a guess that has the same number of R, M, I, and T but likely in wrong positions
        GuessString guessKey = new GuessString(firstGuess(Rmatch, Mmatch, Imatch, Tmatch));
        // System.out.println("Initial guess: " + guessKey.toString());
        
        int match = SecretKey.guess(guessKey.toString());
        int previousMatch = match;
        // Handle the case where the correct key is not found after 1000 iterations
        while (iteration < maxIterations) {
            // Loop through the guess string to find the correct key
            for (int i = 0; i < 16; i++) {
                // Since all the characters are correct we just need to focus on shifting the characters to the correct position by swapping
                // If the character is correct, then we can skip this character
                if (guessKey.isCorrect(i)) {
                    continue;
                }
                for (int j = i + 1; j < 16; j++) {
                    // // Print out the iteration, position, match, and the guessKey
                    // System.out.println("Iteration: " + iteration + " Position: " + i + " Match: " + match + "guessKey: " + guessKey.toString());
                    // iteration++;
                    // If the character is the same as the character at the current position, then we can skip this character
                    if (guessKey.isCorrect(j) || guessKey.getCharacter(i) == guessKey.getCharacter(j)){
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
                        guessKey.setCorrect(i);
                        // If the match increase by 2, then we have already found the correct character for two positions and we can record the correct character
                        if (match - previousMatch == 2) {
                            guessKey.setCorrect(j);
                        }
                        previousMatch = match;  // Update the previous match to keep track of the number of correct characters
                    } else {
                        guessKey.swap(i, j);
                    }
                }
            }
        }
        // If the correct key is not found after maxIterations, then print out a message
        System.out.println("Max iterations reached");
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