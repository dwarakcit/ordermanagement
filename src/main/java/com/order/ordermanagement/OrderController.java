package com.order.ordermanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody OrderRequest orderRequest) {
        if (orderRequest.getOrderId() != null && orderRequest.getOrderName() != null) {
            return new ResponseEntity<>("Order created successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Order creation failed", HttpStatus.BAD_REQUEST);
        }
    }

    public static class OrderRequest {
        private String orderId;
        private String orderName;

        // Getters and setters
        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public String getOrderName() {
            return orderName;
        }

        public void setOrderName(String orderName) {
            this.orderName = orderName;
        }
    }
}