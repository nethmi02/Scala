import scala.io.StdIn.readLine

object recursive {
    def main(args: Array[String]): Unit = {
        println("Enter a string to reverse:")
        val string = readLine()
        val reversed = reverseString(string)
        println(reversed)
    }

    def reverseString(string: String): String = {
        if (string.isEmpty) { 
            string
        } else {
            reverseString(string.tail) + string.head
        }
    }
}