package cn.neyzoter.exam.vip;

import java.util.Scanner;

/**
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /**
         * SELECT s.province 省份, s.sum 有效订单总数, g.un_shipped_sum 未发货数量, (g.unshipped_sum / s.sum) 未发货率 FROM ((SELECT province, COUNT(*) sum  FROM order WHERE is_deleted=0 AND DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= add_time GROUP BY province) s LEFT JOIN (SELECT province, COUNT(*) un_shipped_sum FROM order WHERE is_deleted=0 AND is_shipped=FALSE AND DATE_SUB(CURDATE(), INTERVAL 30 DAY) <= add_time GROUP BY province) g ON s.province=g.province) ORDER BY 省份
         */
    }
}
