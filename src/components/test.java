package components;
import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        int incorrectGuesses = 5;
        // Check if first run
        boolean iterated = false;
        String temp = "";
        System.out.println("Welcome to the guessing game! Guess one letter "
                + "at a time. You have " + incorrectGuesses + " incorrect "
                        + "guesses remaining.");

        Scanner reader = new Scanner(System.in);
        
        String word = "sleepy";
        String dashedWord = createDashedWord(word);
        System.out.println("The Secret Word Is: " + dashedWord + 
                " (" + word.length() + ")");
        
        do {
            System.out.print("Your Guess: ");
            String guess = reader.nextLine();
            boolean correctGuess = false;

            for (int i = 0; i < word.length(); i++) {
                if (guess.equals(Character.toString(word.charAt(i)))) {
                    correctGuess = true;
                    if (!iterated)
                        temp += Character.toString(word.charAt(i));
                    else {
                        String holder = Character.toString(
                                temp.charAt(i)).replace("-", guess);
                        temp = temp.substring(0, i) + holder + 
                                temp.substring(i + 1, temp.length());
                    }
                } else {
                    // Add '-' for first run through (1st guess incorrect)
                    if (!iterated) {
                        temp += "-";
                    }
                }
            }
            iterated = true;
            
            if (correctGuess) {
                System.out.println("The word contains the letter " + guess + ".");
            } else {
                System.out.println("The word does not contain the letter " + guess + ".");
                incorrectGuesses--;
                System.out.println("You have " + incorrectGuesses + 
                        " incorrect guesses remaining.");
            }
            
            System.out.println(temp);
            if (temp.equals(word)) {
                System.out.println("You guessed correctly!");
                break;
            }
        
        } while (incorrectGuesses > 0);
        
        if (incorrectGuesses <= 0) {
            System.out.println("Sorry, you didn't guess the secret word \"" + word + "\".");
        }
        
        reader.close();

    }
    
    private static String createDashedWord(String word) {
        String output = "";
        for (int i = 0; i < word.length(); i++) {
            output += "-";
        }
        return output;
    }

}