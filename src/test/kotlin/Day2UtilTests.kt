import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Day2UtilTests {

    @Test
    fun `parseString - notify when string is invalid`() {

        val sut = Day2()

        val res = sut.parseString("")

        assertEquals(false, res.isValid)
    }

    @Test
    fun `parseString - return correct result`() {

        val sut = Day2()

        val res = sut.parseString("1-3 a: abcde")

        assertTrue(res.isValid)
        assertEquals(1, res.min)
        assertEquals(3, res.max)
        assertEquals('a', res.letter)
        assertEquals("abcde", res.password)
    }

    @Test
    fun `consolidate-AlgorithmType_FIRST - can consolidate single line with valid password`() {
        val sut = Day2()
        val input = "1-3 a: aaa"

        val res = sut.consolidate(input, AlgorithmType.FIRST)

        assertEquals(1, res)
    }

    @Test
    fun `consolidate-AlgorithmType_FIRST - can consolidate multiple line with valid passwords`() {
        val sut = Day2()
        val input = """
            1-3 a: aaa"
            1-3 b: bbb"
        """.trimIndent()

        val res = sut.consolidate(input, AlgorithmType.FIRST)

        assertEquals(2, res)
    }

    @Test
    fun `consolidate-AlgorithmType_FIRST - can consolidate multiple line with valid and invalid passwords`() {
        val sut = Day2()
        val input = """
            1-3 a: aaa"
            1-3 c: bbb"
        """.trimIndent()

        val res = sut.consolidate(input, AlgorithmType.FIRST)

        assertEquals(1, res)
    }

    @Test
    fun `consolidate-AlgorithmType_FIRST - can consolidate multiple line with invalid passwords`() {
        val sut = Day2()
        val input = """
            1-3 b: aaa"
            1-3 c: bbb"
        """.trimIndent()

        val res = sut.consolidate(input, AlgorithmType.FIRST)

        assertEquals(0, res)
    }

    @Test
    fun `consolidate-AlgorithmType_SECOND - can consolidate single line with valid password`() {
        val sut = Day2()
        val input = "1-3 a: abc"

        val res = sut.consolidate(input, AlgorithmType.SECOND)

        assertEquals(1, res)
    }

    @Test
    fun `consolidate-SECOND - can consolidate multiple line with valid passwords`() {
        val sut = Day2()
        val input = """
            1-3 a: abc"
            1-3 c: abc"
        """.trimIndent()

        val res = sut.consolidate(input, AlgorithmType.SECOND)

        assertEquals(2, res)
    }
}