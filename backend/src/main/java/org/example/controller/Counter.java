package org.example.controller;

public class Counter implements AutoCloseable {
    private int count;

    // Конструкторы, геттеры, сеттеры и другие методы

    // Метод для увеличения значения счетчика
    public void add() {
        count++;
    }

    // Реализация метода интерфейса AutoCloseable
    @Override
    public void close() {
        // Проверка, был ли счетчик использован в блоке try-with-resources
        if (count > 0) {
            System.out.println("Счетчик успешно закрыт.");
        } else {
            System.out.println("Ошибка: счетчик не был использован.");
        }
    }
}

