package basicsofdsa;

public class SplitWordsInString {


    public static void main(String[] args) {
        String sentence = "Java is fun to learn";
        String[] words = sentence.split(" "); // Split by space

        // multiple spaces
        String sentence2 = "Java   is   fun";
        String[] words2 = sentence.split("\\s+");

        // Print the resulting array
        for (String word : words) {
            System.out.println(word);
        }
    }


}
