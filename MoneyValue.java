public enum MoneyValue {
    NICKLES(5), DIMES(10), QUARTERS(25), HALF_DOLLARS(50), DOLLARS(100);  

    private int value;

    private MoneyValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static int[] separateMoney(String money){
        String[] sumOfMoney = money.split(",");
        int[] sum = new int[sumOfMoney.length];

        for(int i=0; i<sumOfMoney.length; i++){
            sum[i] = Integer.parseInt(sumOfMoney[i]);
        }
        return sum;
    }

}
