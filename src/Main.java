import java.util.Scanner;

class Main 
{
    static private Character mc;
    static private Scanner getString = new Scanner(System.in);

    private static String check()
    {
        String get = getString.nextLine();
        if(get.equals("y") || get.equals("Y")) return "y";
        else if (get.equals("n") || get.equals("N")) return "n";
        else
        {
            System.out.println("y/n only");
            return null;
        }
    }

    private static Sword crate_sword()
    {
        String input = null;

        while (input == null) 
        {
            System.out.println("Do you have sword? (y/n)");
            input = check();    
        }

        if(input.equals("y"))
        {
            float ATK = 5;
            String name;
            int lv = 1;

            System.out.println("You sword name : ");
            name = getString.nextLine();
            if(name.equals(" ")) name = null;

            System.out.println("How about LV? :");
            if(getString.hasNextInt()) lv = getString.nextInt();
            else System.out.println("I see LV 1");
            getString.nextLine();

            System.out.println("Base ATK : ");
            if(getString.hasNextFloat()) ATK = getString.nextFloat();
            else System.out.println("I change your ATK to 5");
            getString.nextLine();

            return new Sword(name, ATK, lv);
        }
        
        return null;
    }

    private static Shield create_shield()
    {
        String input = null;
        while (input == null) 
        {
            System.out.println("Do you have sheild? (y/n)");
            input = check();
        }

        if(input.equals("y"))
        {
            float defend = 10;
            String name;
            int lv = 1;

            System.out.println("You sheild name : ");
            name = getString.nextLine();

            if(name.equals(" ")) name = null;

            System.out.println("How about LV? :");
            if(getString.hasNextInt()) lv = getString.nextInt();
            else System.out.println("I see LV 1");
            getString.nextLine();

            System.out.println("Base defend : ");
            if(getString.hasNextFloat()) defend = getString.nextFloat();
            else System.out.println("I change your defend to 10");
            getString.nextLine();

            return new Shield(name, defend, lv);
        }
        
        return null;
    }

    private static void working()
    {
        System.out.println(mc);

        boolean running = true;



        while (running) 
        {
            int input = 0;
            System.out.println("What do you want to do?");
            System.out.println("Check status (1) , Take off your equipment(2), Change your equipment(3), attack(4) ,exit(5), Do nothing(else)");
            
            if(getString.hasNextInt()) input =getString.nextInt();
        }
    }

    public static void main(String[] args) 
    {
        String name;
        Sword weapon;
        Shield armor;

        System.out.println("Name of your character : ");
        name = getString.nextLine();
        if(name.equals(" ")) name = null;

        weapon = crate_sword();
        armor = create_shield();
        mc = new Character(weapon, armor, name);

        working();
        getString.close();
    }    
}
