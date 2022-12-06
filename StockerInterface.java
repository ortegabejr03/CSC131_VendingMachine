import java.util.Scanner;

public class StockerInterface {
    
    //HOLDS max number of items being put into vending machine
    static int MAX_NUM_ITEMS = 12;
    private int selectedItem;
    static Item [] copyofItems = new Item[MAX_NUM_ITEMS];

    StockerInterface(Item [] items){
        this.copyofItems = items;
    }

    static void updateItems(Item []items){
        copyofItems = items;
    }

    //Display welcome message for stocker interface
    public static void displayWelcome(){
        System.out.println("Welcome Mr./Mrs stocker ... What would you like to do today?");
        System.out.println("1. Restock an item");
        System.out.println("2. Removing an item");
        System.out.println("3. Creating and Inserting an item");
        System.out.println("4. List of items that need to be restocked");
        System.out.println("5. Exit the stocker interface");
    }


    /*Checks if valid item has been chosen */
    public static int chooseItem(int itemChosen){
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

            } else {

                return itemChosen;

            }
        }
        return -1;
    }

    public static void restockItem(){
        Scanner scanner = new Scanner(System.in);
        String userItem;
        
        //Find which item Stocker would like to restock
        System.out.println("Choose which item you would like to restock");
        userItem = scanner.nextLine();
        int itemChosen = Integer.parseInt(userItem);
        itemChosen = chooseItem(itemChosen);

        //Ask the quantity of the item 
        System.out.println("How much will you add?");
        userItem = scanner.nextLine();
        int quantityAdded = Integer.parseInt(userItem);

        copyofItems[itemChosen - 1].addToQuantity(quantityAdded);

    }

    public static void removeItem(){
        Scanner scanner = new Scanner(System.in);
        String userItem;
        
        //Find which item Stocker would like to restock
        System.out.println("Choose which item you would like to remove");
        userItem = scanner.nextLine();
        int itemChosen = Integer.parseInt(userItem);
        itemChosen = chooseItem(itemChosen);

        copyofItems[itemChosen - 1].removeItem();
    }

    public static boolean isFull(){
        for(int i = 0; i < MAX_NUM_ITEMS; i++){
            if(copyofItems[i] == null){
                return false;
            } else if(copyofItems[i].getId() == -1){
                return false;
            }
        }
        return true;
    }

    public static int nextAvailable(){
        for(int i = 0; i < MAX_NUM_ITEMS; i++){
            if(copyofItems[i] == null){
                return i;
            } else if(copyofItems[i].getId() == -1){
                return i;
            }
        }
        return -1;
    }

    public static void createItem(){
        Scanner scanner = new Scanner(System.in);
        String userItem;
        String name;
        int price; 
        int id;
        int quantity;

        //Find out if there is space for item to be created
        if (isFull() == true){
            System.out.println("The vending machine is currently full. Please remove an item before creating and inserting a new item");
        } else {

            //Ask the user for information to insert into the item into the vending machine 
            System.out.println("What is the name of the item: ");
            name = scanner.nextLine();
            System.out.println("What is the price of the item: ");
            userItem = scanner.nextLine();
            price = Integer.parseInt(userItem);
            System.out.println("What is the quantity of the item being inserted: ");
            userItem = scanner.nextLine();
            quantity = Integer.parseInt(userItem);

            //Find id of next available slot in Vending Machine
            id = nextAvailable();

            //Create the Item 
            copyofItems[id].createItem(name, id + 1, price, quantity);

        }
    }

    public static void displayList(){

        System.out.println("Here is the list of items that need to be restocked");

        for(int i = 0; i < MAX_NUM_ITEMS; i++){
            if(copyofItems[i].getId() > 0){
                System.out.println(" " + copyofItems[i].getName() + " needs " + (20 - copyofItems[i].getQuantity()) + " more");
            }
        }
    }
}
