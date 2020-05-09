package cn.neyzoter.module.proxy;


import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * 测试代理
 * @author Charles Song
 * @date 2020-5-9
 */
public class TestProxy {
    public static void main (String[] args) {
        /**
         * JDK proxy test
         */
        Apple apple = new Apple();
        FruitInvocationHandler handler = new FruitInvocationHandler(apple);
        Fruit fruitInstance1 = (Fruit) Proxy.newProxyInstance(apple.getClass().getClassLoader(), apple.getClass().getInterfaces(), handler);
        fruitInstance1.getName();

        /**
         * cglib test
         */
        FruitMethodInterceptor interceptor = new FruitMethodInterceptor();
        // 增强类
        Enhancer enhancer = new Enhancer();
        // 设置父类（委托类），生成子类
        enhancer.setSuperclass(Apple.class);
        enhancer.setCallback(interceptor);
        Fruit fruitInstance2 = (Fruit) enhancer.create();
        fruitInstance2.getName();
    }
}
