import java.util.ArrayList;
import java.util.Scanner;
public class SingleInning
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
        Pitcher Lester = new Pitcher(int arm, int ctrl, int stf); //arm = 
        while(totalOuts<3) {
            int hit = (int) (Math.random()*100) + 1;
            int pwr = (int) (Math.random()*100) + 1;
            int spd = 200 - hit - pwr; //speed of ball
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

    public String atBat() {
        int strikes=0;
        int balls=0;
        int pitch;
        while(strike<3 && balls<4) {
            if(pitchX < 20 || pitchX > 80 || pitchY < 20 || pitchY > 80) {   //if pitch is out of range then ball ++ 
                if((int) Math.random() * 100 + 1 < ctrl) {
                    while(pitchX < 20 || pitchX > 80 || pitchY < 20 || pitchY > 80) {
                        int pitchX = math.Random()*100;
                        int pitchY = math.Random()*100;
                    }
                }
            }
            else{
                int pitch = gridConversion(pitchX, pitchY);
            }

                
            Scanner swing = newScanner(System.in);
            System.out.println("Swing? ");
            String choice = swing.nextString();
            if(choice.toUpperCase.equals("YES")) {
                System.out.println("Where? ");
                int loc = swing.nextInt();
                if(loc < 1 || loc > 9){
                    System.out.println("Invalid location. choose a number 1-9");
                }
                else if(loc == pitch){
                    return "hit";
                }
            }
            else if(choice.toUpperCase.equals("NO") && (pitch >= 1 || pitch <=9)){
                    strikes ++;
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

}