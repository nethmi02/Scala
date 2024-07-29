import scala.io.StdIn.readLine
import scala.util.Try

object StudentRecords {

 
  def validateInput(name: String, marks: Int, totalMarks: Int): (Boolean, Option[String]) = {
    if (name.isEmpty) {
      (false, Some("Name cannot be empty."))
    } else if (marks < 0 || totalMarks < 0) {
      (false, Some("Marks and total possible marks must be positive integers."))
    } else if (marks > totalMarks) {
      (false, Some("Marks cannot exceed total possible marks."))
    } else {
      (true, None)
    }
  }

  
  def calculatePercentageAndGrade(marks: Int, totalMarks: Int): (Double, Char) = {
    val percentage = (marks.toDouble / totalMarks) * 100
    val grade = percentage match {
      case p if p >= 90 => 'A'
      case p if p >= 75 => 'B'
      case p if p >= 50 => 'C'
      case _ => 'D'
    }
    (percentage, grade)
  }

  
  def getStudentInfo(): (String, Int, Int) = {
    println("Enter student's name:")
    val name = readLine()

    println("Enter student's marks:")
    val marks = Try(readLine().toInt).getOrElse(-1)

    println("Enter total possible marks:")
    val totalMarks = Try(readLine().toInt).getOrElse(-1)

    (name, marks, totalMarks)
  }

  
  def getStudentInfoWithRetry(): (String, Int, Int, Double, Char) = {
    var valid = false
    var studentInfo: (String, Int, Int, Double, Char) = null

    while (!valid) {
      val (name, marks, totalMarks) = getStudentInfo()
      val (isValid, errorMessage) = validateInput(name, marks, totalMarks)

      if (isValid) {
        val (percentage, grade) = calculatePercentageAndGrade(marks, totalMarks)
        studentInfo = (name, marks, totalMarks, percentage, grade)
        valid = true
      } else {
        println(s"Invalid input: ${errorMessage.get}")
      }
    }
    studentInfo
  }

  
  def printStudentRecord(student: (String, Int, Int, Double, Char)): Unit = {
    val (name, marks, totalMarks, percentage, grade) = student
    println(s"Student Name: $name")
    println(s"Marks: $marks / $totalMarks")
    println(f"Percentage: $percentage%.2f%%")
    println(s"Grade: $grade")
  }

  def main(args: Array[String]): Unit = {
    val studentInfo = getStudentInfoWithRetry()
    printStudentRecord(studentInfo)
  }
}

object Main extends App {
  StudentRecords.main(Array())
}
