

<details open>
<summary>🇷🇺 Описание на русском</summary>

# Односвязный список на Java

Данный проект представляет собой реализацию простой односвязной структуры данных на языке Java. Включает базовые методы добавления, удаления, поиска и получения размера списка. Также реализованы юнит-тесты с использованием JUnit 5.

---

## 🧪 Запуск тестов

Проект использует **JUnit 5**. Чтобы запустить все тесты из командной строки, выполните:

```
mvn clean test
```

Тесты находятся в файле `MyLinkedListTest.java`, организованы по вложенным классам.

---

## 💡 Пример использования

```java
MyLinkedList list = new MyLinkedList();
list.add(10);
list.add(20);
list.remove(10);
System.out.println(list.contains(20)); // true
```

---

## 📁 Структура проекта

```
src/
 └── main/
     └── java/
         └── linkedlist/
             ├── MyLinkedList.java
             └── Main.java
 └── test/
     └── java/
         └── linkedlist/
             └── MyLinkedListTest.java
```

</details>





<details>
<summary>🇬🇧 English Description</summary>

# Singly Linked List in Java

This project provides a simple implementation of a singly linked list in Java, supporting basic operations like `add`, `remove`, `contains`, and `size`. Unit tests are written using **JUnit 5**.

---

## 🧪 Running tests

The project uses **JUnit 5**. To run all tests from the command line, execute:

```
mvn clean test
```

Tests are defined in `MyLinkedListTest.java` using nested test classes.

---

## 💡 Usage example

```java
MyLinkedList list = new MyLinkedList();
list.add(10);
list.add(20);
list.remove(10);
System.out.println(list.contains(20)); // true
```

---

## 📁 Project structure

```
src/
 └── main/
     └── java/
         └── linkedlist/
             ├── MyLinkedList.java
             └── Main.java
 └── test/
     └── java/
         └── linkedlist/
             └── MyLinkedListTest.java
```

</details>