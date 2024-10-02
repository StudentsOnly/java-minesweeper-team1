public class NumberCell extends Cell{

    public NumberCell(int[] coordinate, int value){

        super();
        this.coordinate = coordinate;
        this.isOpen = false;
        this.value = "[" + value +"]";

    }

    @Override
    public boolean openCell() {
        this.setAsOpen();
        return true;
    }
}
