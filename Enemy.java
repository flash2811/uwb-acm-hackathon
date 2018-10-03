package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by merli on 5/25/2018.
 */
public class Enemy extends GameObject {
      Enemy(char[][] style, int width, int height, int positionX, int positionY) {
           for(int i = 0; i < width; i++) {
           	for(int j = 0; j < height; j++) {
           		this.ImageStyle[i][j] = style[i][j];
           	}
           }
           this.width = width;
           this.height = height;
           this.x = positionX;
           this.y = positionY;
    }
    
}