public class Driver {

    public static void main(String[] args) {
        Driver me = new Driver();
        me.doIt();

    }

    public void doIt() {

        TextReader readerObj = new TextReader();
        LinkedList wordList = readerObj.readText();


        // get frequency of words
        String[] someWords = {"portrait", "persian", "dorian", "experimental", "magnetic"};
        for (String word : someWords) {
            int num = getFrequency(word, wordList);
            System.out.printf("\n%s %d\n", word, num);
        }

        // get entries in list
        int count = wordList.getCount();
        System.out.printf("\nNumber of word entries: %d \n", count);
        System.out.println("");

        // get words that occur more than 20 times
        LinkedList<Word> overtwenty = wordsTwentyPlus(wordList);
        overtwenty.resetIterator();
        while (overtwenty.hasNext())
        {
            System.out.println(overtwenty.next());
        }

        // get longest word in linked list
        Word longest = longestWord(wordList);
        String longestString = longest.getWordString();
        int length = longestString.length();
        System.out.printf("\nLongest Word in text: \'%s\'\tLength: %d\n", longestString, length);

        // get word before word 'irritating' (in the Linked list which is
        // reversed from order the word appears in text)
        Word wordBefore = wordBefore(wordList, "irritating");
        String beforeString = wordBefore.getWordString();
        System.out.printf("\nThe word that appears before the word \'irritating\' in list is: \'%s\'", beforeString);

        //get word that *appears* after 'irritating' in the text
        Word wordAfter = wordAfter(wordList, "irritating");
        String afterString = wordAfter.getWordString();
        System.out.printf("\nThe word that appears after the word \'irritating\' in text is: \'%s\'", afterString);
    }


    public int getFrequency(String word, LinkedList<Word> wordList) {

        wordList.resetIterator();

        while (wordList.hasNext()) {
            Word n = wordList.next();
            if (n.getWordString().equals(word)) {
                return n.getQuantity();
            }
        }
        return 0;
    }

    public LinkedList<Word> wordsTwentyPlus(LinkedList<Word> wordList) {

        LinkedList<Word> wordArray = new LinkedList<>();

        wordList.resetIterator();
        while (wordList.hasNext()) {
            Word n = wordList.next();
            if (n.getQuantity() > 20 && n.getWordString() != null) {
                wordArray.addToHead(n);

            }
        }
        return wordArray;
    }
    public Word longestWord(LinkedList<Word> wordList){

        Word highest;
        wordList.resetIterator();
        highest = wordList.next();
        while (wordList.hasNext()) {
            Word n = wordList.next();
            if (n.getWordString().length() > highest.getWordString().length()){
                highest = n;
            }
        }
        return highest;
    }
    public Word wordBefore(LinkedList<Word> wordList, String goalString) {
        String goal = goalString;
        Word lastWord = null;

        wordList.resetIterator();
        while (wordList.hasNext()) {
            Word n = wordList.next();
            if (lastWord != null && n.getWordString().equals(goal)) {
                return lastWord;
            }else{
                lastWord = n;
            }

        }
        return lastWord;
    }
    public Word wordAfter(LinkedList<Word> wordList, String goalString) {
        String goalWord = goalString;
        Word lastWord = null;

        wordList.resetIterator();
        while (wordList.hasNext()) {
            Word n = wordList.next();
            if (lastWord!= null && lastWord.getWordString().equals(goalWord)) {
                return n;
            } else {
                lastWord = n;
            }
        }
        return lastWord;
    }
}