package id.ac.ui.cs.advprog.eshop.repository;


import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    @BeforeEach
    void setUp(){

    }

    @Test
    void testCreateAndFind(){
        Product product = new Product();
        product.setProductId("bab96a53-6f22-4a52-bb13-0b59890352c1");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
//        product.crea
    }

}
