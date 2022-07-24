import java.io.InputStream;

import java.net.URL;

import java.util.List;
import java.util.Map;


public class App {

	public static void main(String[] args) throws Exception {
		// Fazer a conexão HTTP que trás os 250 filmes.
		 //String url = "https://api.mocki.io/v2/549a5d8b/MostPopularMovies";
		 String url = "https://api.nasa.gov/planetary/apod?api_key=Fpx2IkHWTHpXhZDUjnQmMcvmgjJf3FHHlB0tKIfO&start_date=2021-10-03&end_date=2021-10-05";		 
		 ClienteHttp client = new ClienteHttp();
		 
		 String json = client.buscaDados(url);
		 System.out.println(json);
        
		
		// Extrair/Parse só os dados q interessam
		Extrator extrator = new ExtratorNasa();		
		List<Conteudo> conteudos = extrator.extraiConteudo(json);
		

	        for (int i = 0; i < 3; i++) {
	        	var gerador = new GeradoraDeFigurinhas();
	        	Conteudo conteudo = conteudos.get(i); 	
	        	
	        	InputStream input = new URL(conteudo.getUrlImagem()).openStream();
	        	String nomeArquivo = conteudo.getTitle();
	        	
	        	gerador.cria(input, nomeArquivo);
	        	
	        	System.out.println(conteudo.getTitle());
	        	
	            System.out.println();
	            System.out.println();
	            
	            
	        }
	    }
	}