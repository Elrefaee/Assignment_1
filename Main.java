import java.util.Date;
import java.text.SimpleDateFormat;
class Account{
    //Variables
    private int id;
    private double balance;
    private static double annualInterestRate;
    private Date dataCreated = new Date();
    //default constructor
    public Account(){

    }
    //constructor
    public Account(int id,double balance){
        this.id = id;
        this.balance = balance;
    }
    //accessors
    public int getID(){ return id;}
    public double getBalance(){return balance;}
    public static double getAnnualInterestRate(){return annualInterestRate;}
    public Date getDateCreated()
    {
        return dataCreated;
    }
    //mutators
    public void setID(int id){ this.id = id;}
    public void setBalance(double balance){ this.balance = balance;}
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    //methods
    public double getMonthlyInterest(){
        return getBalance() * getMonthlyInterestRate();
    }
    public  double getMonthlyInterestRate(){
        return ((getAnnualInterestRate()/100)/12.0f);
    }
    public void withdraw(double amount){
        if(amount <= balance)
            balance -= amount;
    }
    public void deposit(double amount){
        if(amount > 0)
            balance += amount;
    }
}
public class Main {
    public static void main(String[] args)
    {
        Account x = new Account(1122,20000);
        SimpleDateFormat formatter = new SimpleDateFormat("2/3/2023");
        x.setAnnualInterestRate(4.5);
        x.withdraw(2500);
        x.deposit(3000);
        System.out.println("Balance = "+x.getBalance()+"\n"+
                           "Monthly Interest = "+x.getMonthlyInterest()+"\n"+
                           "Date Account is Created is "+formatter.format(x.getDateCreated()));
    }
}