package cn.neyzoter.module.rpc;

/**
 * RPC服务实现
 * @author Charles Song
 * @date 2020-5-17
 */
public class RpcServiceImpl implements RpcService{
    @Override
    public String printString (String str) {
        System.out.println(str);
        return str;
    }
}
