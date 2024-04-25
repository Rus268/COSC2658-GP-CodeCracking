package utility;

public class GuessString {
    private char[] guessOptions;
    private int guessLength = 16;

    // Constructor
    public GuessString() {guessOptions = new char[guessLength];}
    public GuessString(int length) {
        guessLength = length;
        guessOptions = new char[guessLength];
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
    }
}
