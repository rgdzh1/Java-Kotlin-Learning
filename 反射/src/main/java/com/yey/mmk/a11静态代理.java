package com.yey.mmk;

interface ClothFactory {
    void produceCloth();
}

class ProxyClothFactory implements ClothFactory {

    ClothFactory clothFactory;

    public ProxyClothFactory(ClothFactory clothFactory) {
        this.clothFactory = clothFactory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理之前做一些事情");
        clothFactory.produceCloth();
        System.out.println("代理之后做一些事情");
    }
}

class NikeClothFatory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产衣服");
    }
}


public class a11静态代理 {
    public static void main(String[] args) {
        NikeClothFatory nikeClothFatory = new NikeClothFatory();
        ProxyClothFactory proxyClothFactory = new ProxyClothFactory(nikeClothFatory);
        proxyClothFactory.produceCloth();
    }
}
