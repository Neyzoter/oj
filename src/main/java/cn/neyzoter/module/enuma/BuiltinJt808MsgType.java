package cn.neyzoter.module.enuma;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author hylexus
 * createdAt 2019/1/24
 **/
public enum BuiltinJt808MsgType implements MsgType {

    CLIENT_LOG_OUT(0x0003, "终端注销"),
    CLIENT_HEART_BEAT(0x0002, "终端心跳"),

    CLIENT_COMMON_REPLY(0x0001, "终端通用应答"),
    SERVER_COMMON_REPLY(0x8001, "平台通用应答"),

    CLIENT_REGISTER(0x0100, "终端注册"),
    CLIENT_REGISTER_REPLY(0x8100, "平台注册应答"),
    CLIENT_AUTH(0x0102, "终端鉴权"),
    CLIENT_LOCATION_INFO_UPLOAD(0x0200, "位置上报"),
    ;

    BuiltinJt808MsgType(int msgId, String desc) {
        this.msgId = msgId;
        this.desc = desc;
    }
    @Getter
    private final int msgId;
    @Getter
    private final String desc;

    private static final Map<Integer, BuiltinJt808MsgType> mapping = new HashMap<>(BuiltinJt808MsgType.values().length);

    static {
        for (BuiltinJt808MsgType builtinMsgType : values()) {
            mapping.put(builtinMsgType.msgId, builtinMsgType);
        }
    }

    @Override
    public Optional<MsgType> parseFromInt(int msgId) {
        return Optional.ofNullable(mapping.get(msgId));
    }

    @Override
    public String toString() {
        return "BuiltInMsgType{"
                + "msgId=" + msgId
                + "("  + "), desc='" + desc + '\''
                + '}';
    }
}