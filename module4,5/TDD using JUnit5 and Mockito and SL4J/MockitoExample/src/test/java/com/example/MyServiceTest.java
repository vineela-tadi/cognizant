package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyServiceTest {

    @Test
    public void testFetchData() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData("hi")).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        assertEquals("Mock Data", service.fetchData("hi"));
    }
}