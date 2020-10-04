package cn.neyzoter.test;

import lombok.Builder;

/**
 * 测试Lombok
 * @author neyzoter
 */
public class TestLombok {
    public static void main(String[] args) {
        Staff staff = Staff.builder().name("SongChaochao").psw("123").build();
    }
}

@Builder
class Staff {
    private String name;
    private String psw;
}
