package com.basic.network.tcp.autoclosable;

public class ResourceCloseMainV4 {
    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");

            Throwable[] suppressed = e.getSuppressed();
            for (Throwable s : suppressed) {
                System.out.println("suppressed: " + s);
            }
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException  예외 처리");
            throw new RuntimeException(e);
        }
    }

    private static void logic() throws CallException, CloseException {
        try(ResourceV2 resource1 = new ResourceV2("resourceV1");
            ResourceV2 resource2 = new ResourceV2("resourceV2")) {
            resource1.call();
            resource2.callEx(); // CallException

            // 자원 정리가 저절로
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }
    }
}
