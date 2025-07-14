# pets.jaxb-demo

**Spring Boot demo for JAXB: XSD ↔ Java ↔ XML mapping**

This project demonstrates:

- Generating Java classes from XSD using **maven-jaxb2-plugin**  
- Generating XSD from Java classes via **schemagen** and Maven exec plugin  
- Integration with **Spring OXM (Jaxb2Marshaller)** for XML marshalling/unmarshalling  
- Separation of concerns between marshalling and unmarshalling logic  
- Clean unit tests verifying XML ↔ Java mappings

## **How to run**
 ```
 https://github.com/AlekseyBykov/pets.jaxb-demo.git
 cd pets.jaxb-demo
 mvn clean generate-sources install
 mvn test
```

## **How it works**

- The **maven-jaxb2-plugin** generates annotated Java classes from XSD schemas during the build phase.
- `.xjb` binding files adjust generated packages for clean integration with project packages.
- **schemagen** (executed via Maven exec-maven-plugin and JDK 8) generates XSD from annotated Java classes.
- **Spring OXM Jaxb2Marshaller** is configured for seamless XML ↔ Java conversion.
- The service explicitly separates marshalling and unmarshalling into dedicated methods for clarity and testability.
- All examples are isolated into feature-specific packages to clearly distinguish directions: XSD → Java, Java → XSD.

## **Features in detail**

`xsd_to_classes`
- Uses maven-jaxb2-plugin to generate annotated classes from .xsd
- `.xjb` binding file customizes package names
- Uses Spring OXM for XML ↔ Java mapping
- Separate service methods for marshalling/unmarshalling

`classes_to_xsd`
- Uses schemagen (via Maven exec plugin, JDK 8) to generate `.xsd` from annotated Java classes
- Toolchains configured to invoke JDK 8 only for schemagen

## **Tech stack**

- Java 17+
- Spring Boot 3.x
- Maven JAXB2 plugin 3.x
- Jakarta / javax JAXB APIs
- Jakarta XML Bind (JAXB)
- JUnit 5 + Spring Test

---

## License
MIT License
