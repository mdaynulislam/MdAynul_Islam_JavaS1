package com.company;

import java.util.List;
import java.util.Scanner;


public class App {
    public static String handleInput(){
        Scanner sc=new Scanner(System.in);
        return sc.nextLine();
    }

    public static void addUserPrompt(Inventory inventory) {
        String make, model, color;
        int year,mile;

        System.out.println("Enter the Make");
        make=handleInput();
        System.out.println("Enter the Model");
        model=handleInput();
        System.out.println("Enter the Color");
        color=handleInput();
        System.out.println("Enter the Year");
        year=Integer.parseInt(handleInput());
        System.out.println("Enter the Mileage");
        mile=Integer.parseInt(handleInput());

        Car newCar=new Car(make,model,color,year,mile);
        inventory.addCar(newCar);

    }

    public static void searchCarPrompt(Inventory inventory) {

        String search, make,model, color;
        int year, mile;

        System.out.println("Would you like to search all cars or got by field? [A]=All cars [F]= search by field ");
        search=handleInput();
        if(search.equalsIgnoreCase("a"))
        {
            for (Car car: inventory.getCars()) {
               printCars(car);
            }


        }else if(search.equalsIgnoreCase("f"))
        {
            System.out.println("What you want to search by [M]ake, M[o]del, [Y]ear, M[i]les, [C]olor");
            search=handleInput();
            if(search.equalsIgnoreCase("m")){
                make=handleInput();
                for (Car car: inventory.searchByMake(make)) {
                    printCars(car);
                }
            }else if(search.equalsIgnoreCase("o")){
                model = handleInput();
                for (Car car: inventory.searchByModel(model)) {
                    printCars(car);

                }
            }else if(search.equalsIgnoreCase("y")){

                year=Integer.parseInt(handleInput());
                for (Car car: inventory.searchByYear(year)) {
                   printCars(car);
                }


            }else if(search.equalsIgnoreCase("i")){
                mile=Integer.parseInt(handleInput());
                for (Car car: inventory.searchByMileage(mile)) {
                    printCars(car);
                }

            }else if(search.equalsIgnoreCase("c")){
                color=handleInput();

                for (Car car: inventory.searchByColor(color)) {
                    printCars(car);
                }

            } else {
                System.out.println("You have to enter something!!!!");
            }
        } else {
            System.out.println("You have to enter something!!!!");
        }
    }

    public static void removeCarPrompt(Inventory inventory){
        int id;
        System.out.println("which would you like to remove");

        if(inventory.getCars() == null) {
            System.out.println("There are no cars to remove.");
        } else {
            for (Car car : inventory.getCars()) {
                System.out.println("id:  " + inventory.getCars().indexOf(car));
                printCars(car);
            }
            id = Integer.parseInt(handleInput());
            inventory.deleteCar(id);
        }
    }

    public static void printCars(Car car) {
            System.out.println(car.getMake());
            System.out.println(car.getModel());
            System.out.println(car.getColor());
            System.out.println(car.getYear());
            System.out.println(car.getMileage());
    }

    public static void main(String[] args) {
        Inventory inventory=new Inventory();
        System.out.println("Enter a number according to your purpose from below");

        System.out.println("[1] Add [2] Search [3] Remove [4] Exit ");
        int firstInput=Integer.parseInt(handleInput());
       String make, model, color, search;
       int year,mile, id;

      switch (firstInput){
          case 1:
              addUserPrompt(inventory);
          case 2:
              searchCarPrompt(inventory);
          case 3:
              removeCarPrompt(inventory);
              break;
          case 4:
              break;
          default:
              throw new IllegalStateException("Unexpected value: " + firstInput);
      }
    }
}
