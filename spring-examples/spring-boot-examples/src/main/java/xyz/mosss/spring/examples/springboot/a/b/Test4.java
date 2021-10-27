package xyz.mosss.spring.examples.springboot.a.b;

public class Test4 {
    static int count = 0;
    static Object object = new Object();


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {


                    while (count < 10) {
                        synchronized (object) {
                        if (count % 2 == 0) {
                            System.out.println("线程A" + count);
                            count++;
                        }
                    }
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {


                while (count < 10) {
                    synchronized (object) {
                        if (count % 2 != 0) {
                            System.out.println("线程B" + count);
                            count++;
                        }

                    }
                }
            }
        }).start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}