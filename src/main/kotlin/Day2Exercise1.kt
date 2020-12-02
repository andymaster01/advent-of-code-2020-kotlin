data class StringParsedResult(
    val isValid: Boolean,
    val min: Int,
    val max: Int,
    val letter: Char,
    val password: String
)

class Day2Exercise1 {
    fun parseString(input: String): StringParsedResult {

        if (input.isEmpty())
            return StringParsedResult(false, 0, 0, ' ', "")

        val parts = input.split(" ")

        val nums = parts[0].split("-")

        val letter = parts[1].split(":")

        return StringParsedResult(true, nums[0].toInt(), nums[1].toInt(), letter[0].single(), parts[2])
    }

    fun isValidPassword(input: StringParsedResult): Boolean {

        var cnt = 0

        for (item in input.password) {
            if (item == input.letter) {
                cnt++
            }
        }

        return cnt >= input.min && cnt <= input.max
    }

    fun consolidate(input: String): Int {

        val parts = input.lines()
        var cnt = 0

        for (item in parts){
            val p = parseString(item)
            val r = isValidPassword(p)

            cnt += (if (r) 1 else 0)
        }

        return cnt
    }
}
