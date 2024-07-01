import scala.io.StdIn.readLine

object meanValue{
    def main (arrgs : Array[String]): Unit = {
        println("Enter numbers separated by spaces:")
        val numbers = readLine().split(" ").map(_.toInt).toList
        val sum = SumOfEven(numbers)
        println(s"The sum of even numbers is: $sum")
    }
    
    def SumOfEven(numbers:List[Int]): Int = {
        def sumOfEvens(numbers: List[Int]): Int = {
            numbers.filter(_ % 2 == 0).sum
        }
    }
}