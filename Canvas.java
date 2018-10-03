package com.company;
import java.io.*;
import java.util.*;



public class Canvas {
	
	private final char EMPTY_CHAR = '~';
	
    private int canvas_x;
    private int canvas_y;
    
    private int frame_x;
    private int frame_y;
    
    private int camera_x;
    private int camera_y;
    
    ArrayList<GameObject> foregroundObjects;
    ArrayList<GameObject> midgroundObjects;
    ArrayList<GameObject> backgroundObjects;
	
	ArrayList<GameObject> currFrameObjects;
    
    public Canvas(int canvas_x_, 
                int canvas_y_, 
                int frame_x_,
                int frame_y_, 
                int camera_x_, 
                int camera_y_) {
        
        canvas_x = canvas_x_;
        canvas_y = canvas_y_;
    
        frame_x = frame_x_;
        frame_y = frame_y_;
    
        camera_x = camera_x_;
        camera_y = camera_y_;
        
        foregroundObjects = new ArrayList<GameObject>();
        midgroundObjects = new ArrayList<GameObject>();
        backgroundObjects = new ArrayList<GameObject>();
		
		currFrameObjects = new ArrayList<GameObject>();
    }

    private void updateFrame() {
    	currFrameObjects = new ArrayList<GameObject>();
    	
		//For every object in the background arraylist
		for(int fg = 0; fg < backgroundObjects.size(); fg++){
			GameObject currObj = backgroundObjects.get(fg);
			//If the object is in the frame, render it to the frame.
			if(isInFrame(currObj)){
				currFrameObjects.add(currObj);
			}	
		}
		
		for(int fg = 0; fg < midgroundObjects.size(); fg++){
			GameObject currObj = midgroundObjects.get(fg);
			//If the object is in the frame, render it to the frame.
			if(isInFrame(currObj)){
				currFrameObjects.add(currObj);
			}	
		}
		
		for(int fg = 0; fg < foregroundObjects.size(); fg++){
			GameObject currObj = foregroundObjects.get(fg);
			//If the object is in the frame, render it to the frame.
			if(isInFrame(currObj)){
				currFrameObjects.add(currObj);
			}	
		}
    }
	
	private boolean isInFrame(GameObject other){
		if(((other.getWidth() + other.getX()) > (frame_x + camera_x )) ||		//Check if x + width is out of boundry.
		((other.getHeight() + other.getY()) > (frame_y + camera_y )) ||			//Check if y + height is out of boundry.
		(other.getX() < camera_x) ||											//Check if x is out of boundry.
		(other.getY() < camera_y)) {												//Check if y is out of boundry.
			return false;
		}
		
		
		return true;
		
	}

    public void setCameraPosition(int x, int y) {
        camera_x = x;
        camera_y = y;
    }

    public String Render() {
		Character[][] frame = new Character[frame_x][frame_y];
        updateFrame();
		//For every object in the current objects arraylist
		for(int fg = 0; fg < currFrameObjects.size(); fg++){
			GameObject currObj = currFrameObjects.get(fg);
			
			//If the object is in the frame, render it to the frame.
			if(isInFrame(currObj)){
				//For all the x and y values in the shape, copy it into the frame.
				
				for(int toDrawY = 0; toDrawY < currObj.getHeight(); toDrawY++){
					for(int toDrawX = 0; toDrawX < currObj.getWidth(); toDrawX++){
						frame[toDrawX + currObj.getX()][toDrawY + currObj.getY()] = (currObj.getShape())[toDrawX][toDrawY];
					}
				}
			}	
		}
		
		runAction();
		
		StringBuilder toReturn = new StringBuilder();
		for(int y = 0; y < frame_y; y++){
			for(int x = 0; x < frame_x; x++){
				if(frame[x][y] == null) {
					frame[x][y] = EMPTY_CHAR;
				}
				toReturn.append(frame[x][y]);

			}
			toReturn.append('\n');
		}
		
		return toReturn.toString();
    }
	
	void runAction()
	{
		
	}
   
    public void addFG(GameObject to_add){
        foregroundObjects.add(to_add);
    }
    
    public void addBG(GameObject to_add){
        backgroundObjects.add(to_add);
    }
    public void addMG(GameObject to_add){
        midgroundObjects.add(to_add);
    }

}