object Fibonacci {
  // Recursive function to calculate the nth Fibonacci number
  def fibonacci(n: Int): Int = n match {
    case 0 => 0
    case 1 => 1
    case _ => fibonacci(n - 1) + fibonacci(n - 2)
  }

  // print the first n Fibonacci numbers
  def printFibonacci(n: Int): Unit = {
    for (i <- 0 until n) {
      println(fibonacci(i))
    }
  }

  def main(args: Array[String]): Unit = {
    println("Enter the value of n:")
    val n = scala.io.StdIn.readInt()
    println(s"The first $n Fibonacci numbers are:")
    printFibonacci(n)
  }
}
