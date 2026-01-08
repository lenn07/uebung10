package h1;

public class H1_main {
    public static void main(String[] args) {
		Grid grid = new Grid(new Cell[] {new Cell(0, 4), new Cell(1, 1), new Cell(2, 2), new Cell(2, 3), new Cell(3, 1),new Cell(3, 2)}, 4, 5);
		grid.computeNextGen();
		grid.computeNextGen();
		grid.computeNextGen();
		grid.computeNextGen();
		grid.computeNextGen();
		grid.computeNextGen();
		grid.computeNextGen();
		
		System.out.println("finished");
	}
}
