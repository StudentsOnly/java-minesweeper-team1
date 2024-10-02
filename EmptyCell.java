public class EmptyCell extends Cell{

    public EmptyCell(int i, int j){
        this.coordinate = new int[2];
        this.coordinate[0] = i;
        this.coordinate[1] = j;
        this.isOpen = false;
        this.value = "[ ]";
    }

    @Override
    public boolean openCell() {
        this.setAsOpen();
        return true;
    }

}
