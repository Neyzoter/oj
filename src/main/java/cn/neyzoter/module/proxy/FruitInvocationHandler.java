package cn.neyzoter.module.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * fruit invocation handler<br/>
 * Java JDK
 * @author Charles Song
 * @date 2020-5-9
 */
public class FruitInvocationHandler implements InvocationHandler {
    private Object target;

    public FruitInvocationHandler (Object target) {
        this.target = target;
    }

    /**
     * 针对不同的方法，是哟给你不同的增强方法
     * @param o 代理类对象
     * @param method 方法
     * @param args 参数
     * @return 调用结果
     * @throws Throwable
     */
    @Override
    public Object invoke (Object o, Method method, Object[] args) throws Throwable {
        Object result;
        if ("getName".equals(method.getName())) {
            System.out.println("PRE");
            result = method.invoke(target, args);
            System.out.println("POST");
        } else {
            result = method.invoke(target, args);
        }
        return result;
    }
}
