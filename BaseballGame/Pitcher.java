public class Pitcher extends SingleInning
{
    private int arm;
    private int ctrl;
    private int stf;
    public Pitcher(int arm1, int ctrl1, int stf1)
    {
        arm = arm1;
        ctrl = ctrl1;
        stf = stf1;
    }
            public int getArm()
    {
        return arm;
    }
        public int getCtrl()
    {
        return ctrl;
    }
            public int getStf()
    {
        return stf;
    }
}
