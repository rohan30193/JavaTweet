package com.example.helloworld;

/* strategy pattern Duck simulation game   */

public class duckSimulation {


    public interface RunBehaviour{
        public void run();
    }
    public interface FlyBehaviour{

        public void fly();
    }
    public interface QuackBehaviour{

        public void quack();
    }
    public static class canRun implements RunBehaviour{
        public void run() {
            System.out.println("I can run");
        }
    }
    public static class cantRun implements RunBehaviour{
        public void run() {
            System.out.println("I can't run");
        }
    }
    public static class flyWithWings implements FlyBehaviour
    {
        public void fly()
        {
            System.out.println("I am flying");
        }
    }
    public class flyNoWings implements FlyBehaviour
    {
        public void fly()
        {
            System.out.println("I can't flying");
        }
    }
    public static class canQuack implements QuackBehaviour
    {
        public void quack()
        {
            System.out.println("I can quack quack");
        }
    }
    public class cantQuack implements QuackBehaviour
    {
        public void quack()
        {
            System.out.println("I can't quack quack");
        }
    }
    public static abstract class duck{
        FlyBehaviour flyBehaviour;
        QuackBehaviour quackBehaviour;
        RunBehaviour runBehaviour;

        public void performFly()
        {
            flyBehaviour.fly();
        }
        public void performQuack()
        {
            quackBehaviour.quack();
        }
        public void performRun() {runBehaviour.run();}

        public abstract void display();
    }

    public static class malladDuck extends duck{

        public malladDuck()
        {
            flyBehaviour = new flyWithWings();
            quackBehaviour = new canQuack();
            runBehaviour = new cantRun();
        }

        public void display()
        {
            System.out.println("i am a mallard duck");
        }
    }

    public static class runningDuck extends duck{

        public runningDuck()
        {
            flyBehaviour = new flyWithWings();
            quackBehaviour = new canQuack();
            runBehaviour = new canRun();
        }
        public void display()
        {
            System.out.println("I am a running duck");
        }
    }

    public static void main(String[] args) {

        duck mallard = new malladDuck();

        mallard.performRun();
        mallard.performFly();
        mallard.performQuack();
        mallard.performRun();
        mallard.display();

        duck runnerDuck = new runningDuck();
        runnerDuck.performQuack();
        runnerDuck.performQuack();
        runnerDuck.performRun();
        runnerDuck.display();
    }
}
