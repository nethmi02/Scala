import scala.io.StdIn.readLine

object InventoryManagement{
    def main (args: Array[String]): Unit = {
        val productList = getProductList()
        println("\nProduct List:")
        printProductList(productList)
        println(s"Total number of products: ${getTotalProducts(productList)}")

    }

    def getProductList(): List[String] = {
        var products: List[String] = List()
        var input: String = ""

        println("Enter the product names (type 'done' when finished):")

        while (input != "done"){
            input = readLine()
            if (input != "done" && input.nonEmpty){
                products = products :+ input
            }
        }

        return products
    }

    def printProductList(products: List[String]): Unit = {
    for (i <- products.indices) {
        println(s"${i+1}.${products(i)}")
        }
    }

    def getTotalProducts(products: List[String]): Int={
        products.size
    }


}