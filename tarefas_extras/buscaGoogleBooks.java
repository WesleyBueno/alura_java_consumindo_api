import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class BuscaGoogleBooks {
public static void main(String[] args) throws IOException, InterruptedException {

    Scanner leitor = new Scanner(System.in);
    System.out.println("Digite o nome do livro: ");
    String livro = leitor.nextLine();
    String nomeLivro = livro.replace(" ","%20");
    var key="key";
    String url = "https://www.googleapis.com/books/v1/volumes?q=" + nomeLivro + "&key="+ key;

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
    .uri(URI.create(url))
    .build();
    HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

}
}
