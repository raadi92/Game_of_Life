package main;

public class Main {

	public static void main(String[] args) {
		
		World world = new World(10,10);
		
		world.getCell(4, 4).setAlive();
		world.getCell(4, 5).setAlive();
		world.getCell(4, 6).setAlive();
		
		world.printWorld();
		
		world.iterate();
		
		world.printWorld();
		
//		for (int i=0; i<20; i++) {
//			world.iterate();
//			world.printWorld();
//			try {	Thread.sleep(1000);		}
//			catch(InterruptedException ex) {	Thread.currentThread().interrupt();		}
//		}

	}

}
