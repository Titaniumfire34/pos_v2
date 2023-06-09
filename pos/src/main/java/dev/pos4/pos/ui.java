package dev.pos4.pos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;
public class ui {
    //sample variables for testing
    private static employee sampleEmployee;
    private static Dish sampleDish;
    private static LinkedList<employee> sampleEmpList = new LinkedList<employee>();
    private static LinkedList<clockIO> clockSampleList = new LinkedList<clockIO>();
    private static LinkedList<table> sampleTableList = new LinkedList<table>(); //can be used as final
    private static LinkedList<Dish> sampleDishList = new LinkedList<>();
    private static LinkedList<Ticket> sampleticketList = new LinkedList<Ticket>();
    public static void main(String[] args){
        //this is an login example, users are added as samples upon scan, type "test" as user and "fail" as password to example a mismatched case
        login();

        //after this initial login or before, we need to be able to upload existing employee information
        //as well as all dishes ingredients and prior data
        //for testing purposes, these will be instantiated at run time
        createSamples();
        
        //runs the pos and menu options
        pos();
        

    }


    //======================================================================Below this line are functions to initialize samples for testing ===================================================================//
    //all samples will be replaced later when we have database
    public static Dish findDishSample(int dishID){
        LinkedList<Dish> tempDishList = sampleDishList;
        Dish ret = null;
        while(sampleDishList.size()!=0){
            ret = sampleDishList.removeFirst();
            sampleDishList.add(ret);
                if(ret.id == dishID){
                    System.out.println("Dish has been found: "+ ret.name);
                    break;
                }
        }
        return ret;
    }
    
    public static void addSampleTable(table sampleTable){
        sampleTableList.add(sampleTable);
    }
    public static void addSampleTicket(Ticket sampleTicket){
        sampleticketList.add(sampleTicket);
    }

    

    public static void clockInSample(clockIO clockInSample){
        //add new clockIO object, every clock in will be a new object
        clockSampleList.add(clockInSample);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        String clockTimeFormat = clockInSample.clockIn.format(format);
        System.out.println(clockInSample.employee.name + " is clocked in at :"+ clockTimeFormat);
    }
    
    public static void clockOutSample(clockIO clockOutSample){
        //removes clocked in to adjust time then add the same sample back in
        
        clockSampleList.remove(clockOutSample);
        clockOutSample.setClockout(LocalDateTime.now());
        clockSampleList.add(clockOutSample);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        String clockTimeFormat = clockOutSample.clockIn.format(format);
        System.out.println(clockOutSample.employee.name + " is clocked out at :"+ clockTimeFormat);
    }

    public static clockIO findClockSample(employee employeeSample){
        LinkedList<clockIO> tempClockList = clockSampleList;
        clockIO ret = null;
        while(tempClockList.size()!=0){
            clockIO tempClock = tempClockList.removeFirst();
            tempClockList.add(tempClock);
            if(tempClock.employee.equals(employeeSample)){
                ret = tempClock;
                break;
            }
        }
        return ret;
    }

    public static void createSamples(){
        sampleEmployee = new employee("John", "Server", 1, 7.25, 0);
        sampleEmpList.add(sampleEmployee);
        sampleDish = new Dish("Pancakes","breakfast", 1);
        sampleDishList.add(sampleDish);

    }
    public static void addEmpSample(employee sample){
        sampleEmpList.add(sample);
    }
    public static void removeEmpSample(int id){
        LinkedList<employee> temp = sampleEmpList;
        while(temp.size()!=0){
            employee tempEmp = temp.removeFirst();
            if(tempEmp.id==id){
                sampleEmpList.remove(tempEmp);
                break;
            }
        }
    }
    public static employee returnEmpSample(int id){
        LinkedList<employee> temp = sampleEmpList;
        employee ret = null;
        while(temp.size()!=0){
            employee tempEmp = temp.removeFirst();
            temp.add(tempEmp);
            if(tempEmp.id==id){
                ret = tempEmp;
                return ret;
            }
        }
        return ret;
        
    }
    //================================================Above this line are functions to initialize samples for testing ui ================================================================================//

    
    public static void pos(){
        while(true){
            mainMenu();
        }
    }

    public static void mainMenu(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a menu choice 1-3");
        System.out.println("1. Clock in");
        System.out.println("2. Tables");
        System.out.println("3. Tickets");
        System.out.println("4. Kitchen");
        System.out.println("5. Add/Rem Employee");
        System.out.println("9. Exit Software");
        
        int choice = scan.nextInt();
        scan.nextLine();
        switch (choice){
            case 1:
                screens.ClockIn();
                break;
            case 2:
                screens.Tables();
                break;
            case 3:
                screens.Tickets();
                break;
            case 4:
                screens.Kitchen();
                break;
            case 5:
                screens.editEmployee();
                break;
            case 9:
                shutDown();
            default:
                System.out.println("Please choose again.");

        }
    }

    public static void login(){
        while(!userLogin.initLogin()){
            System.out.println("Please login.");
        }
    }

    public static void shutDown(){
        System.out.println("Exiting software.");
        System.exit(0);
    }
    
}
