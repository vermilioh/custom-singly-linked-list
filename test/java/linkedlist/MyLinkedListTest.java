package linkedlist;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyLinkedListTest {

    @Nested
    class SizeTests {

        @Test
        void sizeShouldDecreaseAfterRemovingMiddleElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            list.add(30);
            list.remove(20);
            assertEquals(2, list.size());
        }


        @Test
        void sizeShouldBeZeroAfterRemovingSingleElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.remove(10);
            assertEquals(0, list.size());
        }

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

        @Test
        public void sizeAfterRemoveSingleElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(5);
            assertEquals(1, list.size());
            list.remove(5);
            assertEquals(0, list.size());
        }

        @Test
        public void sizeAfterRemoveNonExistentElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(5);
            list.add(10);
            assertEquals(2, list.size());
            boolean removed = list.remove(20); // элемента 20 нет в списке
            assertFalse(removed);
            assertEquals(2, list.size());
        }

        @Test
        public void sizeAfterRemoveFromEmptyList() {
            MyLinkedList list = new MyLinkedList();
            assertEquals(0, list.size());
            boolean removed = list.remove(10);
            assertFalse(removed);
            assertEquals(0, list.size());
        }

        @Test
        public void sizeAfterRemoveMultipleElements() {
            MyLinkedList list = new MyLinkedList();
            list.add(1);
            list.add(2);
            list.add(3);
            assertEquals(3, list.size());
            list.remove(2);
            assertEquals(2, list.size());
            list.remove(1);
            assertEquals(1, list.size());
            list.remove(3);
            assertEquals(0, list.size());
        }

        @Test
        public void sizeAfterRemoveDuplicates() {
            MyLinkedList list = new MyLinkedList();
            list.add(5);
            list.add(5);
            list.add(5);
            assertEquals(3, list.size());
            list.remove(5);  // удалит первый встреченный 5
            assertEquals(2, list.size());
            list.remove(5);
            assertEquals(1, list.size());
            list.remove(5);
            assertEquals(0, list.size());
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

    @Nested
    class RemoveTest {

        @Test
        public void testListOrderAfterRemove() {
            MyLinkedList list = new MyLinkedList();
            list.add(1);
            list.add(2);
            list.add(3);
            list.remove(2);
            assertEquals(1, list.get(0));
            assertEquals(3, list.get(1));
        }


        @Test
        public void testRemoveAllDuplicatesManually() {
            MyLinkedList list = new MyLinkedList();
            list.add(5);
            list.add(5);
            list.add(5);
            assertTrue(list.remove(5));
            assertTrue(list.remove(5));
            assertTrue(list.remove(5));
            assertEquals(0, list.size());
        }


        @Test
        public void testRemoveMultipleSequentially() {
            MyLinkedList list = new MyLinkedList();
            list.add(1);
            list.add(2);
            list.add(3);
            assertTrue(list.remove(1));
            assertTrue(list.remove(2));
            assertEquals(1, list.size());
            assertEquals(3, list.get(0));
        }


        @Test
        public void testRemoveExistingElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            assertTrue(list.remove(10)); // Удаляем первый элемент
            assertEquals(1, list.size());
            assertEquals(20, list.get(0));
        }

        @Test
        public void testRemoveNonExistingElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            assertFalse(list.remove(30)); // Элемента 30 нет в списке
            assertEquals(2, list.size());
        }

        @Test
        public void testRemoveLastElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            assertTrue(list.remove(20)); // Удаляем последний элемент
            assertEquals(1, list.size());
            assertEquals(10, list.get(0));
        }

        @Test
        public void testRemoveFromEmptyList() {
            MyLinkedList list = new MyLinkedList();
            assertFalse(list.remove(10)); // Нельзя удалить из пустого списка
            assertEquals(0, list.size());
        }

        @Test
        public void testRemoveMultipleOccurrences() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            list.add(10);
            assertTrue(list.remove(10)); // Удаляется первый найденный элемент
            assertEquals(2, list.size());
            assertEquals(20, list.get(0));
            assertEquals(10, list.get(1));
        }

        @Test
        public void testSizeAfterRemove() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            list.add(30);
            assertEquals(3, list.size());
            list.remove(20);
            assertEquals(2, list.size()); // <-- если size не уменьшается, этот тест упадёт
        }

        @Test
        public void testRemoveSingleRemainingElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(42);
            assertTrue(list.remove(42));
            assertEquals(0, list.size());
            assertFalse(list.contains(42));
        }


    }

    @Nested
    class ContainsTest {
        @Test
        public void testContainsAfterRemovingAll() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.remove(10);
            assertFalse(list.contains(10));
        }

        @Test
        public void testContainsAfterClearSimulation() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            list.remove(10);
            list.remove(20);
            assertFalse(list.contains(10));
            assertFalse(list.contains(20));
        }

        @Test
        public void testContainsNegativeNumbers() {
            MyLinkedList list = new MyLinkedList();
            list.add(-1);
            list.add(-100);
            assertTrue(list.contains(-1));
            assertTrue(list.contains(-100));
            assertFalse(list.contains(-999));
        }

        @Test
        public void testContainsExistingElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            assertTrue(list.contains(10));
            assertTrue(list.contains(20));
        }

        @Test
        public void testContainsNonExistingElement() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            assertFalse(list.contains(30));
        }

        @Test
        public void testContainsInEmptyList() {
            MyLinkedList list = new MyLinkedList();
            assertFalse(list.contains(10));
        }

        @Test
        public void testContainsAfterRemove() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            list.remove(10);
            assertFalse(list.contains(10));
            assertTrue(list.contains(20));
        }

        @Test
        public void testContainsWithDuplicates() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            list.add(10);
            assertTrue(list.contains(10));
            assertTrue(list.contains(20));
        }
    }

    @Nested
    class GetTest {

        @Test
        public void testGetValidIndex() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            list.add(30);

            assertEquals(10, list.get(0));
            assertEquals(20, list.get(1));
            assertEquals(30, list.get(2));
        }

        @Test
        public void testGetFromEmptyList_throwsException() {
            MyLinkedList list = new MyLinkedList();
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        }

        @Test
        public void testGetNegativeIndex_throwsException() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        }

        @Test
        public void testGetIndexEqualToSize_throwsException() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(2)); // индекс 2 выходит за пределы
        }

        @Test
        public void testGetIndexGreaterThanSize_throwsException() {
            MyLinkedList list = new MyLinkedList();
            list.add(10);
            list.add(20);
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        }
    }


}


