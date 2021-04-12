package array;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: fengsihan
 * @time: 2021-01-19 01:34
 */
public class PrintABC {

  //状态变量
  private  static volatile int state=0;

  private static final Lock reentrantLock = new ReentrantLock();
  private static final Condition condition = reentrantLock.newCondition();


  public static void main(String[] args) throws InterruptedException {
    Object lock=new Object();
    //打印A的线程
    Thread threadA=new Thread(new Print(lock, 0,1, 'A'));
    //打印B的线程
    Thread threadB=new Thread(new Print(lock, 1,2, 'B'));
    //打印C的线程
    Thread threadC=new Thread(new Print(lock, 2,0, 'C'));
    //一次启动A B C线程
    threadA.start();
    Thread.sleep(1000);
    threadB.start();
    Thread.sleep(1000);
    threadC.start();

  }


  static class Print implements Runnable{

    Object lock;
    char str;
    int printFlag;
    int nexPrintFlag;



    public Print( Object lock,int printFlag,int nexPrintFlag, char str){
      this.lock = lock;
      this.str = str;
      this.printFlag = printFlag;
      this.nexPrintFlag = nexPrintFlag;
    }

    @Override
    public void run() {
      while (true){

        reentrantLock.lock();
          while (state != printFlag){
            try {
              condition.await();
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }

          System.out.println(str);
          state = nexPrintFlag;
        condition.signalAll();

        reentrantLock.unlock();
      }

    }
  }
}

