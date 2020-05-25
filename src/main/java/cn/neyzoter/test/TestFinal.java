package cn.neyzoter.test;

/**
 * 测试final
 * @author Charles Song
 * @date 2020-5-25
 */
public class TestFinal {
    public static void main (String[] args) {
        final int id = 10;
        /**
         * final基础数据类型无法被重新赋值
         */
//        id = 11;
        /**
         * 引用不可更改，但是对象内的内容可以更改
         */
        final Apple apple = new Apple();
        apple.setWeight(1);
    }
}

/**
 * final类无法被继承
 */
final class Fruit {

}

class Apple { //extends Fruit {  // 无法继承
    int weight = 10;
    public final int getWeight() {
        return this.weight;
    }

    public void setWeight(int n) {
        this.weight = n;
    }
}

class AppleChild extends Apple {
    /**
     * final方法无法被重写
     */
//    @Override
//    public final int getWeight() {
//
//    }
}
