import java.util.Scanner;
public class Game
{
    public static void main(String args[]) {
        String answer = startGame();
        int correctCheck = 0;
        while(correctCheck == 0) {
            if(answer.equals("Single-Inning")) {
                correctCheck = 1;
                SingleInning game = new SingleInning(0);
                while(game.getOuts() != 3) {
                }
            } else if(answer.equals("Full Game")) {
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
