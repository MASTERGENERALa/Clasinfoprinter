package Casinfoprinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassInfoPrinter {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введіть повне ім'я класу (наприклад, java.util.ArrayList): ");
            String className = reader.readLine();

            Class<?> clazz = Class.forName(className);

            // Виведення імені класу
            System.out.println("Ім'я класу: " + clazz.getSimpleName());

            // Виведення конструкторів класу
            System.out.println("Конструктори:");
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }

            // Виведення полів класу
            System.out.println("Поля:");
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            // Виведення методів класу
            System.out.println("Методи:");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                System.out.println(method);
            }
        } catch (IOException e) {
            System.err.println("Помилка введення: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Клас не знайдено: " + e.getMessage());
        }
    }
}
