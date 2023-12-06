import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;

 class loop {

    public static void main(String[] args) {
        String[] cannedPhrases = {"Do you want free universal income for people with no income?",   // Democrat
                                  "What do you want to do about lower taxes for the rich?", // Democrat
                                  "What do you want to do about people who earn higher than $450,000 yearly?",  // Republican
                                  "What do you want to do about universal basic income for democratic states?",
                                  "Do you want people who make $150,000 and have no kids to pay higher taxes?"};
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
        for (int i = 0; i < rounds; i++) { // Main program loop
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
                        word = "higher";
                        try {
                            String str = word;
                            File newTextFile = new File("C:/DATA_JAMIE/higher.txt");
                            FileWriter fw = new FileWriter(newTextFile);
                            fw.write(word);
                            fw.close();
                        }
                        catch (Exception e) {
                            e.getStackTrace();
                        }
                        break;
                    case "higher": // data_2.txt
                        word = "lower";
                        try {
                            String str = word;
                            File newTextFile = new File("C:/DATA_JAMIE/lower.txt");
                            FileWriter fw = new FileWriter(newTextFile);
                            fw.write(word);
                            fw.close();
                        }
                        catch (Exception e) {
                            e.getStackTrace();
                        }
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
        Scanner myObj2 = new Scanner(System.in);
        System.out.println("What political party do you affiliate with?");  // ask final question in program to determin which politial party they are affiliated with
    }
}