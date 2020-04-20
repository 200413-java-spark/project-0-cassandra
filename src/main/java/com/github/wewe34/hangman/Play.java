package com.github.wewe34.hangman;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Play {


    public void playGame(){

        Scanner hangman = new Scanner(System.in);
        WordGenerator word = new WordGenerator();
        String wordToGuess = word.generateWord();
        String[] correctGuessArray = word.generateBlankArray();

        // word to guess turned to an array
        char[] wordToGuessArray = wordToGuess.toCharArray();

        // when to end game
        int guessesRemaining = 6;
        boolean win = false;
        ArrayList<String> playerGuesses = new ArrayList<>();

        while (guessesRemaining > 0 && win == false) {
            System.out.println("\nWORD HAS " + wordToGuess.length() + " LETTERS.");
            System.out.println("YOU HAVE  " + guessesRemaining + "  GUESSES REMAINING.");
            System.out.println("MYSTERY WORD: " + Arrays.toString(correctGuessArray));
            System.out.println("Enter guess");
            String guess = hangman.nextLine().toLowerCase();
            char guessChar = guess.charAt(0);
            boolean correctGuess = wordToGuess.contains(guess);
            playerGuesses.add(guess);

            if (correctGuess == true) {
                //find the index of matching character
                System.out.println("\n\nCORRECT!");
                for(int i = 0; i < wordToGuess.length(); i++){
                    if (wordToGuessArray[i] == guessChar){
                            correctGuessArray[i] = guess;
                    }
                }
                boolean containsUnderScore = Arrays.stream(correctGuessArray).anyMatch("_"::equals);
                if (containsUnderScore == false) {
                    win = true;
                    System.out.println("\nYOU WON. THE WORD WAS " + wordToGuess.toUpperCase() + "!");
                }
            }
            else {
                System.out.println("\n\nWRONG!");
                if(guessesRemaining == 1){
                    System.out.println("\nSORRY. YOU HAVE NO MORE GUESSES LEFT. THE WORD WAS--- " + wordToGuess.toUpperCase());
                }
                guessesRemaining -= 1;
            }
            System.out.println("YOUR GUESSES: " + Arrays.toString(playerGuesses.toArray()));
        }
    }
}