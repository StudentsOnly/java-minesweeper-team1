import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {

            System.out.println("Welcome to the Minesweeper Game!");

            InputManager inputManager = new InputManager(scan);

            int gridSize = inputManager.getGridSize();
            int numMines = inputManager.getNumberOfMines(gridSize);

            GridGenerator gridGenerator = new GridGenerator(gridSize, numMines);
            Grid grid = gridGenerator.generate();
            Game game = new Game(grid, inputManager);

            game.start();
        }
    }
}
