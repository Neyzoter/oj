package cn.neyzoter.test;

import lombok.ToString;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * 测试clone函数
 * @author Charles Song
 * @date 2020-6-29
 */
public class TestClone {
    public static void main (String[] args) {
        testArrayClone();
    }
    public static void testArrayClone () {
        System.out.println(" ===== 测试基础数据类型数组 =====");
        Integer[] nums = {1,2,3,4,5};
        Integer[] copy = nums.clone();
        // 结果同上
//        System.arraycopy(copy, 0, nums, 0, nums.length);
//        copy = Arrays.copyOf(nums, nums.length);
        nums[1] = 10;
        System.out.println(Arrays.toString(copy));

        System.out.println(" ===== 测试自定义类型数组 =====");
        User2TestClone[] users = new User2TestClone[2];
        users[0] = new User2TestClone(10,80);
        users[1] = new User2TestClone(9,70);
        User2TestClone[] usersClone = users.clone();
        // 结果同上
//        System.arraycopy(usersClone, 0, users, 0, users.length);
        users[0].weight = 200;
        users[0].age = 30;
        System.out.println(Arrays.toString(usersClone));

        System.out.println(" ===== 测试自定义类型 =====");
        User2TestClone user = new User2TestClone(2, 20);
        try {
            User2TestClone userClone = (User2TestClone) user.clone();

            user.age = 100;
            user.weight = 90;
            System.out.println(userClone.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }
}

@ToString
class User2TestClone implements Cloneable {
    int age;
    int weight;
    User2TestClone (int a, int w) {
        age = a;
        weight = w;
    }

    @Override
    protected Object clone () throws CloneNotSupportedException {
        return new User2TestClone(this.age, this.weight);
    }
}
