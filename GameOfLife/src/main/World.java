package main;

import Cell.*;
import Types.*;

public class World {
	private Cell[][]  world; //iniziamo con risoluzione standard
	private int height;
	private int width;

	public World(int height, int width) {
		super();
		world = new Cell [height][];
		for (int i=0; i<height;i++) {
			world[i] = new Cell[width];
			for (int j=0; j<width;j++)
				world[i][j] = new Cell();
		}
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
}
