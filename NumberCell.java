public class NumberCell extends Cell{

    public NumberCell(int[] coordinate, int value){

        super();
        this.coordinate = coordinate;
        this.isOpen = false;
        this.value = "[" + value +"]";

    }

    @Override
    boolean openCell() {
        this.isOpen = true;
        return false;
    }
}
