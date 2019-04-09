package com.jyh.jiangboot.command;

public class TestThread {

    static class Task implements Runnable {

        private String stu; //定义需要传值进来的参数
        public Task(String stu){
            this.stu = stu;
        }


        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
                System.out.println(stu);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread thread = new Thread(new Task("asd"));

        thread.start();

    }






}
