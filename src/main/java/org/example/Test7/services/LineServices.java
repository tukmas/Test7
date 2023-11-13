package org.example.Test7.services;

import org.springframework.web.bind.annotation.RequestParam;

public interface LineServices {

   String calculateAndSort(@RequestParam String page);

}

