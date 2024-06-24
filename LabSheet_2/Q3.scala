object lab {
  def main(args: Array[String]): Unit = {
    val normalHourlyRate: Int = 250
    val otHourlyRate: Int = 85
    val taxRate: Double = 0.12  

    val normalHoursWorked: Int = 40
    val otHoursWorked: Int = 30

    
    println(f"Take-home Salary:" + salary(normalHourlyRate, otHourlyRate, taxRate, normalHoursWorked, otHoursWorked) )
  }

  def salary(normalHourlyRate: Int, otHourlyRate: Int, taxRate: Double, normalHoursWorked: Int, otHoursWorked: Int): Double = {
    val totalEarnings: Double = (normalHoursWorked * normalHourlyRate) + (otHoursWorked * otHourlyRate)
    val tax: Double = totalEarnings * taxRate
    val netSalary: Double = totalEarnings - tax
    netSalary
  }
}
