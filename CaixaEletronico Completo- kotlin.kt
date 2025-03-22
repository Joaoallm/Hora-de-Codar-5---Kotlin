import kotlin.system.exitProcess

var saldo = 100.5 // Float
var senha = 3589
var nome : String = ""
fun main() {
    inicio()

}


fun inicio() {
    println("Qual o seu nome?")
     nome = readln()

    println("Olá, $nome, é um prazer ter voce aqui!")
    opcoes()
}
fun opcoes () {

    while (true) {
        println(
            """ 
                Escolha uma opção: 
                1. Ver Saldo  
                2. Extrato
                3. Fazer saque
                4. Deposito
                5. Transferencia
                6. Sair 

                """.trimIndent()
        )

        val escolha = readLine()?.toIntOrNull()

        when (escolha) {
            1 -> verSaldo()
            2 -> verExtrato()
            3 -> fazerSaque()
            4 -> fazerDeposito()
            5 -> transferencia()
            6 -> sair()
            else -> erro()
        }
    }
}
fun senha(){
    println("Informe a senha: ")
    senha = readln().toInt()
    if (senha != 3589){
        println("Senha incorreta, tente novamente")
        senha()
    }
}
fun verSaldo() {
    senha()
    println("Seu saldo atual é: $saldo")
    opcoes()
}

fun fazerDeposito() {
    while (true) {
        print("Qual o valor para depósito? ")
        val deposito = readLine()?.toFloatOrNull()

        if (deposito == null || deposito <= 0) {
            println("Por favor, informe um número válido.")
        } else {
            saldo += deposito
            println("Deposito realizado com sucesso")
            break
        }
    }
    opcoes()
}
fun fazerSaque() {
    senha()
    while (true) {
        print("Qual o valor para saque? ")
        val saque = readln().toFloatOrNull()

        // Verifica se o valor é inválido (nulo ou menor/igual a 0)
        if (saque == null || saque <= 0.0) {
            println("Operação não autorizada. Por favor, insira um valor válido e positivo.")
        }
        // Verifica se o valor do saque é maior que o saldo disponível
        else if (saque > saldo) {
            println("Operação não autorizada. Saldo insuficiente.")
        }
        // Realiza o saque se todas as condições forem atendidas
        else {
            saldo -= saque
            println("Saque realizado com sucesso! Seu saldo atual é: R$%.2f".format(saldo))
            break // Sai do loop após saque bem-sucedido
        }
    }
    opcoes() // Volta ao menu principal
}

fun verExtrato(){
    senha()
    println("Compra pix - R$500,00 - Compra do mês\n Compra pix - R$150,00 - Camisa esportiva")
    opcoes()
}
fun transferencia() {
    senha()
    println("Informe uma conta para fazer a transferência: ")
    var conta = readln().toIntOrNull()

    while (conta == null) {
        println("Erro. Somente números válidos: ")
        conta = readln().toIntOrNull()
    }

    println("Informe o valor para transferência: ")
    var valor = readln().toFloatOrNull()

    while (valor == null || valor <= 0 || valor > saldo) {
        if (valor == null) {
            println("Erro. Informe um valor válido: ")
        } else if (valor <= 0) {
            println("Operação não autorizada, o valor deve ser maior que zero: ")
        } else if (valor > saldo) {
            println("Operação não autorizada, saldo insuficiente. Informe outro valor: ")
        }
        valor = readln().toFloatOrNull()
    }

    saldo -= valor
    println("Transferência realizada com sucesso!")
    println("Seu saldo atual é: $saldo")
    opcoes()
}

fun erro() {
    println("Por favor, informe um número entre 1 e 6.")
    opcoes()
}

fun sair() {
    print("Você deseja sair? (s/n) ")
    val confirma = readln()
    if (confirma == "s") {
        println("$nome, foi um prazer ter você aqui")
        exitProcess(0)
    }

    else if (confirma == "n") {
        opcoes()
    }
}