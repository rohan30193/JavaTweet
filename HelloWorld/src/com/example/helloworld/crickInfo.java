package com.example.helloworld;

/*crickinfo observer pattern*/
import java.util.ArrayList;

public class crickInfo {

    public interface Crickdata{
        public void notifyUsers();
        public void addUsers(Observer observer);
        public void RemoveUsers(Observer observer);
    }
    public interface Observer{
        public void Update(int run,int wicket,float overs);
    }
    public interface Display{
        public void display();
    }

    public static class users implements Observer,Display {
        int run;
        int wickets;
        float overs;
        Crickdata crickdata;
        public users (Crickdata crickdata)
        {
            this.crickdata=crickdata;
            crickdata.addUsers(this);
        }

        @Override
        public void display() {
            System.out.println("current run:-"+run+" current wicket:-"+wickets+" overs:-"+overs+" average:-"+run/overs+" projected score"+(run/overs)*50);
        }

        @Override
        public void Update(int run, int wicket, float overs) {
            this.run=run;
            this.wickets=wicket;
            this.overs=overs;
            display();
        }
    }
    public static class CricketInfo implements Crickdata {
        int run;
        int wicket;
        float overs;
        ArrayList<Observer> list;

        public CricketInfo() {
            list = new ArrayList<Observer>();
        }

        @Override
        public void addUsers(Observer observer) {
            list.add(observer);
        }

        @Override
        public void  RemoveUsers(Observer observer) {
            int i=list.indexOf(observer);
            if(i>=0)
            {
                list.remove(i);
            }
        }

        @Override
        public void notifyUsers() {

            for(int i=0;i<list.size();i++)
            {
                Observer observer= list.get(i);
                observer.Update(run,wicket,overs);
            }
        }
        public void setUpdate(int run, int wickets, float overs )
        {
            this.run=run;
            this.wicket=wickets;
            this.overs=overs;
            notifyUsers();
        }
    }

    public static void main(String[] args) {
        CricketInfo cricketInfo=new CricketInfo();
        users users= new users(cricketInfo);
        cricketInfo.setUpdate(70,3,11.2f);
        cricketInfo.setUpdate(81,3,15.3f);
    }
    }


