package entities;

import java.io.Serializable;

public class Position implements Serializable {
    private int x, y;
    
    public Position (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    void updateY (int y) {
        this.y = y;
    } 
    
    void updateX (int x) {
        this.x = x;
    }
    
    int getX () {
        return x;
    }
    
    int getY() {
        return y;
    }
}
