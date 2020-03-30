package com.example.helloworld;

public class singelton {

    public static class Singelton{

        private static Singelton instance;
        int a;
        private Singelton()
        {
            a=2;
        }
        public static Singelton getInstance()
        {
            if(instance==null)
            {
                System.out.println("instanciating once");
                instance = new Singelton();

            }
            return instance;

        }

        public int getA() {
            return a;
        }
    }

    public static void main(String[] args) {
        Singelton singelton = Singelton.getInstance();
        System.out.println(singelton.getA());
        Singelton singelton1 = Singelton.getInstance();
        System.out.println(singelton1.getA());
    }
}
