import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;

 class loop {

    public static void main(String[] args) {
        String[] cannedPhrases = {"Yes",
                                  "What do you want to do about lower taxes for the rich?",
                                  "What do you want to do about people who earn higher than $450,000 yearly?",
                                  "What do you want to do about universal basic income for democratic states?",
                                  "Interesting...",
                                  "Indeed"};
        int cannedTimes = cannedPhrases.length;
        Random rand = new Random();
        Scanner conversationStart = new Scanner(System.in);  
        System.out.println("Machine learning AI program for WGU written by Jamie Morrissey\nin December 2023, insert Left-Wing, Right-Wing, Democrat, or Republican for input of choice.");
        System.out.println("How many rounds of conversation would you like to have?\n");
        int rounds = conversationStart.nextInt();
        conversationStart.nextLine();
        String[] transcript = new String[2 * rounds + 1];
        transcript[0] = "Sounds great! How are you doing today?";
        System.out.println(transcript[0]);
        
        int index = -1;
        for (int i = 0; i < 4; i++) { // Main program loop
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
                switch(word) {
                    case "lower": // data_1.txt
                        
                        try {             
                            FileWriter output_1 = new FileWriter("new_file.txt", true);
                            output_1.write(word);
                            output_1.close();
                        }

                        catch (Exceptionn e) {
                            e.getStackTrace();
                        }
                        word = "higher";
                        break;
                    case "higher": // data_2.txt
                        word = "lower";
                        FileWriter output_2 = new FileWriter("new_file_2.txt", true);
                        break;
                    case "medium": // data_3.txt
                        word = "Republican";
                        break;
                    case "free": // data_4.txt
                        word = "Democrat";
                        break;
                    }
                result.append(word);
            }
            String newVersion = result.toString();
            if (!newVersion.equals(userWords)) {
                mirrored = newVersion;
            }
            else {
                mirrored = cannedPhrases[rand.nextInt(cannedTimes)];
            }
            System.out.println(mirrored);
            transcript[++index] = userWords;
            transcript[++index] = mirrored;
        }
        System.out.println("Thank you for chatting with me! Come back soon!");
        System.out.println(" ");
    }
}