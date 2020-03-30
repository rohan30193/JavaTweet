package com.example.helloworld;

import java.util.*;

public class Flipfit {

    public static class Person{
        String firstName;
        String lastName;
        String phone;
        String email;
        public Person(String firstName,String lastName,String phone,String email)
        {
            this.firstName=firstName;
            this.lastName=lastName;
            this.phone=phone;
            this.email=email;
        }
    }
    public static abstract class Account{
        String userName;
        String passWord;
        Person person;

    }
    public static class User extends Account{

        Mycentre mycentre;
        List<Mycentre> mycentreList = new LinkedList<>();

        void getAccess(List<Mycentre> list){
            mycentreList=list;
        }

        void viewAllGymSlots()
        {
            for(int i=0;i<mycentreList.size();i++)
            {
                Mycentre mycentre = mycentreList.get(i);
                mycentre.getSchedule();
            }
        }

        void bookASlot(String centerName, String day, String start, String end, String workout)
        {
            try{
                Mycentre mycentre = new Mycentre();
                for(int i=0;i<mycentreList.size();i++)
                {
                    mycentre=mycentreList.get(i);
                    if(mycentre.getName().equals(centerName.toLowerCase()))
                    {
                        HashMap<slots,List<Workout>> hm=mycentre.getSlotsWorkoutListHashMap();
                        for(Map.Entry<slots, List<Workout>> entry:hm.entrySet())
                        {
                            slots slots = new slots();
                            slots = entry.getKey();
                            List<Workout> workoutList= new LinkedList<>();
                            workoutList = entry.getValue();


                            if(slots.getDay().equals(day.toLowerCase()) && slots.getStartTime().equals(start.toLowerCase()) && slots.getEndTime().equals(end.toLowerCase()))
                            {
                                for(int j=0;j<workoutList.size();j++)
                                {
                                    Workout workout1 = new Workout();
                                    workout1=workoutList.get(j);
                                    if(workout1.getName().equals(workout.toLowerCase()))
                                    {
                                        if(workout1.getWorkoutCapacity()>0) {
                                            workout1.setWorkoutCapacity(workout1.WorkoutCapacity - 1);
                                            System.out.println("booking confirmed for" + workout1.getName());
                                        }
                                        else {
                                            System.out.println("This slot is full");
                                        }
                                    }
                                    else
                                    {
                                        System.out.println(workout+"not available");
                                    }
                                }
                            }
                        }

                    }

                }
            }
            catch (Exception ex)
            {
                System.out.println("exception thrown"+ex);
            }
        }



    }
    public static class Admin extends Account{

        List<Mycentre> mycentreList;
        List<User> userList;
        public Admin()
        {
            userList = new LinkedList<>();
            mycentreList = new LinkedList<>();
        }

        private void addCenters(Mycentre mycentre)
        {
            mycentreList.add(mycentre);
        }


        public void deleteUser(User user)
        {
            int deletedUserIndex = userList.indexOf(user);
            userList.remove(deletedUserIndex);
        }

        public void registerUser(User user)
        {
            userList.add(user);
            user.getAccess(mycentreList);
        }



    }
    public static class Workout{
        String name;
        int WorkoutCapacity;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name.toLowerCase();
        }

        public int getWorkoutCapacity() {
            return WorkoutCapacity;
        }

