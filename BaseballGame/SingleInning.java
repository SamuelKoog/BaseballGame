import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class SingleInning here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SingleInning
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class SingleInning
     */
    public SingleInning()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    public class SingleInning extends Game
    {
        private int[][] grid;
        private int totalOuts;
        private int runs = 0;
        private ArrayList<Batter> order = new ArrayList<Batter>(9);
        public SingleInning() {
            totalOuts = 0;
            runs = 0;
        }

        public int getOuts() {
            return totalOuts;
        }

        public int getRuns() {
            return runs;
        }

        public void newGame() {
            int arm = (int) (Math.random()*100) + 1;
            int ctrl = (int) (Math.random()*100) + 1;
            int stf = 200 - arm - ctrl;
            Pitcher Lester = new Pitcher(int arm, int ctrl, int stf);
            while(totalOuts<3) {
                int hit = (int) (Math.random()*100) + 1;
                int pwr = (int) (Math.random()*100) + 1;
                int spd = 200 - hit - pwr;
                Batter Javier = new Batter(int hit, int pwr, int spd);
                String result = atBat(Lester, Javier);
                if(result.equals("out")) {
                    totalOuts++;
                } else if(result.equals("hit")) {
                    int type = (int) Math.random(pwr+20);
                    if(type<10) {
                        System.out.println("Groundout!");
                        totalOuts++;
                    } else if(type < 60) {
                        System.out.println("Single!");
                        single();
                    } else if(type < 90) {
                        int fly = Math.random(100);
                        if(fly<25) {
                            System.out.println("Fly out!");
                            totalOuts++;
                        } else {
                            System.out.println("Double!");
                            duble();
                        }
                    } else if(type < 100) {
                        System.out.println("Triple!");
                    } else if(type < 120) {
                        if(fly<25) {
                            System.out.println("Fly out!");
                            totalOuts++;
                        } else {
                            System.out.println("Home run!");
                            homeRun();
                        }
                    }

                } else if(result.equals("walk")) {
                }
            }

        }

        public void atBat() {
            int strikes=0;
            int balls=0;
            while(strike<3 && balls<4) {
                if(pitchX < 20 || pitchX > 70 || pitchY < 20 || pitchY > 70) {
                    if((int) Math.random() * 100 + 1 < ctrl) {
                        while(pitchX < 20 || pitchX > 70 || pitchY < 20 || pitchY > 70) {
                            int pitchX = math.Random()*100;
                            int pitchY = math.Random()*100;
                        }
                    }
                }
                Scanner swing = newScanner(System.in);
                System.out.println("Swing? ");
                String choice = swing.nextString();
                if(choice.equals("Yes")) {
                    System.out.println("Where? ");
                    int loc = swing.nextInt();
                }
            }
        }

        public void printField() {
            System.out.println("   " + "O" + "   ");
            System.out.println("                 ");
            System.out.println("                 ");
            System.out.println("                 ");
            System.out.println("O       O       O");
            System.out.println("                 ");
            System.out.println("                 ");
            System.out.println("                 ");
            System.out.println("   " + "O" + "   ");
        }

        public void printDiagram(){
            System.out.println("|     |     |     |");
            System.out.println("|  1  |  2  |  3  |");
            System.out.println("|     |     |     |");
            System.out.println("|-----|-----|-----|");
            System.out.println("|  4  |  5  |  6  |");
            System.out.println("|     |     |     |");
            System.out.println("|-----|-----|-----|");
            System.out.println("|  7  |  8  |  9  |");
            System.out.println("|     |     |     |");
            System.out.println("|     |     |     |");
        }
    }


}