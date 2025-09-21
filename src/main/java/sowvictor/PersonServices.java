package sowvictor;

import org.springframework.stereotype.Service;
import sowvictor.model.Person;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public Person findByid(String id) {
        logger.info("Finding one Person!");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstname("victor");
        person.setLastname("vicente");
        person.setAddress("Recife - Pernambuco - Brasil");
        person.setGender("male");
        return person;

    }
}
