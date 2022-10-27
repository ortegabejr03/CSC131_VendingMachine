public class Arithmetic implements Calc{

    @Override
    public int calcTotal(MoneySlots moneyIn) {
        return moneyIn.getTotal();
    }

    @Override
    public MoneySlots calcChange(int change) {
        MoneySlots money = new MoneySlots(new int[5]);
        int remainingAmount = change;

        money.dollarSlot = remainingAmount / 100;
        remainingAmount = remainingAmount % 100;

        money.halfDollarSlot = remainingAmount / 50;
        remainingAmount = remainingAmount % 50;

        money.quarterSlot = remainingAmount / 25;
        remainingAmount = remainingAmount % 25;

        money.dimeSlot = remainingAmount / 10;
        remainingAmount = remainingAmount % 10;

        money.nickleSlot = remainingAmount / 5;
        
        return money;
    }

    
}
