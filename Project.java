package project;
import java.util.*;
public class Project {
    //Scanner is global for convienience.
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Variable needed
        int menuSelect = 1;
        ArrayList<CarClass> cars = new ArrayList<>();
        
        //Filling the array with some info
        CarClass temp = new CarClass("1237362", "Porsche", "911", 2005, 18990, 5000);
        cars.add(temp);        
        temp = new CarClass("7337372", "Ford", "Mustang", 2007, 49842, 2000);
        cars.add(temp); 
        temp = new CarClass("2873644", "Chevorlet", "Beretta", 1989, 90332, 5500);
        cars.add(temp);
        
        //Menu loop
        while(menuSelect != 0)
        {
            System.out.println("|===================================|");
            System.out.println("| 1 - Add a car                     |");
            System.out.println("| 2 - Show all cars                 |");
            System.out.println("| 3 - Show car info                 |");
            System.out.println("| 4 - Make changes to a car         |");
            System.out.println("| 5 - Show average milage of cars   |");
            System.out.println("| 6 - Show lowest priced car        |");
            System.out.println("| 7 - Make an offer!                |");
            System.out.println("| 0 - EXIT                          |");
            System.out.println("|===================================|");

            //get menu option and step into switch-case
            System.out.println("Please enter an option from above: ");
            menuSelect = Integer.parseInt(input.nextLine());
            switch (menuSelect)
            {
                case 1:
                    addCar(cars);
                    break;
                case 2:
                    showAllCars(cars);
                    break;
                case 3:
                    showOneCar(cars);
                    break;
                case 4:
                    changeCar(cars);
                    break;
                case 5:
                    showAvgMilage(cars);
                    break;
                case 6:
                    showLowestPrice(cars);
                    break;
                case 7:
                    makeAnOffer(cars);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Please enter a valid option from the menu");
                    break;
            }
        }
    }
    
    //All public functions for the menu
    //Add a car
    public static void addCar(ArrayList<CarClass> _cars)
    {
        String vin;
        String make;
        String model;
        int year;
        int milage;
        float price;

        try
        {
            System.out.println("Adding a new car!");
            System.out.println("Enter a VIN: ");
            vin = input.nextLine();
            System.out.println("Enter a Make: ");
            make = input.nextLine();
            System.out.println("Enter a Model: ");
            model = input.nextLine();
            System.out.println("Enter a Year: ");
            year = Integer.parseInt(input.nextLine());
            System.out.println("Enter a Milage: ");
            milage = Integer.parseInt(input.nextLine());
            System.out.println("Enter a Price: ");
            price = Float.parseFloat(input.nextLine());
            CarClass temp = new CarClass(vin, make, model, year, milage, price);
            _cars.add(temp);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    } 
    
    //Change a car
    public static void changeCar(ArrayList<CarClass> _cars)
    {
        String tempString = "";
        int tempInt = 0;
        showAllCars(_cars);
        System.out.println("Please enter the car you need to modify: ");
        int tempIndex = Integer.parseInt(input.nextLine());
        System.out.println(_cars.get(tempIndex).getValues());
        System.out.println("|===================================|");
        System.out.println("| 1 - VIN                           |");
        System.out.println("| 2 - Make                          |");
        System.out.println("| 3 - Model                         |");
        System.out.println("| 4 - Year                          |");
        System.out.println("| 5 - Milage                        |");
        System.out.println("| 6 - Price                         |");
        System.out.println("|===================================|");
        System.out.println("Please enter which value to modify: ");
        int select = Integer.parseInt(input.nextLine());
        switch(select)
        {
            case 1:
                System.out.println("Please enter a new VIN: ");
                tempString = input.nextLine();
                _cars.get(tempIndex).setVIN(tempString);
                break;
            case 2:
                System.out.println("Please enter a new Make: ");
                tempString = input.nextLine();
                _cars.get(tempIndex).setMake(tempString);
                break;
            case 3:
                System.out.println("Please enter a new Model: ");
                tempString = input.nextLine();
                _cars.get(tempIndex).setModel(tempString);
                break;
            case 4:
                System.out.println("Please enter a new Year: ");
                tempInt = Integer.parseInt(input.nextLine());
                try{
                    _cars.get(tempIndex).setYear(tempInt);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            case 5:
                System.out.println("Please enter a new Milage: ");
                tempInt = Integer.parseInt(input.nextLine());
                try{
                    _cars.get(tempIndex).setMilage(tempInt);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            case 6:
                System.out.println("Please enter a new Price: ");
                float tempF = Float.parseFloat(input.nextLine());
                try{
                    _cars.get(tempIndex).setPrice(tempF);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                break;
            default:
                System.out.println("Invalid selecton. Exiting back to Main Menu ..");
        }
    }
    
    //Show all cars
    public static void showAllCars(ArrayList<CarClass> _cars)
    {
        for (int x = 0; x < _cars.size(); x++)
        {
            System.out.println(x+1 + " - " + _cars.get(x).getValues());
        }
    }
    
    //Show a single car
    public static void showOneCar(ArrayList<CarClass> _cars)
    {
        showAllCars(_cars);
        System.out.println("Please choose a car to see the details: ");
        int temp = Integer.parseInt(input.nextLine());
        System.out.println(_cars.get(temp-1).getValues());
    }
    
    //Find the average milage
    public static void showAvgMilage(ArrayList<CarClass> _cars)
    {
        int tempMilage = 0;
        for (int x = 0; x < _cars.size(); x++)
        {
            tempMilage += _cars.get(x).getMilage();
        }
        int tempAverage = tempMilage / _cars.size();
        System.out.println("The average miles of each car on the lot is: " + tempAverage);
    }
    
    //Find which car has the lowest price
    public static void showLowestPrice(ArrayList<CarClass> _cars)
    {
        float lowestPrice = _cars.get(0).getPrice();
        int lowestInd = 0;
        for(int x = 1; x < _cars.size(); x++)
        {
            if(lowestPrice > _cars.get(x).getPrice())
            {
                lowestPrice = _cars.get(x).getPrice();
                lowestInd = x;
            }
        }
        System.out.println("The lowest price car on the lot costs: " + String.format("%.2f", lowestPrice));
        System.out.println(_cars.get(lowestInd).getValues());
    }
    
    //Make an offer!
    public static void makeAnOffer(ArrayList<CarClass> _cars)
    {
        for(int x = 0; x < _cars.size(); x++)
        {
            System.out.println(x + 1 + " - " + _cars.get(x).getValues());
        }
        System.out.println("Please choose a car from above to make an offer: ");
        int tempSel = Integer.parseInt(input.nextLine());
        try
        {
            float tempPrice = _cars.get(tempSel).getPrice();
            System.out.println("|-----------------------|");
            System.out.println("| 1 - Just likes it     |");
            System.out.println("| 2 - Somewhat likes it |");
            System.out.println("| 3 - Almost likes it   |");
            System.out.println("|-----------------------|");
            System.out.println("How would you rate the customers attachment to the car?");
            tempSel = Integer.parseInt(input.nextLine());
            switch(tempSel)
            {
                case 1:
                    System.out.println("The customer get's a discount of $100");
                    break;
                case 2:
                    System.out.println("The customer get's a discount of $200");
                    break;
                case 3:
                    System.out.println("The customer get's a discount of $500");
                    break;
                default:
                    System.out.println("Invalid option: Returning to Main Menu.");
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
}