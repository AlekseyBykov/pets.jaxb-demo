package dev.abykov.pets.jaxb.demo.feature.xsd_to_classes;

import dev.abykov.pets.jaxb.demo.generated.PersonType;
import jakarta.xml.bind.JAXBElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;

@Service
public class PersonService {

    @Autowired
    private Jaxb2Marshaller marshaller;

    public PersonType unmarshalPerson(File xmlFile) {
        Object result = marshaller.unmarshal(new StreamSource(xmlFile));

        if (result instanceof JAXBElement) {
            return ((JAXBElement<PersonType>) result).getValue();
        } else {
            return (PersonType) result;
        }
    }

    public String marshalPerson(PersonType person) {
        var qName = new QName("https://abykov.dev/person", "person");

        JAXBElement<PersonType> jaxbElement = new JAXBElement<>(qName, PersonType.class, person);

        StringWriter writer = new StringWriter();
        marshaller.marshal(jaxbElement, new StreamResult(writer));

        return writer.toString();
    }
}
