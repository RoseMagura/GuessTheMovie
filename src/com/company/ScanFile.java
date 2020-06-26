package com.company;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class ScanFile {
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
            
        } catch (FileNotFoundException e) {
            System.out.println("Could not locate file.");
        }}}

