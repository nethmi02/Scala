object labSheet {
  def main(args: Array[String]): Unit = {
    println("Calculate the area of a disk" + " => " + calculateArea(5))
    println(" Convert temperature into Fahrenheit" + " => " + calculateTemp(35))
    println("Calculate volume of a sphere" + " => " + calculatevolume(5))
    println("cost for books" + " => " + calculateBookPrice(24.95,60))
    println("Total Running Time " + " => " + RunningTime(2,3,2))

    
  }

  def calculateArea(r: Int): Double = {
    val area: Double = math.Pi * r * r
    area
  }

  def calculateTemp(temp: Int):Double = {
    val F : Double = temp * 1.8 + 32.0
    F
  }

  def calculatevolume(r: Int):Double ={
    val volume : Double = (4 * math.Pi * r * r * r) / 3
    volume
  }

  def calculateBookPrice(price: Double, count : Int ) : Double = {
    val discountForBook : Double = (price * 40 ) / 100
    val BookPriceAfterDis : Double = (price - discountForBook)*60
    
    val shipping: Double = if (count <= 50){
        count * 3 
    }
    else {
        (50*3) + ((count -50) * 0.75)
    }

    val totalPrice : Double = BookPriceAfterDis + shipping
    totalPrice
  }

  def RunningTime(d1:Int , d2:Int , d3: Int) : Int = {
    val R1 : Int = d1 * 8
    val R2 : Int = d2 * 7
    val R3 : Int = d3 * 8

    val totalRunningTime : Int = R1 +R2+R3
    totalRunningTime
  }
}
