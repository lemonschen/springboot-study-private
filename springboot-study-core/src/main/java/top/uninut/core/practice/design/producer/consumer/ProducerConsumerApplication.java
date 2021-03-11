package top.uninut.core.practice.design.producer.consumer;

public class ProducerConsumerApplication {
    public static void main(String[] args) {
        Thread p1 = new Thread(new Producer());
        Thread p2 = new Thread(new Producer());
        Thread c1 = new Thread(new Consumer());
        Thread c2 = new Thread(new Consumer());
        p1.start();
        p2.start();
        c1.start();
        c2.start();
    }
}
