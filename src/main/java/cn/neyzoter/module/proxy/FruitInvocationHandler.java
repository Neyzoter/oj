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
