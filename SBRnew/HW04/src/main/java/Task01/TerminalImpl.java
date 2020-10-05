package Task01;

public class TerminalImpl implements Terminal {

    private final TerminalServer server = new TerminalServer();
    private final PinValidator pinValidator = new PinValidator();


    private int money = 10000;

    @Override
    public void checkAccountStatus() {

        System.out.println(money + "\n");

    }

    @Override
    public int withDrawMoney(int DrawMoney) {

        try {
            if((money -= DrawMoney) < 0){
                throw new RuntimeException();
            }
        } catch (RuntimeException e){
            TerminalServer t = new TerminalServer();
            System.out.println("Not enough money to complete the operation\n");
            t.print();
        }
        return money;
    }

    @Override
    public int withPutMoney(int PutMoney) {
        money += PutMoney;
        return money;
    }
}
