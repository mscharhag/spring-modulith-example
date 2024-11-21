package de.ruv.demo.order

import de.ruv.demo.inventory.service.InventoryService
import de.ruv.demo.inventory.service.InventoryServiceImpl
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class OrderService(
//    private val inventoryService: InventoryService
    private val events: ApplicationEventPublisher
) {

    @Transactional
    fun placeOrder(order: Order) {
//        for (item in order.items) {
//            inventoryService.reduceStock(item.productId, item.quantity)
//        }
        println("pre publish")
        events.publishEvent(OrderCompleted(order))
        println("post publish")
    }

    data class OrderCompleted(
        val order: Order
    )
}