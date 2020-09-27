package Task01;

public class TerminalImpl implements Terminal {

//    private final TerminalServer server;
//    private final PinValidator pinValidator;

//    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
//        this.server = server;
//        this.pinValidator = pinValidator;
//    }
    private int money = 1000;

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
