

public class UserInterface implements VendingMachine{

    private int selectedItem;
    private MoneySlots money1;

    @Override
    public void displayItems() {
        System.out.println("===========WELCOME============");
        System.out.println("==============================");
        System.out.println("       Select a Product       ");
        System.out.println("                              ");

        for(Item.ItemsAvailable items: Item.ItemsAvailable.values()){
            System.out.println("    " + items.getId() + ")  " + items.name() + " - Cost: " + items.getPrice());
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
        Item.ItemsAvailable items = Item.ItemsAvailable.valueOf(this.selectedItem);
        int total = calc.calcTotal(new MoneySlots(money));

        int moneyAmount = total - items.getPrice();
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
