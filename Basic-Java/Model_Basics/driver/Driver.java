package Model_Basics.driver;

import Model_Basics.models.Penguin;

public class Driver{

    public static void main(String[] args){

        Penguin one = new Penguin();
        
        Penguin two = new Penguin("Two");

        Penguin three = new Penguin("Three", 14);

        Penguin four = new Penguin("Four", 13, "Emperor");

        System.out.println("This is penguin " + four.name);
        System.out.println("Penguin " + three.name + " is " + three.age + " years old");
        System.out.println(two.fish("Two"));
        System.out.println("This one is asleep " + one.sleep());
    }
}