package structure

import org.example.structure.MyLinkedList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MyLInkedListTest {

    @Test
    @DisplayName("하나씩 단순 추가 테스트")
    fun linkTest() {
        val list = MyLinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)

        assert(list.get(1) == 2)
        assert(list.get(3) == null)
        assert(list.get(1000) == null)

        assert(list.size() == 3)
    }

    @Test
    @DisplayName("여러건 있을 때 삭제 테스트")
    fun removeAtTest() {
        val list = MyLinkedList<Int>()
        list.add(0)
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)
        list.add(5)
        list.add(6)
        list.add(7)

        list.removeAt(3) // 0 -> 1 -> 2 -> 4 -> 5 -> 6 -> 7

        assert(list.get(3) == 4)
        assert(list.get(5) == 6)
        assert(list.size() == 7)

        list.removeAt(6) // 0 -> 1 -> 2 -> 4 -> 5 -> 6

        assert(list.get(5) == 6)
        assert(list.size() == 6)
    }

    @Test
    @DisplayName("1건 있을 때 삭제 테스트")
    fun removeAtOnlyOneValue() {
        val list = MyLinkedList<Int>()
        list.add(0)

        list.removeAt(0)

        assert(list.get(0) == null)
        assert(list.size() == 0)
    }

    @Test
    @DisplayName("아무것도 없는 리스트에서 삭제 테스트")
    fun removeAtEmptyList() {
        val list = MyLinkedList<Int>()

        list.removeAt(0)

        assert(list.get(0) == null)
        assert(list.size() == 0)

    }

    @Test
    @DisplayName("완전히 오버된 인덱스 삭제 테스트")
    fun removeOverIndex() {
        val list = MyLinkedList<Int>()
        list.add(1)
        list.add(2)
        list.add(3)
        list.add(4)

        list.removeAt(10000)

        assert(list.size() == 4)
        assert(list.get(1) == 2)
    }
}