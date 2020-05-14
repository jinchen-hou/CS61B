public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordToDeque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            wordToDeque.addLast(c);
        }
        return wordToDeque;
    }

    public boolean isPalindrome(String word){
        return isPalindrome(wordToDeque(word));
    }

    public boolean isPalindrome(Deque<Character> d){
        while (d.size() >1){
            return d.removeFirst() == d.removeLast() && isPalindrome(d);
        }
        return true;
    }

    //Implement isPalindrome with OffByOne
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque d = wordToDeque(word);
        while (d.size() > 1){
            return cc.equalChars((char)d.removeFirst(), (char)d.removeLast()) || isPalindrome(d);
        }
        return true;
    }


}
