package dev.abykov.pets.jaxb.demo.service;

import dev.abykov.pets.jaxb.demo.generated.PersonType;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;

@Service
public class PersonService {

    @Autowired
    private Jaxb2Marshaller marshaller;

    public PersonType unmarshalPerson(File xmlFile) throws Exception {
        Object result = marshaller.unmarshal(new StreamSource(xmlFile));
        if (result instanceof jakarta.xml.bind.JAXBElement) {
            return ((JAXBElement<PersonType>) result).getValue();
        } else {
            return (PersonType) result;
        }
    }

    public String marshalPerson(PersonType person) throws Exception {
        StringWriter writer = new StringWriter();
        QName qName = new QName("https://abykov.dev/person", "person");
        JAXBElement<PersonType> jaxbElement = new JAXBElement<>(qName, PersonType.class, person);
        marshaller.marshal(jaxbElement, new javax.xml.transform.stream.StreamResult(writer));
        return writer.toString();
    }
}
