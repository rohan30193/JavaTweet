package com.example.helloworld;



//Factory pattern shape factory//
public class ShapeFactory {

    public interface Ishape{
        void getShape();
    }
    public static class Square implements Ishape{
        @Override
        public void getShape() {
            System.out.println("Getting Square");
        }
    }

    public static class Circle implements Ishape{
        @Override
        public void getShape() {
            System.out.println("Getting Circle");
        }
    }

    public static class Rectangle implements Ishape{
        @Override
        public void getShape() {
            System.out.println("Getting Rectangle");
        }
    }

    public static class shapefactory{
        Ishape ishape;

         Ishape createShape(String type)
         {
             if(type.equals("square"))
             {
                 this.ishape = new Square();
             }
             else if(type.equals("circle"))
             {
                 this.ishape = new Circle();
             }
             else if(type.equals("rectangle"))
             {
                 this.ishape = new Rectangle();
             }
             return ishape;
         }
    }

    public static class ShapeStore{

        shapefactory shapeFactory;
        public Ishape getYourShape(String type)
        {
            shapeFactory = new shapefactory();
            Ishape ishape = shapeFactory.createShape(type);
            return ishape;
        }
    }

    public static void main(String[] args) {
        ShapeStore shapeStore = new ShapeStore();
        Ishape ishape = shapeStore.getYourShape("circle");
        ishape.getShape();
    }


}
