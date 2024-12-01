package com.java_basic.designpatterns.creational_patterns.factory_method;

public class Client {

    public static void main(String[] args) {
        Client client = new Client();
        client.print(new WhiteShipFactory(),"whiteship","jangdm37@gmail.com");
        client.print(new BlackShipFactory(),"blackship","jangdm37@gmail.com");
    }

    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }

}
