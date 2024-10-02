public class NumberCell extends Cell{

    public NumberCell(int i, int j, int value){

        this.coordinate = new int[2];
        this.coordinate[0] = i;
        this.coordinate[1] = j;
        this.isOpen = false;
        this.value = "[" + value +"]";

    }

    @Override
    public boolean openCell() {
        this.setAsOpen();
        return true;
    }
}
