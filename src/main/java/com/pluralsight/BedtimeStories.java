package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BedtimeStories {
    public static  void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the name of a story: ");
        String fileName = scanner.nextLine().trim();

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader buffReader = new BufferedReader(fileReader);

            String input;
            int lineNumber = 1;

            while ((input = buffReader.readLine()) != null) {
                System.out.println(lineNumber + ". " + input);
                lineNumber++;
            }
            buffReader.close();
        } catch (IOException e) {
            System.out.println("Sorry, I couldn't read \"" + fileName + "\". Check the file name and try again.");
        }

        scanner.close();
    }
}


//  Unzip the DataFiles.zip file and copy the three children's stories to your bedtime-stories project folder.
// (goldilocks.txt, hansel_and_gretel.txt and mary_had_a_little_lamb.txt).
//  Each story text file contains a children’s bedtime story.
//      For example:
//          goldilocks.txt
//  Goldilocks and the Three Bears
//  Once upon a time a girl named Goldilocks lived in a house at the edge of the woods.
//  In those days curls of hair were called "locks."
//  She was "Goldilocks" because golden hair ran down her head and shoulders.
//      Prompt the user for the name of the story/file to read.
//      Use a new BufferedReader to load and read each line of the selected story in the file.
//      Print the file to the screen, but add a line number to the beginning of each line
//  Enter the name of a story: goldilocks.txt
//      1.  Goldilocks and the Three Bears
//      2.
//      3.  Once upon a time a girl named Goldilocks lived in
//      4.  a house at the edge of the woods. In those days
//      5.  curls of hair were called "locks."  She was
//      6.  "Goldilocks" because golden hair ran down her head
//      7.  and shoulders.