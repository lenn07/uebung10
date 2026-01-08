package h2;

public class Spielstein {
	private int currentRow;
    private int currentCol;
    private Spielbrett brett;
    public Spielstein(int indexRow, int indexCol, Spielbrett brett) {
    	this.currentRow = indexRow;
    	this.currentCol = indexCol;
    	this.brett = brett;
    }
	public int getCurrentRow() {
		return currentRow;
	}
	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}
	public int getCurrentCol() {
		return currentCol;
	}
	public void setCurrentCol(int currentCol) {
		this.currentCol = currentCol;
	}
	public Spielbrett getBrett() {
		return brett;
	}
	public void setBrett(Spielbrett brett) {
		this.brett = brett;
	}
    
    private boolean movesOut() {
    	boolean up = currentRow-1>=0;
    	boolean down = currentRow+1<brett.getDim();
    	boolean left = currentCol-1>=0;
    	boolean right = currentCol+1<brett.getDim();
    	
    	char direction = brett.getBrett()[currentRow][currentCol].getDirection();
    	
    	if((direction == 'U' && up) || (direction == 'D' && down) || (direction == 'L' && left) || (direction == 'R' && right)) {
    		return true;
    	}else {
			return false;
		}
    }
    
    public void go(int n) {
    	for(int x = 0; x < n; x++) {
    		Feld tempFeld = brett.getBrett()[currentRow][currentCol];
    		if(!tempFeld.isBoese() && movesOut()) {
    			if(tempFeld.getDirection() == 'U') {
    				currentRow -=1;
    			}if(tempFeld.getDirection() == 'D') {
    				currentRow +=1;
    			}if(tempFeld.getDirection() == 'L') {
    				currentCol -=1;
    			}if(tempFeld.getDirection() == 'R') {
    				currentCol +=1;
    			}
    		}
    	}
    }
    
}
