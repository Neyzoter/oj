package cn.neyzoter.module.tf.serving;

/**
 * Rpc调用Tensorflow Serving的服务
 * @author Charles Song
 * @date 2020-5-17
 */
public class Rpc {
    public static void main (String[] args) {
        Tfserving.Instance tfserving = Tfserving.Instance.newBuilder().addInstance(1).addInstance(2).addInstance(5).build();
        String params = tfserving.toString();
        System.out.println(params);
    }
}
