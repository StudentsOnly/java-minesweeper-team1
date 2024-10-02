public class Grid {
    private int size;
    private int openCells;
    private Cell[][] cells;
    private int mines;

    public Grid(int size, int mines){
        this.size = size;
        this.openCells = 0;
        this.cells = new Cell[size][size];
        this.mines = mines;
    }

    public Cell getCell(int[] coordinate){
        int i = coordinate[0];
        int j = coordinate[1];
        return cells[i][j];
    }

    public Cell[][] getCells(){
        return cells;
    }

    public int getSize(){
        return size;
    }

    public boolean allCellOpened(){

      if(openCells == size * size - mines){
          return true;
      }
        return false;
    }

    public boolean openCell(Cell cell){
       if(!cell.isOpen) {
           openCells++;
           if (!cell.openCell()) {
               return false;
           }else if(cell.getClass().equals(EmptyCell.class)) {
               openCellsAround(cell);
           }
       }else{
           //is already open
           return true;
       }
       return true;
    }

    private void openCellsAround(Cell cell){
        
        int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
        int[] deltaCoordinate = new int[2];
        int[] currentCoordinate = cell.getCoordinate();
        for(int[] coordinate: deltas){
            deltaCoordinate[0] = currentCoordinate[0] + coordinate[0];
            deltaCoordinate[1] = currentCoordinate[1] + coordinate[1];
            if(isValid(deltaCoordinate) && !this.getCell(deltaCoordinate).isOpen){
                this.openCell(this.getCell(deltaCoordinate));
            }
        }
    }
    private boolean isValid(int[] coordinate){
        if(coordinate[0] < 0 || coordinate[0] >= size || coordinate[1] < 0 || coordinate[1] >= size){
            return false;
        }
        return true;
    }

    public void setAllCellOpened(){
        for(Cell[] row: cells){
            for(Cell cell: row){
                if(!cell.isOpen){
                    cell.setAsOpen();
                }
            }
        }
    }

}
