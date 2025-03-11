package sowvictor.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sowvictor.model.Greeting;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello meu povo,%s!";
    private final AtomicLong counter = new AtomicLong();

    //http://localhost:8080/greeting?name=victor
    @RequestMapping("/greeting")
    public Greeting greeting(
            @RequestParam(value = "name",defaultValue = "World")
            String name){
        return new Greeting(counter.incrementAndGet(),String.format(template,name));

        }
}
