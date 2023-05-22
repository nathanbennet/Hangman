package app;

import java.util.Arrays;

/**
 * Hangman
 */
public class Hangman {

    // check if the word is completed
    private String completed = "";

    // numbers of starting guesses
    private int guesses = 8;

    // check if it's a win or not
    private boolean win = false;

    // empty constructor
    public Hangman() {
    }

    // constructor with starting guesses parameters
    public Hangman(int guesses) {
        this.guesses = guesses;
    }

    // display the game
    public void displayGame(char[] game) {

        for (int i = 0; i < game.length; i++) {
            System.out.print(game[i]);

        }

    }

    // fill game
    public void fillGame(char[] game) {

        for (int i = 0; i < game.length; i++) {
            Arrays.fill(game, '-');

        }

    }

    // helper method for guessing
    public void findLetter(char[] game, Character userGuess, String secretWord) {

        // check if it's a valid a character
        if (!userGuess.toString().matches("[a-zA-Z]")) {

            System.err.println("Please enter a valid character from (A-Z)\n");
            return;

        }

        /// check if users input same letter
        LetterIsAlreadyFound(game, userGuess, secretWord);

        // if user guess is wrong
        if (secretWord.indexOf(userGuess) == -1) {

            // Decrements the guesses by 1
            guesses--;

            System.out.println("The Letter " + userGuess + " is not in the word.");

        }

        // Loop into each Char of the secret word and if the user enters the correct
        // Char replace it
        for (int i = 0; i < game.length; i++) {

            if (secretWord.charAt(i) == userGuess) {

                game[i] = userGuess;
                completed += userGuess;

            }

        }

        printCorrectGuess(game, userGuess, secretWord);
    }

    // helper method to print Correct! once letter found then break out loop to
    // avoid multiples
    // statements
    public void printCorrectGuess(char[] game, Character userGuess, String secretWord) {
        for (int i = 0; i < game.length; i++) {

            if (secretWord.charAt(i) == userGuess) {

                System.out.println("Correct!");
                break;

            }

        }

    }

    // helper method to check if user inputs the same letter twice or more
    public void LetterIsAlreadyFound(char[] game, Character userGuess, String secretWord) {

        for (int i = 0; i < game.length; i++) {

            if (game[i] == userGuess) {

                System.out.println("The Letter " + userGuess + " is already guessed");
                break;

            }

        }

    }

    // check if word is found
    public boolean isTheWordCompleted(char[] game, String secretWord) {
        String result = "";

        for (char c : game) {
            result += c;

        }

        if (result.equals(secretWord)) {
            win = true;
            return true;

        }

        return false;

    }

    // get and set methods
    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

    public int getGuesses() {
        return guesses;
    }

    public void setGuesses(int guesses) {
        this.guesses = guesses;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

}