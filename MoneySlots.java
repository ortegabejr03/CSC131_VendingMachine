public class MoneySlots {
    public int nickleSlot;
    public int dimeSlot;
    public int quarterSlot;
    public int halfDollarSlot;
    public int dollarSlot;

    public MoneySlots(int... moneyEntered){
        this.nickleSlot = moneyEntered[0];
        this.dimeSlot = moneyEntered[1];
        this.quarterSlot = moneyEntered[2];
        this.halfDollarSlot = moneyEntered[3];
        this.dollarSlot = moneyEntered[4];
    }

    public int getTotal(){
        int total = 0;
        total = total + this.nickleSlot * 5;
        total = total + this.dimeSlot * 10;
        total = total + this.quarterSlot * 25;
        total = total + this.halfDollarSlot * 50;
        total = total + this.dollarSlot * 100;
        return total;
}
}
