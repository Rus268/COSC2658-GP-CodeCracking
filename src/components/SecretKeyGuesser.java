package components;

import Ultility.ArrayList;

public class SecretKeyGuesser {
    private String initSecretKey = "RRRRRRRRRMITRMIT";
    
    public void start() {
        SecretKey secret = new SecretKey(initSecretKey);
        String allRString = "R".repeat(16);
        String allMString = "M".repeat(16);
        String allIString = "I".repeat(16);
        String allTString = "T".repeat(16);

        // Total number of R
        int rAccuracy = secret.guess(allRString);
        if (rAccuracy == 16) {
            System.out.println("Secret key: " + allRString);
            return;
        }
        ArrayList<Integer> rCorrect = secret.correctPosition(allRString);
        // Total number of M
        int mAccuracy = secret.guess(allMString);
        if (mAccuracy == 16) {
            System.out.println("Secret key: " + allMString);
            return;
        }
        ArrayList<Integer> mCorrect = secret.correctPosition(allMString);
        // Total number of I
        int iAccuracy = secret.guess(allIString);
        if (iAccuracy == 16) {
            System.out.println("Secret key: " + allIString);
            return;
        }
        ArrayList<Integer> iCorrect = secret.correctPosition(allIString);
        // Total number of T
        int tAccuracy = 16 - rAccuracy - mAccuracy - iAccuracy;
        if (tAccuracy == 16) {
            System.out.println("Secret key: " + allTString);
            return;
        }
        ArrayList<Integer> tCorrect = secret.correctPosition(allTString);
        char[] correctGuess = new char[16];
        for (int i = 0; i < rAccuracy; i++) {
            int index = rCorrect.get(i);
            correctGuess[index] = 'R';
        }
        for (int i = 0; i < mAccuracy; i++) {
            int index = mCorrect.get(i);
            correctGuess[index] = 'M';
        }
        for (int i = 0; i < iAccuracy; i++) {
            int index = iCorrect.get(i);
            correctGuess[index] = 'I';
        }
        for (int i = 0; i < tAccuracy; i++) {
            int index = tCorrect.get(i);
            correctGuess[index] = 'T';
        }
        String correct = new String(correctGuess);
        int test = secret.guess(correct);
        System.out.println(test);
        return;
    }
}
