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
		int h = this.height, w = this.width;
		for(int i=0; i<h;i++)
			for (int j=0;j<w;j++) {
				Cell[] neighbours = {
					this.world[(i+h-1)%this.height][(j+w-1)%this.width],
					this.world[(i+h-1)%this.height][j],
					this.world[(i+h-1)%this.height][(j+1)%this.width],
					this.world[i][(j+w-1)%this.width],
					this.world[i][(j+1)%this.width],
					this.world[(i+1)%this.height][(j+w-1)%this.width],
					this.world[(i+1)%this.height][j],
					this.world[(i+1)%this.height][(j+1)%this.width]
				};
				this.world[i][j].setNeighbours(neighbours);
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
	
	public Cell getCell(int x, int y) {
		return this.world[x][y];
	}
	
	public void printWorld() {
		System.out.println("____________________");
		for (int i=0; i<this.height;i++) {
			String line = "";
			for (int j=0; j<this.width;j++) {
				line += (world[i][j].isAlive()) ? "xx" : "  " ;
			}
			line += "|";
			System.out.println(line);
		}
		System.out.println("____________________");
	}
	
	private int mod (int dividendo, int divisore) {
		if (dividendo>=divisore)	mod(dividendo-divisore, divisore);
		if (dividendo<0) mod(dividendo+divisore, divisore);
		return dividendo;
	}
}
