# pets.jaxb-demo

**Spring Boot demo for JAXB with XSD generation and XML binding**

This project demonstrates:

- Generating Java classes from XSD using **maven-jaxb2-plugin**
- Using `.xjb` binding files to customize generated package names
- Integrating JAXB with **Spring OXM (Jaxb2Marshaller)**
- Marshalling and unmarshalling XML ↔ Java objects in a clean service design
- Unit testing of marshalling and unmarshalling logic

---

## **How to run**

1. Clone the repository:
    ```
    https://github.com/AlekseyBykov/pets.jaxb-demo.git
    cd pets.jaxb-demo
    ```

2. Generate classes and build the project:
    ```
    mvn clean generate-sources install
    ```

3. Run tests:
    ```
    mvn test
    ```
---

## **How it works**

- The **maven-jaxb2-plugin** generates annotated Java classes from XSD schemas during build.
- `.xjb` binding files adjust the generated packages for better integration.
- **Spring OXM Jaxb2Marshaller** is configured for seamless XML ↔ Java conversion.
- The service splits marshalling and unmarshalling into separate methods for clarity and testability.

---

## **Key features**

- Generates `ObjectFactory` for root elements  
- Uses `JAXBElement` for marshalling when `@XmlRootElement` is absent  
- Clean separation of marshalling and unmarshalling logic  
- JUnit tests ensure correctness of XML ↔ Java mapping

---

## **Tech stack**

- Java 17+
- Spring Boot 3.x
- Maven JAXB2 plugin 3.x
- Jakarta XML Bind (JAXB)
- JUnit 5 + Spring Test

---

## License
MIT License
