package com.findasquare;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author Harsh <girdharharsh01@gmail.com>
 * @since
 */
public class FindASquare {

	Coordinate[] coordinates;
	//use array of 4 length.
	
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		String line;
		
		while ((line = buffer.readLine()) != null) {
			if (!line.trim().equals("")) {
				String inputs[] = line.split(", ");
				new FindASquare().intializeVars(inputs);
				boolean isSquare = new FindASquare().checkForSquare();
				System.out.println(isSquare);
			}
		}
		buffer.close();
	}

	public boolean checkForSquare() {
		boolean isSquare = false;
		double distance[] = new double[]{};
		int counter = 0;
		for(int i = 0 ; i < coordinates.length ; i++) {
			for(int j = i+1 ; j < coordinates.length ; j++) {
				distance[counter++] = Math.sqrt(Math.pow((coordinates[j].getX() - coordinates[i].getX()), 2) +
						Math.pow((coordinates[j].getY() - coordinates[i].getY()), 2));
			}
		}
		counter = 0;
		for(double dist : distance) {
			
		}
		return isSquare;
	}

	private void intializeVars(String[] inputs) {
		int counter = 0;
		for(String input : inputs) {
			input = input.replace("(", "").replace(")", "");
			String coor[] = input.split(",");
			coordinates[counter] = new Coordinate(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
			counter++;
		}
	}

}

class Coordinate {
	int x,y;

	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}