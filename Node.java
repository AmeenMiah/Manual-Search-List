public class Node {
    int value = 0;
    char letter = ' ';
    String letters = "";

    public Node(int value, char letter, String letters) {
        this.value = value;
        this.letter = letter;
        this.letters = letters;
    }


    public char getLetter() {
        return letter;
    }

    public String getLetters() {
        return letters;
    }

    public int getValue() {
        return value;
    }


}
