public class Batter extends SingleInning
{
    private int hit;
    private int pwr;
    private int spd;
    private int arm;
    public Batter(int hit1, int pwr1, int spd1)
    {
        hit = hit1;
        pwr = pwr1;
        spd = spd1;
    }
    public void Steal()
    {
        boolean success = false;
        if(spd > arm)
        {
            if(((int)Math.random() * 100 + (spd - arm + 1)) > 50)
            {
                success = true;
            } else {
                success = false;
            }
        } else if(arm > spd){
            if(((int)Math.random() * 100 + (arm - spd + 1)) > 50)
            {
                success = false;
            } else {
                success = true;
            }
        } else if(arm = spd){
            if(((int)Math.random() * 100 + 1) > 50)
            {
                success = false;
            } else {
                success = true;
            }
        }
    }
}
