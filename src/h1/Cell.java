package h1;

import java.security.PublicKey;

public class Cell {
    private int indexRow;
    private int indexCol;
    private boolean alive;
    private int numLivingNeighbors;
    private boolean isAliveNextGen;
    
    public Cell(int indexRow, int indexCol, boolean alive) {
    	this.indexRow = indexRow;
    	this.indexCol = indexCol;
    	this.alive = alive;
    }
    
    public Cell(int indexRow, int indexCol) {
    	this.indexRow = indexRow;
    	this.indexCol = indexCol;
    }
    
	public int getIndexRow() {
		return indexRow;
	}
	public void setIndexRow(int indexRow) {
		this.indexRow = indexRow;
	}
	public int getIndexCol() {
		return indexCol;
	}
	public void setIndexCol(int indexCol) {
		this.indexCol = indexCol;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	public int getNumLivingNeighbors() {
		return numLivingNeighbors;
	}
	public void setNumLivingNeighbors(int numLivingNeighbors) {
		this.numLivingNeighbors = numLivingNeighbors;
	}
	public boolean isAliveNextGen() {
		return isAliveNextGen;
	}
	public void setAliveNextGen(boolean isAliveNextGen) {
		this.isAliveNextGen = isAliveNextGen;
	}
    
    public void countLivingNeighbors(Cell[][] gridArray) {
    	int counter = 0;    
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {

                if(i == 0 && j == 0) {
                    continue;
                }

                if(indexRow + i >= 0 && indexRow + i < gridArray.length
                && indexCol + j >= 0 && indexCol + j < gridArray[0].length) {

                    if(gridArray[indexRow + i][indexCol + j].isAlive()) {
                        counter++;
                    }
                }
            }
        }

        numLivingNeighbors = counter;

        decideNextStatus();
    }
    
    private void decideNextStatus() {
        if(alive) {
            isAliveNextGen = numLivingNeighbors == 2 || numLivingNeighbors == 3;
        } else {
            isAliveNextGen = numLivingNeighbors == 3;
        }
    }
}


