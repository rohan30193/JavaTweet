package com.example.helloworld;

import com.sun.tools.javac.code.Attribute;

public class DominosPizzaFactory {

    public static abstract class Pizza{
        String description;
         public abstract String description();

         public abstract int cost();

    }

    public static abstract class toppings extends Pizza{

        Pizza pizza;
        public abstract String description();
        public abstract int cost();
    }

    public static class cheeseburst extends toppings{
        Pizza pizza;
        cheeseburst(Pizza pizza)
        {
            this.pizza=pizza;
        }

        public String description()
        {
            return pizza.description()+"with cheese burst";
        }

        public int cost()
        {
            return pizza.cost()+50;
        }
    }

    public static class chickenTikka extends toppings{
        Pizza pizza;
        chickenTikka(Pizza pizza)
        {
            this.pizza=pizza;
        }

        public String description()
        {
            return pizza.description()+"with chicken tikka";
        }

        public int cost()
        {
            return pizza.cost()+30;
        }
    }

    public static class RashmiKabab extends toppings{
        Pizza pizza;
        RashmiKabab(Pizza pizza)
        {
            this.pizza=pizza;
        }

        public String description()
        {
            return pizza.description()+"with rashmi kabab";
        }

        public int cost()
        {
            return pizza.cost()+30;
        }
    }

    public static class Paneertikka extends toppings{
        Pizza pizza;
        Paneertikka(Pizza pizza)
        {
            this.pizza=pizza;
        }

        public String description()
        {
            return pizza.description()+"with paneerTikka";
        }

        public int cost()
        {
            return pizza.cost()+30;
        }
    }

    public static class NonVegPizza extends Pizza{


        NonVegPizza()
        {
            description="non veg pizza";
        }

        @Override
        public String description() {

            return description;
        }



        @Override
        public int cost() {
            return 200;
        }
    }

    public static class VegPizza extends Pizza{


        VegPizza()
        {
            description="veg pizza";
        }
        @Override
        public String description() {

            return description;
        }



        @Override
        public int cost() {
            return 150;
        }
    }
    public static class pizzaFactory{
        Pizza pizza;

        public Pizza createPizza(Pizza pizza, String type)
        {
            if(type=="non veg")
            {
                pizza = new NonVegPizza();
            }
            else if(type=="veg")
            {
                pizza = new VegPizza();
            }
            return pizza;
        }
    }
    public static class pizzaStore{
        pizzaFactory pizzaFactory;

        public pizzaStore(pizzaFactory pizzaFactory)
        {
            this.pizzaFactory=pizzaFactory;

        }

        public Pizza orderPizza(Pizza pizza,String type)
        {

            pizza=pizzaFactory.createPizza(pizza,type);

            pizza.description();

            return pizza;
        }


    }

    public static void main(String[] args) {

        pizzaFactory pizzaFactory = new pizzaFactory();
        pizzaStore pizzaStore = new pizzaStore(pizzaFactory);

        Pizza pizza = new NonVegPizza();
        pizza=pizzaStore.orderPizza(pizza,pizza.description());
        pizza=new chickenTikka(pizza);
        pizza=new RashmiKabab(pizza);
        pizza = new cheeseburst(pizza);
        System.out.println("your pizza is "+pizza.description()+" and its cost is "+pizza.cost());




    }
}
