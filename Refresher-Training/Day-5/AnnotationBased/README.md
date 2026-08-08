# AnnotationBased

Same demo as the XML and Java-config versions, but using **pure Spring
annotation-based configuration** with component scanning — no `@Bean` methods,
no XML.

## How it maps to the other two versions

| XML version | Java-config version | Annotation version |
|---|---|---|
| `applicationContext.xml` | `AppConfig.java` (`@Bean` methods) | `AppConfig.java` (just `@ComponentScan`) |
| `<bean id="studentRepository" class="...StudentRepository"/>` | `@Bean public StudentRepository studentRepository()` | `@Repository` on the class itself |
| `<bean id="studentService" ...><constructor-arg ref="studentRepository"/></bean>` | `@Bean public StudentService studentService() {...}` | `@Service` on the class + `@Autowired` constructor |

Spring scans `com.student.StudentManagementAnnotation`, finds every class
annotated `@Component` / `@Service` / `@Repository`, creates them, and wires
constructor dependencies automatically — you never call `new StudentService(...)`
yourself.

## How to run

```bash
mvn compile exec:java
```

or:

```bash
mvn package
java -jar target/AnnotationBased-0.0.1-SNAPSHOT.jar
```

Expected output:

```
StudentService Object Created
Checking Student Details...
Adding the Student ...
Student Name: Aayush
Student Roll No: 101
Student Course: B.Tech AIML
Student Added ...
```
