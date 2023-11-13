package org.example.Test7.services.Impl;

import lombok.RequiredArgsConstructor;
import org.example.Test7.services.LineServices;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.isNumeric;


@Service
@RequiredArgsConstructor
public class LineServicesImpl implements LineServices {
    @Override
    public String calculateAndSort(String page) {
//        Проверяем валидность вводимых данных, если ввод не корректен выводим сообщение:

        if (page == null || page.isBlank() || isNumeric(page) || page.contains("а")) {
            return "Ошибка валидации сущности." +
                    " Введите буквы латинского алфавита (Aa-Zz): ";
        }
//        Создаём дополнительные инструменты и записываем ввод:

        Map<Character, Integer> map = new HashMap<>();
        String abc = "abcdefghijklmnopqrstuvwxyz";
        char[] abcArray = abc.toCharArray();
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char c : abcArray) {
            alphabet.add(c);
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 1; i++){
            list.add(page.toLowerCase());
        }
//        Получаем искомые значения и записываем в карту:

        for (Character ch: alphabet){
            int count = 0;
            for (String str: list){
                int res = 0;
                while (res != -1){
                    res = str.indexOf(ch.toString(), res);
                    if (res != -1)
                    {
                        count++;
                        res++;
                    }
                }
            }
            if (count > 0) {
                map.put(ch, count);
            }
        }
//        Сортируем:

        Map<Character, Integer> sortedMap = map.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        return "Искомое значение: " + sortedMap;
    }
}

