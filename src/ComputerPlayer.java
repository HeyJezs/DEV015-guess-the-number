import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String name) {
        super(name);
    }

    @Override
    public int makeGuess() {
        Random random = new Random();
        int guess = random.nextInt(100) + 1; // Genera una suposición aleatoria entre 1 y 100
        guesses.add(guess);
        System.out.println(name + " ha hecho su suposición: " + guess);
        return guess;
    }
}