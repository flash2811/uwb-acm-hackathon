package com.company;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

import java.util.ArrayList;

public class run {
	private final static String OUTPUT = "Server.txt";
	private final static String INPUT = "Client.txt";

	public static void main(String[] args) throws IOException{

		System.out.println(Character.toChars(0x1F600));
		Canvas testCanvas = new Canvas(1000,1000,50,20,1,1);

		//the player
		char[][] player = new char[3][2];
		player[0][0] = '.';
		player[0][1] = ' ';
		player[1][1] = '-';
		player[2][0] = '.';
		player[2][1] = ' ';
		player[1][0] = ' ';
		GameObject pl = new MainPlayer(player, 3,2,25,1);

		char[][] enemy2 = new char[3][2];
		enemy2[0][0] = '@';
		enemy2[0][1] = ' ';
		enemy2[1][1] = 'V';
		enemy2[2][0] = '@';
		enemy2[2][1] = ' ';
		enemy2[1][0] = ' ';
		GameObject en = new MainPlayer(enemy2, 3,2,10,18);

		char[][] enemy = new char[3][2];
		enemy[0][0] = '@';
		enemy[0][1] = ' ';
		enemy[1][1] = 'V';
		enemy[2][0] = '@';
		enemy[2][1] = ' ';
		enemy[1][0] = ' ';
		GameObject enz = new MainPlayer(enemy, 3,2,1,1);

//		char[][] style = new char[2][2];
//		style[0][0] = '!';
//		style[0][1] = '!';
//		style[1][0] = '!';
//		style[1][1] = '!';
//		GameObject o = new MainPlayer(style, 2,2,1,1);
//
//		char[][] style2 = new char[1][2];
//		style2[0][0] = 'a';
//		style2[0][1] = 'b';


//		GameObject o2 = new MainPlayer(style2, 1,2,7,7);

		System.out.println("Server Started");
//		testCanvas.addFG(o2);
//		testCanvas.addFG(o);
		testCanvas.addFG(pl);
		testCanvas.addFG(en);
		testCanvas.addFG(enz);
		System.out.println(testCanvas.Render());

		pl.moveGridBased('L');
		pl.moveGridBased('U');


		System.out.println(testCanvas.Render());

		while(true){
			Character curr = stringReader(INPUT);
			if(curr == '*') {
				pl.moveGridBased(curr);
				stringWriter(testCanvas.Render(), OUTPUT);
			}
			else if(curr != 0) {
				pl.moveGridBased(curr);
				stringWriter(testCanvas.Render(), OUTPUT);
			}
		}

	}

	public static char stringReader(String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			char result = br.readLine().charAt(0);
			br.close();

			BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
			writer.close();
			return result;
		}
		catch (Exception e){
			return 0;
		}
	}

	public static void stringWriter(String toWrite, String fileName) throws IOException {

		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write(toWrite);
		writer.close();
	}

}
