package cn.neyzoter.module.concurrent.queue;


public class TestQueue {
    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<>(5);
        try {
            q.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            q.push(1);
            q.push(2);
            q.push(3);
            q.push(4);
            q.push(5);
            q.push(6);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            q.pop();
            q.pop();
            q.pop();
            q.pop();
            q.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
