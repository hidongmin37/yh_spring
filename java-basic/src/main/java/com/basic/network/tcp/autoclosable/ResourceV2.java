package com.basic.network.tcp.autoclosable;

public class ResourceV2 implements AutoCloseable {
    private String name;

    public ResourceV2(String name) {
        this.name = name;
    }

    // call은 정상적인 비즈니스 로직을 수행하는 것이라고 가정하면 되고,
    public void call(){
        System.out.println(name + " call");
    }

    // 비정상 로직 호출 callException
    public void callEx() throws CallException {
        System.out.println(name + " call ex");
        throw new CallException(name + " ex");
    }



    // close는 사용한 자원을 정리하는 것이다.
    @Override
    public void close() throws CloseException {
        System.out.println(name + " close");
        throw new CloseException(name + " ex");

    }
}
