class Day2 {

    data class StringParsedResult(
        val min: Int,
        val max: Int,
        val letter: Char,
        val password: String
    )

    enum class AlgorithmType {
        FIRST, SECOND
    }


    fun parseString(input: String): Pair<Boolean, StringParsedResult> {

        if (input.isEmpty())
            return Pair(false, StringParsedResult(0, 0, ' ', ""))

        val parts = input.split(" ")

        val nums = parts[0].split("-")

        val letter = parts[1].split(":")

        return Pair(true, StringParsedResult(nums[0].toInt(), nums[1].toInt(), letter[0].single(), parts[2]))
    }

    fun isValidPasswordFirstTake(input: StringParsedResult): Boolean {

        var cnt = 0

        for (item in input.password) {
            if (item == input.letter) {
                cnt++
            }
        }

        return cnt >= input.min && cnt <= input.max
    }

    fun isValidPasswordSecondTake(input: StringParsedResult): Boolean {

        val x = input.password[input.min - 1] == input.letter

        val y = input.password[input.max - 1] == input.letter

        return x.xor(y)
    }

    fun consolidate(input: String, method: AlgorithmType): Int {

        val parts = input.lines()
        var cnt = 0

        for (item in parts) {
            val p = parseString(item)

            if(!p.first) continue

            val r = if (method == AlgorithmType.FIRST)
                        isValidPasswordFirstTake(p.second)
                    else
                        isValidPasswordSecondTake(p.second)

            cnt += (if (r) 1 else 0)
        }

        return cnt
    }
}
