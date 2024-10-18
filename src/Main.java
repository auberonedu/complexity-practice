import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Main {

  // The time complexity is:
  // O(n^2) (Oh n-squared)
  public static void timesTable(int x) {
    for(int i = 1; i <= x; i++) { //O(n)
        for(int j = 1; j <= x; j++) { //*O(n)
            System.out.print(i*j + " ");//O(1)
        }
        System.out.println(); //O(n)
    }
  }

  // The time complexity is:
  // O(n)
  public static void printLetters(String word) {
    char[] letters = word.toCharArray(); //O(1)

    for (char letter : letters) { //O(n)
        System.out.println(letter); //O(1)
    }
  }

  // The time complexity is:
  // O(1)
  public static boolean isBanned(String password) {
    String[] bannedPasswords = {"password", "hello", "qwerty"}; //O(1)
    boolean banned = false; //O(1)
    for(String bannedPassword : bannedPasswords) { //O(1) - fixed-length list (would be O(n) if variable)
        if(password.equals(bannedPassword)) {
            banned = true; //O(1)
        }
    }
    return banned;
  }


  // The time complexity is:
  // O(n)
  public static int computeProduct(int[] nums) {
    int total = 1; //O(1)
    for(int num : nums) { //O(n)
        total *= num; //O(1)
    }
    return total;
  }

  // The time complexity is:
  // O(n) (calling computeProduct(nums) which is O(n))
  public static void describeProduct(int[] nums) {
    System.out.println("About to compute the product of the array...");
    int product = computeProduct(nums);
    System.out.println("The product I found was " + product);
  }


  // The time complexity is:
  // O(n)
  public static int computeFactorial(int n) {
    int result = 1;
    for(int i = 1; i <= n; i++) {
        result *= n;
    }
    return result;
  }

  // Assume that the largest number is no bigger than the length
  // of the array

  //Time complexity is O(n^2)
  public static void computeAllFactorials(int[] nums) {
    for(int num : nums) {
        int result = computeFactorial(num);
        System.out.println("The factorial of " + num + " is " + result);
    }
  }


  // The time complexity is:
  // O(n) - contains() performs linear search
  public static void checkIfContainedArrayList(ArrayList<String> arr, String target) {
    if (arr.contains(target)) {
        System.out.println(target + " is present in the list");
    } else {
        System.out.println(target + " is not present in the list");
    }
  }


  // assume n = wordsA.length = wordsB.length
  // The time complexity is:
  // O(n^2)
  public static boolean containsOverlap(String[] wordsA, String[] wordsB) {
    for(String wordA : wordsA) {
        for(String wordB : wordsB) {
            if(wordA.equals(wordB)) {
                return true;
            }
        }
    }
    return false;
  }

  // The time complexity is:
  // O(n)
  public static boolean containsOverlap2(String[] wordsA, String[] wordsB) {
    Set<String> wordsSet = new HashSet<>();
    for(String word : wordsA) {
        wordsSet.add(word);
    }

    for(String word : wordsB) {
        if(wordsSet.contains(word)) {
            return true;
        }
    }

    return false;
  }

  // The time complexity is:
  // O(n)
  public static void printCharacters(char[] chars) {
    for (int i = 0; i < chars.length; i++) {
      char character = chars[i];
      System.out.println("The character at index " + i + " is " + character);
    }
  }
  // The time complexity is:
  // O(1)
  public static double computeAverage(double a, double b) {
    return (a + b) / 2.0;
  }
  // The time complexity is:
  // O(1)
  public static void checkIfContainedHashSet(HashSet<String> set, String target)
  {
    if (set.contains(target)) {
      System.out.println(target + " is present in the set");
    } else {
      System.out.println(target + " is not present in the set");
    }
  }

  // emailLookup attempts to find the email associated with a name.
  // The name at index i of names corresponds to the email at index i of emails
  // A queryName is given, and this method returns the corresponding email if it is found
  // Otherwise, it returns "Person not found"
  // What is the time complexity of this method?
  // O(n)
  public static String emailLookup(String[] names, String[] emails, String queryName) {
    for(int i = 0; i < names.length; i++) {
      if (names[i].equals(queryName)) {
        return emails[i];
      }
    }
    return "Person not found";
  }

  // Suppose that emailLookupEfficient performs the same task as emailLookup
  // However, instead of two arrays it is passed a map where the
  // keys are names and the values are emails.
  // Write this method to efficiently return the corresponding email or "Person not found" if appropriate
  // What is the time complexity of your solution?
  // O(1)
  public static String emailLookupEfficient(HashMap<String, String> namesToEmails, String queryName) {
    //use HashMap get method to find email associated with queryName
    String email = namesToEmails.get(queryName);

    //if email null
    if (email == null) {
        return "Person not found";
    }

    return email;
  }

  // What is the time complexity of this method?
  // (assume the set and list have the same number of elements)
  // O(n^2) (this method is inefficient/backwards)
  public static boolean hasCommon(HashSet<String> wordSet, ArrayList<String> wordList) {
    for(String word : wordSet) {
      if(wordList.contains(word)) {
        return true;
      }
    }
    return false;
  }
  // Rewrite hasCommon so it does the same thing as hasCommon, but with a better time complexity.
  // Do not change the datatype of wordSet or wordList.
  // What is the time complexity of your new solution?
  // O(n)
  public static boolean hasCommonEfficient(HashSet<String> wordSet, ArrayList<String> wordList) {
    //iterate over the wordList (instead of over wordSet)
    for (String word : wordList) {
      //check if word present in wordSet
      if (wordSet.contains(word)) {
          return true;
      }
  }
  return false; //return false if no common word found
  }

  // Suppose you are building a dashboard that displays real-time stock prices.
  // You want to keep track of the current price of each stock, with the stock's ticker symbol as the key.
  // The prices will be updated frequently throughout the day, and you need to efficiently update
  // and access the current price for each stock. The order of the ticker symbols is not important.
  // What would be a good choice of data structure?
  // ** HashMap (efficient lookups O(1); efficient updates
  // O(1); order of ticker symbols not important)

  // Suppose you are building a music player application where users can create playlists.
  // Songs can be added to the end of the playlist in the order the user chooses, and the user can
  // skip to the next or previous song. Most operations involve adding songs and accessing them by
  // their position in the playlist.
  // What would be a good choice of data structure?
  // ** LinkedList (efficient adding of songs especially at end of list; users usually listen to songs in sequential order, LinkedList is good for this; random access would be O(n) however)

  // Suppose you are developing a search feature that keeps track of the user's
  // recent search queries. You want to store the queries in the order they were made,
  // so you can display them to the user for quick access. The number of recent searches is
  // relatively small, and it is more important to preserve the order of the searches than
  // to optimize for fast lookups or deletions.
  // What would be a good choice of data structure?
  // ** I would think a LinkedList would again be the
  //best choice here (a LinkedList implemented as a queue actually); this would preserve order for a small number of queries and allow for efficient additions
}