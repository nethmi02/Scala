import scala.io.StdIn.readLine

object meanValue{
    def main (arrgs : Array[String]): Unit = {
        println("Enter 2 numbers, one per line.")
        val num1 = readLine().toInt
        val num2 = readLine().toInt
        val mean = CalculateMean(num1,num2)
        println(f"Mean: $mean%.2f")
    }

    def CalculateMean(num1: Int, num2: Int): Double = {
        (num1 + num2) / 2.0
    }

}