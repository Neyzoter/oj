package cn.neyzoter.module.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * fruit invocation handler<br/>
 * CGLIB
 * @author Charles Song
 * @date 2020-5-9
 */
public class FruitMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept (Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("PRE");
        Object result = methodProxy.invokeSuper(o, args);
        System.out.println("POST");
        return result;
    }
}
