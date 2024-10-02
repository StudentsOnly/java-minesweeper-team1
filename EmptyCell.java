public class EmptyCell extends Cell{

    public EmptyCell(int[] coordinate){
        super();
        this.coordinate = coordinate;
        this.isOpen = false;
        this.value = "[ ]";
    }

    @Override
    public boolean openCell() {
        this.setAsOpen();
        return true;
    }

}
