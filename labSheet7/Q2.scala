object SquareNumber {
    def calculateSquare(numbers: List[Int]) :List[Int] = {
        numbers.map(num => num*num)
    }

    def main(args: Array[String]):Unit = {
        val input = List(1,2,3,4,5,6,7,8,9,10)
        val squares = calculateSquare(input)
        println(squares)
    }
}

