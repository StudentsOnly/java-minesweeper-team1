abstract class Cell {
    boolean isOpen;
    String value;

   private Cell(){
        this.isOpen = false;
        this.value = "[ ]";
    }

    String printCell(){
        if(isOpen){
            return value;
        }
        return "[_]";
    }

    abstract boolean openCell();
}
