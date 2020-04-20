package cn.neyzoter.test.rpc;

/**
 * RPC服务实现
 */
public class RpcServiceImpl implements RpcService{
    @Override
    public String printString (String str) {
        System.out.println(str);
        return str;
    }
}
