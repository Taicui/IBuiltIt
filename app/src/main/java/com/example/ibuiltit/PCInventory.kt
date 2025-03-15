package com.example.ibuiltit
// Class to represent a PC part
data class PCPart(
    val name: String,
    val brand: String,
    val model: String,
    val socket: String,
    val quantity: Int = 0,
    val description: String = ""  // Description field
)

class PCInventory// Constructor to initialize inventory with a list of initial parts (optional)
    (initialParts: List<PCPart> = emptyList()) {
    // A mutable map to store PC parts and their quantities
    private val inventory = mutableMapOf<String, PCPart>()

    init {
        for (part in initialParts) {
            inventory[part.name] = part
        }
    }

    // Method to add a specified quantity of a PC part to the inventory
    fun addPart(name: String, brand: String, model: String, socket: String, quantity: Int, description: String) {
        if (quantity <= 0) {
            println("Quantity must be positive.")
            return
        }
        val currentPart = inventory[name]
        if (currentPart != null) {
            // Update the quantity of an existing part
            inventory[name] = currentPart.copy(quantity = currentPart.quantity + quantity)
        } else {
            // Add new part to inventory with the description
            inventory[name] = PCPart(name, brand, model, socket, quantity, description)
        }
        println("$quantity $name(s) added to inventory.")
    }

    // Method to remove a specified quantity of a PC part from the inventory
    fun removePart(name: String, quantity: Int) {
        val currentPart = inventory[name]
        if (currentPart != null) {
            if (currentPart.quantity >= quantity) {
                // Update the quantity of the part
                inventory[name] = currentPart.copy(quantity = currentPart.quantity - quantity)
                println("$quantity $name(s) removed from inventory.")
            } else {
                println("Not enough $name in inventory to remove.")
            }
        } else {
            println("$name not found in inventory.")
        }
    }

    // Method to view the inventory
    fun viewInventory() {
        if (inventory.isEmpty()) {
            println("Inventory is empty.")
        } else {
            println("Current inventory:")
            for ((name, part) in inventory) {
                println("${part.name} (Brand: ${part.brand}, Model: ${part.model}, Socket: ${part.socket}): ${part.quantity}")
                if (part.description.isNotEmpty()) {
                    println("  Description: ${part.description}")
                }
            }
        }
    }
}
