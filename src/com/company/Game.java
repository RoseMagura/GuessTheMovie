package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Game {
    File file = new File("movies.txt");
    {
        try {
           Scanner scanner = new Scanner(file);
           String[] movieList = new String[30];
           int numMovies = 0;
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                movieList[numMovies] = line;
                numMovies++;
            }

            int random = new Random().nextInt(numMovies);
            String pick = movieList[random];
            String answer = pick.replaceAll(" ", "_");
            StringBuilder mystery = new StringBuilder("                             ");
            for(int i=0; i<pick.length(); i++){
                mystery.setCharAt(i, '_');
            }
            System.out.println("Let's play a guessing game!");
            System.out.println("Mystery movie title: " + mystery);

            int wrongGuesses = 0;
            Scanner scanner2 = new Scanner(System.in);
            char [] wrongLetters = new char[10];

            while(wrongGuesses < 10){
                String mysteryString = mystery.toString().trim();
                   if (mysteryString.equals(answer)) {
                            System.out.println("You won!");
                            break;
                        }
            System.out.print("Guess a letter: ");
            char guess = scanner2.next().charAt(0);
//           Use regex to only allow letters?  
            int index = pick.indexOf(guess);
            if(index == -1){
                boolean contains = false;
                for(char c : wrongLetters){
                    if ( c == guess){
                        contains = true;
                        break;
                    }
                }
                if (!contains){
                   wrongLetters[wrongGuesses] = guess;
                   String wrongList = Arrays.toString(wrongLetters);

                   System.out.println("You have guessed " + (wrongGuesses + 1)+ " wrong letter(s): " +
                           wrongList.replaceAll("[\\[\\],]", ""));
                    wrongGuesses++;
            }      }
            else{
                 mystery.setCharAt(index, guess);
                 while(index >= 0){
//                           System.out.println(index);
                           mystery.setCharAt(index, guess);
                           index = pick.indexOf(guess, index+1);
                       }
                 System.out.println(mystery);
            }
                     if(wrongGuesses >= 10){
                          System.out.println("You lost");
                     }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
