# Java多线程

## 进程

程序(任务)的执行过程

持有资源(共享内存,共享文件)和线程

## 线程

源代码文本编辑

源代码编译

语法校验

线程是系统中最小的执行单元

同一进程中有多个线程

线程共享进程的资源

## Java 线程初体验

### Java 中线程的常用方法介绍

Java对线程的支持

线程的创建和启动

线程常用方法

如何停止线程

![未命名文件.png](https://flowus.cn/preview/4c1b5302-ba12-4ec7-a1d7-df166a2a4491)

### Java线程-隋唐演义框架说明

```txt
军队 ArmyRunnable
英雄 KeyPersonThread
舞台 Stage
```

### Java线程-隋唐演义实战开发

```java
public class Actor extends Thread {
    public void run() {
        System.out.println(getName() + "是一个演员！");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(getName() + "登台演出:" + (++count));
            if (count == 100) {
                keepRunning = false;
            }
            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(getName() + "的演出结束了！");
    }
    public static void main(String[] args) {
        Thread actor = new Actor();
        actor.setName("Mr. Thread");
        actor.start();
        Thread actressThread = new Thread(new Actress(), "Ms. Runnable");
        actressThread.start();
    }
}
class Actress implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "是一个演员！");
        int count = 0;
        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println(Thread.currentThread().getName() + "登台演出:" + (++count));
            if (count == 100) {
                keepRunning = false;
            }
            if (count % 10 == 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + "的演出结束了！");
    }
}
```

军队

```java
/**
* 隋唐演义大戏舞台
*/
public class Stage extends Thread {
    public void run() {
        System.out.println("欢迎观看隋唐演义");
        //让观众们安静片刻,等待大戏上演
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        System.out.println("话说隋朝末年,隋军与农民起义军杀得昏天黑地...");
        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();
        //使用Runnable接口创建线程
        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");
        //启动线程,让军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();
        //舞台线程休眠,大家专心观看军队厮杀
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("正当双方激战正酣,半路杀出了个程咬金");
        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");
        System.out.println("程咬金的理想就是结束战争,使百姓安居乐业！");
        //停止军队作战
        //停止线程的方法
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
         * 历史大戏留给关键人物
         */
        mrCheng.start();
        //万众瞩目,所有线程等待程先生完成历史使命
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("战争结束,人民安居乐业,程先生实现了积极的人生梦想,为人民作出了贡献！");
        System.out.println("谢谢观看隋唐演义,再见！");
    }
    public static void main(String[] args) {
        new Stage().start();
    }
}
```

关键先生

```java
public class KeyPersonThread extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName()+"开始了战斗！");
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"左突右杀,攻击隋军...");
        }
        System.out.println(Thread.currentThread().getName()+"结束了战斗！");
    }
}
```

## Java 线程的正确停止

### Java线程停止错误的方法

stop()方法是错误的退出方法

stop退出会导致程序突然中断

### Java线程停止正确的方法

使用退出旗标,而不是stop()方法

即退出使用标志

```txt
//停止军队作战
//停止线程的方法
armyTaskOfSuiDynasty.keepRunning = false;
armyTaskOfRevolt.keepRunning = false;
```

### Java线程停止广为流传的错误方法

interrupt方法

此方法并不是用于停止线程的方法

```txt
interrupt
public void interrupt()中断这个线程。
除非当前线程中断自身,这是始终允许的,所以调用此线程的checkAccess方法,这可能会导致抛出SecurityException 。
如果该线程阻塞的调用wait() , wait(long) ,或wait(long, int)的方法Object类,或者在join() , join(long) , join(long, int) , sleep(long) ,或sleep(long, int) ,这个类的方法,那么它的中断状态将被清除,并且将收到一个InterruptedException 。
如果该线程在可阻止在I / O操作InterruptibleChannel则信道将被关闭,该线程的中断状态将被设置,并且螺纹将收到一个ClosedByInterruptException 。
如果该线程在Selector中被阻塞,则线程的中断状态将被设置,并且它将从选择操作立即返回,可能具有非零值,就像调用了选择器的wakeup方法一样。
如果以前的条件都不成立,则该线程的中断状态将被设置。
中断不存在的线程不需要任何效果。
异常
SecurityException - 如果当前线程不能修改此线程
interrupted
public static boolean interrupted()测试当前线程是否中断。 该方法可以清除线程的中断状态 。 换句话说,如果这个方法被连续调用两次,那么第二个调用将返回false（除非当前线程再次中断,在第一个调用已经清除其中断状态之后,在第二个调用之前已经检查过）。
忽略线程中断,因为线程在中断时不存在将被该方法返回false所反映。
结果
true如果当前线程已被中断; false否则。
另请参见:
isInterrupted()
isInterrupted
public boolean isInterrupted()测试这个线程是否被中断。 线程的中断状态不受此方法的影响。
忽略线程中断,因为线程在中断时不存在将被该方法返回false所反映。
结果
true如果这个线程已被中断; false否则。
另请参见:
interrupted()
```

## 线程交互

```java
public class WrongWayStopThread extends Thread {
    public static void main(String[] args) {
        WrongWayStopThread thread = new WrongWayStopThread();
        System.out.println("Starting thread...");
        thread.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Interrupting thread");
        thread.interrupt();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping application");
    }
    public void run() {
//        while (true) { //使用错误的停止方法,interrupt()并没有终止线程
        while (!this.isInterrupted()) {//同样是标志的方法正确的终止了线程
            System.out.println("Thread is running");
//            long time = System.currentTimeMillis();
//            while (System.currentTimeMillis() - time < 1000) {
//                //减少屏幕输出的空循环
//            }
            try {
                //如果该线程阻塞的调用wait() , wait(long) ,或wait(long, int)的方法Object类,
                // 或者在join() , join(long) , join(long, int) , sleep(long) ,
                // 或sleep(long, int) ,这个类的方法,
                // 那么它的中断状态将被清除,并且将收到一个InterruptedException 。
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```

```java


/**
* 宇宙的能量系统
* 遵循能量守恒定律:
* 能量不会凭空创生或消失,只会从一处转移到另一处
*/
public class EnergySystem {
    //能量盒子,能量存贮的地方
    private final double[] energyBoxes;
    private final Object lockObj = new Object();
    /**
     *
     * @param n    能量盒子的数量
     * @param initialEnergy 每个能量盒子初始含有的能量值
     */
    public EnergySystem(int n, double initialEnergy){
        energyBoxes = new double[n];
        for (int i = 0; i < energyBoxes.length; i++)
            energyBoxes[i] = initialEnergy;
    }
    /**
     * 能量的转移,从一个盒子到另一个盒子
     * @param from 能量源
     * @param to     能量终点
     * @param amount 能量值
     */
    public void transfer(int from, int to, double amount){
        synchronized(lockObj){
//       if (energyBoxes[from] < amount)
//         return;
            //while循环,保证条件不满足时任务都会被条件阻挡
            //而不是继续竞争CPU资源
            while (energyBoxes[from] < amount){
                try {
                    //条件不满足, 将当前线程放入Wait Set
                    lockObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(Thread.currentThread().getName());
            energyBoxes[from] -= amount;
            System.out.printf("从%d转移%10.2f单位能量到%d", from, amount, to);
            energyBoxes[to] += amount;
            System.out.printf(" 能量总和:%10.2f%n", getTotalEnergies());
            //唤醒所有在lockObj对象上等待的线程
            lockObj.notifyAll();
        }
    }
    /**
     * 获取能量世界的能量总和
     */
    public double getTotalEnergies(){
        double sum = 0;
        for (double amount : energyBoxes)
            sum += amount;
        return sum;
    }
    /**
     * 返回能量盒子的长度
     */
    public  int getBoxAmount(){
        return energyBoxes.length;
    }
}
```

```java
public class EnergyTransferTask implements Runnable{
  //共享的能量世界
  private EnergySystem energySystem;
  //能量转移的源能量盒子下标
  private int fromBox;
  //单次能量转移最大单元
  private double maxAmount;
  //最大休眠时间（毫秒）
  private int DELAY = 10;
  public EnergyTransferTask(EnergySystem energySystem, int from, double max){
    this.energySystem = energySystem;
    this.fromBox = from;
    this.maxAmount = max;
  }
  public void run() {
    try{
      while (true){
        int toBox = (int) (energySystem.getBoxAmount()* Math.random());
        double amount = maxAmount * Math.random();
        energySystem.transfer(fromBox, toBox, amount);
        Thread.sleep((int) (DELAY * Math.random()));
      }
    }catch (InterruptedException e){
      e.printStackTrace();
    }
  }
}
```

```java


public class EnergySystemTest {
  //将要构建的能量世界中能量盒子数量
  public static final int BOX_AMOUNT = 100;
  //每个盒子初始能量
  public static final double INITIAL_ENERGY = 1000;
  public static void main(String[] args){
    EnergySystem eng = new EnergySystem(BOX_AMOUNT, INITIAL_ENERGY);
    for (int i = 0; i < BOX_AMOUNT; i++){
      EnergyTransferTask task = new EnergyTransferTask(eng, i, INITIAL_ENERGY);
      Thread t = new Thread(task,"TransferThread_"+i);
      t.start();
    }
  }
}
```

当多个线程同时共享访问同一数据(内存区域)时,每个线程都尝试操作该数据,从而导致数据被破坏( corrupted ),这种现象称为争用条件(Race Condition)。

线程的交互:互斥和同步

![未命名文件.png](https://flowus.cn/preview/355fe79a-5b0a-4193-9dfe-40e68f026867)

互斥的实现: synchronized(intrinsic lock)

当多个线程访问共享资源时,为了保证数据的一致性和线程安全,可以使用互斥机制。在Java中,可以使用`synchronized`关键字实现互斥。

以下是一个简单的Java代码示例,演示了如何使用`synchronized`实现互斥:

```java
public class MutexDemo {
    private int counter = 0;

    public synchronized void increment() {
        counter++;
    }

    public synchronized void decrement() {
        counter--;
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        MutexDemo demo = new MutexDemo();

        // 创建多个线程来增加和减少计数器的值
        Thread incrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.increment();
            }
        });

        Thread decrementThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                demo.decrement();
            }
        });

        // 启动线程
        incrementThread.start();
        decrementThread.start();

        // 等待线程执行完毕
        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 打印计数器的值
        System.out.println("Counter: " + demo.getCounter());
    }
}
```

在这个示例中,`MutexDemo`类具有一个`counter`变量,可以通过`increment()`和`decrement()`方法增加和减少其值。这两个方法都使用`synchronized`关键字修饰,确保在同一时间只有一个线程可以访问它们。这样就实现了互斥,避免了多个线程同时修改`counter`变量导致的数据不一致性。

在`main()`方法中,创建了两个线程`incrementThread`和`decrementThread`,分别用于增加和减少计数器的值。然后通过调用`start()`方法启动这两个线程,并使用`join()`方法等待它们执行完毕。最后打印计数器的值。

请注意,`synchronized`关键字还可以用于修饰方法块,而不仅仅是整个方法。使用`synchronized`关键字可以确保在同一时间只有一个线程执行被修饰的代码块或方法,从而实现互斥。

同步的实现: wait()/notify()/notifyAll()

`wait()`, `notify()`, 和 `notifyAll()` 是用于线程间的协作和同步的方法。它们通常与`synchronized`关键字一起使用。下面是一个示例代码演示了如何使用这些方法实现线程的同步和协作:

```java
public class SynchronizationDemo {
    private boolean isDataReady = false;

    public synchronized void processData() {
        // 检查数据是否准备好
        while (!isDataReady) {
            try {
                // 数据未准备好,等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 处理数据
        System.out.println("Processing data...");
        // 数据处理完成后重置标志位
        isDataReady = false;

        // 通知等待的线程数据已经处理完成
        notifyAll();
    }

    public synchronized void prepareData() {
        // 检查数据是否已经准备好
        while (isDataReady) {
            try {
                // 数据已准备好,等待
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 准备数据
        System.out.println("Preparing data...");
        // 数据准备完成后设置标志位
        isDataReady = true;

        // 通知等待的线程数据已经准备好
        notifyAll();
    }

    public static void main(String[] args) {
        SynchronizationDemo demo = new SynchronizationDemo();

        // 创建数据处理线程
        Thread processDataThread = new Thread(() -> {
            demo.processData();
        });

        // 创建数据准备线程
        Thread prepareDataThread = new Thread(() -> {
            demo.prepareData();
        });

        // 启动线程
        processDataThread.start();
        prepareDataThread.start();

        // 等待线程执行完毕
        try {
            processDataThread.join();
            prepareDataThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

在这个示例中,`SynchronizationDemo`类有一个`isDataReady`变量,表示数据是否准备好的标志位。`processData()`方法用于处理数据,而`prepareData()`方法用于准备数据。

这两个方法都使用`synchronized`关键字修饰,确保在同一时间只有一个线程可以执行它们。在方法中,使用了`wait()`方法来暂停当前线程的执行,并释放对象的锁。`wait()`方法会导致线程进入等待状态,直到被`notify()`或`notifyAll()`方法唤醒。

在`processData()`方法中,通过一个`while`循环来检查数据是否准备好。如果数据未准备好,则线程调用`wait()`方法进行等待。一旦数据准备好,线程继续执行数据处理逻辑,并在处理完成后重置`isDataReady`标志位。最后,调用`notifyAll()`方法通知等待的线程数据已经处理完成。

在`prepareData()`方法中,同样使用一个`while`循环来检查数据是否已经准备好。如果数据已经

准备好,则线程调用`wait()`方法进行等待。一旦数据未准备好,线程继续执行数据准备逻辑,并在准备完成后设置`isDataReady`标志位。最后,调用`notifyAll()`方法通知等待的线程数据已经准备好。

在`main()`方法中,创建了两个线程`processDataThread`和`prepareDataThread`,分别用于处理数据和准备数据。然后通过调用`start()`方法启动这两个线程,并使用`join()`方法等待它们执行完毕。

这样,通过使用`wait()`、`notify()`和`synchronized`,线程之间实现了同步和协作。`processData()`方法等待数据准备完毕,`prepareData()`方法等待数据处理完成,从而保证数据的正确处理顺序。

## 总结及展望

```txt
1.如何创建线程及线程的基本操作
2.可见性及volatile关键字
3.争用条件
4.线程的互斥synchronized
5.线程的同步wait/notifyAll
```
