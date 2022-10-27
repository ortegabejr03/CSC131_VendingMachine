
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
    
        VendingMachine vendingMachine = new UserInterface();
    
        //Display the products
        vendingMachine.displayItems();

        //Collect item info from customer
        String userItem = scanner.nextLine();
        int itemChosen = Integer.parseInt(userItem);

        //Put item into system
        vendingMachine.selectItem(itemChosen);

        //Request money from Customer
        vendingMachine.displayMoneyInfo();

        String moneyCollected = scanner.nextLine();

        int [] moneyIn = MoneyValue.separateMoney(moneyCollected); 







        vendingMachine.enterMoney(moneyIn);
        vendingMachine.displayChange();

        
    }
    
}
