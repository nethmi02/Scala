object NameFormatter {
  //convert a string to uppercase
  def toUpper(name: String): String = name.toUpperCase

  //convert a string to lowercase
  def toLower(name: String): String = name.toLowerCase

  //format names based on the function passed
  def formatNames(name: String)(formatter: String => String): String = formatter(name)

  def main(args: Array[String]): Unit = {
    println(formatNames("Benny")(toUpper))
    println(formatNames("Niroshan")(name => name.substring(0, 1).toUpperCase + name.substring(1).toLowerCase))
    println(formatNames("Saman")(toLower))
    println(formatNames("Kumara")(name => name.substring(0, name.length - 1).toLowerCase + name.substring(name.length - 1).toUpperCase))
  }
}