package com.company;

public class Warrior extends Base{


    private int shieldStrength;

    public Warrior(String name, int strength, int health,
                   int stamina, int speed, int attackPower, int shieldStrength)


                {
                super(name, strength, health, stamina, speed, attackPower);
                this.name = name;
                this.strength = 75;
                this.health = 100;
                this.stamina = 100;
                this.speed = 50;
                this.attackPower = 10;
                this.shieldStrength = 100;
                 }


                public int decreaseShieldStrength(int a){
                    this.shieldStrength -= a;
                    return shieldStrength;
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

                public int getShieldStrength() {
                    return shieldStrength;
                }

    }
