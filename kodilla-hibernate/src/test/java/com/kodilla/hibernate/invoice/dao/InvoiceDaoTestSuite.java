package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;
    @Autowired
    private ProductDao productDao;
    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product = new Product("Rower");
        Product product1 = new Product("Deskorolka");
        Product product2 = new Product("Skuter");
        productDao.save(product);
        productDao.save(product1);
        productDao.save(product2);

        Item item = new Item(product, new BigDecimal(1400), 4);
        Item item1 = new Item(product1,new BigDecimal(700), 6);
        Item item2 = new Item(product2, new BigDecimal(5200), 2);

        Invoice invoice = new Invoice("145/16");

        item.setInvoice(invoice);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);

        invoice.getItems().add(item);
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();
        //Then
        assertNotEquals(0, id);
        assertNotEquals(0,product.getId());
        //CleanUp
        invoiceDao.deleteById(id);

    }
}
