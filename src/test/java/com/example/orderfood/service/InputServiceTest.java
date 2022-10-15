package com.example.orderfood.service;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputServiceTest {

    @Test
    void getChoice() {
        String expected = "1";
        ByteArrayInputStream fakeIS = new ByteArrayInputStream(expected.getBytes());
        InputService service = new InputService(fakeIS);
        int actual = service.getChoice();
        int expectInt = Integer.parseInt(expected);
        assertEquals(expectInt, actual);
    }
}