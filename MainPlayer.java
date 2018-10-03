package com.company;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by merli on 5/25/2018.
 */
public class MainPlayer extends GameObject {
	
	 MainPlayer(char[][] style, int width, int height, int positionX, int positionY) {
        ImageStyle = new char[width][height];
        for(int j = 0; j < height; j++) {
        	for(int i = 0; i < width; i++) {
        		this.ImageStyle[i][j] = style[i][j];
        	}
        }
        this.width = width;
        this.height = height;
        this.x = positionX;
        this.y = positionY;
    }
    
    
    boolean isVisible() {
        return this.visible;
    }
    
    boolean collision(Enemy monster){
        if(this.x == monster.getX() && this.y == monster.getY() && monster.isVisible()) {
            return true;
        }
        return false;
    }
    
  
    
}
