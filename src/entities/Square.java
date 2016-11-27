package entities;

public class Square {

    Position position;
    Tile tile;
    boolean enabled;

    public Square(Position p, boolean enabled, Tile t) {
        this.position = p;
        this.enabled = enabled;
        this.tile = t;
    }
    
    public Square(Position p, boolean enabled) {
        this.position = p;
        this.enabled = enabled;
        this.tile = null;
    }
    
    void generateRandomTile () {
        //TODO pseudo-rand generator
    }
    
    void tileAdd (Tile t) {
        this.tile = t;
    }
    
    Tile tilePeek () {
        return tile;
    }
    
    Tile tilePop () {
        Tile t = tile;
        tileRemove();
        return t;
    }
    
    void tileRemove () {
        tile = null;
    }
    
    
    
    
    

}
