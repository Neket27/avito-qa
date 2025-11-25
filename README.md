# Запуск тестов

## 1. Установка зависимостей
- Установите JDK 17+
- Установите Gradle

## 2. Клонирование проекта
- git clone (https://github.com/Neket27/avito-qa.git)
- cd QA/avito

## 3. Запуск тестов
Вариант A: Через IntelliJ IDEA
Откройте проект как Gradle-проект
Перейдите в директорию:
src/test/java/avito
Нажмите ► возле класса теста для запуска

Вариант B: Через Gradle
# Все тесты
./gradlew test

# Конкретный класс (пример)
./gradlew test --tests avito.YourTestClass
