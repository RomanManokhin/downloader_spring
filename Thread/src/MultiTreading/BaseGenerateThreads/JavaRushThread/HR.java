package MultiTreading.BaseGenerateThreads.JavaRushThread;

public class HR {

    public static void main(String[] args) {

        PeopleQueue queue1 = new PeopleQueue("Иван","Сергей","Николай","Фердинанд","Василий");
        PeopleQueue queue2 = new PeopleQueue("Мария","Людмила","Алиса","Карина","Ольга");

        System.out.println("Start");

        queue1.start();
        queue2.start();

    }
}
