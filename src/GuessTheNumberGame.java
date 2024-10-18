import java.util.Random;

public class GuessTheNumberGame {
    private int targetNumber;
    private Random random;

    // Constructor que genera un número aleatorio entre 1 y 100
    public GuessTheNumberGame() {
        random = new Random();
        targetNumber = random.nextInt(100) + 1;
    }

    // Nuevo metodo para establecer el número objetivo (necesario para las pruebas)
    public void setTargetNumber(int targetNumber) {
        this.targetNumber = targetNumber;
    }

    // Metodo para verificar la suposición del jugador
    public boolean checkGuess(Player player) {
        int guess = player.makeGuess();
        if (guess == targetNumber) {
            System.out.println(player.getName() + " ha adivinado el número correctamente. ¡Felicidades!");
            return true;
        } else if (guess < targetNumber) {
            System.out.println("El número es mayor que " + guess);
        } else {
            System.out.println("El número es menor que " + guess);
        }
        return false;
    }

    // Metodo main
    public static void main(String[] args) {
        GuessTheNumberGame game = new GuessTheNumberGame();

        // Crear jugadores
        Player humanPlayer = new HumanPlayer("Jugadora");
        Player computerPlayer = new ComputerPlayer("Computadora");

        Player currentPlayer = humanPlayer;
        boolean guessedCorrectly = false;

        // Bucle del juego
        while (!guessedCorrectly) {
            guessedCorrectly = game.checkGuess(currentPlayer);

            // Alternar entre los jugadores
            currentPlayer = (currentPlayer == humanPlayer) ? computerPlayer : humanPlayer;
        }
    }
}