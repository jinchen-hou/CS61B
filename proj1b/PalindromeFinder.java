/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {

    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words.txt");
        Palindrome palindrome = new Palindrome();
        CharacterComparator offBy1 = new OffByOne();

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, offBy1)) {
                System.out.println(word);
            }
        }
    }
//    Uncomment this class once you've written isPalindrome.
}