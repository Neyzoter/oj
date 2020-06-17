package cn.neyzoter.module.enuma;

import java.util.Optional;

/**
 * 测试enum
 * @author Charles Song
 * @date 2020-6-17
 */
public class TestMsgType {
    public static void main (String[] args) {
        Optional<?> optional = BuiltinJt808MsgType.CLIENT_AUTH.parseFromInt(0x0102);
        System.out.println(optional);
        optional = BuiltinJt808MsgType.CLIENT_AUTH.parseFromInt(0x0100);
        System.out.println(optional);
        System.out.println(optional.get());
    }
}
