package com.payment.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.payment.exception.BillNotFoundException;
import com.payment.model.Invoice;

@FeignClient(name="bill-service",url="http://localhost:2006/bill")
public interface InvoiceClient
{
    @PostMapping("/addbill")
    public ResponseEntity<Invoice> addBill(@RequestBody Invoice invoice) throws BillNotFoundException;

}
