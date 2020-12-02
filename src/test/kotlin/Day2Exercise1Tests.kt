import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class Day2Exercise1Tests {

    @Test
    fun `notify when string is invalid`() {

        val sut = Day2Exercise1()

        val res = sut.parseString("")

        assertEquals(false, res.isValid)
    }

    @Test
    fun `return correct result`() {

        val sut = Day2Exercise1()

        val res = sut.parseString("1-3 a: abcde")

        assertTrue(res.isValid)
        assertEquals(1, res.min)
        assertEquals(3, res.max)
        assertEquals('a', res.letter)
        assertEquals("abcde", res.password)
    }

    @Test
    fun `false when letter is not there at least minimum`() {
        val sut = Day2Exercise1()
        val input = StringParsedResult(true, 1, 3, 'b', "aaa")

        val res = sut.isValidPassword(input)

        assertFalse(res)
    }

    @Test
    fun `true when minimum is met`() {
        val sut = Day2Exercise1()
        val input = StringParsedResult(true, 1, 3, 'a', "aaa")

        val res = sut.isValidPassword(input)

        assertTrue(res)
    }

    @Test
    fun `false when maximum is not met`() {
        val sut = Day2Exercise1()
        val input = StringParsedResult(true, 1, 2, 'a', "aaa")

        val res = sut.isValidPassword(input)

        assertFalse(res)
    }

    @Test
    fun `true when maximum is met`() {
        val sut = Day2Exercise1()
        val input = StringParsedResult(true, 1, 3, 'a', "aaa")

        val res = sut.isValidPassword(input)

        assertTrue(res)
    }

    @Test
    fun `false when min is met but max is not`() {
        val sut = Day2Exercise1()
        val input = StringParsedResult(true, 1, 3, 'a', "aaaaaa")

        val res = sut.isValidPassword(input)

        assertFalse(res)
    }

    @Test
    fun `false when max is met but min is not`() {
        val sut = Day2Exercise1()
        val input = StringParsedResult(true, 3, 6, 'a', "aa")

        val res = sut.isValidPassword(input)

        assertFalse(res)
    }

    @Test
    fun `true when both min and max are met`() {
        val sut = Day2Exercise1()
        val input = StringParsedResult(true, 3, 5, 'a', "aaaa")

        val res = sut.isValidPassword(input)

        assertTrue(res)
    }

    @Test
    fun `can consolidate single line with valid password`() {
        val sut = Day2Exercise1()
        val input = "1-3 a: aaa"

        val res = sut.consolidate(input)

        assertEquals(1, res)
    }

    @Test
    fun `can consolidate multiple line with valid passwords`() {
        val sut = Day2Exercise1()
        val input = """
            1-3 a: aaa"
            1-3 b: bbb"
        """.trimIndent()

        val res = sut.consolidate(input)

        assertEquals(2, res)
    }

    @Test
    fun `can consolidate multiple line with valid and invalid passwords`() {
        val sut = Day2Exercise1()
        val input = """
            1-3 a: aaa"
            1-3 c: bbb"
        """.trimIndent()

        val res = sut.consolidate(input)

        assertEquals(1, res)
    }

    @Test
    fun `can consolidate multiple line with invalid passwords`() {
        val sut = Day2Exercise1()
        val input = """
            1-3 b: aaa"
            1-3 c: bbb"
        """.trimIndent()

        val res = sut.consolidate(input)

        assertEquals(0, res)
    }
}