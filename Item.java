public class Item {

private int MAX_NUM_ITEMS = 12;
private int id;
private int price;
private int quantity;
private String name;

Item(String name, int id, int price, int quantity){
    this.name = name;
    this.id = id;
    this.price = price;
    this.quantity = quantity;
}

public int getId(){
    
    return this.id;
}

public int getPrice() {
    return this.price;
}

public String getName(){
    return this.name;
}

public int getQuantity(){
    return this.quantity;
}

public void removeOne(){
    this.quantity --;
}
 

}
