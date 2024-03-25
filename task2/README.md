# Домашнее задание №2
---
21.03.24 - 28.03.24
---

## Задачи

- Написать 3 - 5 простых автотеста
- Использовать:
	- Selenide
	- Page Object
	- JUnit5
---
## Выполнение

Используемые PageObject:
 - [LoginPage](src/test/java/ru/ok/model/LoginPage.java) -- инкапсулирует в себе страницу авторизацию, позволяет получить доступ к полям логина и пароля, для последующих проверок
 - [MainPage] (src/test/java/ru/ok/model/MainPage.java) -- инкапсулирует в себе основную страницу, которая открывается после авторизации

Используемые Actor (Используется для повышения уровня абстракции над PageObject):
 - [LoginActor](src/test/java/ru/ok/model/LoginOrchestrator.java)
 - [MainPageActor] (src/test/java/ru/ok/model/MainPageActor.java)

