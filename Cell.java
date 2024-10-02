abstract class Cell {
    boolean isOpen;
    String value;
    int[] coordinate;

   public Cell(int[] coordinate){
        this.isOpen = false;
        this.value = "[ ]";
        this.coordinate = coordinate;
    }
    public Cell(){
        this.isOpen = false;
        this.value = "[ ]";
    }

    public int[] getCoordinate(){
       return this.coordinate;
    }

    String printCell(){
        if(isOpen){
            return value;
        }
        return "[_]";
    }

    abstract boolean openCell();
}
