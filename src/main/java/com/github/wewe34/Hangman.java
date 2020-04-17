package com.github.wewe34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.WrappedPlainView;

class Hangman {

    public static void main(String args[]){

        String[] words = new String[]{"lightbulb", "pasta", "skirt", "zebra", "faith", "banana", "microsystem"};
        Scanner hangman = new Scanner(System.in);
        Random rand = new Random();

        int wordIndex = rand.nextInt(4);
        String wordToGuess = words[wordIndex];
        char[] wordToGuessArray = wordToGuess.toCharArray();
        int guessesRemaining = 6;
        boolean win = false;
        String[] correctGuessArray =  new String[wordToGuess.length()];

        for (int i = 0; i < wordToGuess.length(); i++) {
                correctGuessArray[i] = "_";
        }

        while (guessesRemaining > 0 && win == false) {
            System.out.println(Arrays.toString(correctGuessArray));
            System.out.println(wordToGuess);
            System.out.println("Enter guess");
            String guess = hangman.nextLine().toLowerCase();
            char guessChar = guess.charAt(0);
            boolean correctGuess = wordToGuess.contains(guess);

            if (correctGuess == true) {
                //find the index of matching character
                System.out.println("CORRECT");
                for(int i = 0; i < wordToGuess.length(); i++){
                    if (wordToGuessArray[i] == guessChar){
                            correctGuessArray[i] = guess;
                    }
                }
                boolean containsUnderScore = Arrays.stream(correctGuessArray).anyMatch("_"::equals);
                if (containsUnderScore == false) {
                    win = true;
                    System.out.println("YOU WON. THE WORD WAS " + wordToGuess + "!");
                }
            }
            else {
                if(guessesRemaining == 1){
                    System.out.println("SORRY. YOU HAVE NO MORE GUESSES LEFT. THE WORD WAS " + wordToGuess);
                }
                guessesRemaining -= 1;
                System.out.println("WRONG GUESS. YOU HAVE " + guessesRemaining + " GUESSES REMAINING.");
            }
        }

    }
}


// Stick man symbols to use
        //  0
        // -|-
        //  /\