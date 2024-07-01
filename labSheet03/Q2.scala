import scala.io.StdIn.readLine

object GetListString{
    def main (arrgs: Array[String]):Unit = {
        println("Enter strings, one per line. Enter an empty line to finish.")
        val strings = Iterator.continually(readLine()).takeWhile(_.nonEmpty).toList
        println("You entered the following strings:")
        strings.foreach(println)

        println("Strings longer than 5 characters:")
        strings.filter(_.length >5).foreach(println)
    }
}