package de.ruv.demo.inventory.service

import org.springframework.modulith.NamedInterface

@NamedInterface
interface InventoryService {
    fun getStockInfo()
    fun reduceStock(productId: Int, quantity: Int)
}