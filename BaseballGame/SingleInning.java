import java.util.ArrayList;
import java.util.Scanner;
public class SingleInning
{
    private String[]runners = {"O", "O", "O"};
    private int[][] grid;
    private int totalOuts;
    private int runs = 0;
<<<<<<< HEAD
    private int runner = 0;
=======
    private int gameChecker = 0;
>>>>>>> ace16e72a7c471257a2fbe5e1da3524a8e0c5d74
    private int stealHit = 0;
    private ArrayList<Batter> order = new ArrayList<Batter>(8);
    private int nameChecker = 0; //checks if names are automated
    private String namer[] = new String[9];
    int batterPos = -1; //which batter up
    int batterPos2 = 0; //determines end of order
    public SingleInning() {
        totalOuts = 0;
        runs = 0;
    }

    public void gameChecker() {
        gameChecker = 1;
    }

    public int getOuts() {
        return totalOuts;
    }

    public int getRuns() {
        return runs;
    }

    public void name() {
        Scanner names = new Scanner(System.in);
        System.out.println("Name batters automatically?");
        if((names.next()).equals("Yes")) {
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
<<<<<<< HEAD
        System.out.println("Play ball!");

=======

        int batterPos = -1; //which batter up
        int batterPos2 = 0; //determines end of order
>>>>>>> ace16e72a7c471257a2fbe5e1da3524a8e0c5d74
        int arm = (int) (Math.random()*50) + 51;
        int ctrl = (int) (Math.random()*50) + 51;
        int stf = 200 - arm - ctrl;

        Pitcher Lester = new Pitcher(arm, ctrl, stf); //arm = 
        System.out.println("On the mound: Jon Lester (Arm = " + arm + ", Control = " + ctrl + ", Stuff = " + stf + ")");
        while(totalOuts<3) {
            if(batterPos>7) {
                batterPos = 0;
                batterPos2++;
            } else {
                batterPos++;
            }
            Batter Javier;
            printField();
            int hit = (int) (Math.random()*75) + 26;
            int pwr = (int) (Math.random()*75) + 26;
            int spd = 200 - hit - pwr; //speed of batter
            if(order.size() == batterPos && batterPos2 == 0) {
                if(nameChecker == 0) {
                    Scanner name = new Scanner(System.in);
                    System.out.println("Batter " + (batterPos + 1) + " name? ");
                    Javier = new Batter(hit, pwr, spd, name.next());
                } else {
                    Javier = new Batter(hit, pwr, spd, namer[batterPos]);
                }
                order.add(Javier);
            } else {
                System.out.println(batterPos);
                Javier = order.get(batterPos);
            }
            System.out.println("Outs: " + totalOuts + " - Runs: " + runs);
            System.out.println("At Bat: " + Javier.getName() + " (Hit = " + Javier.getHit() + ", Power = " + Javier.getPwr() + ", Speed = " + Javier.getSpd() + ")");
<<<<<<< HEAD
            if(runners[0].equals("X") && runners[1].equals("O") && runners[2].equals("O")) { //runners on 2nd only
=======

            if(runners[0].equals("X") && runners[1].equals("O")) {
>>>>>>> ace16e72a7c471257a2fbe5e1da3524a8e0c5d74
                int temp = batterPos;
                int outs = getOuts();

                
                System.out.println("Steal base?");
                Scanner steal = new Scanner(System.in);
                String choice = steal.next();
                if(choice.toUpperCase().equals("YES")) {

                    steal(order.get(runner), Lester);

                }
            }


            //URGENT picked off to 3 outs doesnt end game instantly
            String result = atBat(Lester, Javier);
            if(result.equals("out")) {
                System.out.println("out");
                totalOuts++;
                System.out.println("Outs: " + totalOuts + " - Runs: " + runs);
            } else if(result.equals("hit")) {
                int type = (int) (Math.random()*(pwr+30));
                int fly = (int) (Math.random()*100);
                System.out.println(fly);
                if(type<20) {
                    System.out.println("Groundout!");
                    totalOuts++;
                } else if(type < 50) {
                    System.out.println("Single!");
                    single();
                } else if(type < 80) {
                    if(fly<20) {
                        System.out.println("Fly out!");
                        totalOuts++;
                    } else {
                        System.out.println("Double!");
                        duble();
                    }
                } else if(type < 90) {
                    System.out.println("Triple!");
                    triple();
                } else if(type < 110) {
                    if(fly<20) {
                        System.out.println("Fly out!");
                        totalOuts++;
                    } else {
                        System.out.println("Home run!");
                        homeRun();
                    }
                }

            } else if(result.equals("walk")) {
                runner = batterPos;

                System.out.println("Batter walked");
                if(runners[0].equals("X")) {
                    if(runners[1].equals("X")) {
                        if(runners[2].equals("X")) {
                            System.out.println("1 run scores!");
                            runs++;
                        }
                        runners[2] = "X";
                    }
                    runners[1] = "X";
                }
                runners[0] = "X";

            }
        }
        if(gameChecker == 0) {
            System.out.println("Good Game! You Scored: " + runs + " run(s) in a single inning!");
        } else {
            System.out.println("Inning over!");
        }
    }

    public void steal(Batter b, Pitcher p) {
        int spd = b.getSpd();
        int arm = p.getArm();
        if(runners[1].equals("X")) {
            if(1.0 < Math.random()*(((double) spd) / arm)) {
                if(Math.random()*10 != 9) {
                    System.out.println("Stolen Base!");
                    runners[1] = "O";
                    runners[2] = ("X");
                }
                else {
                }
            } else {
                System.out.println("Picked Off!");
                runners[1] = "O";
                totalOuts++;
            }
        } else {
            if(0.5 < Math.random()*(((double) spd) / arm)) {
                if(Math.random()*10 != 9) {
                    System.out.println("Stolen Base!");
                    runners[0] = "O";
                    runners[1] = ("X");
                }
                else {
                }
            } else {
                System.out.println("Picked Off!");
                runners[0] = "O";
                totalOuts++;
            }
        }
        printField();
        System.out.println("Outs: " + totalOuts + " - Runs: " + runs);
    }

    public void single() {
        runner = batterPos;
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
        runners[0] = "X";
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
        int pitch = 0;
        int pitches = 0;

        while(strikes<3 && balls<4) {
            int pitchX = (int) (Math.random()*100);
            int pitchY = (int) (Math.random()*100);
            if(pitchX < 30 || pitchX > 70 || pitchY < 30 || pitchY >70) {   //if pitch is out of range then ball ++ 
                if((int) (Math.random() * 120) < Lester.getCtrl()) {

                    while(pitchX < 20 || pitchX > 80 || pitchY < 20 || pitchY > 80) {
                        pitchX = (int) (Math.random()*100);
                        pitchY = (int) (Math.random()*100);
                    } 
                } else {
                    while(!(pitchX < 20) && !(pitchX > 80) && !(pitchY < 20) && !(pitchY > 80)) {
                        pitchX = (int) (Math.random()*100);
                        pitchY = (int) (Math.random()*100);
                    }
                    System.out.println(pitchX + pitchY);
                }

            }
            pitches++;
            System.out.println("Pitch " + pitches);
            pitch = gridConversion(pitchX, pitchY);
            System.out.println(pitch);
            System.out.println("Chances of hitting ball in each location: ");
            
            if(hiddenLocation(pitchX, pitchY) == 1){
                printDiagram();
            }
            if(hiddenLocation(pitchX, pitchY) == 2){
                printDiagram2();
            }
            if(hiddenLocation(pitchX, pitchY) == 3){
                printDiagram3();
            }
            if(hiddenLocation(pitchX, pitchY) == 4){
                printDiagram4();
            }
            /*int[] loc1 = {1, 2, 4, 5};
            int[] loc2 = {2, 3, 5, 6};
            int[] loc3 = {4, 5, 7, 8};
            int[] loc4 = {5, 6, 8, 9};
            if(pitch == 1){
            pitch = loc1[((int)Math.random() * 4)];
            }else if(pitch == 2){
            pitch = loc2[((int)Math.random() * 4)];
            }else if(pitch == 3){
            pitch = loc3[((int)Math.random() * 4)];
            }else if(pitch == 4){
            pitch = loc4[((int)Math.random() * 4)];
            }*/

            Scanner swing = new Scanner(System.in);
            System.out.println("Swing? ");
            String choice = swing.next();
            if(choice.toUpperCase().equals("YES")) {
                System.out.println("Where? ");
                printDiagram1();
                int loc = swing.nextInt();
                if(loc < 1 || loc > 9){
                    System.out.println("Invalid location. choose a number 1-9");
                }
                else if(loc == pitch){
                    int hita = Javier.getHit();
                    int stfa = Lester.getStf();
                    double chances = Math.random()*(((double) hita) / stfa); 
                    if(0.3 <= chances) {
                        return "hit";
                    } else if(0.15 <= chances) {
                        System.out.println("Foul ball!");
                        if(strikes<2) {
                            strikes++;
                        }
                    } else {
                        System.out.println("Pop out!");
                        totalOuts++;
                        return "";
                    }

                } else if(loc != pitch) {
                    System.out.println("strike");
                    strikes++;
                }
            }
            else if(choice.toUpperCase().equals("NO")){
                if((pitch >= 1 && pitch <=9)) {
                    System.out.println("Strike!");
                    strikes++;
                } else {
                    System.out.println("Ball!");
                    balls++;
                }
            }
            else{
                System.out.println("Invalid Command: please choose yes or no");
                pitches--;
            }

            System.out.println("Current Count: Strikes: " + strikes + " - Balls: " + balls);

        }
        if(strikes == 3) {
            System.out.println("Strikeout");
            //totalOuts++;
            return "out";
        }
        return "walk";

    }

    public int hiddenLocation(int pitchX, int pitchY){
        int px = pitchX;
        int py = pitchY;
        int pitchLoc = 0;
        if((px >= 0 && px < 50) && (py >= 0 && py < 50)){
            return 1;
        }
        else if((px >= 50 && px < 100) && (py >= 50 && py < 100)){
            return 4;
        }
        else if((px >= 50 && px < 100) && (py >= 0 && py < 50)){
            return 2;
        }
        else if((px >= 0 && px < 50) && (py >= 50 && py < 100)){
            return 3;
        }
        return 0;
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
        else if ((px >= 60 && px < 80) && (py >= 60 && py <= 80)){
            return 9;
        } else {
            return 0; //ball
        }
    }

    public void printField() {
        System.out.println("        " + runners[1] + "      ");
        System.out.println("                 ");
        System.out.println("                 ");
        System.out.println("                 ");
        System.out.println(runners[2] + "       O       " + runners[0]);
        System.out.println("                 ");
        System.out.println("                 ");
        System.out.println("                 ");
        System.out.println("        " + "O" + "      ");
    }

    public void printDiagram(){
        
            System.out.println("|     |     |     |");
            System.out.println("| 25% | 25% | 0%  |");
            System.out.println("|     |     |     |");
            System.out.println("|-----------------|");
            System.out.println("|     |     |     |");
            System.out.println("| 25% | 25% | 0%  |");
            System.out.println("|     |     |     |");
            System.out.println("|-----------------|");
            System.out.println("|     |     |     |");
            System.out.println("| 0%  | 0%  | 0%  |");
            System.out.println("|     |     |     |");
        
    }
    
    public void printDiagram2(){
        
            System.out.println("|     |     |     |");
            System.out.println("| 0%  | 25% | 25% |");
            System.out.println("|     |     |     |");
            System.out.println("|-----------------|");
            System.out.println("|     |     |     |");
            System.out.println("| 0%  | 25% | 25% |");
            System.out.println("|     |     |     |");
            System.out.println("|-----------------|");
            System.out.println("|     |     |     |");
            System.out.println("| 0%  | 0%  | 0%  |");
            System.out.println("|     |     |     |");
        
    }
    
    public void printDiagram3(){
        
            System.out.println("|     |     |     |");
            System.out.println("| 0%  | 0%  | 0%  |");
            System.out.println("|     |     |     |");
            System.out.println("|-----------------|");
            System.out.println("|     |     |     |");
            System.out.println("| 25% | 25% | 0%  |");
            System.out.println("|     |     |     |");
            System.out.println("|-----------------|");
            System.out.println("|     |     |     |");
            System.out.println("| 25% | 25% | 0%  |");
            System.out.println("|     |     |     |");
        
    }
    
    public void printDiagram4(){
        
            System.out.println("|     |     |     |");
            System.out.println("| 0%  | 0%  | 0%  |");
            System.out.println("|     |     |     |");
            System.out.println("|-----------------|");
            System.out.println("|     |     |     |");
            System.out.println("| 0%  | 25% | 25% |");
            System.out.println("|     |     |     |");
            System.out.println("|-----------------|");
            System.out.println("|     |     |     |");
            System.out.println("| 0%  | 25% | 25% |");
            System.out.println("|     |     |     |");
        
    }

    public void printDiagram1(){
        System.out.println("|     |     |     |");
        System.out.println("|  1  |  2  |  3  |");
        System.out.println("|     |     |     |");
        System.out.println("|-----|-----|-----|");
        System.out.println("|     |     |     |");
        System.out.println("|  4  |  5  |  6  |");
        System.out.println("|     |     |     |");
        System.out.println("|-----|-----|-----|");
        System.out.println("|     |     |     |");
        System.out.println("|  7  |  8  |  9  |");
        System.out.println("|     |     |     |");
    }

}

