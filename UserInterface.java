import java.util.Scanner;

public class UserInterface implements VendingMachine{
    //HOLDS max number of items being put into vending machine
    static int MAX_NUM_ITEMS = 12;
    private int selectedItem;
    private MoneySlots money1;
    static Item [] copyofItems = new Item[MAX_NUM_ITEMS];
   
    UserInterface(Item [] items){
        this.copyofItems = items;
    }

    static void updateItems(Item []items){
        copyofItems = items;
    }

    /*Gets the correct selection from the user
     * -1 means there is an error
     */
    static int getSelection(int itemChosen){
        Scanner scanner = new Scanner(System.in);
        String userItem ;

        boolean isAvailable = false;
        while(!isAvailable){
            
            if (itemChosen <= 0 ||itemChosen > 12 ){                                                      //Wait until a valid item has been chosen
                System.out.println("\nError: Please choose a valid item from the vending machine");
                userItem = scanner.nextLine();
                itemChosen = Integer.parseInt(userItem);
            } else if(copyofItems[itemChosen] == null){                                                               //Wait until a valid item has been chosen
                System.out.println("\nError: Please choose a valid item from the vending machine");
                userItem = scanner.nextLine();
                itemChosen = Integer.parseInt(userItem);
            } else if (copyofItems[itemChosen].getQuantity() <= 0){
                System.out.println("Error: We have ran out of the item you have chosen. Please choose another");
                userItem = scanner.nextLine();
                itemChosen = Integer.parseInt(userItem);
            } else {
                return itemChosen;
            }
        }


        return -1;
    }

    @Override
    public void displayItems() {
        System.out.println("===========WELCOME============");
        System.out.println("==============================");
        System.out.println("       Select a Product       ");
        System.out.println("                              ");

        
        for(int i = 0; i < MAX_NUM_ITEMS; i++){
            if( copyofItems[i] != null){
                if (copyofItems[i].getId() != -1){
                    System.out.println("    " + copyofItems[i].getId() + ")  " + copyofItems[i].getName() + " - Cost: " + copyofItems[i].getPrice());
                }   
            }
        }   
    }

    @Override
    public void selectItem(int item) {
        this.selectedItem = item;  
    }

    @Override
    public void displayTotal() {
        
    }

    @Override
    public void enterMoney(int... money) {
        Calc calc = new Arithmetic(); 
        int total = calc.calcTotal(new MoneySlots(money));

        int moneyAmount = total - copyofItems[selectedItem -1].getPrice();
        this.money1 = calc.calcChange(moneyAmount);
        
    }

    @Override
    public void displayChange() {
        System.out.println("================================================================");
        System.out.println("Your change is: " + money1.getTotal() + " split into the following:");
        System.out.println("    Dollars: " + money1.dollarSlot);
        System.out.println("    Half-Dollars: " + money1.halfDollarSlot);
        System.out.println("    Quarters: " + money1.quarterSlot);
        System.out.println("    Dimes: " + money1.dimeSlot);
        System.out.println("    Nickles: " + money1.nickleSlot);
        
    }

    @Override
    public void displayMoneyInfo() {
        System.out.println("Please enter money in correct format: ");
        System.out.println("Enter how many of each currency type you wish to insert into the machine followed by a comma");
        System.out.println("The order is as follows: nickles,dimes,quarters,half-dollars,dollars");
        System.out.println("                                                                                            ");
        System.out.println("Example: if you wish to insert 3 quarters and two nickles the format would be: 2,0,3,0,0");
        System.out.println("Insert money when ready:");

        
    }
    
    
}
