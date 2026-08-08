# JavaBased

Spring Java-based configuration demo (`@Configuration` + `@Bean`, no XML).

## What was broken

1. **`pom.xml` had no Spring dependency at all** — it was still the leftover default
   Maven archetype pom (just JUnit 3.8.1). Since `App.java` and `AppConfig.java` import
   `org.springframework.context.*`, the project could not compile. Added `spring-context`.
2. No Java release version was set — added `maven.compiler.release=17`.
3. `AppTest.java` was in a mismatched package (`com.student.JavaBased`, an archetype leftover)
   and used old JUnit 3 (`TestCase`/`TestSuite`) style. Moved it to `com.student.StudentManagementJava`
   and updated to JUnit 5.
4. Added `exec-maven-plugin` so the app runs with one command.

`App.java`, `AppConfig.java`, `Student.java`, `StudentRepository.java`, `StudentService.java`
were all already correct — no changes needed there.

## How it works

`AppConfig` is a `@Configuration` class whose `@Bean` methods replace XML `<bean>` tags:

```java
@Bean
public StudentRepository studentRepository() {
    return new StudentRepository();
}

@Bean
public StudentService studentService() {
    return new StudentService(studentRepository());
}
```

`App` loads it with `AnnotationConfigApplicationContext(AppConfig.class)` instead of
`ClassPathXmlApplicationContext`.

## How to run

```bash
mvn compile exec:java
```

or:

```bash
mvn package
java -jar target/JavaBased-0.0.1-SNAPSHOT.jar
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
