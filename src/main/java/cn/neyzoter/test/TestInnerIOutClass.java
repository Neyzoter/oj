package cn.neyzoter.test;

/**
 * 测试内部类和外部类
 */
public class TestInnerIOutClass {
    public static void main (String[] args) {
        OutClass1 out = new OutClass1();
        OutClass1.OutClass1Inner inner = out.new OutClass1Inner();
        System.out.println(inner.getOutAA());
    }
}

class OutClass1 {
    public int a;
    private int b;
    public static int aa;
    public OutClass1 () {
        a = 1;
        b = 2;
        aa = 0;
    }
    public void setA (int n) {
        a = n;
    }
    public static int getAA () {
        return aa;
    }
    public class OutClass1Inner {
        public int c;
        private int d;
        // 非静态内部类不能有静态变量
//        public static int e;
        public void setC (int n) {
            c = n;
        }

        // 非静态内部类调用外部的静态方法和对象
        public int getOutAA () {
            return getAA();
        }

        // 非静态类可以调用外部的非静态方法和对象
        public void setOutA () {
            setA(1);
        }
    }
}

class OutClass2 {
    public int a;
    private int b;
    public static int aa;
    public OutClass2 () {
        a = 1;
        b = 2;
        aa = 0;
    }
    public void setA (int n) {
        a = n;
    }
    public static int getAA () {
        return aa;
    }
    public static class OutClass2Inner {
        public int c;
        private int d;
        // 静态内部类可以有静态变量
        public static int e;
        public void setC (int n) {
            c = n;
        }

        // 静态内部类调用外部的静态方法和对象
        public int getOutAA () {
            return getAA();
        }

        // 静态类不可以调用外部的非静态方法和对象
//        public void setOutA () {
//            setA(1);
//        }
    }
}
