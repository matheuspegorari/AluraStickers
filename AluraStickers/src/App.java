import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;


public class App {

	public static void main(String[] args) throws Exception {
		// Fazer a conexão HTTP que trás os 250 filmes.
		 String url = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
	        URI endereco = URI.create(url);
	        HttpClient client = HttpClient.newHttpClient();
	        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();
	        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	        String body = response.body();	        
		
		// Extrair/Parse só os dados q interessam
		JsonParser parser = new JsonParser();
		
		List<Map<String, String>> listaDeFilmes = parser.parse(body);

	    // exibir e manipular os dados 
	        for (Map<String,String> filme : listaDeFilmes) {
	        	
	        	InputStream inputStream = new URL(filme.get("image")).openStream();
	        	
	        	var gerador = new GeradoraDeFigurinhas();
	        	
	        	gerador.cria(inputStream, filme.get("title"));
	        	
	        	
	            System.out.println(filme.get("title"));
	            System.out.println();	            
	            Double rating =  Double.parseDouble(filme.get("imDbRating"));
	            System.out.println(rating);
	            for (int i = 0; i < rating; i++) {
					System.out.print("☆");					
				}
	            System.out.println();
	            System.out.println();
	            
	            
	        }
	    }
	}