package MultiTreading.CloseThread.InterruptWithTryCatch;

public class JThread extends Thread {

    public JThread(String name) {
        super(name);
    }

    public void run(){
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int counter=1; // счетчик циклов
        while (!isInterrupted()){
            System.out.println("Loop " + counter++);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " has been interrupted");
                System.out.println(isInterrupted());    // false
                interrupt();    // повторно сбрасываем состояние
//                break;  // или мы просто можем выйти из цикла через brake
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
    //альтернативный выход из безконечного цикла, просто поместить while в try
    /**
    try{
        while(!isInterrupted()){
            System.out.println("Loop " + counter++);
            Thread.sleep(100);
        }
    }
    catch(InterruptedException e){
        System.out.println(getName() + " has been interrupted");
    }
     */