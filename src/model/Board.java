package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Board{

    private int size;

    private List<Snake> snakes;
    
    private List<Ladder> ladders;
    
    private HashMap<String, Integer> playesrLocation;
    
    

	public Board(int size) {
		
		super();
		this.size = size;
		
		this.snakes = new ArrayList<Snake>();
		
		this.ladders = new ArrayList<Ladder>();
		
		this.playesrLocation = new HashMap<>();
		
	}

	public Board(int size, List<Snake> snakes, List<Ladder> ladders, HashMap<String, Integer> playesrLocation) {
		super();
		this.size = size;
		this.snakes = snakes;
		this.ladders = ladders;
		this.playesrLocation = playesrLocation;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<Snake> getSnakes() {
		return snakes;
	}

	public void setSnakes(List<Snake> snakes) {
		this.snakes = snakes;
	}

	public List<Ladder> getLadders() {
		return ladders;
	}

	public void setLadders(List<Ladder> ladders) {
		this.ladders = ladders;
	}

	public HashMap<String, Integer> getPlayesrLocation() {
		return playesrLocation;
	}

	public void setPlayesrLocation(HashMap<String, Integer> playesrLocation) {
		this.playesrLocation = playesrLocation;
	}
    
    
    
    
}