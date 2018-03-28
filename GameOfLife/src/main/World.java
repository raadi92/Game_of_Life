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
		this.assignNeighbours();
	}
	
	private void assignNeighbours() {
		for(int i=0; i<this.height;i++)
			for (int j=0;j<this.width;j++) {
				Cell[] neighbours = {
					world[(i-1)%this.height][(j-1)%this.width],
					world[(i-1)%this.height][j],
					world[(i-1)%this.height][(j+1)%this.width],
					world[i][(j-1)%this.width],
					world[i][(j+1)%this.width],
					world[(i+1)%this.height][(j-1)%this.width],
					world[(i+1)%this.height][j],
					world[(i+1)%this.height][(j+1)%this.width]
				};
				world[i][j].setNeighbours(neighbours);
			}
	}
	
	public void iterate() {
		for(int i=0; i<this.height;i++)
			for (int j=0;j<this.width;j++)
				world[i][j].iterate();
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}
	
}
