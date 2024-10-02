public class Grid {
    private int size;
    private int openCells;
    private Cell[][] cells;

    public Grid(int size){
        this.size = size;
        this.openCells = 0;
        this.cells = new Cell[size][size];
    }

    public Cell getCell(int row, int col){
        return cells[row][col];
    }

    public Cell[][] getCells(){
        return cells;
    }
}
