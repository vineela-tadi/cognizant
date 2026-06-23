package com.example;

import org.junit.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class MyServiceOrderTest {

    @Test
    public void testOrder() {

        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.fetchData("A");
        service.fetchData("B");

        InOrder inOrder = inOrder(mockApi);

        inOrder.verify(mockApi).getData("A");
        inOrder.verify(mockApi).getData("B");
    }
}