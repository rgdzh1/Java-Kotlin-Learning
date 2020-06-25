package com.yey.thread;

public class a09线程安全的懒汉式单例模式 {
    static class Bank {
        private static Bank bank = null;

        public static Bank getInstance() {
            // 外部加一个判断是提升效率,防止其他线程等待后进入到同步代码块中后发现bank已经存在了,在返回.
            // 所以提前对bank进行判断,防止其他线程白白等待浪费效率.
            if (bank == null) {
                synchronized (Bank.class) {
                    if (bank == null) {
                        bank = new Bank();
                    }
                }
            }
            return bank;
        }
    }
}
