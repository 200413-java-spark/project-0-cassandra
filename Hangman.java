import java.util.Random;
import java.util.Scanner;

class Hangman {

    public static void main(String args[]){

        String[] words = new String[]{"Pasta", "Skirt", "Zebra", "Faith"};
        Scanner hangman = new Scanner(System.in);
        Random rand = new Random();

        int wordIndex = rand.nextInt(4);
        String wordToGuess = words[wordIndex];
        int score = 0;
        int guessesRemaining = 6;
        boolean playing = true;

        while (playing == true) {
            System.out.println(wordToGuess);
            System.out.println("Enter guess");
            String guess = hangman.nextLine();
            boolean correctGuess = wordToGuess.contains(guess);

            //implement logic

            System.out.println("Playing " + playing);
            System.out.println("Score " + score);
            System.out.println("Guesses " + guessesRemaining);
        }

    }
}


// Stick man symbols to use
        //  0
        // -|-
        //  /\