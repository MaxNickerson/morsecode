import java.util.*;

public class Morse {

    private static String[] alphabet = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
                "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
                "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8",
                "9", "0"};
    
    private static String[] morseCodes = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....",
            "-....", "--...", "---..", "----.", "-----"};

    static HashMap<String, String> morseConversion = new HashMap<>(); // basically like a dictionary in python


    public static ArrayList<String> decodeMorse(String encMessage) {
        /**
         * HINT: use your own methods to execute your recursion
         *       (feel free to add as many methods as you need),
         *       you CANNOT change the number of arguments in
         *       this `decodeMorse` method
         */
        for (int i = 0; i < alphabet.length; i++) 
        {
            morseConversion.put(morseCodes[i],alphabet[i]);
            // System.out.println(morseConversion.get(morseCodes[i])); // testin
        }
        
        ArrayList<String> result = new ArrayList<>();

        decodePlus(encMessage, result, ""); // recursion!!

        return result;
        
    }

    public static void decodePlus(String encMessage, ArrayList<String> result, String word) {

        if (encMessage.length() == 0) // base case
        {
            result.add(word);
        }

        for (int i = 1; i <= encMessage.length(); i++)  // loopin through the string
        {
            String morse = encMessage.substring(0, i); // splittin da string

            if (morseConversion.containsKey(morse)) // if da string is in the morse code
            {
                decodePlus(encMessage.substring(i), result, word + morseConversion.get(morse)); // repeat and add word
            }
            
        }
    
    }

    public static void main(String[] args) {
        /**
         * The `decoded` array list should contain 
         * ["tet", "ta", "nt", "k"] in any order
         * if you pass "-.-" as an argument
         */

        ArrayList<String> decoded = decodeMorse("-.-");

        ArrayList<String> decoded1 = decodeMorse("-.-.-");

        for (String words : decoded1) // testing
        {
            System.out.println(words);
        }
        
    }
}
