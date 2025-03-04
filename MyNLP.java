import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class traverses through the passwords and goodpasswords txt files and
 * checks to see if the user put a password similar in the console. It then uses
 * logic to check and returns a random password using a method.
 *
 * Precondition: There must be at least 1 string in each txt file and the user
 * must input a password for the algorithm
 * Postcondition: Must return either response of bad or good and return a good password
 * choice
 *
 * @param Class Definiton
 * @return Response of Good Password
 */

public class MyNLP {

private ArrayList<String> passwords;
private ArrayList<String> goodPasswords;


/**
 * This reads the passwordsFile.txt and goodPasswords.txt and stores them.
 *
 * Precondition: There needs to be a txt file to read
 * Postcondition: Stores two files into two ArrayLists
 *
 * @param No parameters
 * @return Stores text into ArrayList variables
 */

  public MyNLP(){
  passwords = FileReader.toStringList("passwordsFile.txt");
  goodPasswords = FileReader.toStringList("goodPasswords.txt");
  }

 
  public void printSummary(){
    System.out.println(goodPasswords);
  }

/**
 * Prints out the text in the console
 *
 * Precondition: Must enter password
 * Postcondition: returns finder
 *
 * @param No parameters
 * @return finder
 */

  public String promptUser() {
    Scanner input = new Scanner(System.in);
    System.out.println("Please Enter a Password You Would Wish to Use: ");
    System.out.println("--------------------------------------------------------------");
    String userInput = input.nextLine();
    String finder = findByWord(userInput);
    input.close();
    return finder;
  }
 
/**
 * Uses Math.random to find a random password
 *
 * Precondition: There needs to be at least one index in the goodPasswords
 * Postcondition: returns randPassword
 *
 * @param No parameters
 * @return Returns randPassword
 */

  public String randomWord(){
    for(int i = 0; i < goodPasswords.size(); i++){
      int randomindex = (int)(Math.random() * goodPasswords.size());
      String randPassword = goodPasswords.get(randomindex);
      return randPassword;
    }
    return null;
  }

/**
 * Traverses passwords and uses logic to check if the user entered a password
 * similar to the non-secure passwords.
 *
 * Precondition: Must be an input from user
 * Postcondition: Returns one ouput
 *
 * @param One Paramter String word
 * @return Returns security verification
 */

  public String findByWord(String word) {
    for (int i = 0; i < passwords.size(); i++){
    if (passwords.get(i).equals(word)){
        return "\n" + "You should not use this password, it isnt secure." + "\n" + "Instead Use This: " + "\n" + randomWord();
    }
  }
    return "\n" + "Great Password Choice! If you still feel it isnt what you want, feel free to use This!" + "\n" + randomWord();
  }

  }
