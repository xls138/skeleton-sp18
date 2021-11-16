public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        //Deque a = new LinkedListDeque();
        LinkedListDeque<Character> LLD = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            LLD.addLast(word.charAt(i));
        }
        return LLD;
    }

    public boolean isPalindrome(String word){
        Deque<Character>LLD = wordToDeque(word);
        char a,b;
        while (LLD.size()>1){
            a = LLD.removeFirst();
            b = LLD.removeLast();
            if(a!=b){
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character>LLD = wordToDeque(word);
        char a,b;
        while (LLD.size()>1){
            a = LLD.removeFirst();
            b = LLD.removeLast();
            if(!cc.equalChars(a,b)){
                return false;
            }
        }
        return true;
    }

}
