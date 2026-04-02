public class WumpusPlayer {
    private int direction;
    private boolean arrow;
    private boolean gold;
    private int colPosition;
    private int rowPosition;

    public WumpusPlayer(int direction, boolean arrow, boolean gold){
        this.direction=direction;
        this.arrow=arrow;
        this.gold=gold;
    }

    public void setArrow(boolean arrow) {
        this.arrow = arrow;
    }

    public void setColPosition(int colPosition) {
        this.colPosition = colPosition;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setGold(boolean gold) {
        this.gold = gold;
    }

    public void setRowPosition(int rowPosition) {
        this.rowPosition = rowPosition;
    }

    public int getColPosition() {
        return colPosition;
    }

    public int getDirection() {
        return direction;
    }

    public int getRowPosition() {
        return rowPosition;
    }
    public boolean getArrow(){
        return arrow;
    }
    public boolean getGold(){
        return gold;
    }
}
