public class Character 
{
    // private:
        //status
        private String name;
        private float max_hp,max_mana;
        private float current_hp, current_mana;
        int lv;
        private float base_atk;
        private float base_running_speed;

        //equipment
        private Sword weapon;
        private Shield armor;

        private float dmg,defend,running_speed,running_speed_with_lv;

        private float sw_de_speed, sh_d_speed;

        private void hp_cal() //cal hp
        {
            max_hp = 100+10*lv;
        }

        private void mana_cal() //mana cal
        {
            max_mana = 50+2*lv;
        }

        //defend zone
        private void defend_cal()
        {
            if(!(armor == null))
            {
                defend = (float) armor.for_return_defend();
            }
            else defend = 0;
        }

        private void upgrade_armor()
        {
            if(weapon != null)
            {
                weapon.upgrade();
                defend_cal();

                armor_speed();
                running_speed_cal();
            }
            else System.out.println("How to upgrade empty sheild?");
        }

        private void armor_speed()
        {
            sh_d_speed = armor.reduce_speed(base_running_speed);
        }

        //dmg zone
        private void dmg_cal()
        {
            if(!(weapon == null))
            {
                weapon.dmg_cal(base_atk);
                dmg = (float) weapon.for_return_dmg();
            }
            else dmg = (float) ((base_atk)*(1+0.1*lv));
        }

        private void upgrade_weapon()
        {
            if(weapon != null)
            {
                weapon.upgrade();
                dmg_cal();

                sword_speed();
                running_speed_cal();
            }
            else System.out.println("How to upgrade empty sword?");
        }

        private void sword_speed()
        {
            sw_de_speed = (float) weapon.speed_decrease(base_running_speed);
        }

        //speed zone

        private void running_speed_lv()
        {
            running_speed_with_lv = (float) ((base_running_speed*(0.1+0.03*lv)) + base_running_speed);
        }

        private void running_speed_cal()
        {
            // System.out.println("sw = "+ sw_de_speed);
            // System.out.println("sh = " + sh_d_speed);
            running_speed = running_speed_with_lv - sw_de_speed - sh_d_speed;
            if(running_speed < 0) running_speed = 0;
        }

    // public:
        public Character(Sword sword, Shield shield,String give_name)
        {
            lv = 1;
            base_atk = 10;
            base_running_speed = running_speed = 10;

            max_hp = current_hp = 100;
            max_mana = current_mana = 20;

            weapon = sword;
            dmg_cal();

            armor = shield;
            defend_cal();

            name = give_name;

            running_speed_lv();

            if(armor != null) armor_speed();
            if(weapon != null) sword_speed();

            running_speed_cal();
        }

        public void attack()
        {
            System.out.println("ATTACK!!");
            System.out.println(dmg);
        }

        public void level_up()
        {
            System.out.println("LEVEL UP!");
            lv += 1;

            hp_cal();
            mana_cal();

            running_speed_lv();
            if(weapon != null) sword_speed();
            if(armor != null) armor_speed();
            running_speed_cal();

            base_atk += 5;
            dmg_cal();
        }

        public void equipment_upgrade(int id) //1 waepon 2 armor
        {
            switch (id)
            {
                case 1 ->
                {
                    upgrade_weapon();
                }    
                case 2 ->
                {
                    upgrade_armor();
                }
                default ->
                {
                    
                }
            }
        }

        public void unequipment(int id)
        {
            switch (id)
            {
                case 1 ->
                {
                    if(weapon != null)
                    {
                        weapon = null;
                        dmg_cal();
                        sw_de_speed = 0;
                        running_speed_cal();
                    }
                    else
                    {
                        System.out.println("You can't unwear your fist!");
                    }

                }    
                case 2 ->
                {
                    if(armor != null)
                    {
                        armor = null;
                        defend_cal();
                        sh_d_speed = 0;
                        running_speed_cal();
                    }
                    else
                    {
                        System.out.println("Are you kidding me?");
                    }
                }
                default ->
                {
                    
                }
            }
        }

        @Override
        public String toString() //show stat
        {
            String 
                s_stat = "\n\nYOUR STAT\n",
                s_name = "Name : "+name+'\n',
                s_hp = "HP : " + current_hp + '/'+ max_hp + '\n',
                s_mana = "Mana : " + current_mana + '/' + max_mana + '\n',
                s_atk = "ATK : "+ base_atk + ((weapon != null)? (" + " + weapon.return_atk() + '\n') : '\n'),
                s_defend = "Defend : " + defend + '\n',//+ ((armor != null)? (armor.for_return_defend()): '0')+ '\n',

                s_equipment = "\nEquipment : \n",
                s_weapon = "Weapon : "+((weapon != null) ?weapon.for_return_name() + " LV " + weapon.for_return_lv(): "None") + '\n',
                s_armor = "Shield : "+((armor != null) ?armor.for_return_name() + " LV " + armor.for_return_lv(): "None") + "\n\n",
                s_speed = "Running Speed : " + running_speed + '\n',
                for_return = s_stat+s_name+s_hp+s_defend+s_mana+s_atk+s_equipment+s_weapon+s_armor+s_speed;
            return for_return;
        }

}