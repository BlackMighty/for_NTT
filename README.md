# TestNTT

TestNTT - это Spring Java-приложение, реализующее REST API для работы с данными организаций.

## Технологии

- Java 11
- Spring Boot 2.5
- PostgreSQL 12 и выше
- Liquibase
- Maven

## Настройки профиля

В проекте используется профиль `default`, в котором заданы следующие настройки:

- Параметры подключения к базе данных: `spring.datasource.url`, `spring.datasource.username`, `spring.datasource.password`
- Параметры миграций Liquibase: `liquibase.change-log`, `liquibase.contexts`

Для запуска приложения, убедитесь, что у вас настроены соответствующие значения этих параметров в файле `application.properties` или через переменные среды.

## REST API

### Получение списка организаций

**GET /organizations**

Этот метод возвращает список всех организаций в формате JSON.

Параметры запроса:
- `search` (необязательный) - строка поиска для фильтрации списка организаций

Пример запроса: 

GET /organizations?search=test


### Получение информации об организации

**GET /organizations/{id}**

Этот метод возвращает информацию об организации с указанным идентификатором в формате JSON.

Пример запроса:

GET /organizations/1


### Создание организации

**POST /organizations**

Этот метод создает новую организацию на основе переданных данных.

Пример запроса:

POST /organizations
Content-Type: application/json

{
"fullName": "ООО Тестовая организация",
"shortName": "ТестОрг",
"inn": "1234567890",
"ogrn": "0123456789012",
"postalAddress": "123456, г. Тестово, ул. Тестовая, д. 1",
"legalAddress": "123456, г. Тестово, ул. Тестовая, д. 1",
"directorLastName": "Иванов",
"directorFirstName": "Иван",
"directorMiddleName": "Иванович",
"directorBirthDate": "1990-01-01"
}

### Обновление организации

**PUT /organizations/{id}**

Этот метод обновляет информацию об организации с указанным идентификатором на основе переданных данных.

Пример запроса:

PUT /organizations/1
Content-Type: application/json

{
"fullName": "ООО Новое название",
"shortName": "Новое имя"
}


### Удаление организации

**DELETE /organizations/{id}**

Этот метод удаляет организацию с указанным идентификатором.

Пример запроса:

DELETE /organizations/1

