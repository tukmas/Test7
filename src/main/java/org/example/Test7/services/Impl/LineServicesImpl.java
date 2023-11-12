package org.example.Test7.services.Impl;

import lombok.RequiredArgsConstructor;
import org.example.Test7.services.LineServices;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class LineServicesImpl implements LineServices {

    @Override
    public String calculateAndSort(String page) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        String abc = "abcdefghijklmnopqrstuvwxyz";
        char[] abcArray = abc.toCharArray();
        ArrayList<Character> alphabet = new ArrayList<Character>();
        for (int i = 0; i < abcArray.length; i++){
            alphabet.add(abcArray[i]);
        }
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 1; i++){
            list.add(page.toLowerCase());
        }
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
        Map<Character, Integer> sortedMap = map.entrySet().stream()
                .sorted(Comparator.comparingInt(e -> -e.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> { throw new AssertionError(); },
                        LinkedHashMap::new
                ));
        return sortedMap.toString();
    }
}

