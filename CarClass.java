package project;
public class CarClass {
    //private variables
    private String vin;
    private String make;
    private String model;
    private int year;
    private int milage;
    private float price;
    
    //Custom exception classes
    static class exWrongYear extends Exception {
        public exWrongYear(String err){
            super(err);
        }
    };
    static class exWrongMilage extends Exception {
        public exWrongMilage(String err){
            super(err);
        }
    };
    static class exWrongPrice extends Exception {
        public exWrongPrice(String err){
            super(err);
        }
    };
    
    //Public functions, gets and sets
    public CarClass(String _vin, String _make, String _model, int _year, int _milage, float _price)
    {
        this.vin = _vin;
        this.make = _make;
        this.model = _model;
        this.year = _year;
        this.milage = _milage;
        this.price = _price;
    }
    public void setVIN(String _vin)
    {
        vin = _vin;
    }
    public void setMake(String _make)
    {
        make = _make;
    }
    public void setModel(String _Model)
    {
        model = _Model;
    }
    public void setYear(int _year) throws exWrongPrice
    {
        if (_year > 1970)
        {
            year = _year;
        } else {
            throw new CarClass.exWrongPrice("Year must be newer than 1970");
        }
       
    }
    public void setMilage(int _milage) throws exWrongMilage
    {
        if (_milage > 0)
        {
            milage = _milage;
        } else {
            throw new CarClass.exWrongMilage("Milage must be greater than 0");
        }
    }
    public void setPrice(float _price) throws exWrongPrice
    {
        if (_price > 1000)
        {
            price = _price;
        } else {
            throw new CarClass.exWrongPrice("Price must be greater than $1000");
        }
    }
    public String getValues()
    {
        return this.vin + " " + this.make + " " + this.model + " " + this.year + " " + this.milage + " " + String.format("%.2f", this.price);
    }
    public int getMilage()
    {
        return this.milage;
    }
    public float getPrice()
    {
        return this.price;
    }
}
