

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
		
		//https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY
		String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json";
		
		URI endereco = URI.create(url);
		
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest requisicao = HttpRequest.newBuilder(endereco).GET().build();
		HttpResponse<String> resposta = cliente.send(requisicao, BodyHandlers.ofString());
		
		String body = resposta.body();
		
		var parser = new JsonParser();
		
		List<Map<String, String>> ListaDeConteudos = parser.parse(body);
		
		var geradora = new GeradoraDeFigurinhas();
		
		for (int i = 0; i < 10; i++) {
            
			Map<String, String> conteudo = ListaDeConteudos.get(i);
			
			String urlImage = conteudo.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
			String titulo = conteudo.get("title");
			
			InputStream inputStream = new URL(urlImage).openStream();
			String nomeArquivo = "inside/" + titulo + ".png";
			
			geradora.criaFigurinha(inputStream, nomeArquivo);
			
            
            System.out.println(conteudo.get("title"));
		}
	}
}
