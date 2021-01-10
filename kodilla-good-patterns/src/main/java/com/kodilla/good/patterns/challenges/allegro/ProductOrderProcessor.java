package com.kodilla.good.patterns.challenges.allegro;

public class ProductOrderProcessor {

    private InformationService informationService;
    private ProductOrderService productOrderService;
    private ProductOrderRepository productOrderRepository;

    public ProductOrderProcessor(final InformationService informationService, final ProductOrderService productOrderService,
                                 final ProductOrderRepository productOrderRepository) {
        this.informationService = informationService;
        this.productOrderService = productOrderService;
        this.productOrderRepository = productOrderRepository;
    }

    public ProductOrderDTO process(final ProductOrderRequest productOrderRequest) {
        boolean isSold = productOrderService.sold(productOrderRequest.getUser(), productOrderRequest.getOrderDate(),
                productOrderRequest.getProduct(), productOrderRequest.getQuantity());
        if (isSold) {
            informationService.inform(productOrderRequest.getUser());
            productOrderRepository.createProductOrder(productOrderRequest.getUser(), productOrderRequest.getOrderDate(),
                    productOrderRequest.getProduct(), productOrderRequest.getQuantity());
            return new ProductOrderDTO(productOrderRequest.getUser(),productOrderRequest.getProduct(),productOrderRequest.getOrderDate(),
                    productOrderRequest.getQuantity(), true);
        } else {
            System.out.println("This order is not exist");
            return new ProductOrderDTO(productOrderRequest.getUser(),productOrderRequest.getProduct(),productOrderRequest.getOrderDate(),
                    productOrderRequest.getQuantity(), false);
        }

    }
}
