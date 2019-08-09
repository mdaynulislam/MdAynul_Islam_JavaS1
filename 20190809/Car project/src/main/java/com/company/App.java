package com.company;

import java.util.List;
import java.util.Scanner;


public class App {
    public static String handleInput(){
        Scanner sc=new Scanner(System.in);
        return sc.nextLine();
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

              break;

          case 2:
              System.out.println("Would you like to search all cars or got by field? [A]=All cars [F]= search by field ");
              search=handleInput();
              if(search.equalsIgnoreCase("a"))
              {
                  System.out.println(inventory.getCars());

              }else if(search.equalsIgnoreCase("f"))
              {
                  System.out.println("What you want to search by [M]ake, M[o]del, [Y]ear, M[i]les, [C]olor");
                  search=handleInput();
                  if(search.equalsIgnoreCase("m")){
                      make=handleInput();
                      inventory.searchByMake(make);
                  }else  if(search.equalsIgnoreCase("o")){
                      model=handleInput();
                      inventory.searchByModel(model);
                  }else if(search.equalsIgnoreCase("y")){

                      year=Integer.parseInt(handleInput());
                      inventory.searchByYear(year);

                  }else if(search.equalsIgnoreCase("i")){
                      mile=Integer.parseInt(handleInput());
                      inventory.searchByMileage(mile);
                  }else if(search.equalsIgnoreCase("c")){
                      color=handleInput();
                      System.out.println(inventory.searchByColor(color));
                  } else {
                      System.out.println("You have to enter something!!!!");
                  }
              } else {
                  System.out.println("You have to enter something!!!!");
              }
             break;

          case 3:
              System.out.println("which would you like to remove");
              for(Car car : inventory.getCars()) {
                  System.out.println("id: "+ inventory.getCars().indexOf(car) + car);
              }
              id = Integer.parseInt(handleInput());
              inventory.deleteCar(id);
              break;
          case 4:
              break;

      }




    }
}
