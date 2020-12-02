fun main() {

    println("Day 1")
    println("\tExercise 1: ${Day1().calculateFirst(getDay1Dataset(), 2020)}")
    println("\tExercise 2: ${Day1().calculateSecond(getDay1Dataset(), 2020)}")
    println("")

    println("Day 2")
    println("\tExercise 1: ${Day2().consolidate(getDay2Dataset(), Day2.AlgorithmType.FIRST)}")
    println("\tExercise 2: ${Day2().consolidate(getDay2Dataset(), Day2.AlgorithmType.SECOND)}")
    println("")
}

