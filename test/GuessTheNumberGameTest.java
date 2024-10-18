import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GuessTheNumberGameTest {

    @Test
    public void testHumanPlayerGuessesCorrectly() {
        // Crear el juego y establecer el número objetivo manualmente
        GuessTheNumberGame juego = new GuessTheNumberGame();
        juego.setTargetNumber(50);  // Usar el setter para fijar el número objetivo

        // Crear una jugadora humana
        HumanPlayer humanPlayer = new HumanPlayer("Jugadora");
        humanPlayer.setIntento(50);  // Adivinación correcta

        // Verificar que la jugadora adivinó correctamente
        assertTrue(juego.checkGuess(humanPlayer));
    }

    @Test
    public void testComputerPlayerGuessing() {
        // Crear el juego y establecer el número objetivo manualmente
        GuessTheNumberGame juego = new GuessTheNumberGame();
        juego.setTargetNumber(100);  // Establecer un número objetivo que la computadora no pueda adivinar

        // Crear un jugador de computadora
        ComputerPlayer computerPlayer = new ComputerPlayer("Computadora");

        // Hacer que la computadora adivine (sabemos que es aleatorio)
        int guess = computerPlayer.makeGuess();

        // Verificar que la adivinación esté dentro del rango permitido
        assertTrue(guess >= 1 && guess <= 100);

        // Simulamos que la computadora no adivina correctamente
        assertFalse(juego.checkGuess(computerPlayer));
    }
}