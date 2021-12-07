package com.example.demo.endpoint;

import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import com.example.demo.soap.order.GetOrderRequest;
import com.example.demo.soap.order.GetOrderResponse;
import com.example.demo.soap.product.GetProductRequest;
import com.example.demo.soap.product.GetProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class OrderEndpoint {

    @Autowired
    private OrderService orderService;

    @PayloadRoot(namespace = "http://example.com/demo/soap/order/",
            localPart = "getOrderRequest")
    @ResponsePayload
    public GetOrderResponse getOrderRequest(@RequestPayload GetOrderRequest request) {
        GetOrderResponse response = new GetOrderResponse();
        response.setBooking(orderService.getOrder(request.getId()));
        return response;
    }
}
