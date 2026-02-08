package id.ac.ui.cs.advprog.eshop.model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;
    @BeforeEach
    void setUp(){
        this.product = new Product();
        this.product.setProductId("bab96a53-6f22-4a52-bb13-0b59890352c1");
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setProductQuantity(100);
    }

    @Test
    void testGetProductId(){
        assertEquals("bab96a53-6f22-4a52-bb13-0b59890352c1", this.product.getProductId());
    }

    @Test
    void testGetProductName(){
        assertEquals("Sampo Cap Bambang", this.product.getProductName());
    }

    @Test
    void testGetProductQuantity(){
        assertEquals(100, this.product.getProductQuantity());
    }


}
