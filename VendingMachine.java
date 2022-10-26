public interface VendingMachine{
    

    //Method to display the items available
    void displayItems();

    //method to select an item
    void selectItem(int item);

    //Method to ask for money owed
    void displayTotal();

    //Method to collect the money
    void enterMoney(int ... money);

    //Method to display change owed
    void displayChange();


}