
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
    
        VendingMachine vendingMachine = new UserInterface();
        while (true){
            //Display the products
            vendingMachine.displayItems();

            //Collect item info from customer
            String userItem = scanner.nextLine();

            //If stocker enters code then go to stocker interface
            if(userItem.equals("*67")){
                

                //Enter Stocker Interface until user wants out
                while (!userItem.equals("4") ){
                    
                    StockerInterface.displayWelcome();
                    userItem = scanner.nextLine();
                
                
                }
            } else{
                
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

            
        }
    
}
