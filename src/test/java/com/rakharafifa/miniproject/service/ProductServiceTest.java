package com.rakharafifa.miniproject.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rakharafifa.miniproject.model.entity.ProductEntity;
import com.rakharafifa.miniproject.repository.ProductRepository;
import com.rakharafifa.miniproject.service.implementation.ProductServiceImpl;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    private final EasyRandom EASY_RANDOM = new EasyRandom();

    @InjectMocks
    private ProductServiceImpl service;

    @Mock
    private ProductRepository repository;

    @Test
    void findAllProduct(){
        List<ProductEntity> products = EASY_RANDOM.objects(ProductEntity.class, 2)
        .collect(Collectors.toList());

        when(repository.findAll()).thenReturn(products);
        service.getAllProduct();
        verify(repository, times(1)).findAll();
    }

    @Test
    void findProductById(){
        ProductEntity product = EASY_RANDOM.nextObject(ProductEntity.class);
        System.out.println(product);

        when(repository.findById(product.getProduct_id())).thenReturn(Optional.of(product));
        service.getProductById(product.getProduct_id());
        verify(repository, times(1)).findById(product.getProduct_id());
    }

    // @Test
    // void createNewProduct(){
    //     Product product = EASY_RANDOM.nextObject(Product.class);
    //     System.out.println(product);

    //     when(repository.save(product)).thenReturn(product);
    //     service.createProduct(product);
    //     verify(repository, times(1)).save(product);
    // }

    @Test
    public void deleteProductById(){
        ProductEntity product = EASY_RANDOM.nextObject(ProductEntity.class);

        service.deleteProduct(product.getProduct_id());
        verify(repository).deleteById(product.getProduct_id());
    }

    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() {
        ProductEntity product = EASY_RANDOM.nextObject(ProductEntity.class);
        ProductEntity newProduct = new ProductEntity();
        newProduct.setName("Baru");

        when(repository.findById(product.getProduct_id())).thenReturn(Optional.of(product));
        service.updateProduct(product.getProduct_id(), newProduct);
        verify(repository).save(product);
        verify(repository).findById(product.getProduct_id());
    }
}
