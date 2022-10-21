// função principal
fun main() {
    do {
        println("\nInsira um valor máximo:")
        // recebe o valor do usuário corta espaços em branco e converte para int
        val num : Int = readln().trim().replace(" ", "").toInt()

        // Se num for maior que 46349 (valor máximo que testei sem que apresente erro)
        if (num > 46349) {
            // Mostra no console que o valor é muito alto
            println("Valor muito alto, tente inserir um valor menor que 46.349")
        } else {
            // passa para a constante primos o retorno do método crivo com o parâmetro "num", que foi inserido pelo usuário
            val primos = crivo(num)
            // chama o método para mostrar os números no console
            println("\nNúmeros primos da lista do valor máximo $num:")
            mostrar(primos)
        }
        // Pergunta ao usuário se ele deseja inserir outro valor
        println("\n\nDigite \"s\" para inserir outro valor ou qualquer caractere para encerrar o programa.")
        // Recebe a opção do usuário e converte para lowercase caso ele digite "S"
        val opt = readln().lowercase()
        // Enquanto a opção do usuário for "s" execute o programa
    }while (opt == "s")
}

// método que ignora os números 0 e 1 para mostrar os números primos
// recebe como parâmetro um Array Booleano
private fun mostrar(primos: BooleanArray) {
    // por cada valor de 2 até o tamanho máximo do array
    for (i in 2 until primos.size) {
        // se o valor de primo for verdadeiro, ou seja, retorna apenas os valores "true" do array (números primos)
        if (primos[i]) {
            // então mostra esses valores
            print("$i ")
        }
    }
}

// método que faz a verificação de números primos
// recebe um número, nesse caso, o valor inserido pelo usuário
// e retorna um Array Booleano
private fun crivo(n: Int): BooleanArray {
    // criando um Array Booleano com tamanho do número do usuário + 1, porque o array tem como primeiro índice o valor 0
    // portanto se o número inserido fosse 10, o seu valor máximo seria 9, mesmo tendo 10 itens.
    val primos = BooleanArray(n + 1)

    // por cada valor, partindo do 2 até o valor anterior do valor máximo do array (Por que o valor máximo seria 11 se o usuário inserisse o valor 10, por exemplo)
    // defina cada valor como true, ou seja, até esse ponto do código, todos os valores são primos exceto 0 e 1
    // equivalente a i >= 2 && i < n
    for (i in 2 until n) primos[i] = true

    // por cada valor, partindo de 2 até o valor máximo inserido pelo usuário
    // equivalente a i >= 2 && i <= n
    for (i in 2..n) {
        // se os valores primos forem true (retorna apenas o valores de 2 até o número inserido pelo usuário)
        if (primos[i]) {
            // criando uma variável equivalente ao valor de i para verificar os múltiplos de cada número do array
            var ii = i
            // enquanto o produto de i * ii for menor que o valor máximo
            while (i * ii < n) {
                // esses produtos, ou seja, os múltiplos de i, serão definidos como falso
                // por exemplo: os múltiplos de 2 (4, 6, 8, 10...) não são primos, portanto devem ser declarados como false
                primos[i * ii] = false
                // vai para o próximo valor de ii para repetir o while e receber o próximo valor de i.
                ii++
            }
        }
    }
    // retorna o array devidamente processado com os números primos
    return primos
}
