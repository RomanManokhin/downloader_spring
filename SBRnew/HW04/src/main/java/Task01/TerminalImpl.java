package Task01;

public class TerminalImpl implements Terminal {

//    private final TerminalServer server;
//    private final PinValidator pinValidator;

//    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
//        this.server = server;
//        this.pinValidator = pinValidator;
//    }
int money = 10000;

    @Override
    public void checkAccountStatus() {

        System.out.println(money + "\n");

    }

    @Override
    public int withDrawMoney(int DrawMoney) {
        money -= DrawMoney;
        return money;
    }

    @Override
    public int withPutMoney(int PutMoney) {
        money += PutMoney;
        return money;
    }
}
