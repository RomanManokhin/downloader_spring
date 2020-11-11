package MultiTreading.BaseGenerateThreads.ExtendsThread;

public class MainExtends {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyFirstThreadExtends());
            t.start();
        }
    }
}
