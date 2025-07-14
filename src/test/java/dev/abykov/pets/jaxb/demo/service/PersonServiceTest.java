package dev.abykov.pets.jaxb.demo.service;

import dev.abykov.pets.jaxb.demo.feature.xsd_to_classes.PersonService;
import dev.abykov.pets.jaxb.demo.generated.PersonType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    void testUnmarshalPerson() throws Exception {
        File xmlFile = new File("src/main/resources/person.xml");
        assertTrue(xmlFile.exists(), "XML file not found");

        PersonType person = personService.unmarshalPerson(xmlFile);
        assertNotNull(person);
        assertEquals("User", person.getName());
    }

    @Test
    void testMarshalPerson() throws Exception {
        PersonType person = new PersonType();
        person.setName("User");
        person.setAge(0);

        String xml = personService.marshalPerson(person);
        assertTrue(xml.contains("<age>0</age>"), "Marshalled XML does not contain updated age");
    }
}
