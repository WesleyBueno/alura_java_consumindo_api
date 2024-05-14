import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscaCripto {

    public static void main(String[] args) throws IOException, InterruptedException {
        
        Scanner leitor = new Scanner(System.in);

        System.out.println("Qual crypto deseja buscar:\nEx: Ethereum");
        var crypto = leitor.nextLine();
        var key = "key";
        var url = "https://api.coingecko.com/api/v3/search?query="+ crypto + "&x-cg-demo-api-key="+ key;


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build();
        HttpResponse<String> response = client
        .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());


    }
}
