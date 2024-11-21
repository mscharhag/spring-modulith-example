package de.ruv.demo.inventory.service

import de.ruv.demo.order.OrderService
import de.ruv.demo.order.OrderService.OrderCompleted
import de.ruv.demo.shared.SharedUtil
import org.springframework.context.event.EventListener
import org.springframework.modulith.events.ApplicationModuleListener
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.event.TransactionalEventListener

@Component
class InventoryServiceImpl : InventoryService {

    override fun getStockInfo() {
        SharedUtil.usefulUtility()
    }

    override fun reduceStock(productId: Int, quantity: Int) {
        //TODO("Not yet implemented")
        println("updating stock $productId")
    }

//    @Async
//    @TransactionalEventListener
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @ApplicationModuleListener
//    @EventListener
    fun onOrderCompleted(orderCompleted: OrderCompleted) {
        println("updating stock")
    }
}