package model;
class Player{

    private String name;

    private int turnNumber;

    public Player(String name) {
        this.name = name;
        this.turnNumber = turnNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    public void setTurnNumber(int turnNumber) {
        this.turnNumber = turnNumber;
    }
}