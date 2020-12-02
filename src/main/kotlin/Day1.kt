class Day1 {
    fun calculateFirst(input: List<Int>, pivot: Int): Int {
        if(input.size < 2)
            return -1

        for(i in input.indices){
            for (y in (i+1) until input.size){
                if(input[i] + input[y] == pivot)
                    return input[i] * input[y]
            }
        }

        return -1
    }

    fun calculateSecond(input: List<Int>, pivot: Int): Int {
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