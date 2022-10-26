public interface Calc {

    //Method to calculate the total
    int calcTotal(MoneyValue moneyIn);

    //Method to return the change
    MoneyValue calcChange(int change);
    
}
