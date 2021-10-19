package Model_Basics.models;

import java.util.Random;

public class Penguin{

    Random rand = new Random();
    public String species;
    public int age;
    public String name;

    public Penguin(){}

    public Penguin(String name){
        this.name = name;
    }

    public Penguin(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Penguin(String name, int age, String species){
        this.name = name;
        this.age = age;
        this.species = species;
    }
    public String fish(String name){
        int randint = rand.nextInt(6);
        return "Penguin " + name + " caught " + randint + " fish";
    }
    public String sleep(){
        return "zzzz";
    }
}