class Second  implements Runnable{
    private String name;
    Second(String threadname){
        name = threadname;
        Thread t = new Thread(this,"Demonstration one");
        System.out.println("First thread created: " + t);
        t.start();
    }
    public void run(){
        try{
            for(int i = 5;i > 0; i--){
                System.out.println(name +": " + i);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println(name + " thread interrupted");
        }
        System.out.println(name + " thread off");
    }
}

public class One {
    public static void main(String...args){
        new Second("one");
        new Second("two");
        new Second("three");

        try{
            Thread.sleep(10000);

        }catch(InterruptedException e){
            System.out.println("Main thread interrapted");
        }

        System.out.println("Main thread off");
    }
}
