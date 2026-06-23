package com.example;

import org.junit.Test;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MyServiceVoidExceptionTest {

    @Test(expected = RuntimeException.class)
    public void testVoidMethodThrowsException() {

        // Step 1: Create mock
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub void method to throw exception
        doThrow(new RuntimeException("API Error"))
                .when(mockApi)
                .getData("fail");

        // Step 3: Call method
        MyService service = new MyService(mockApi);

        service.fetchData("fail");

        // Step 4: Verify interaction (optional but good practice)
        verify(mockApi).getData("fail");
    }
}