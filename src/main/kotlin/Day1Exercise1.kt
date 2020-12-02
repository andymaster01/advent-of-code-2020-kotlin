class Day1Exercise1 {
    fun calculate(input: List<Int>, pivot: Int): Int {
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
}