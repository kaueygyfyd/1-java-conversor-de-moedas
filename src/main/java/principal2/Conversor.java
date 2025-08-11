package principal2;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

//.....

import java.io.IOException;

public class Conversor {
    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD"; // Exemplo de URL
    private String apiKey; // Sua chave de API

    public Conversor(String apiKey) {
        this.apiKey = apiKey;
    }

    public double obterTaxaDeCambio(String moeda) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(API_URL + "?access_key=" + apiKey) // Adicionando a chave de API na URL
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Erro na requisição: " + response);
            }

            String jsonResponse = response.body().string();
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonResponse, JsonObject.class);
            return jsonObject.getAsJsonObject("rates").get(moeda).getAsDouble(); // Obtendo a taxa da moeda desejada
        }
    }

    public  double converterDolarParaPesoArgentino(double valorDolar) throws IOException {
        double taxaDeCambio = obterTaxaDeCambio("ARS"); //Dólar para Peso Argentino
        return valorDolar * taxaDeCambio;
    }

    public double converterPesoArgentinoParaDolar(double valorPesoArgentino) throws IOException {
        double taxaDeCambio = obterTaxaDeCambio("ARS"); // ARS para Dólar
        return valorPesoArgentino / taxaDeCambio; //Retorna o valor convertido
    }

    public double converterDolarParaReal(double valorDolar) throws IOException {
        double taxaDeCambio = obterTaxaDeCambio("BRL"); // Dolar para Real
        return valorDolar * taxaDeCambio;
    }

    public double converterRealParaDolar(double valorReal) throws IOException {
        double taxaDeCambio = obterTaxaDeCambio("USD"); // USD para Dólar
        return valorReal / taxaDeCambio; // Divide o valor em reais pela taxa de câmbio para obter o valor em dólares
    }

    public double converterDolarParaPesoColombiano(double valorDolar) throws IOException {
        double taxaDeCambio = obterTaxaDeCambio("COP"); // COP para Peso Colombiano
        return valorDolar * taxaDeCambio; // Retorna o valor convertido
    }

    public double converterPesoColombianoParaDolar(double valorPeso) throws IOException {
        double taxaDeCambio = obterTaxaDeCambio("COP"); //COP para Dólar
        return valorPeso / taxaDeCambio; // Retorna o valor convertido
    }

}

/*

package principal;

import com.google.gson.Gson;

public class Conversor {

    public double converterDolarParaReal(double valorDolar) {
        double taxaDeCambio = 4.86; // Exemplo de taxa de câmbio
        return valorDolar * taxaDeCambio;
    }

    public double converterRealParaDolar(double valorReal) {
        double taxaDeCambio = 0.20; // Exemplo de taxa de câmbio
        return valorReal * taxaDeCambio;
    }
}

*/

/*import com.google.gson.Gson;
import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {

    }
}

    String nome = "Kauê";
    int opcao = 0;


    String menu = """
                     ** Digite sua opção para **
                     1- Dolar - peso argentino
                     2- Peso  - argentino dolar
                     3- Dolar - real brasileiro
                     4- Real brasileiro - dolar
                     5- Dolar - peso colombiano
                     6- Peso colombiano - dolar
                     7- Sair
                     """;
    Scanner leitura = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println(menu);
    }

    While (opcao != 7) {
        System.out.println(menu);
        opcao = leitura.nextInt();
    }

     if (opcao == 1) {
        System.out.println("Digite o valor que deseja converter: ");
        double valor = leitura.nextDouble();


    } else if (opcao == 2) {
        System.out.println("Qual o valor deseja transferir");
        double valor = leitura.nextDouble();
        if (valor > saldo) {
            System.out.println("Não há saldo para realizar a transferência");
        } else {
            saldo -= valor;
            System.out.println("Novo saldo" + saldo);
        }
    } else if (opcao == 3) {
        System.out.println("valor recebido: ");
        double valor = leitura.nextDouble();
        saldo += valor;
        System.out.println("Novo saldo" + saldo);
    } else if (opcao != 4) {
        System.out.println("Opção inválida");if (opcao == 1) {
            System.out.println("O saldo disponivel é: " + saldo);
        } else if (opcao == 2) {
            System.out.println("Qual o valor deseja transferir");
            double valor = leitura.nextDouble();
            if (valor > saldo) {
                System.out.println("Não há saldo para realizar a transferência");
            } else {
                saldo -= valor;
                System.out.println("Novo saldo" + saldo);
            }
        } else if (opcao == 3) {
            System.out.println("valor recebido: ");
            double valor = leitura.nextDouble();
            saldo += valor;
            System.out.println("Novo saldo" + saldo);
        } else if (opcao != 4) {
            System.out.println("Opção inválida");

        }*/