package com.yey.thread;

public class a10死锁 {
    /**
     * 不同得线程分别占用对方需要的同步资源不放弃,都在等待对方放弃自己需要的同步资源,就形成了线程的死锁.
     * 出现死锁后,不会出现异常,不会出现提示,只是左右的线程都处于阻塞状态无法继续运行.
     */
    public static void main(String[] args) {
       final StringBuffer s1 = new StringBuffer();
        final StringBuffer s2 = new StringBuffer();
        new Thread(){
            @Override
            public void run() {
                synchronized (s1){
                    s1.append(1);
                    s2.append("a");
                    // 让当前线程睡眠,使得另外一个线程持有锁s2,当前线程醒来继续向下执行发现s2已经被另外一个线程持有,所以当前线程会等待另外线程释放锁后才会拿到锁继续执行.
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s2){
                        s1.append(2);
                        s2.append("b");
                        System.out.println(s1.toString());
                        System.out.println(s2.toString());
                    }
                }
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append(3);
                    s2.append("d");
                    // 让该线程睡眠,使另外一个线程持有了锁s1,当前线程醒来后同样会等待锁s1拿到后才继续执行,但是上一线程正在被阻塞状态,这样相互僵持不下就造成了死锁.
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1){
                        s1.append(4);
                        s2.append("e");
                        System.out.println(s1.toString());
                        System.out.println(s2.toString());
                    }
                }
            }
        }).start();
    }
}
