package cn.neyzoter.exam.net.huyu;

import java.util.*;

/**
 * AC ?%
 * 问题考虑, 保存加入时，自己就是stack的top的任务的子任务
 * 1 1 0
 * 5 2 0
 * 10 3 0
 * 20 3 1
 * 25 4 0
 * 40 4 1
 * 1000 2 1
 * 2000 1 1
 *
 * task2 : 1000 - 5 - 10(20 - 10) - 15(40 - 25) = 970
 * @author neyzoter
 */
public class TestForZr2 {
    public static int START = 0;
    public static int STOP = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<int[]> stack = new Stack<>();
        Long deltaTime = null;
        // 线程id
        int id = 0;
        while (n-- > 0) {
            int[] input = new int[4];
            // 3 : 子任务的时间
            input[0] = sc.nextInt();input[1] = sc.nextInt();input[2] = sc.nextInt();input[3] = 0;
            if (input[2] == START) {
                stack.add(input);
            } else if (input[2] == STOP) {
                if (stack.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                int[] start = stack.pop();
                // 异常
                if (start[1] != input[1] || start[0] > input[0] || start[2] != START) {
                    System.out.println("error");
                    return;
                }
                // 时间差
                long dt = input[0] - start[0] - start[3];
                if (!stack.isEmpty()) {
                    int[] temp = stack.pop();
                    temp[3] += input[0] - start[0];
                    stack.add(temp);
                }
                // 如果第一次计算出结果，或者结果比以前的大
                if (deltaTime == null || dt > deltaTime) {
                    deltaTime = dt;
                    id = input[1];
                }
                System.out.println(String.format("Task : %d , time : %d", start[1], dt));
            }
        }
        // 数据正常用完
        if (stack.isEmpty()) {
            System.out.println(id);
        // 数据没有用完
        } else {
            System.out.println("error");
        }
    }
}

/*
4
1 1 0
2 2 0
6 2 1
7 1 1

2
 */

/*
8
1 1 0
5 2 0
10 3 0
20 3 1
25 4 0
40 4 1
1000 2 1
2000 1 1

1
 */

/*
3
1 1 0
2 2 0
7 1 1

error
 */

/*
2
1 1 0
1 2 0

error
 */

/*
8
1 1 0
5 2 0
10 3 0
20 3 1
25 4 0
40 4 1
1000 2 1
2000 1 1

1
 */