        public void setWorkoutCapacity(int workoutCapacity) {
            WorkoutCapacity = workoutCapacity;
        }
    }


    public static class slots{
        String day;
        String startTime;
        String endTime;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day.toLowerCase();
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime.toLowerCase();
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime.toLowerCase();
        }
    }


 public static class Mycentre{
     String name;
     String city;
     String state;
     String area;
      List<Workout> workoutList;
      List<slots> slotsList;
      HashMap<slots,List<Workout>> slotsWorkoutListHashMap;
     Mycentre()
     {

         slotsList = new LinkedList<>();
         workoutList = new LinkedList<>();
         slotsWorkoutListHashMap = new HashMap<>();
     }

     public List<Workout> getWorkoutList() {
         return workoutList;
     }

     public List<slots> getSlotsList() {
         return slotsList;
     }

     public HashMap<slots, List<Workout>> getSlotsWorkoutListHashMap() {
         return slotsWorkoutListHashMap;
     }

     void addSlots(slots slot)
     {
         slotsList.add(slot);
     }

     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name.toLowerCase();
     }

     public String getCity() {
         return city;
     }

     public void setCity(String city) {
         this.city = city.toLowerCase();
     }

     public String getState() {
         return state;
     }

     public void setState(String state) {
         this.state = state.toLowerCase();
     }

     public String getArea() {
         return area;
     }

     public void setArea(String area) {
         this.area = area.toLowerCase();
     }

     void addWorkOuts(Workout workout)
     {
         workoutList.add(workout);
     }

     void addWorkoutsInSlots(String day, String startTime, String endTime, Workout workout)
     {
         try {
             for (int i = 0; i < slotsList.size(); i++) {
                 slots slots = slotsList.get(i);
                 if (slots.day.equals(day.toLowerCase()) && slots.startTime.equals(startTime.toLowerCase()) && slots.endTime.equals(endTime.toLowerCase())) {
                     if (slotsWorkoutListHashMap.containsKey(slots)) {
                         List<Workout> list = new LinkedList<>();
                         list = slotsWorkoutListHashMap.get(slots);
                         list.add(workout);
                         slotsWorkoutListHashMap.put(slots, list);
                     } else {
                         List<Workout> list = new LinkedList<>();
                         list.add(workout);
                         slotsWorkoutListHashMap.put(slots, list);
                     }
                 }

             }
         }
         catch (Exception ex)
         {
             System.out.println("slot not found");
             throw ex;
         }
     }


     public void getSchedule()
     {
         for(Map.Entry<slots, List<Workout>> entry:slotsWorkoutListHashMap.entrySet())
         {
             slots slots = entry.getKey();
             List<Workout> list = entry.getValue();
             System.out.println(name+" "+state+" "+city+" "+area+" "+slots.day+" "+slots.startTime+" "+slots.endTime);
             for(int i=0;i<list.size();i++)
             {
                 Workout workout = list.get(i);
                 System.out.println(workout.name+" "+workout.WorkoutCapacity);
             }

         }
     }





 }

    public static void main(String[] args) {
        Workout zumba = new Workout();
        zumba.setName("zumba");
        zumba.setWorkoutCapacity(1);
        Workout cardio = new Workout();
        cardio.setName("cardio");
        cardio.setWorkoutCapacity(1);
        slots slot1 = new slots();
        slot1.setDay("monday");
        slot1.setStartTime("1pm");
        slot1.setEndTime("2pm");
        slots slot2 = new slots();
        slot2.setDay("tuesday");
        slot2.setStartTime("1pm");
        slot2.setEndTime("2pm");


        Mycentre KoramanglaCenter = new Mycentre();
        KoramanglaCenter.setArea("koramangla");
        KoramanglaCenter.setCity("banglore");
        KoramanglaCenter.setName("koramanglaCenter");
        KoramanglaCenter.setState("karnataka");
        KoramanglaCenter.addSlots(slot1);
        KoramanglaCenter.addSlots(slot2);
        KoramanglaCenter.addWorkOuts(zumba);
        KoramanglaCenter.addWorkOuts(cardio);
        KoramanglaCenter.addWorkoutsInSlots("Monday","1pm","2pm",zumba);
        KoramanglaCenter.addWorkoutsInSlots("Monday","1pm","2pm",cardio);
        KoramanglaCenter.addWorkoutsInSlots("tuesday","1pm","2pm",zumba);
        KoramanglaCenter.addWorkoutsInSlots("tuesday","1pm","2pm",cardio);

        Mycentre BellandurCenter = new Mycentre();
        BellandurCenter.setArea("bellandur");
        BellandurCenter.setCity("banglore");
        BellandurCenter.setName("bellandurCenter");
        BellandurCenter.setState("karnataka");
        BellandurCenter.addSlots(slot1);
        BellandurCenter.addSlots(slot2);
        BellandurCenter.addWorkOuts(zumba);
        BellandurCenter.addWorkOuts(cardio);
        BellandurCenter.addWorkoutsInSlots("Monday","1pm","2pm",zumba);
        BellandurCenter.addWorkoutsInSlots("Monday","1pm","2pm",cardio);
        BellandurCenter.addWorkoutsInSlots("tuesday","1pm","2pm",zumba);
        BellandurCenter.addWorkoutsInSlots("tuesday","1pm","2pm",cardio);
        BellandurCenter.getSchedule();

        User user1 = new User();
        User user2 = new User();
        Admin admin = new Admin();
        admin.addCenters(KoramanglaCenter);
        admin.addCenters(BellandurCenter);
        admin.registerUser(user2);
        admin.registerUser(user1);
        user1.viewAllGymSlots();
        user1.bookASlot("koramanglaCenter","monday","1pm","2pm","cardio");
        user2.bookASlot("koramanglaCenter","monday","1pm","2pm","cardio");





    }

}
