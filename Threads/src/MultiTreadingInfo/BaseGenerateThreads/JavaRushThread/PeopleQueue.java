package MultiTreadingInfo.BaseGenerateThreads.JavaRushThread;

public class PeopleQueue extends Thread{

    private final String[] names;


    public PeopleQueue(String ... names) {
        this.names = names;
    }

    @Override
    public void run(){

        for (String name : names) {
            System.out.println("Обработаны документы: " + name);

            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
