# Hello Spring (REST API)


Минимальное приложение для проверки знаний Spring Boot: in-memory репозиторий, сервис, контроллер, REST, интеграционные тесты.


## Требования
- Java 17+
- Gradle (локально не обязателен: используем gradle-wrapper)


## Сборка и запуск
```bash
./gradlew clean test
./gradlew bootJar
java -jar build/libs/hello-spring-0.0.1-SNAPSHOT.jar
# или во время разработки:
./gradlew bootRun