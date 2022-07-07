package com.github.app.rest;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.app.api.MessageApi;
import com.github.domain.model.Message;
import com.github.domain.service.MessageService;
import com.github.domain.util.MessageMatcher;

/*
    Необходимо протестировать MessageController используя моки
    TODO
        создайте мок для MessageService
        создайте мок для MessageController
        протестируйте создание нового сообщения
*/
@RunWith(MockitoJUnitRunner.class)
public class MessageControllerUnitTest {
    @Mock
    MessageController messageController;

    @Mock
    MessageService messageService;

    @Test
    public void attackWithSwordTest() throws Exception {
        Message message = new Message();
        message.setText("Test");
        MessageApi messageApi = new MessageApi();
        messageApi.setText("Test");

        Mockito.when(messageController.createMessage(eq(messageApi))).thenReturn(message);

        Message messageResult =  messageController.createMessage(messageApi);

        assertEquals(messageResult, message);

    }

    
}