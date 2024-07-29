object InventoryManagement {
  case class Product(id: Int, name: String, quantity: Int, price: Double)

  val inventory1: Map[Int, Product] = Map(
    1 -> Product(101, "ProductA", 10, 1000.00),
    2 -> Product(102, "ProductB", 5, 2000.00),
    3 -> Product(103, "ProductC", 15, 3000.00)
  )

  val inventory2: Map[Int, Product] = Map(
    2 -> Product(102, "ProductB", 10, 2500.00),
    4 -> Product(104, "ProductD", 5, 3500.00)
  )

  def retrieveAllProductNames(inventory: Map[Int, Product]): List[String] = {
    inventory.values.map(_.name).toList
  }

  
  def calculateTotalValue(inventory: Map[Int, Product]): Double = {
    inventory.values.map(product => product.quantity * product.price).sum
  }

  
  def isInventoryEmpty(inventory: Map[Int, Product]): Boolean = {
    inventory.isEmpty
  }

 
  def mergeInventories(inventory1: Map[Int, Product], inventory2: Map[Int, Product]): Map[Int, Product] = {
    inventory2.foldLeft(inventory1) { (acc, kv) =>
      val (id, product2) = kv
      acc.get(id) match {
        case Some(product1) =>
          acc + (id -> product1.copy(
            quantity = product1.quantity + product2.quantity,
            price = math.max(product1.price, product2.price)
          ))
        case None =>
          acc + (id -> product2)
      }
    }
  }

  
  def checkProductExists(inventory: Map[Int, Product], productId: Int): Unit = {
    inventory.get(productId) match {
      case Some(product) => println(s"Product found: $product")
      case None => println(s"Product with ID $productId does not exist.")
    }
  }

  def main(args: Array[String]): Unit = {
    
    val productNames = retrieveAllProductNames(inventory1)
    println("Product names in inventory1: " + productNames)

    
    val totalValue = calculateTotalValue(inventory1)
    println("Total value of inventory1: " + totalValue)

    
    val isEmpty = isInventoryEmpty(inventory1)
    println("Is inventory1 empty? " + isEmpty)

    
    val mergedInventory = mergeInventories(inventory1, inventory2)
    println("Merged inventory: " + mergedInventory)

    
    checkProductExists(inventory1, 2)
  }
}

object Main extends App {
  InventoryManagement.main(Array())
}
