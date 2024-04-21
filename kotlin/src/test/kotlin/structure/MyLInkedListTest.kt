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
}