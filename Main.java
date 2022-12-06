
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

         //Create am array of items to insert into the vending machine 
        Item [] items = new Item[12];       //Max of 12 items in the vending machine
        items[0] = new Item("COKE", 1, 75, 8);
        items[1] = new Item("PEPSI", 2, 75, 5);
        items[2] = new Item("SPRITE", 3, 75, 8);
        items[3] = new Item("DORITOS", 4, 50, 9);
        items[4] = new Item("LAYS", 5, 50, 5);
        items[5] = new Item("CHEETOS", 6, 50, 9);
        items[6] = new Item("COOKIES", 7, 25, 6);
        items[7] = new Item("SNICKERS", 8, 25, 7);

        //initialize the rest of the available items
        for(int i = 8; i < 12; i++){
            items[i] = new Item(null, -1, -1, -1);
        }
    
        VendingMachine vendingMachine = new UserInterface(items);
        while (true){
            //Update Items to userInterface and stockerInterface
            UserInterface.updateItems(items);
            StockerInterface.updateItems(items);

            //Display the products
            vendingMachine.displayItems();

            //Collect item info from customer

            String userItem = scanner.nextLine();

            //If stocker enters code then go to stocker interface
            if(userItem.equals("*67")){
                

                //Enter Stocker Interface until user wants out
                while (!userItem.equals("5") ){
                    
                    StockerInterface.displayWelcome();
                    userItem = scanner.nextLine();
                    int itemChosen = Integer.parseInt(userItem);

                    switch (itemChosen){
                        case 1: StockerInterface.restockItem();
                                items = StockerInterface.copyofItems;
                                break;
                        
                        case 2: StockerInterface.removeItem();
                                items = StockerInterface.copyofItems;
                                break;
                        case 3: StockerInterface.createItem();
                                items = StockerInterface.copyofItems;
                                break;
                        case 4: StockerInterface.displayList();
                                break;
                        case 5: break;

                        default:System.out.println("Please choose a valid option");
                                break;
                    }
                    
                
                
                }
            } else{
                
                int itemChosen = Integer.parseInt(userItem);
                itemChosen = UserInterface.getSelection(itemChosen);
                
                //Put item into system
                vendingMachine.selectItem(itemChosen);
                
                //Request money from Customer
                vendingMachine.displayMoneyInfo();

                String moneyCollected = scanner.nextLine();

                int [] moneyIn = MoneyValue.separateMoney(moneyCollected); 

                vendingMachine.enterMoney(moneyIn);
                vendingMachine.displayChange();

                //Remove one from quantity of item chosen
                items[itemChosen].removeOne();
            }
        }

            
        }
    
}
