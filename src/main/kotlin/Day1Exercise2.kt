class Day1Exercise2 {
    fun calculate(input: List<Int>, pivot: Int): Int {
        if (input.size < 3)
            return -1

        for (x in input.indices) {
            for (y in (x + 1) until input.size) {
                for (z in (y + 1) until input.size) {
                    if (input[x] + input[y] + input[z] == pivot)
                        return input[x] * input[y] * input[z]
                }
            }

        }
        return -1
    }
}