package xyz.mosss.spring.examples.springboot.a.b;

public class Test2 {
    static int count = 0;
    static Object object=new Object();


    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {

                    synchronized (object){
                        while (count<10){
                            if(count%2!=0){
                                try {
                                    object.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("线程A"+count);
                            count++;
                            object.notify();;
                        }
                    }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (object){
                    while (count<10){
                        if(count%2==0){
                            try {
                                object.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("线程B"+count);
                        count++;
                        object.notify();;
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