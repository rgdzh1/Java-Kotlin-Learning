package com.yey.thread;

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("子线程");
    }
}

public class a01run与start方法开启线程 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        // start() 1. 启动MyThread线程. 2. 调用当前run()方法.
        myThread.start();
        // 如果myThread已经start()过了,还要再去start()它一遍的话就会报错IllegalThreadStateException,
        // myThread如果start()过一次之后this.threadStatus将不会再等于0,
        // 当再次myThread.start()后,就会触发if (this.threadStatus != 0)条件报异常.
        myThread.start();
        // run(): 直接使用对象调用它的run()方法,并没有开启线程.
        // myThread.run();

        // 这样也可以开启子线程
        new Thread() {
            @Override
            public void run() {
                System.out.println("子线程");
            }
        }.start();
    }
}