class Second implements Runnable{
    Second(){
        Thread t = new Thread(this, "Demonstration one");
        System.out.println("First thread created: "+ t);
        t.start();
    }
    public void run(){
        try{
            for(int i = 5;i > 0; i--){
                System.out.println("Demon thread: " + i);
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            System.out.println("First thread interrapted");
        }
        System.out.println("First thread off");
    }
}

public class One {
    public static void main(String...args){
        new Second();

        try{
            for(int i = 5 ; i > 0; i--){
                System.out.println("Main Thread: " + i);
                Thread.sleep(1000);
            }
        }catch(InterruptedException e){
            System.out.println("Main thread interrapted");
        }

        System.out.println("Main thread off");
    }
}
