package linkedlist;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        System.out.println("\n=== Тесты для метода get(int index) ===");

        list.clear();



// Добавляем элементы
        list.add(10);
        list.add(20);
        list.add(30);

// Тест: получить элемент по валидным индексам
        System.out.println("Ожидается 10 → list.get(0): " + list.get(0));
        System.out.println("Ожидается 20 → list.get(1): " + list.get(1));
        System.out.println("Ожидается 30 → list.get(2): " + list.get(2));
    }
}

