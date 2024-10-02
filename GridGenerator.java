import java.util.ArrayList;
import java.util.Random;

public class GridGenerator {
    private int size;
    private int mines;
    private int[][] minesCoordinates;
    private int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 1}, {1, 0}, {1, 1}};

    public GridGenerator(int size, int mines){
        this.size = size;
        this.mines = mines;
        this.minesCoordinates = new int[mines][2];
    }

    public int getMines(){
        return mines;
    }
/*
    public Grid generate(){
        Grid grid = new Grid(size);
        placeMines(grid);
        for(Cell[] row : grid.getCells()){
            for(Cell cell: row){
                if(countMines(cell, grid) > 0 ){
                    cell = new NumberCell()
                }
            }
        }



        return grid;
    }
    
 */

    private int[][] generateMines(){
        int[][] coordinates = new int[mines][2];
        ArrayList<Integer> index = new ArrayList<>();
        Random random = new Random();
        int currentIndex;
        for(int i = 0; i < size*size; i++){
            index.add(i);
        }
        for(int i = 0; i < mines; i++) {
            currentIndex = random.nextInt(index.size());
            coordinates[i][0] = index.get(currentIndex) / size;
            coordinates[i][1] = index.get(currentIndex) % size;
            index.remove(currentIndex);
        }

        return coordinates;
    }

    private void placeMines(Grid grid){
        int[][] coordinates = generateMines();
        for(int[] row : coordinates){
            grid.getCells()[row[0]][row[1]] = new MineCell(row); // gives coordinates?!
        }
    }

    private int countMines(Cell cell, Grid grid){
        int[] deltaCoordinate = new int[2];
        int minesAround = 0;
        // int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 1}, {1, 0}, {1, 1}};
        int[] currentCoordinate = cell.getCoordinate();
        for(int[] coordinate: deltas){
            deltaCoordinate[0] = currentCoordinate[0] + coordinate[0];
            deltaCoordinate[1] = currentCoordinate[1] + coordinate[1];
            if(isValid(deltaCoordinate) && grid.getCell(deltaCoordinate) != null){
                if(grid.getCell(deltaCoordinate).getClass().equals(MineCell.class)){
                    minesAround++;
                }
            }
        }
        return minesAround;

    }

    private boolean isValid(int[] coordinate){
        if(coordinate[0] < 0 || coordinate[0] >= size || coordinate[1] < 0 || coordinate[1] >= size){
            return false;
        }
        return true;
    }

}
