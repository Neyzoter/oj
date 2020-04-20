package cn.neyzoter.test.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * RPC 服务使用者
 * @author Charles Song
 * @date 2020-4-19
 */
public class RpcConsumer {
    public static void main (String[] args) {
        try {
            String ifName = RpcService.class.getName();
            Method method = RpcService.class.getMethod("printString", String.class);
            String methodName = method.getName();
            Class[] methodArgClass = method.getParameterTypes();
            Object[] arguments = {"Msg Received..."};

            Socket socket = new Socket("127.0.0.1", RpcProvider.PORT);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            // 接口名称
            objectOutputStream.writeUTF(ifName);
            // 方法名称
            objectOutputStream.writeUTF(methodName);
            // 方法参数类型
            objectOutputStream.writeObject(methodArgClass);
            // 方法参数
            objectOutputStream.writeObject(arguments);

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object result = objectInputStream.readObject();
            System.out.println("result = " + (String)result);
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
