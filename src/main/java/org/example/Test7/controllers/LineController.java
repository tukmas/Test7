package org.example.Test7.controllers;

import org.example.Test7.services.LineServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LineController {
    private final LineServices lineServices;

    public LineController(LineServices lineServices) {
        this.lineServices = lineServices;
    }
    @GetMapping("/path/to/page")
    public String page(@RequestParam String page) {
        return lineServices.calculateAndSort(page);
    }
}
