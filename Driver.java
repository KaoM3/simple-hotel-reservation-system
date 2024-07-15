import room.*;

public class Driver {
    
    public static void main(String[] args) {

        double baseRate = 100;
        
        StandardRoom s = new StandardRoom("Standard Room", baseRate);
        DeluxeRoom d = new DeluxeRoom("Deluxe Room", baseRate);
        ExecutiveRoom e = new ExecutiveRoom("Executive's Office", baseRate);

        System.out.printf("%s %.2f\n", s.getName(), s.getBasePrice());
        System.out.printf("%s %.2f\n", d.getName(), d.getBasePrice());
        System.out.printf("%s %.2f\n", e.getName(), e.getBasePrice());

    }

}
