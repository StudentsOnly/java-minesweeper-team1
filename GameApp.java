public class GameApp {
    public static void main(String[] args) {

        InputManager input = new InputManager();
        GridGenerator generator = new GridGenerator(10, 10);
        Grid grid = generator.generate();

        // Start the game
        Game game = new Game(grid, input);
        game.start();
    }
}
