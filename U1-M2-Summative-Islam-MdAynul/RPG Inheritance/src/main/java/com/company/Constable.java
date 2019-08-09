package com.company;

public class Constable extends Base {

    private boolean jurisdiction;
    public Constable(String name, int strength, int health, int stamina, int speed, int attackPower)

        {
        super(name, strength, health, stamina, speed, attackPower);

                    this.name = name;
                    this.strength = 60;
                    this.health = 100;
                    this.stamina = 60;
                    this.speed = 20;
                    this.attackPower = 5;
         }

                public boolean isJurisdiction() {
                    return jurisdiction;
                }

                public void setJurisdiction(boolean jurisdiction) {
                    this.jurisdiction = jurisdiction;
                }

                @Override
                public void run(){
                    System.out.println("Run Run Run");
                }

                @Override
                public void attack(){
                    System.out.println("Attack!!!!!!...");
                }
                @Override
                public void heal(){
                    System.out.println("Heal");
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

                public void arrest(){

                }


}
