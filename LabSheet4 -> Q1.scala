object InventoryManagementSystem {
    var itemNames = Array("Apple", "Banana", "Orange", "Mango")
    var itemQuantity = Array(10, 20, 30, 40)

    def main(args: Array[String]): Unit = {
        displayInventory()
        restockItem("Banana", 15)
        displayInventory()
        sellItem("Mango", 5)
        displayInventory()
        sellItem("Pineapple", 3) 
        sellItem("Banana", 50) 
    }

    def displayInventory(): Unit = {
        println("Current Inventory:")
        for (i <- itemNames.indices) {
            println(s"${itemNames(i)}: ${itemQuantity(i)}")
        }
        println()
    }

    def restockItem(itemName: String, quantity: Int): Unit = {
        val index = itemNames.indexOf(itemName)
        if (index != -1) {
            itemQuantity(index) += quantity
            println(s"Restocked $itemName with $quantity units.")
        } else {
            println(s"Item $itemName does not exist.")
        }
    }

    def sellItem(itemName: String, quantity: Int): Unit = {
        val index = itemNames.indexOf(itemName)
        if (index != -1) {
            if (itemQuantity(index) >= quantity) {
                itemQuantity(index) -= quantity
                println(s"Sold $quantity units of $itemName.")
            } else {
                println(s"Not enough $itemName in stock to sell $quantity units.")
            }
        } else {
            println(s"Item $itemName does not exist.")
        }
    }
}
