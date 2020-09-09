package cn.neyzoter.exam.glodan;

import java.util.*;

/**
 * 测试2
 * 你购买了一个机器人，它现在剩下C单位电量，你现在想让它做一些动作愉悦自己。它可以做n种动作，每种动作最多做一次，因为你觉得让机器人重复做一种动作是无聊的。每种动作都有一个固定电量花费ci单位电量，以及这个动作的愉悦度wi。请在你电量范围内让它做出让你最愉悦的动作。即做的动作的总电量消耗不能超过C，并使愉悦度之和最大。（我们将情景简化，电量在开始动作前就要扣除，若电量不足则无法开始作，不存在动作进行到一半的状态）
 *
 *
 *
 * 输入描述
 * 第一行两个以空格隔开的正整数n和C，表示动作数量和机器人剩余电量。
 *
 * 接下来n行，每行两个以空格隔开的浮点数ci和整数wi，代表第i种动作电量消耗以及愉悦度。
 *
 * 输出描述
 * 一个整数，表示愉悦度之和的最大值
 *
 *
 * 样例输入
 * 3 15
 * 5.00 16
 * 9.00 1
 * 8.00 15
 * 样例输出
 * 31
 *
 * 提示
 * 选择第一个和第三个动作，总电量消耗5.00+8.00=13.00<15，总愉悦度31，可以证明这是最优方案。
 * n≤300，C≤30000，0≤c_i≤900000.00，0<w_i≤250
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int C = sc.nextInt();
        double[] ci = new double[n];
        int[] wi = new int[n];
        for (int i = 0; i < n; i++) {
            ci[i] = sc.nextDouble();
            wi[i] = sc.nextInt();
        }
        int X = 250 * 300 + 1;
        double[] dp = new double[X + 1];
        for (int i = 0; i < X + 1; i++) {
            dp[i] = Double.MAX_VALUE - 900000.00;
        }
        dp[0] = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = X; j >= wi[i]; j--) {
                dp[j] = Math.min(dp[j - wi[i]] + ci[i], dp[j]);
                if (dp[j] <= C) {
                    res = Math.max(j, res);
                }
            }
        }
        System.out.print(res);
    }
}
