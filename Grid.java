public class Grid {
    private int size;
    private int openCells;
    private Cell[][] cells;

    public Grid(int size){
        this.size = size;
        this.openCells = 0;
        this.cells = new Cell[size][size];
    }

    public Cell getCell(int[] coordinate){
        return cells[coordinate[0]][coordinate[1]];
    }

    public Cell[][] getCells(){
        return cells;
    }

    public int getSize(){
        return size;
    }
}
