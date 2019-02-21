import java.util.Objects;

public class Word {
    private String wordString;
    private int quantity = 1;


    public Word() {

    }

    public int getQuantity() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity += 1;
    }
    public Word(String data) {
        this.wordString = data;
    }

    public String getWordString() {
        return wordString;
    }

    public void setWordString(String data) {
        this.wordString = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;
        Word word = (Word) o;
        return getWordString().equals(word.getWordString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWordString());
    }

    public String toString() {
        String tempString = wordString + " " + quantity;
        return tempString;
    }

}
