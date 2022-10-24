fun main() {
    do {
        println("\nInsira um valor máximo:")
        val num : Int = readln().trim().replace(" ", "").toInt()

        if (num > 46349) {
            println("Valor muito alto, tente inserir um valor menor que 46.349")
        } else {
            val primos = crivo(num)
            println("\nNúmeros primos da lista do valor máximo $num:")
            mostrar(primos)
        }
        println("\n\nDigite \"s\" para inserir outro valor ou qualquer caractere para encerrar o programa.")
        val opt = readln().lowercase()
    }while (opt == "s")
}

private fun mostrar(primos: BooleanArray) {
    for (i in 2 until primos.size) {
        if (primos[i]) {
            print("$i ")
        }
    }
}

private fun crivo(n: Int): BooleanArray {
    val primos = BooleanArray(n + 1)

    for (i in 2 until n) primos[i] = true

    for (i in 2..n) {
        if (primos[i]) {
            var ii = i
            while (i * ii < n) {
                primos[i * ii] = false
                ii++
            }
        }
    }
    return primos
}
