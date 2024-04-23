package src;

public class SecretKeyGuesser {
    private SecretKey SecretKey;
    private char[] guessOptions = {'R', 'M', 'I', 'T'}; // The possible characters in the secret key

    public SecretKeyGuesser(){
        this.SecretKey = new SecretKey();
    }

    public String start() {
        //1. Initialize an array to store the frequency of each character ("R", "M", "I", "T")
        for (int i = 0; i < 4; i++) {
            int maxMatched =0;
            String finalKey = "";
            String guessKey = generateString(16, guessOptions[i]);
            int matched = SecretKey.guess(guessKey);
            // Consider edge case where the correct key is all the same character
            if (matched == 16) {
                return guessKey;
            } else if (matched > maxMatched) {
                maxMatched = matched;
                finalKey = guessKey;
            }
        }
        //2. Guess the secret key using 16 characters of the same type for each character type and update the frequency array.
        //3. Find the character with the highest frequency and create a guessed key with this character.
        //4. Partition the guessed key into two halves.
        //5. Define a recursive function that:
        //a. Takes a substring and the frequency array as input.
        //b. If the length of the substring is 1, guess the key with the character that has a frequency of 1.
        //c. If the length of the substring is greater than 1, partition the substring into two halves. For each half, find the character with the highest frequency and replace the characters in the half with this character. Then, recursively call the function on each half.
        //6. Call the recursive function on each half of the guessed key.
        //7. Continue this process until the correct secret key is found.
        //8. Return the correct secret key.
        }
    }

    public void recursiveGuess(int i, int j, String guess) {
        if 
    }
    //TODO: Implement the recursiveGuess function to recursively guess the secret key

    public String generateString (int length, char c) {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += c;
        }
        return s;
    }

    public static void main(String[] args) {
    }
}