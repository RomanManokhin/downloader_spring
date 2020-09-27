package Task01;

public class TerminalImpl<TerminalServer, PinValidator> implements Terminal {

    private final TerminalServer server;
    private final PinValidator pinValidator;

    public TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }


    @Override
    public void checkAccountStatus() {

    }

    @Override
    public void withDrawMoney() {

    }

    @Override
    public void withPutMoney() {

    }
}
