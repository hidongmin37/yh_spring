package com.basic.network.tcp.autoclosable;

public class ResourceCloseMainV1 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException  예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = new ResourceV1("resourceV1");
        ResourceV1 resource2 = new ResourceV1("resourceV2");

        resource1.call();
        resource2.callEx(); // CallException

        System.out.println("자원 정리"); // 호출 안됨.

        resource2.closeEx();
        resource1.closeEx();// 서로 관련된 자원은  나중에 생성한 자원을 먼저 정리해야한다.
        

    }
}
