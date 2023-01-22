fun main() {
    val amount1 = 5000.0
    val amount2 = 10000.0
    val amount3 = 200.0
    val amount4 = 100_000.0
    println("Цена для Вас: ${amount3 - calculateFee("MasterCard", amount1, amount3)} руб.")
    println("Цена для Вас: ${amount3 - calculateFee("Maestro", amount2, amount3)} руб.")
    println("Цена для Вас: ${amount3 - calculateFee("VK Pay", amount2, amount3)} руб.")
    println("Цена для Вас: ${amount3 - calculateFee("MasterCard", amount4, amount3)} руб.")
    println("Цена для Вас: ${200_000 - calculateFee("Мир", amount4, 200_000.0)} руб.")
}

fun calculateFee(cardType: String, PreviousMoneyTransfers: Double, currentTransfer: Double): Double {
    return when (cardType) {
        "Visa", "Мир" -> if (0.0075 * currentTransfer < 35.0) {
            35.0
        } else {
            0.0075 * currentTransfer
        }

        "MasterCard", "Maestro" -> if (PreviousMoneyTransfers + currentTransfer >= 75000) {
            0.006 * currentTransfer + 20
        } else 0.0

//        "VK Pay" -> 0.0
        else -> 0.0
    }
}