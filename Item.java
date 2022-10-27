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

   private String name;
 //  private int price;
   private int quantity;

   public Item(String name, int price){
    this.name = name;
//    this.price = price;
    quantity = 0;
   }
public String getName() {
    return name;
}
public void setName(String name) {
    this.name = name;
}
//public int getPrice() {
//    return price;
//}
public void setPrice(int price) {
 //   this.price = price;
}
public int getQuantity() {
    return quantity;
}
public void addQuantity(int quantity) {
    this.quantity += quantity;
}

public void removeQuantity(int quantity){
    this.quantity -= quantity;
}
}
