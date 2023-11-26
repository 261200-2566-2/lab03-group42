public class Shield 
{
    private String name = "Holy Armor";
    private float defend;
    private int lv;

    public Shield(String name,float defend, int lv)
    {
        this(defend,lv);
        if(name != null)this.name = name;
    }

    public Shield(float defend, int lv)
    {
        this.defend = defend;
        this.lv = lv;
    }

    public double for_return_defend()
    {
        return defend*(1+0.1*lv);
    }

    public float for_return_lv()
    {
        return lv;
    }

    public String for_return_name()
    {
        return name;
    }

    public void upgrade()
    {
        lv += 1;
    }
}