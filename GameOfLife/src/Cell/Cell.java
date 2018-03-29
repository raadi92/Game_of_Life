package Cell;

import Types.*;
import main.World;

public class Cell {
	private Status s;
	private Status fS;	// Future Status
	private Cell [] neighbours;
	
	public Cell() {
		super();
		this.s = Status.DEAD;
	}

	//		Getter and Setter 
	
	public Cell[] getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(Cell[] neighbours) {
		this.neighbours = neighbours;
	}

	public boolean isAlive() {
		return s.boolvalue();
	}

	public void setDead() {
		this.s = Status.DEAD;
	}
	
	public void setAlive() {
		this.s = Status.ALIVE;
	}	
	
	public void iterate() {
		if (this.isAlive()) {
			//ALIVE
			int count = this.count();
			if (count<2 || count >3)	this.futureDead();
			else this.futureAlive();
		} else
			//DEAD
			if (this.count() == 3) this.futureAlive();
			else this.futureDead();
			
	}
	
	private void futureAlive() {
		this.fS = Status.ALIVE;
	}

	private void futureDead() {
		this.fS = Status.DEAD;
		
	}

	private int count() {
		int count=0;
		for (int i=0;i<this.neighbours.length;i++)
			if (this.neighbours[i].isAlive()) count++;
		return count;
	}

	public void evolve() {
		this.s = this.fS;
		
	}
}

/**
	The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells,
	each of which is in one of two possible states, alive or dead, or "populated" or "unpopulated".
	Every cell interacts with its eight neighbours, which are the cells that are horizontally, vertically,
	or diagonally adjacent. At each step in time, the following transitions occur:
		-Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
		-Any live cell with two or three live neighbours lives on to the next generation.
		-Any live cell with more than three live neighbours dies, as if by overpopulation.
		-Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
	The initial pattern constitutes the seed of the system. The first generation is created by applying
	the above rules simultaneously to every cell in the seed—births and deaths occur simultaneously, and
	the discrete moment at which this happens is sometimes called a tick (in other words, each generation
	is a pure function of the preceding one). The rules continue to be applied repeatedly to create further
	generations.
 */