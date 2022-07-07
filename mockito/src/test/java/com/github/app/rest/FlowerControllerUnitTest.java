package com.github.app.rest;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.app.api.Flower;
import com.github.app.rest.FlowerController;
import com.github.domain.service.FlowerService;

/*
    Необходимо протестировать MessageController используя моки
    TODO
        создайте мок для FlowerService
        создайте мок для FlowerController
        напишите метод для тестирования flowerController.isAFlower, создав мок для flowerService.isABigFlower, который возвращает true
        напишите метод для тестирования flowerController.isABigFlower, создав мок для flowerService.isABigFlower, который возвращает true
*/
@RunWith(MockitoJUnitRunner.class)
public class FlowerControllerUnitTest {

    @Mock
    private FlowerService flowerService;
    @InjectMocks
    private FlowerController flowerController;

    @Test
    public void isFlower_Test() {
        when(flowerService.analize(eq("Poppy"))).thenReturn("flower");
        String flower = flowerController.isAFlower("Poppy");
        assertEquals("flower", flower);
    }

    @Test
    public void isBigFlower_Test() {
        when(flowerService.isABigFlower(eq("rose"), anyInt())).thenReturn(true);
        Flower flower = new Flower("rose", 25);
        Boolean response = flowerController.isABigFlower(flower);
        Assert.assertTrue(response);
    }


}