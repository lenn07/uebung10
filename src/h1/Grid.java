package h1;

import java.util.Iterator;

public class Grid {
	private Cell[][] gridArray;

	public Grid(Cell[] cells, int gridRows, int gridCols) {
		gridArray = new Cell[gridRows][gridCols];
		for (int r = 0; r < gridRows; r++) {
			for (int c = 0; c < gridCols; c++) {
				boolean tempAlive = false;
				for (int a = 0; a < cells.length; a++) {
					if (r == cells[a].getIndexRow() && c == cells[a].getIndexCol()) {
						tempAlive = true;
					}
				}

				gridArray[r][c] = new Cell(r, c, tempAlive);
							
			}
		}
		
		for (int r = 0; r < gridArray.length; r++) {		
			for (int c = 0; c < gridArray[0].length; c++) {
				gridArray[r][c].countLivingNeighbors(gridArray);
			}
		}
		
		/*for (int r = 0; r < gridArray.length; r++) {
			System.out.println("/n");
			String textString = "";
			for (int c = 0; c < gridArray[0].length; c++) {
				textString = textString + " " + gridArray[r][c].isAlive();
			}
			System.out.println(textString);
		}
		System.out.println("----------------------");*/
		
	}
    
	public void computeNextGen() {
		for (int r = 0; r < gridArray.length; r++) {		
			for (int c = 0; c < gridArray[0].length; c++) {
				gridArray[r][c].setAlive(gridArray[r][c].isAliveNextGen());
			}
		}
		for (int r = 0; r < gridArray.length; r++) {		
			for (int c = 0; c < gridArray[0].length; c++) {
				gridArray[r][c].countLivingNeighbors(gridArray);
			}
		}
		
		/*for (int r = 0; r < gridArray.length; r++) {
			System.out.println("/n");
			String textString = "";
			for (int c = 0; c < gridArray[0].length; c++) {
				textString = textString + " " + gridArray[r][c].isAlive();
			}
			System.out.println(textString);
		}
		System.out.println("----------------------");*/
	}
	
	public void computeGeneration(int n) {
		for(int x = 0; x < n; x++) {
			computeNextGen();
		}
	}
	
	public Cell[][] getGridArray() {
		return gridArray;
	}

	public void setGridArray(Cell[][] gridArray) {
		this.gridArray = gridArray;
	}
}
