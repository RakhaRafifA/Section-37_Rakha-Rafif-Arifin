package com.rakharafifa.miniproject.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rakharafifa.miniproject.model.entity.CartEntity;
import com.rakharafifa.miniproject.repository.CartRepository;
import com.rakharafifa.miniproject.service.implementation.CartServiceImpl;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CartSericeTest {
    private final EasyRandom EASY_RANDOM = new EasyRandom();

    @InjectMocks
    private CartServiceImpl service;

    @Mock
    private CartRepository repository;

    @Test
    void findAllCart(){
        List<CartEntity> carts = EASY_RANDOM.objects(CartEntity.class, 2)
        .collect(Collectors.toList());

        when(repository.findAll()).thenReturn(carts);
        service.getAllCart();
        verify(repository, times(1)).findAll();
    }

    @Test
    void findCartById(){
        CartEntity cart = EASY_RANDOM.nextObject(CartEntity.class);
        System.out.println(cart);

        when(repository.findById(cart.getCart_id())).thenReturn(Optional.of(cart));
        service.getCartById(cart.getCart_id());
        verify(repository, times(1)).findById(cart.getCart_id());
    }

    // @Test
    // void createNewCart(){
    //     Cart cart = EASY_RANDOM.nextObject(Cart.class);
    //     System.out.println(cart);

    //     when(repository.save(cart)).thenReturn(cart);
    //     service.createCart(cart);
    //     verify(repository, times(1)).save(cart);
    // }

    @Test
    public void deleteCartById(){
        CartEntity cart = EASY_RANDOM.nextObject(CartEntity.class);

        service.deleteCart(cart.getCart_id());
        verify(repository).deleteById(cart.getCart_id());
    }

    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() {
        CartEntity cart = EASY_RANDOM.nextObject(CartEntity.class);
        CartEntity newCart = new CartEntity();
        newCart.setQuantity(20L);

        when(repository.findById(cart.getCart_id())).thenReturn(Optional.of(cart));
        service.updateCart(cart.getCart_id(), newCart);
        verify(repository).save(cart);
        verify(repository).findById(cart.getCart_id());
    }
}
