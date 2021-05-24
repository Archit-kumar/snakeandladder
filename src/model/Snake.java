package model;
public class Snake{

    // snake has a start value which denotes it's head and end denotes its end value;

    // condition start > end;

    private int start ;
    
    private boolean isGreenSnake;
    
    private boolean isUsed;
    
    private int end ;

    public Snake(int start, int end, boolean isGreenSnake) {
        this.start = start;
        this.end = end;
        this.isGreenSnake=isGreenSnake;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

	public boolean isGreenSnake() {
		return isGreenSnake;
	}

	public void setGreenSnake(boolean isGreenSnake) {
		this.isGreenSnake = isGreenSnake;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

}