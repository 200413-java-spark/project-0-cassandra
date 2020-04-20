package com.github.wewe34.hangman;

import java.util.Random;
import java.util.Scanner;

public class WordGenerator {

    String wordToGuess;

    public String generateWord(){
        String[] words = new String[]{"lightbulb", "pasta", "skirt", "zebra", "faith", "banana", "microsystem"};
        Random rand = new Random();
        int wordIndex = rand.nextInt(4);
        wordToGuess = words[wordIndex];
        return wordToGuess;
    }

    public String[] generateBlankArray(){
        // creating string of underscores for player to track progress of guesses
        String[] correctGuessArray =  new String[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
                correctGuessArray[i] = "_";
        }
        return correctGuessArray;
    }
}