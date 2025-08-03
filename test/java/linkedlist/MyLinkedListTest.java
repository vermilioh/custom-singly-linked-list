package linkedlist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyLinkedListTest {

    @Nested
    class SizeTests {

        @Test
        void sizeOfEmptyListShouldBeZero() {
            MyLinkedList list = new MyLinkedList();
            assertEquals(0, list.size());
        }

        @Test
        void sizeAfterAddingElements() {
            MyLinkedList list = new MyLinkedList();
            list.add(1);
            list.add(2);
            assertEquals(2, list.size());
        }

        @Test
        void sizeAfterAddingOneElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(42);
            assertEquals(1, list.size(), "Размер должен быть 1 после добавления одного элемента");
        }

        @Test
        void sizeAfterAddingMultipleElements() {
            MyLinkedList list = new MyLinkedList();
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
            assertEquals(10, list.size(), "Размер должен быть 10 после добавления 10 элементов");
        }

        @Test
        void sizeAfterRemovingElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(1);
            list.add(2);
            list.add(3);
            list.remove(2);
            assertEquals(2, list.size(), "Размер должен уменьшиться после удаления элемента");
        }

        @Test
        void sizeAfterClearingList() {
            MyLinkedList list = new MyLinkedList();
            list.add(5);
            list.add(6);
            list.clear();
            assertEquals(0, list.size(), "Размер должен быть 0 после очистки списка");
        }

        @Test
        void sizeDoesNotChangeWhenRemovingNonexistentElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(1);
            list.add(2);
            list.remove(999); // не существует
            assertEquals(2, list.size(), "Размер не должен измениться при попытке удалить несуществующий элемент");
        }


    }
    @Nested
    class AddTest {

        @Test
        void addSingleElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            assertEquals(1, list.size());
            assertEquals(10, list.get(0));
        }

        @Test
        void addMultipleElements() {
            MyLinkedList list = new MyLinkedList();
            list.add(1);
            list.add(2);
            list.add(3);
            assertEquals(3, list.size());
            assertEquals(1, list.get(0));
            assertEquals(2, list.get(1));
            assertEquals(3, list.get(2));
        }

        @Test
        void addDuplicateValues() {
            MyLinkedList list = new MyLinkedList();
            list.add(5);
            list.add(5);
            list.add(5);
            assertEquals(3, list.size());
            assertEquals(5, list.get(0));
            assertEquals(5, list.get(1));
            assertEquals(5, list.get(2));
        }

        @Test
        void addNegativeAndZero() {
            MyLinkedList list = new MyLinkedList();
            list.add(0);
            list.add(-1);
            list.add(-100);
            assertEquals(3, list.size());
            assertEquals(0, list.get(0));
            assertEquals(-1, list.get(1));
            assertEquals(-100, list.get(2));
        }

        @Test
        void addToEmptyList() {
            MyLinkedList list = new MyLinkedList();
            list.add(42);
            assertEquals(1, list.size());
            assertEquals(42, list.get(0));
        }


        @Test
        void addLargeNumberOfElements() {
            MyLinkedList list = new MyLinkedList();
            int count = 10000;
            for (int i = 0; i < count; i++) {
                list.add(i);
            }
            assertEquals(count, list.size());
            assertEquals(0, list.get(0));
            assertEquals(count - 1, list.get(count - 1));
        }

        @Test
        void addAfterManyAdds() {
            MyLinkedList list = new MyLinkedList();
            for (int i = 0; i < 100; i++) {
                list.add(i);
            }
            list.add(999);
            assertEquals(101, list.size());
            assertEquals(999, list.get(100));
        }
    }
}


