
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
import java.util.ArrayList;
import java.util.Scanner;
public class SingleInning extends Game
{
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
        pitcher Lester = 
        
    }
}

