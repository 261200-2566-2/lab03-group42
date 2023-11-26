public class Sword 
{
    private String name = "Katana";
    private float base_atk;
    private int lv;

    public Sword(String name, float base_atk, int lv)
    {
        this(base_atk,lv);
        if(name != null)this.name = name;
    }

    public Sword(float base_atk, int lv)
    {
        this.base_atk = base_atk;
        this.lv = lv;
    }

    public double for_return_atk()
    {
        return base_atk*(1+0.1*lv);
    }

    public double speed_decrease(float speed)
    {
        return speed*(0.1+0.04*lv);
    }

    public int for_return_lv()
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
