package de.ruv.demo.order

class Order(
    val items: List<OrderItem>
) {
    class OrderItem(
        val productId: Int,
        val quantity: Int
    )
}