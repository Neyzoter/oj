package cn.neyzoter.oj.test.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * RPC 服务提供者
 * @author Charles Song
 * @date 2020-4-19
 */
public class RpcProvider {
    public static final int PORT = 5000;
    public static void main (String[] args) {
        // 创建保存服务实现类的对象
        HashMap<String, Object> servicesImpl = new HashMap<>(10);
        // 加入RpcService接口实现RpcServiceImpl
        servicesImpl.put(RpcService.class.getName(), new RpcServiceImpl());

        try{
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Waiting for RPC...");
            while (true) {
                Socket socket = serverSocket.accept();

                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                // 获取接口名称
                String ifName = objectInputStream.readUTF();
                System.out.println("Interface Name : " + ifName);
                // 获取方法名称
                String methodName = objectInputStream.readUTF();
                System.out.println("Method Name : " + methodName);
                // 获取方法参数类型
                Class<?>[] methodArgClass = (Class<?>[]) objectInputStream.readObject();
                // 获取方法的参数
                Object[] arguments = (Object[]) objectInputStream.readObject();

                // 获取接口
                Class serviceIfClass = Class.forName(ifName);
                // 获取接口的实现
                Object serviceImpl = servicesImpl.get(ifName);
                // 获取方法
                Method method = serviceIfClass.getMethod(methodName, methodArgClass);
                // 调用函数methodArgClass
                Object result = method.invoke(serviceImpl, arguments);
                // 将结果发送给消费者
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(result);
            }
        } catch (Exception e) {
            System.err.println(e);
        }

    }
}
