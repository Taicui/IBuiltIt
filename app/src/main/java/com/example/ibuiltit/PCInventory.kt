package com.example.ibuiltit

// Define the Singleton for PCInventory
object PCInventory {
    private val inventory = mutableMapOf<String, PCPart>()

    // You can add or remove parts as before
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
    }

    fun removePart(name: String, quantity: Int) {
        val currentPart = inventory[name]
        if (currentPart != null) {
            if (currentPart.quantity >= quantity) {
                inventory[name] = currentPart.copy(quantity = currentPart.quantity - quantity)
                println("$quantity $name(s) removed from inventory.")
            } else {
                println("Not enough $name in inventory to remove.")
            }
        } else {
            println("$name not found in inventory.")
        }
    }

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