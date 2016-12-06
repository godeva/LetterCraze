package entities;

public class Tile {

    String letter;
    int value;

    public Tile (String letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public String toString () {
        return letter;
    }

    public int getPoints() {
        // TODO Auto-generated method stub
        return value;
    }
}

