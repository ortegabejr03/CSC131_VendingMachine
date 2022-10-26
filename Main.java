
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
    
        VendingMachine vendingMachine = null;
    
        //Display the products
        vendingMachine.displayItems();

        //Collect item info from customer
        String userItem = scanner.nextLine();
        int itemChosen = Integer.parseInt(userItem);

        //Put item into system
        vendingMachine.selectItem(itemChosen);

        //Request money from Customer
        vendingMachine.displayChange();
        String moneyCollected = scanner.nextLine();
        int [] moneyIn = {}; //TODO

        vendingMachine.enterMoney(moneyIn);
        vendingMachine.displayChange();

        
    }
    
}
