fun main() {
    print("Введите тип кабеля: ")
    val type = readLine() ?: ""
    print("Введите количество жил: ")
    val numStrands = readLine()?.toIntOrNull() ?: 1
    print("Введите диаметр (мм): ")
    val diameter = readLine()?.toDoubleOrNull() ?: 1.0

    val cable = Cable(type, numStrands, diameter)
    println("\nИнформация о кабеле:")
    println(cable.getCableInfo())

    print("\nВведите тип бронированного кабеля: ")
    val typeArmored = readLine() ?: ""
    print("Введите количество жил: ")
    val numStrandsArmored = readLine()?.toIntOrNull() ?: 1
    print("Введите диаметр (мм): ")
    val diameterArmored = readLine()?.toDoubleOrNull() ?: 1.0
    print("Есть оплетка? (true/false): ")
    val hasArmor = readLine()?.toBooleanStrictOrNull() ?: false

    val armoredCable = ArmoredCable(typeArmored, numStrandsArmored, diameterArmored, hasArmor)
    println("\nИнформация о бронированном кабеле:")
    println(armoredCable.getCableInfo())
}
open class Cable(val type: String, val numStrands: Int, val diameter: Double) {
    init {
        require(numStrands > 0) { "Количество жил должно быть больше 0" }
        require(diameter > 0) { "Диаметр должен быть больше 0" }
    }

    open fun calculateQuality(): Double {
        return diameter / numStrands
    }

    open fun getCableInfo(): String {
        return "Тип: $type, Количество жил: $numStrands, Диаметр: $diameter мм, Качество (Q): ${calculateQuality()}"
    }
}

class ArmoredCable(type: String, numStrands: Int, diameter: Double, val hasArmor: Boolean) : Cable(type, numStrands, diameter) {
    override fun calculateQuality(): Double {
        return if (hasArmor) {
            2 * super.calculateQuality()
        } else {
            0.7 * super.calculateQuality()
        }
    }

    override fun getCableInfo(): String {
        return "${super.getCableInfo()}, Наличие оплетки: ${if (hasArmor) "Есть" else "Нет"}, Качество (Qp): ${calculateQuality()}"
    }
}


