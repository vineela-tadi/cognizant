package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyServiceArgumentMatcherTest {

    @Test
    public void testMatcher() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData(anyString())).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);

        assertEquals("Mock Data", service.fetchData("anything"));
    }
}