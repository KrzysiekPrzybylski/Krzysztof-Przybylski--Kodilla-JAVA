package com.kodilla.good.patterns.challenges.allegro;

public class Application {
    public static void main(String[] args) {
        ProductOrderRequestRetriever productOrderRequestRetriever = new ProductOrderRequestRetriever();
        ProductOrderRequest productOrderRequest = productOrderRequestRetriever.retrieve();

        ProductOrderProcessor productOrderProcessor = new ProductOrderProcessor(new MailService(),
                new ScooterOrderService(), new ScooterOrderRepository());
        productOrderProcessor.process(productOrderRequest);



    }
}
