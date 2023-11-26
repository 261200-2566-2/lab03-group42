public class Character 
{
    // private:
        //status
        private float max_hp,max_mana;
        int lv;
        private float base_atk;
        private float base_running_speed;

        private Sword weapon;
        private Shield armor;

        private float atk, defend,running_speed;

        private void hp_cal()
        {
            max_hp = 100+10*lv;
        }

        private void mana_cal()
        {
            max_mana = 50+2*lv;
        }

        private void atk_cal()
        {

        }

        private void defend_cal()
        {
            
        }

        private void running_speed_cal()
        {

        }

        private void stat_cal()
        {
            hp_cal();
            defend_cal();

            running_speed_cal();

            atk_cal();
            mana_cal();
        }

        // private Sword copy_sword_data(Sword sword_eq)
        // {
        //     return new Sword();
        // }

        // private Shield copy_shield_data(Shield armor_eq)
        // {
        //     return new Shield();
        // }

    // public:
        public Character(Sword sword, Shield shield)
        {
            lv = 1;
            base_atk = 10;
            base_running_speed = 10;

            weapon = sword;
            armor = shield;
        }
        public float attack()
        {
            return 0;
        }

        public void level_up()
        {
            lv += 1;
            stat_cal();
        }

        public void equipment_upgrade()
        {
            
            stat_cal();
        }

}