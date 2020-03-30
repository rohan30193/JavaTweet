
/* strategy pattern beverage machine   */

package com.example.helloworld;
public class BeverageMachine {

    public interface HotBeverage{
        public void myHotBeverage();
    }

    public interface ColdBeverage{
        public void myColdBeverage();
    }

    public static class getCoffee implements HotBeverage{
        public void myHotBeverage(){
            System.out.println("you are getting coffee");
        }
    }

    public static class getTea implements HotBeverage{
        public void myHotBeverage(){
            System.out.println("you are getting Tea");
        }
    }
    public static class getMilk implements HotBeverage{
        public void myHotBeverage(){
            System.out.println("you are getting Milk");
        }
    }

    public static class getColdCoffee implements HotBeverage{
        public void myHotBeverage(){
            System.out.println("you are getting cold coffee");
        }
    }

    public static class getColdDrink implements ColdBeverage{
        public void myColdBeverage(){
            System.out.println("you are getting cold drink");
        }
    }



    public static abstract class machine{
        HotBeverage hotBeverage;
        ColdBeverage coldBeverage;

        public void GetSelectedHotItem()
        {
            hotBeverage.myHotBeverage();
        }
        public void GetSelectedColdItem()
        {
            coldBeverage.myColdBeverage();
        }
        public abstract void  display();
    }

    public static class Coffee extends machine
    {
        public Coffee()
        {
            hotBeverage = new getCoffee();
        }
        public void display()
        {
            System.out.println("I am coffee, have it and get refereshed");
        }
    }

    public static class ColdDrinks extends machine
    {
        public ColdDrinks()
        {
            coldBeverage = new getColdDrink();
        }
        public void display()
        {
            System.out.println("I am coke, have it and get refereshed");
        }
    }

    public static void main(String[] args) {

        Coffee coffee = new Coffee();
        coffee.GetSelectedHotItem();
        coffee.display();

        ColdDrinks coldDrinks = new ColdDrinks();
        coldDrinks.GetSelectedColdItem();
        coldDrinks.display();
    }
}
