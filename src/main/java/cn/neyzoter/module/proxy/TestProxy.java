package cn.neyzoter.module.proxy;


import net.sf.cglib.proxy.Enhancer;
import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Modifier;
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
         * cglib testnewProxyInstance
         */
        FruitMethodInterceptor interceptor = new FruitMethodInterceptor();
        // 增强类
        Enhancer enhancer = new Enhancer();
        // 设置父类（委托类），生成子类
        enhancer.setSuperclass(Apple.class);
        // 设置回调对象
        enhancer.setCallback(interceptor);
        // 设置代理对象
        Fruit fruitInstance2 = (Fruit) enhancer.create();
        // 通过代理对象调用目标方法
        fruitInstance2.getName();


        /**
         * 生成代理类到文件
         */
        String packAge = "cn.neyzoter.module.proxy";
        String className = "ProxyClass";
        String fileName = className + ".class";

        byte[] proxyClassFile = ProxyGenerator.generateProxyClass(
                packAge + "." + className, new Class[]{Fruit.class}, Modifier.PUBLIC);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("/home/scc/code/java/oj/src/main/java/cn/neyzoter/module/proxy", fileName));
            fos.write(proxyClassFile);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
