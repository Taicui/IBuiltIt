package models

enum class InventorySize(val pageInventory: Int) {
    fun getWidth(): Int{
        return 100;
    }

}