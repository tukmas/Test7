package org.example.Test7.services.Impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LineServicesImplTest {

    private LineServicesImpl lineServices;

    @BeforeEach
    void setUp() {
        lineServices = new LineServicesImpl();
    }

    @Test
    public void calculateAndSort() {
        String even = lineServices.calculateAndSort("aaaaabcccc");
        String result = "Искомое значение: {a=5, c=4, b=1}";
        Assertions.assertEquals(even, result);
    }
    @Test
    public void calculateAndSort_CheckingForNull() {
        String even = lineServices.calculateAndSort(null);
        String result = "Ошибка валидации сущности. Введите буквы латинского алфавита (Aa-Zz): ";
        Assertions.assertEquals(even, result);
    }
    @Test
    public void calculateAndSort_CheckForSpace() {
        String even = lineServices.calculateAndSort(" ");
        String result = "Ошибка валидации сущности. Введите буквы латинского алфавита (Aa-Zz): ";
        Assertions.assertEquals(even, result);
    }
    @Test
    public void calculateAndSort_CheckingForEmptiness() {
        String even = lineServices.calculateAndSort("");
        String result = "Ошибка валидации сущности. Введите буквы латинского алфавита (Aa-Zz): ";
        Assertions.assertEquals(even, result);
    }
    @Test
    public void calculateAndSort_NumberCheck() {
        String even = lineServices.calculateAndSort("0123456789");
        String result = "Ошибка валидации сущности. Введите буквы латинского алфавита (Aa-Zz): ";
        Assertions.assertEquals(even, result);
    }
    @Test
    public void calculateAndSort_CyrillicCheck() {
        String even = lineServices.calculateAndSort("а");
        String result = "Ошибка валидации сущности. Введите буквы латинского алфавита (Aa-Zz): ";
        Assertions.assertEquals(even, result);
    }
}