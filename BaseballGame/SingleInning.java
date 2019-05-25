import java.util.ArrayList;
import java.util.Scanner;
public class SingleInning
{
    private String[]runners = {"O", "O", "O"};
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
        Pitcher Lester = new Pitcher(arm, ctrl, stf); //arm = 
        while(totalOuts<3) {
            int hit = (int) (Math.random()*100) + 1;
            int pwr = (int) (Math.random()*100) + 1;
            int spd = 200 - hit - pwr; //speed of batter
            Batter Javier = new Batter(hit, pwr, spd);
            String result = atBat(Lester, Javier);
            if(result.equals("out")) {
                totalOuts++;
            } else if(result.equals("hit")) {
                int type = (int) (Math.random()*(pwr+20));
                                    int fly = (int) Math.random()*100;
                if(type<10) {
                    System.out.println("Groundout!");
                    totalOuts++;
                } else if(type < 60) {
                    System.out.println("Single!");
                    single();
                } else if(type < 90) {
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
    public void single() {
        int rbi=0; //runs batted in for one hit
        if(runners[1].equals("X")) {
            runners[1] = "O";
            runs++;
            rbi++;
        } 
        if(runners[2].equals("X")) {
                        runners[2] = "O";
            runs++;
            rbi++;
        }
        if(runners[0].equals("X")) {
            runners[2] = "X";
        }
        System.out.println(rbi + " runs scored!");
    }
    
        public void duble() {
            int rbi=0; //runs batted in for one hit
        if(runners[1].equals("X")) {
            runners[1] = "O";
            runs++;
            rbi++;
        } 
        if(runners[2].equals("X")) {
                        runners[2] = "O";
            runs++;
            rbi++;
        }
        if(runners[0].equals("X")) {
                        runners[0] = "O";
            runs++;
            rbi++;
        }
        runners[1] = "X";
        System.out.println(rbi + " runs scored!");
    }
        public void triple() {
             int rbi=0; //runs batted in for one hit
        if(runners[1].equals("X")) {
            runners[1] = "O";
            runs++;
            rbi++;
        } 
        if(runners[2].equals("X")) {
                        runners[2] = "O";
            runs++;
            rbi++;
        }
        if(runners[0].equals("X")) {
                        runners[0] = "O";
            runs++;
            rbi++;
        }
        runners[2] = "X";
        System.out.println(rbi + " runs scored!");
    }
        public void homeRun() {
             int rbi=0; //runs batted in for one hit
        if(runners[1].equals("X")) {
            runners[1] = "O";
            runs++;
            rbi++;
        } 
        if(runners[2].equals("X")) {
                        runners[2] = "O";
            runs++;
            rbi++;
        }
        if(runners[0].equals("X")) {
                        runners[0] = "O";
            runs++;
            rbi++;
        }
        runs++;
        if(rbi == 3) {
            System.out.println("Grand Slam! 4 runs scored!");
        }
        System.out.println((rbi + 1) + " runs scored!");
    }

    public String atBat(Pitcher Lester, Batter Javier) {
        int strikes=0;
        int balls=0;
        int pitch;
        while(strikes<3 && balls<4) {
            int pitchX = (int) Math.random()*100;
            int pitchY = (int) Math.random()*100;
            if(pitchX < 20 || pitchX > 80 || pitchY < 20 || pitchY > 80) {   //if pitch is out of range then ball ++ 
                if((int) Math.random() * 100 + 1 < Lester.getCtrl()) {
                    while(pitchX < 20 || pitchX > 80 || pitchY < 20 || pitchY > 80) {
                        pitchX = (int) Math.random()*100;
                        pitchY = (int) Math.random()*100;
                    }
                }
            }
            else{
                pitch = gridConversion(pitchX, pitchY);
            }

            Scanner swing = new Scanner(System.in);
            System.out.println("Swing? ");
            String choice = swing.next();
            if(choice.toUpperCase().equals("YES")) {
                System.out.println("Where? ");
                int loc = swing.nextInt();
                if(loc < 1 || loc > 9){
                    System.out.println("Invalid location. choose a number 1-9");
                }
                else if(loc == pitch){
                    return "hit";
                }
            }
            else if(choice.toUpperCase().equals("NO") && (pitch >= 1 || pitch <=9)){
                strikes ++;
            }

            /* if(loc /= pitchLoc){
            }*/

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
        System.out.println("   " + runners[1] + "   ");
        System.out.println("                 ");
        System.out.println("                 ");
        System.out.println("                 ");
        System.out.println(runners[2] + "       O       " + runners[0]);
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

