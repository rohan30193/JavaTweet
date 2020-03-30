package com.example.helloworld;

public class starbucks {

    public static abstract class Beverage{
        public String description=" unknown coffee";
        public String  getDescription()
        {
            return description;
        }
        public abstract float getCost();

    }

    public static class Lattee extends Beverage{

        public Lattee()
        {
            description="lattee ";
        }
        public String getDescription()
        {

            return description;
        }
        public float getCost()
        {
            return 1.20f;
        }

    }

    public static class Capucchino extends Beverage{

        public Capucchino()
        {
            description="Capucchino ";
        }
        public String  getDescription()
        {

            return description;
        }
        public float getCost()
        {
            return 1.25f;
        }

    }



    public static class Mocha extends Beverage{

        Beverage beverage;
        public Mocha(Beverage beverage)
        {
            this.beverage=beverage;
        }
        public String getDescription()
        {
           return beverage.getDescription()+" and mocha ";
        }
        public float getCost()
        {
            return beverage.getCost() +.25f;
        }
    }
    public static class Whip extends Beverage{

        Beverage beverage;
        public Whip(Beverage beverage)
        {
            this.beverage=beverage;
        }
        public String getDescription()
        {
            return beverage.getDescription()+" and whip ";
        }
        public float getCost()
        {
            return beverage.getCost() +.22f;
        }
    }

    public static void main(String[] args) {

        Beverage beverage = new Capucchino();
        System.out.println("your coffee is "+beverage.getDescription()+" cost "+beverage.getCost());
        Beverage beverage1 = new Lattee();
        beverage1=new Mocha(beverage1);
        beverage1 = new Whip(beverage1);
        System.out.println("your coffee is "+beverage1.getDescription()+" cost "+beverage1.getCost());



    }
}
