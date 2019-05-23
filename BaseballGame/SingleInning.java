import java.util.ArrayList;
import java.util.Scanner;
/**
 * Write a description of class SingleInning here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SingleInning extends Game
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
                atBat(Lester, Javier);
            }

        }

        public String atBat() {
            int strikes=0;
            int balls=0;
            while(strike<3 && balls<4) {
                if(pitchX < 20 || pitchX > 80 || pitchY < 20 || pitchY > 80) {   //if pitch is out of range then ball ++ 
                    if((int) Math.random() * 100 + 1 < ctrl) {
                        while(pitchX < 20 || pitchX > 80 || pitchY < 20 || pitchY > 80) {
                            int pitchX = math.Random()*100;
                            int pitchY = math.Random()*100;
                        }
                    }
                }
                
                Scanner swing = newScanner(System.in);
                System.out.println("Swing? ");
                String choice = swing.nextString();
                if(choice.toUpperCase.equals("YES")) {
                    System.out.println("Where? ");
                    int loc = swing.nextInt();
                    if(loc < 1 || loc > 9){
                        System.out.printl("Invalid location. choose a number 1-9");
                    }
                    else if(loc == pitch
                }
                else if(choice.toUpperCase.equals("NO")){
                    
                }
                
                if(loc /= pitchLoc){
                    }
                
                
            }
        }
        
        public int gridConversion(int pitchX, int pitchY){
            int px = pitchX;
            int py = pitchY;
            int pitchLoc = 0;
            if((px >= 20 && px < 40) && (py >= 20 && py < 40)){
                return 1;
            }
            else if((px >= 40 && px < 60) && (py >= 20 && py < 40)){
                return 2;
            }
            else if((px >= 60 && px < 80) && (py >= 20 && py < 40)){
                return 3;
            }
            else if((px >= 20 && px < 40) && (py >= 40 && py < 60)){
                return 4;
            }
            else if((px >= 40 && px < 60) && (py >= 40 && py < 60)){
                return 5;
            }
            else if((px >= 60 && px < 80) && (py >= 40 && py < 60)){
                return 6;
            }
            else if((px >= 20 && px < 40) && (py >= 60 && py <= 80)){
                return 7;
            }
            else if((px >= 20 && px < 60) && (py >= 60 && py <= 80)){
                return 8;
            }
            else{
                return 9;
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

