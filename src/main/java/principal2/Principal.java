package principal2;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) { // Usando try-with-resources para fechar o scanner
            Conversor conversor = new Conversor("EXTENDED_RATE_API_KEY"); // Sua chave de API

            while (true) {
                // Exibir o menu
                String menu = """
                        ** Digite sua opção para **
                        1- Dólar - Peso Argentino
                        2- Peso Argentino - Dólar
                        3- Dólar - Real Brasileiro
                        4- Real Brasileiro - Dólar
                        5- Dólar - Peso Colombiano
                        6- Peso Colombiano - Dólar
                        7- Sair
                        """;
                System.out.println(menu);

                // Ler a opção do usuário
                int opcao = scanner.nextInt();

                if (opcao == 7) {
                    System.out.println("Saindo...");
                    break; // Sair do loop
                }

                // Ler o valor a ser convertido
                System.out.print("Digite o valor a ser convertido: ");
                double valor = scanner.nextDouble();
                double resultado = 0;

                // Lógica de conversão com base na opção escolhida
                try {
                    switch (opcao) {
                        case 1:
                            resultado = conversor.converterDolarParaPesoArgentino(valor);
                            System.out.println(valor + " dólares equivalem a " + resultado + " pesos argentinos.");
                            break;
                        case 2:
                            resultado = conversor.converterPesoArgentinoParaDolar(valor);
                            System.out.println(valor + " pesos argentinos equivalem a " + resultado + " dólares.");
                            break;
                        case 3:
                            resultado = conversor.converterDolarParaReal(valor);
                            System.out.println(valor + " dólares equivalem a " + resultado + " reais.");
                            break;
                        case 4:
                            resultado = conversor.converterRealParaDolar(valor);
                            System.out.println(valor + " reais equivalem a " + resultado + " dólares.");
                            break;
                        case 5:
                            resultado = conversor.converterDolarParaPesoColombiano(valor);
                            System.out.println(valor + " dólares equivalem a " + resultado + " pesos colombianos.");
                            break;
                        case 6:
                            resultado = conversor.converterPesoColombianoParaDolar(valor);
                            System.out.println(valor + " pesos colombianos equivalem a " + resultado + " dólares.");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao realizar a conversão: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao ler a entrada: " + e.getMessage());
        }
    }
}