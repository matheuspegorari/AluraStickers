import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorImdb implements Extrator {
	public List<Conteudo> extraiConteudo(String json){
		// Extrair/Parse só os dados q interessam
		
		JsonParser parser = new JsonParser();
				
		List<Map<String, String>> listaDeAtributos = parser.parse(json);
		
		List<Conteudo> conteudos = new ArrayList<>();
		
		// popular a lista de conteudos
		
		for (Map<String,String> atributos : listaDeAtributos) {
			String titulo = atributos.get("title");
			String urlImagem = atributos.get("image");
			Conteudo conteudo = new Conteudo(titulo, urlImagem);
			
			conteudos.add(conteudo);
		}
		return conteudos;
		
		
		
		
	}

}
