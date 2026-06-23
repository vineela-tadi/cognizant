package com.example;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MyServiceVoidTest {

    @Test
    public void testVoid() {

        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.fetchData("hello");

        verify(mockApi).getData("hello");
    }
}