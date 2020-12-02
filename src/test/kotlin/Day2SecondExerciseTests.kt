import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day2SecondExerciseTests {

    @Test
    fun `true when min position is valid`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 3, 'a', "abc")

        val res = sut.isValidPasswordSecondTake(input)

        assertTrue(res)
    }

    @Test
    fun `false when min position is invalid`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 3, 'a', "bce")

        val res = sut.isValidPasswordSecondTake(input)

        assertFalse(res)
    }

    @Test
    fun `true when max position is valid`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 3, 'a', "bca")

        val res = sut.isValidPasswordSecondTake(input)

        assertTrue(res)
    }

    @Test
    fun `false when max position is invalid`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 3, 'a', "bcd")

        val res = sut.isValidPasswordSecondTake(input)

        assertFalse(res)
    }

    @Test
    fun `false when both position are valid`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 3, 'a', "aaa")

        val res = sut.isValidPasswordSecondTake(input)

        assertFalse(res)
    }

    @Test
    fun `false when both position are invalid`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 3, 'b', "aaa")

        val res = sut.isValidPasswordSecondTake(input)

        assertFalse(res)
    }

}