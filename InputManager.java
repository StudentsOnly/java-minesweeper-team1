import java.util.Scanner;

public class InputManager {
    private Scanner scan = new Scanner(System.in);

    public int[] getInput() {
        System.out.println("Enter row and column (e.g., 0 0): ");
        int row = scan.nextInt();
        int col = scan.nextInt();
        return new int[]{row, col};
    }
}
