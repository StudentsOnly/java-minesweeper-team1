import java.util.ArrayList;
import java.util.Random;

public class GridGenerator {
    private int size;
    private int mines;
    private int[][] minesCoordinates;

    public GridGenerator(int size, int mines){
        this.size = size;
        this.mines = mines;
        this.minesCoordinates = new int[mines][2];
    }

    public Grid generate(){
        Grid grid = new Grid(size);
        placeMines(grid);



        return grid;
    }

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
            grid.getCells()[row[0]][row[1]] = new MineCell();
        }
    }

    private void goAround(Cell cell){
        int[][] deltas = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 1}, {1, 0}, {1, 1}};

    }


}
