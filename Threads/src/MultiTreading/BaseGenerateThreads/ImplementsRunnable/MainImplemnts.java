package MultiTreading.BaseGenerateThreads.ImplementsRunnable;

public class MainImplemnts {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new MyFirstThreadImplements());

            thread.start();
        }

    }
}
