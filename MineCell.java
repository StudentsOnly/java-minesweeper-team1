public class MineCell extends Cell{

    public MineCell(int[] coordinate){

        super();
        this.coordinate = coordinate;
        this.isOpen = false;
        this.value = "[*]";

    }

    @Override
    boolean openCell() {
        this.setAsOpen();
        return false;
    }
}
