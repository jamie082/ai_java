import java.util.Scanner;  // import settings specified 
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;


 class loop {

    public static void main(String[] args) {  // type in these questions in the prompt to ask it the questions
        String[] cannedPhrases = {"Do you want legalization in all 50 states?",   // Democrat   these are the responses
                                  "What do you want to do about lower taxes for the rich?", // Democrat
                                  "What do you want to do about people who earn higher than $450,000 yearly?",  // Republican
                                  "What do you want to do about universal basic income for democratic states?", // Democrat
                                  "Do you want people who make $150,000 and have no kids to pay higher taxes?"}; // Republican
        int cannedTimes = cannedPhrases.length;
        Random rand = new Random();
        Scanner conversationStart = new Scanner(System.in);  
        System.out.println("Machine learning AI program for WGU written by Jamie Morrissey\nin December 2023, Please see source file for input choices.");
        System.out.println("How many questions do you want me to ask?\n");
        int rounds = conversationStart.nextInt();
        //conversationStart.nextLine();
        String[] transcript = new String[2 * rounds + 1];
        transcript[0] = "Sounds great! How are you doing today?"; // ask "how are you doing today?"
        System.out.println(transcript[0]);
        int index = -1;
        int myHigher = 001, myLower = 002, myFree = 003, myUniversal = 004;
        for (int i = 1; i <= rounds; i++) { // Main program loop, loop amount of times specified by input
            String userWords = conversationStart.nextLine();
            String mirrored;
            StringBuilder result = new StringBuilder();
            String[] words = userWords.split(" ");
            boolean first = true;
            for (String word : words) {
                if (first) {
                    first = false;
                }
                else {
                    result.append(' ');
                }
                switch(word) {  // use switch keyword for AI
                    case "lower": // data_1.txt
                        word = "Democrat"; // write "higher" to data_1.txt
                        try {
                            File newTextFile =new File("higher.txt"); // open higher.txt for writing
                            /* This logic is to create the file if the
                            * file is not already preent */

                            if(!newTextFile.exists()) { // if text file exists, then dont overwrite it
                                newTextFile.createNewFile();
                            }

                            String str = word;

                            // Here true is to append the content to file
                            FileWriter fw = new FileWriter(newTextFile); // append s set to true
                            // BufferedWriter writer give better perforamance
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(str + "\n"); // write str plus new line 
                            // Closing BufferedWriter stream
                            bw.close();  // close bw
                            System.out.println("Data successfully appened at the end of the file");
                            // read text file in Java
                            File myObj = new File("higher.txt");
                            Scanner myReader = new Scanner(myObj);
                            while (myReader.hasNextLine()) {     // read the data
                                String lower_string = myReader.nextLine();
                                //System.out.println(data);
                            }
                            myReader.close();
                            ++myLower;
                        }
                        catch (Exception e) {
                            e.getStackTrace();
                        }
                        break;
                    case "higher": // data_2.txt
                        word = "Republican"; // write "lower" to lower.txt
                        try {
                            File newTextFile =new File("lower.txt");
                            if(!newTextFile.exists()) {
                                newTextFile.createNewFile();
                            }

                            String str = word;

                            // Here true is to append the content to file
                            FileWriter fw = new FileWriter(newTextFile);
                            // BufferedWriter writer give better perforamance
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(str + "\n");
                            // Closing BufferedWriter stream
                            bw.close(); 
                            System.out.println("Data successfully appeded at the end of the file");
                            File myObj2 = new File("lower.txt");
                            Scanner myReader = new Scanner(myObj2);
                            while (myReader.hasNextLine()) {
                                String higher_string = myReader.nextLine();
                                //System.out.println(data);
                            }
                            ++myHigher;
                        }
                        catch (Exception e) {
                            e.getStackTrace();
                        }
                        break;
                    case "free": // data_3.txt
                        word = "Democrat";
                        try {
                            File newTextFile =new File("free.txt"); // open Text file for writing, democrat.txt
                            /* This logic is to create the file if the
                            * file is not already preent */

                            if(!newTextFile.exists()) {
                                newTextFile.createNewFile();
                            }

                            String str = word;

                            // Here true is to append the content to file
                            FileWriter fw = new FileWriter(newTextFile);
                            // BufferedWriter writer give better perforamance
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(str + "\n");
                            // Closing BufferedWriter stream
                            bw.close(); 
                            System.out.println("Data successfully appened at the end of the file");
                            File myObj2 = new File("free.txt");
                            Scanner myReader = new Scanner(myObj2);
                            while (myReader.hasNextLine()) {
                                String free_string = myReader.nextLine();
                                //System.out.println(data);
                            }
                            ++myFree;
                        }
                        catch (Exception e) {
                            e.getStackTrace();
                        }
                        break;
                    case "legalization": // data_4.txt
                        word = "Democrat";
                        try {
                            File newTextFile =new File("legalization.txt");
                            /* This logic is to create the file if the
                            * file is not already preent */

                            if(!newTextFile.exists()) {
                                newTextFile.createNewFile();
                            }

                            String str = word; // use String statement 

                            // Here true is to append the content to file
                            FileWriter fw = new FileWriter(newTextFile);
                            // BufferedWriter writer give better perforamance
                            BufferedWriter bw = new BufferedWriter(fw);
                            bw.write(str + "\n"); // write to data file 
                            // Closing BufferedWriter stream
                            bw.close();  // close data file 
                            System.out.println("Data successfully appened at the end of the file");
                            File myObj2 = new File("legalization.txt");
                            Scanner myReader = new Scanner(myObj2);
                            while (myReader.hasNextLine()) {
                                String legalization_string = myReader.nextLine();
                                //System.out.println(data);
                            }
                            ++myUniversal;
                        }
                        catch (Exception e) {  // if exception is caught
                            e.getStackTrace();
                        }
                        break;   // use break statement
                    }
                result.append(word);

            }

            String newVersion = result.toString();
            if (!newVersion.equals(userWords)) { // if else statements
                mirrored = newVersion;
            }
            else {
                mirrored = cannedPhrases[rand.nextInt(cannedTimes)];
            }
            System.out.println(mirrored);
            transcript[++index] = userWords;
            transcript[++index] = mirrored;
        }
        Scanner myObj = new Scanner(System.in);
        System.out.println("What political party do you affiliate with?");  // ask final question in program to determin which politial party they are affiliated with
        String pol_party = myObj.nextLine();
        System.out.println("Your political party is " + pol_party);
        // Compute the output for what party you are affiliated with
        int guessed_variable = 0;
        guessed_variable = myHigher + myLower + myFree + myUniversal; // guess political affiliation
        System.out.println(guessed_variable); // output String or integer
    }
}