fun main() {
    print("Калорийность 100г: ")
    val calories = readLine()?.toDoubleOrNull() ?: 0.0
    print("Вес (г): ")
    val weight = readLine()?.toDoubleOrNull() ?: 0.0

    val food = Food(calories, weight)
    println("\nИнформация о базовом продукте: ${food.getFoodInfo()}")
    println("Общая калорийность: ${food.calculateTotalCalories()} ккал\n")

    print("Калорийность 100г (для продукта с витамином С): ")
    val caloriesVC = readLine()?.toDoubleOrNull() ?: 0.0
    print("Вес (г) (для продукта с витамином С): ")
    val weightVC = readLine()?.toDoubleOrNull() ?: 0.0
    print("Витамин C в 1г (мг): ")
    val vitaminC = readLine()?.toDoubleOrNull() ?: 0.0

    val vitaminCFood = VitaminCFood(caloriesVC, weightVC, vitaminC)
    println("\nИнформация о продукте с витамином C: ${vitaminCFood.getFoodInfo()}")
    println("Общая калорийность: ${vitaminCFood.calculateTotalCalories()} ккал")
    println("Общее количество витамина C: ${vitaminCFood.calculateTotalVitaminC()} мг")
}

open class Food(val caloriesPer100g: Double, val weightInGrams: Double) {
    init {
        require(caloriesPer100g >= 0) { "Калорийность должна быть неотрицательной" }
        require(weightInGrams >= 0) { "Вес должен быть неотрицательным" }
    }

    open fun getFoodInfo(): String {
        return "Калорийность 100г: $caloriesPer100g ккал, Вес: $weightInGrams г"
    }

    fun calculateTotalCalories(): Double {
        return caloriesPer100g * weightInGrams / 100
    }
}

class VitaminCFood(caloriesPer100g: Double, weightInGrams: Double, val vitaminCPerGram: Double) : Food(caloriesPer100g, weightInGrams) {
    init {
        require(vitaminCPerGram >= 0) { "Количество витамина С должно быть неотрицательным" }
    }

    fun calculateTotalVitaminC(): Double {
        return vitaminCPerGram * weightInGrams
    }

    override fun getFoodInfo(): String {
        return "${super.getFoodInfo()}, Витамин С/г: $vitaminCPerGram мг"
    }
}

