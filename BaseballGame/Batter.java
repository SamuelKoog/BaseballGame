public class Batter
{
    private int hit;
    private int pwr;
    private int spd;
    private String name;
    public Batter(int hit1, int pwr1, int spd1, String nam)
    {
        hit = hit1;
        pwr = pwr1;
        spd = spd1;
        name = nam;
    }
        public int getHit()
    {
        return hit;
    }
        public int getPwr()
    {
        return pwr;
    }
            public int getSpd()
    {
        return spd;
    }
    public String getName() {
        return name;
    }
    /*public void Steal()
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
        } else if(arm == spd){
            if(((int)Math.random() * 100 + 1) > 50)
            {
                success = false;
            } else {
                success = true;
            }
        }
    }*/
}
