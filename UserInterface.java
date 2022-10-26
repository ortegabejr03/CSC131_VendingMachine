public class UserInterface implements VendingMachine{

    private int selectedItem;

    @Override
    public void displayItems() {
        System.out.println("===========WELCOME============");
        System.out.println("==============================");
        System.out.println("       Select a Product       ");
        System.out.println("                              ");

        for(Item item: Item.values()){
            System.out.println("    " + item.getName());
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
        Calc calc = null;
        Item item = Item.price(this.selectedItem);
        int total = calc.calcTotal(null);
        
    }

    @Override
    public void displayChange() {
        // TODO Auto-generated method stub
        
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
