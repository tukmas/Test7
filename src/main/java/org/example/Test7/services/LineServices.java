package org.example.Test7.services;


import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

public interface LineServices {

    String calculateAndSort(@RequestParam String page) throws IOException;

}

