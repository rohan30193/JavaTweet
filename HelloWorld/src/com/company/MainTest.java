package com.company;

import org.mockito.Mock;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.mock;
import static org.testng.Assert.*;

public class MainTest {


    @Mock
    private T mockAddNumbers;

    @BeforeMethod
    public void BeforeMethod()
    {
        mockAddNumbers=mock(addNumbersInterface.class);
    }

    @AfterMethod

    @Test
    public void testMain() {
    }
}
