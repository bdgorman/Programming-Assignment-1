import java.io.*;
import java.nio.charset.Charset;

public class TextReader {
    public LinkedList<Word> readText() {
        String fileName = "ThePictureOfDorianGray.txt";
        LinkedList<Word> wordList = new LinkedList<Word>();

        try {
            String line;
            InputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);

            while ((line = br.readLine()) != null) {

                line = line.toLowerCase();
                String[] lineArray = line.split("\\W+");

                for (String word : lineArray){
                    if (!word.isEmpty()) {
                        Word wordObj = new Word();
                        wordObj.setWordString(word);
                        if (isRepeat(wordObj, wordList) == false) {
                            wordList.addToHead(wordObj);
                        }
                    }

                }



            }
            fis.close();

        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file " + fileName);
        } catch (IOException e) {
            System.out.println("Problem with input from file " + fileName);
        }
//        wordList.resetIterator();
//        wordList.deleteFromHead();
        return wordList;
    }
    public boolean isRepeat(Word data, LinkedList<Word> wordList) {

        wordList.resetIterator();
        while(wordList.hasNext()) {
            Word n = wordList.next();
            if (n.equals(data))
            {
                n.increaseQuantity();
                return true;
            }

        }
        return false;
    }
}
