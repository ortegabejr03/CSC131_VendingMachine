public class Item {

public enum ItemsAvailable {
    COKE(1,75), PEPSI(2,75), SPRITE(3,75), DORITOS(4,50), LAYS(5,50), CHEETOS(6,50), COOKIES(7,25), SNICKERS(8,25);

    private int id;
    private int price;
   
    
    ItemsAvailable(int id, int price){
        this.id = id;
        this.price = price;
    }

    public int getId(){
        return this.id;
    }

    public int getPrice() {
        return this.price;
    }

    public static ItemsAvailable valueOf(int itemSelected){
        for(ItemsAvailable items: ItemsAvailable.values()){
            if(itemSelected == items.getId()){
                return items;
            }
        }
        return null;
    }

}

   




}
