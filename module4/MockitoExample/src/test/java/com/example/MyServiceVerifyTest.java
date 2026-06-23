package com.example;

import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MyServiceVerifyTest {

    @Test
    public void testVerify() {

        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.fetchData("hi");

        verify(mockApi).getData("hi");
    }
}