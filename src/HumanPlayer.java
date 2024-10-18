import java.util.Scanner;

public class HumanPlayer extends Player {

    private int currentGuess;

    public HumanPlayer(String name) {
        super(name);
    }

    // Establecer el intento de la jugadora manualmente (útil para pruebas unitarias)
    public void setIntento(int guess) {
        this.currentGuess = guess;
        guesses.add(guess);  // Añadir el intento a la lista
    }

    // Obtener el intento actual
    public int getIntento() {
        return currentGuess;
    }

    @Override
    public int makeGuess() {
        // Si el intento fue establecido en pruebas, simplemente devolverlo
        if (currentGuess != 0) {
            return currentGuess;
        } else {
            // Si no está en modo de prueba, usar Scanner para interactuar con el usuario
            Scanner scanner = new Scanner(System.in);
            System.out.print(name + ", introduce tu suposición: ");
            int guess = scanner.nextInt();
            guesses.add(guess);
            return guess;
        }
    }
}