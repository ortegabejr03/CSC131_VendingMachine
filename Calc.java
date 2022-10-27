public interface Calc {

    //Method to calculate the total
    int calcTotal(MoneySlots moneyIn);

    //Method to return the change
    MoneySlots calcChange(int change);
    
}
