import java.util.Scanner;
public class Game
{
    public static void main(String args[]) {
        String answer = startGame();
        int correctCheck = 0;
        while(correctCheck == 0) {
            if(answer.toUpperCase().equals("SINGLE-INNING")) {
                correctCheck = 1;
                SingleInning game = new SingleInning();
                game.name();
                game.newGame();
            } else if(answer.toUpperCase().equals("FULL GAME")) {
                correctCheck = 1;
            } else {
                System.out.println();
                System.out.print("Invalid input! Try again: ");
                answer = startGame();
            }
        }

    }

    public static String startGame() {
        Scanner type = new Scanner(System.in);
        System.out.print("Type of Game (Single-Inning, Full Game) : ");
        String answer = type.nextLine();
        return answer;
    }
}
