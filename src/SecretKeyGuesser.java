import src;

public class SecretKeyGuesser {
    private SecretKey;

    public SecretKeyGuesser(){
        this.SecretKey = new SecretKey();
    }

    public String start() {
        /*1. Initialize an array to store the frequency of each character ("R", "M", "I", "T").
        2. Guess the secret key using 16 characters of the same type for each character type and update the frequency array.
        3. Find the character with the highest frequency and create a guessed key with this character.
        4. Partition the guessed key into two halves.
        5. Define a recursive function that:
        a. Takes a substring and the frequency array as input.
        b. If the length of the substring is 1, guess the key with the character that has a frequency of 1.
        c. If the length of the substring is greater than 1, partition the substring into two halves. For each half, find the character with the highest frequency and replace the characters in the half with this character. Then, recursively call the function on each half.
        6. Call the recursive function on each half of the guessed key.
        7. Continue this process until the correct secret key is found.
        */
    
    public void recursiveGuess(int i, int j, String guess) {
        //TODO
    }

    public static void main(String[] args) {
        System.out.println("42");
    }
}