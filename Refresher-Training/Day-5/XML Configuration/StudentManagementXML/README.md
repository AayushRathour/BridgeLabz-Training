# StudentManagementXML

Small Spring XML-configuration demo: `App` loads beans from `applicationContext.xml`,
gets a `StudentService`, and registers a `Student` through it.

## What was broken (and fixed)

1. **Wrong bean classes in the XML** — `applicationContex.xml` pointed to `com.demo.StudentRepository`
   / `com.demo.StudentService`, but the real package is `com.student.StudentManagementXML`.
   This alone caused a `ClassNotFoundException` at startup.
2. **Filename typo** — the XML was named `applicationContex.xml` (missing a "t"), while `App.java`
   loaded `"applicationContext.xml"`. Renamed the file to match.
3. **Wrong location** — the XML lived under `src/main/java/.../resources/`, which plain Maven does
   NOT copy to the classpath (only `src/main/resources` is copied by default). It only worked before
   because Eclipse's own incremental builder was copying it. Moved it to `src/main/resources/`.
4. **Missing imports** in `App.java` for `ApplicationContext` and `ClassPathXmlApplicationContext`.
5. Minor cleanup: renamed `role_no`/`getRool_no`/`cource` typos to `rollNo`/`getRollNo`/`course`.
6. Added the `exec-maven-plugin` so the app can be run with one command.

## How to run

```bash
mvn compile exec:java
```

or build a jar and run it:

```bash
mvn package
java -jar target/StudentManagementXML-0.0.1-SNAPSHOT.jar
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
