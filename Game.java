public class Game {
    private Grid grid;
    private GameStatus status;
    private int counter;
    private InputManager user;

    public Game(Grid grid, InputManager input) {
        this.grid = grid;
        this.status = GameStatus.PLAY;
        this.counter = 0;
        this.user = input;
    }

    public void start() {
        while (status == GameStatus.PLAY) {
            printGrid();
            int[] coordinates = user.getInput(grid.getSize());

            Cell selectedCell = grid.getCell(coordinates);
            if (!selectedCell.openCell()) {
                status = GameStatus.LOSE;
                System.out.println("You hit a mine! Game Over.");
                break;
            }

            if (grid.allCellOpened()) {
                status = GameStatus.WIN;
                System.out.println("Congratulations! You won.");
                break;
            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < grid.getSize(); i++) {
            for (int j = 0; j < grid.getSize(); j++) {
                int[] coordinates = new int[]{i,j};
                System.out.print(grid.getCell(coordinates).printCell() + " ");
            }
            System.out.println();
        }
    }
}
