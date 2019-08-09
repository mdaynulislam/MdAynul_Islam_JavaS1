package com.company;

public class Farmer extends Base {
    public Farmer(String name, int strength, int health, int stamina, int speed,
                  int attackPower, String name1, int strength1, int health1,
                  int stamina1, int speed1, int attackPower1)
        {
        super(name, strength, health, stamina, speed, attackPower);


                    this.name = name;
                    this.strength = 75;
                    this.health = 100;
                    this.stamina = 75;
                    this.speed = 10;
                    this.attackPower = 1;
        }

                        public void plow(){
                            System.out.println("Plow...");
                        }

                        public void harvest(){
                            System.out.println("Harvesting...");
                        }

                        @Override
                        public void decreaseHealth(){
                            health -= this.health;
                        }
                        @Override
                        public void increaseStamina(){
                            stamina += this.stamina;
                        }
                        @Override
                        public void decreaseStamina(){
                            stamina -= this.stamina;
                        }

}
