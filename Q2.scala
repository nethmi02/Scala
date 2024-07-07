import scala.io.StdIn

object ArrayInputPatternMatching {
    def main(args: Array[String]): Unit = {
        println("Please enter a list of integers separated by spaces:")
        val inputString = StdIn.readLine()
        val intArray = inputString.split(" ").map(_.toInt)

        intArray.foreach { input =>
            input match {
                case x if x <= 0 => println(s"$x: Negative/Zero in input")
                case x if x % 2 == 0 => println(s"$x: Even number is given")
                case x => println(s"$x: Odd number is given")
            }
        }
    }
}