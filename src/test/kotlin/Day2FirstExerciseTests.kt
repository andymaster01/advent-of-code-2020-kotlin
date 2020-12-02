import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day2FirstExerciseTests {
    @Test
    fun `false when letter is not there at least minimum`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 3, 'b', "aaa")

        val res = sut.isValidPasswordFirstTake(input)

        assertFalse(res)
    }

    @Test
    fun `true when minimum is met`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 3, 'a', "aaa")

        val res = sut.isValidPasswordFirstTake(input)

        assertTrue(res)
    }

    @Test
    fun `false when maximum is not met`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 2, 'a', "aaa")

        val res = sut.isValidPasswordFirstTake(input)

        assertFalse(res)
    }

    @Test
    fun `true when maximum is met`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 3, 'a', "aaa")

        val res = sut.isValidPasswordFirstTake(input)

        assertTrue(res)
    }

    @Test
    fun `false when min is met but max is not`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(1, 3, 'a', "aaaaaa")

        val res = sut.isValidPasswordFirstTake(input)

        assertFalse(res)
    }

    @Test
    fun `false when max is met but min is not`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(3, 6, 'a', "aa")

        val res = sut.isValidPasswordFirstTake(input)

        assertFalse(res)
    }

    @Test
    fun `true when both min and max are met`() {
        val sut = Day2()
        val input = Day2.StringParsedResult(3, 5, 'a', "aaaa")

        val res = sut.isValidPasswordFirstTake(input)

        assertTrue(res)
    }
}