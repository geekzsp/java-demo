package xyz.mosss.spring.examples.springboot.a.b;

public class Test5 {
    static class SoulutionTask implements Runnable{
        static int value = 0;
        @Override
        public void run() {
            while (value <= 100){
                synchronized (SoulutionTask.class){
                    System.out.println(Thread.currentThread().getName() + ":" + value++);
                    SoulutionTask.class.notify();
                    try {
                        SoulutionTask.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new SoulutionTask(), "偶数").start();
        new Thread(new SoulutionTask(), "奇数").start();
    }
}