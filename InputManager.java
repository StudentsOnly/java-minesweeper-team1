import java.util.Scanner;

public class InputManager {
    private final Scanner scanner;
    int maxGridSize = 20;

    public InputManager(Scanner scan) {
        this.scanner = scan;
    }

    public int getGridSize() {
        int gridSize;
        do {
            System.out.println("Enter the grid size (e.g., 5 for a 5x5 grid) maximum " + maxGridSize +": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid integer less than " + maxGridSize + ".");
                scanner.next();
            }
            gridSize = scanner.nextInt();
            if (gridSize > maxGridSize) {
                System.out.println("Invalid input! Please enter a valid integer less than " + maxGridSize + ".");
            }
        } while (gridSize <= 0 || gridSize > maxGridSize);
        return gridSize;
    }


    public int getNumberOfMines(int gridSize) {
        int mines;
        do {
            int minesSquared = gridSize * gridSize;
            System.out.println("Enter the number of mines must be less than the total number of cells ("+ minesSquared +"): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next();
            }
            mines = scanner.nextInt();
            if (mines >= gridSize * gridSize) {
                System.out.println("The number of mines must be less than the total number of cells (" + minesSquared + ").");
            }
        } while (mines <= 0 || mines >= gridSize * gridSize);
        return mines;
    }

    public int[] getInput(int gridSize) {
        int row, col;
        do {
            System.out.println("Enter row and column (e.g., 0 0): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter valid integers for row and column.");
                scanner.next();
            }
            row = scanner.nextInt();

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter valid integers for row and column.");
                scanner.next();
            }
            col = scanner.nextInt();
        } while (!validateCoordinate(row, col, gridSize));

        return new int[]{row, col};
    }


    private boolean validateCoordinate(int row, int col, int gridSize) {
        if (row < 0 || row >= gridSize || col < 0 || col >= gridSize) {
            System.out.println("Coordinates are out of bounds. Please enter values between 0 and " + (gridSize - 1));
            return false;
        }
        return true;
    }
}
