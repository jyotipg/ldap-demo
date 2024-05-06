package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    DemoComponent demoComponent;

    @GetMapping("/default")
    public String getDefault()
    {
        return demoComponent.getName();
    }

    @GetMapping("/props")
    public String getPros()
    {
        return demoComponent.readPropereties();
    }

    @GetMapping("/static")
    public String getStatic()
    {
        return demoComponent.readStaticProperties();
    }
}
