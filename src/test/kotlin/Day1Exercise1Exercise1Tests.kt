import org.junit.Test
import kotlin.test.assertEquals

class Day1Exercise1Exercise1Tests {

    @Test
    fun `empty list should return negative 1`(){
        val sut = Day1Exercise1()

        val res = sut.calculate(listOf(), 0)

        assertEquals(-1, res)
    }

    @Test
    fun single_item_list_should_return_negative_1(){
        val sut = Day1Exercise1()

        val res = sut.calculate(listOf(4), 0)

        assertEquals(-1, res)
    }

    @Test
    fun should_return_product_when_2_numbers_add_to_pivot(){
        val sut = Day1Exercise1()

        val res = sut.calculate(listOf(2,4), 6)

        assertEquals(8, res)
    }

    @Test
    fun `should return -1 when 3 not matching numbers`(){
        val sut = Day1Exercise1()

        val res = sut.calculate(listOf(2,4, 6), 100)

        assertEquals(-1, res)
    }

    @Test
    fun `should_return_negative_1_when_2_numbers_don't_add_to_pivot`(){
        val sut = Day1Exercise1()

        val res = sut.calculate(listOf(2,4), 3)

        assertEquals(-1, res)
    }

    @Test
    fun `should return product when 2 matching numbers in the list`(){
        val sut = Day1Exercise1()

        val res = sut.calculate(listOf(2, 4, 6), 10)

        assertEquals(24, res)
    }
}