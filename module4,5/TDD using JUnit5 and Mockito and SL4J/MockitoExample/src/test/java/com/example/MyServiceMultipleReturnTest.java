package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyServiceMultipleReturnTest {

    @Test
    public void testMultipleReturns() {

        // Arrange
        ExternalApi mockApi = mock(ExternalApi.class);

        // consecutive stubbing (IMPORTANT PART)
        when(mockApi.getData("123"))
                .thenReturn("First Response")
                .thenReturn("Second Response")
                .thenReturn("Third Response");

        MyService service = new MyService(mockApi);

        // Act + Assert
        String r1 = service.fetchData("123");
        String r2 = service.fetchData("123");
        String r3 = service.fetchData("123");

        assertEquals("First Response", r1);
        assertEquals("Second Response", r2);
        assertEquals("Third Response", r3);
    }
}