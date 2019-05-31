import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class FullGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FullGame
{
        private String[]runners = {"O", "O", "O"};
        private int[]PCrunners = {0, 0, 0};
    private int[][] grid;
    private int totalOuts;
    private int runs = 0;
    private int PCouts = 0;
    private int PCruns = 0;
    private ArrayList<SingleInning> innings = new ArrayList<SingleInning>();
    private int stealHit = 0;
    private ArrayList<Batter> order = new ArrayList<Batter>(8);
    private int nameChecker = 0; //checks if names are automated
    private String namer[] = new String[9];
    private int inningNumber = 1;
    private String name[] = new String[8];
    private String prev[] = new String[8];
    public FullGame() {
        totalOuts = 0;
        runs = 0;
    }
    public void name() {
        Scanner names = new Scanner(System.in);
        System.out.println("Name batters automatically?");
        if((names.next()).toUpperCase().equals("YES")) {
            namer[0] = "Christian Yelich";
            namer[1] = "Cody Bellinger";
            namer[2] = "Nolan Arenado";
            namer[3] = "Jose Altuve";
            namer[4] = "Javier Baez";
            namer[5] = "Buster Posey";
            namer[6] = "Aaron Judge";
            namer[7] = "Ronald Acuña Jr.";
            namer[8] = "Aaron Nola";
            nameChecker = 1;
        }
    }
    public void newGame() {
        while(innings.size()<8) {
            int Iscore=computerInning();
            PCruns+=Iscore;
            System.out.println("Away team scored " + Iscore + " runs!");
            System.out.println("Box score: Home - " + runs + ", Away - " + PCruns);
            if(inningNumber == 1) {
                System.out.println("Bottom of " + inningNumber + "st");
            } else if (inningNumber == 2) {
                System.out.println("Bottom of " + inningNumber + "nd");
            } else if (inningNumber == 3) {
                System.out.println("Bottom of " + inningNumber + "rd");
            } else {
                System.out.println("Bottom of " + inningNumber + "th");
            }
            inningNumber++;
            SingleInning inning = new SingleInning(); 
            inning.gameChecker();
            if(nameChecker == 1) {
                inning.namerCheck();
                inning.changeOrder(namer);
            } 
            
            inning.newGame();
            int Yscore = inning.getRuns();
            runs+=Yscore;
            System.out.println("Home team scored " + Yscore + " runs!");
            System.out.println("Box score: Home - " + runs + ", Away - " + PCruns);
        }
        if(runs == PCruns) {
            while(runs == PCruns) {
                int Iscore=computerInning();
            PCruns+=Iscore;
            System.out.println("Away team scored " + Iscore + " runs!");
            System.out.println("Box score: Home - " + runs + ", Away - " + PCruns);
            System.out.println("Bottom of " + inningNumber + "th");
            inningNumber++;
            SingleInning inning = new SingleInning();
            inning.gameChecker();
            inning.newGame();
            int Yscore = inning.getRuns();
            runs+=Yscore;
            System.out.println("Home team scored " + Yscore + " runs!");
            System.out.println("Box score: Home - " + runs + ", Away - " + PCruns);
            }
        }
        if(runs > PCruns) {
            System.out.println("Good Game! You Win! Final score: Home - " + runs + ", Away - " + PCruns);
        } else {
            System.out.println("Good Game! You Lose! Final score: Home - " + runs + ", Away - " + PCruns);
        }
    }
    public int computerInning() {
        int PCrun = 0;
        while(PCouts<3) {
            if(Math.random() < 0.3) {
                double hit = Math.random();
                int runner;
                if(hit < 0.5) { //single
                    for(int i=1; i < 3; i++) {
                        if(PCrunners[i] == 1) {
                            PCrunners[i] = 0;
                            PCrun++;
                        }
                    }
                    if(PCrunners[0] == 1) {
                        PCrunners[2] = 1;
                    }
                } else if(hit < 0.8) {
                    for(int i=0; i < 3; i++) {
                        if(PCrunners[i] == 1) {
                            PCrunners[i] = 0;
                            PCrun++;
                        }
                    }
                    PCrunners[1] = 1;
                } else if(hit < 0.85) {
                    for(int i=0; i < 3; i++) {
                        if(PCrunners[i] == 1) {
                            PCrunners[i] = 0;
                            PCrun++;
                        }
                    }
                    PCrunners[1] = 1;
                } else {
                    for(int i=0; i < 3; i++) {
                        if(PCrunners[i] == 1) {
                            PCrunners[i] = 0;
                            PCrun++;
                        }
                    }
                    PCrun++;
                }
            } else {
                PCouts++;
            }
            
        }
        PCrun+=(int) (Math.random() * 3);
        return PCrun;
    }
}






















