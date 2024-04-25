package utility;

public class GuessString {
    /*
     * This class is to help keep track of the correct characters in the secret key.
     */
    private char[] guessOptions;
    private int guessLength = 16;

    // Constructor
    public GuessString() {guessOptions = new char[guessLength];}
    public GuessString(int length) {
        guessLength = length;
        guessOptions = new char[guessLength];
    }

    public GuessString(String guess) {
        guessLength = guess.length();
        guessOptions = new char[guessLength];
        for (int i = 0; i < guessLength; i++) {
            guessOptions[i] = guess.charAt(i);
        }
    }

    // Method to set a character at a specific index
    public boolean setCharacter(int index, char c) {
        if (index < 0 || index >= guessLength) {
            return false;
        }
        guessOptions[index] = c;
        return true;
    }

    // Method to get a character at a specific index
    public char getCharacter(int index) {
        if (index < 0 || index >= guessLength) {
            return '\0';
        }
        return guessOptions[index];
    }

    // Method to check if the position is empty
    public boolean isEmpty(int index) {
        if (index < 0 || index >= guessLength) {
            return false;
        }
        return guessOptions[index] == '\0';
    }

    // Method to get the guess string
    public String toString() {
        return new String(guessOptions);
    }

    // Swap the characters at two indexes
    public void swap(int index1, int index2) {
        char temp = guessOptions[index1];
        guessOptions[index1] = guessOptions[index2];
        guessOptions[index2] = temp;
    }


    public static void main(String[] args) {
        GuessString guessString = new GuessString(5);
        guessString.setCharacter(0, 'R');
        guessString.setCharacter(1, 'M');
        guessString.setCharacter(2, 'I');
        guessString.setCharacter(3, 'T');
        System.out.println(guessString.toString()); //Return RMIT
        System.out.println(guessString.getCharacter(0)); //Return R
        System.out.println(guessString.getCharacter(1)); //Return M
        System.out.println(guessString.isEmpty(0)); //Return false
        System.out.println(guessString.isEmpty(4)); //Return True
        GuessString guessString2 = new GuessString("NewString");
        System.out.println(guessString2.toString()); //Return NewString
        guessString2.swap(0, 1);
        System.out.println(guessString2.toString()); //Return eNwString

    }
}
