package com.company;
import java.util.ArrayList;

/**
 * Created by merli on 5/25/2018.
 */
public class GameObject {
    public boolean visible;
    public int width;
    public int height;
    public int x;
    public int y;
    char[][] ImageStyle;
    
    

    int getWidth() {
        return this.width;
    }
    int getHeight() {
        return this.height;
    }

    int getX() {
        return this.x;
    }
    int getY() {
        return this.y;
    }
    
    boolean isVisible() {
        return this.visible;
    }
    
    public char[][] getShape() {
    	return ImageStyle;
    }
    
    public boolean moveGridBased(char move) {
        if(move == 'L') {
            this.x -= width;
            return true;
        }
        else if(move == 'R') {
            this.x += width;
            return true;
        }
        else if(move == 'U') {
            this.y -= height;
            return true;
        }
        else if(move == 'D') {
            this.y += height;
            return true;
        }
        else {
            return false;
        }
    }

}