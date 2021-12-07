package com.example.demo.endpoint;

import com.example.demo.service.ProductService;
import com.example.demo.soap.product.GetProductRequest;
import com.example.demo.soap.product.GetProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ProductEndpoint {

    @Autowired
    private ProductService productService;

    @PayloadRoot(namespace = "http://example.com/demo/soap/product/",
            localPart = "getProductRequest")
    @ResponsePayload
    public GetProductResponse getProductRequest(@RequestPayload GetProductRequest request) {
        GetProductResponse response = new GetProductResponse();
        response.setProduct(productService.getProduct(request.getOrderId()));
        return response;
    }
}
