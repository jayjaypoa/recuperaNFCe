package principal;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cupom.Produto;
import util.Localidade;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("Recupera NFCe");
		Main main = new Main();
		main.executarRS();
		
	} // fim do main()
	
	// RIO GRANDE DO SUL - RS
	private void executarRS() throws Exception {
		
		String urlFinal = "";
		//String chave = "43170293015006002833651120000969211356021104";
		String chave = "43170433014556019024652090000079951878545252";
		
		Localidade local = new Localidade("RS");
		System.out.println(local.getURL());
		
		urlFinal = local.getURL().replace("@CHAVE@", chave);
		
		System.out.println(urlFinal);
		
		System.out.println("1 =========================================================");
		
		URL paginaBase = new URL(urlFinal);
        BufferedReader in = new BufferedReader(
        		new InputStreamReader(paginaBase.openStream()));

        String inputLine;
        String html = "";
        while ((inputLine = in.readLine()) != null){
        	html += inputLine;
            System.out.println(inputLine);            
        }
        in.close();
	
        System.out.println("2 =========================================================");
        
        // parse HTML
        Document doc = Jsoup.parse(html);
        
        //Element content = doc.getElementById("content");
        //Elements links = content.getElementsByTag("td");
        Elements divs = doc.getElementsByTag("div");
        for (Element div : divs) {
        	
        	//String linkHref = link.attr("href");
        	//String linkText = link.text();
        	//System.out.println(link);
        	
        	/*        	
        	// Div NFe - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("NFE")){
        		System.out.println(" #################################################### ");
        		System.out.println(" NFE : ");
        		System.out.println(div);
        	} // Div NFe - Fim        	
        	
        	// Div EMITENTE - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("EMITENTE")){
        		System.out.println(" #################################################### ");
        		System.out.println(" EMITENTE : ");
        		System.out.println(div);
        	} // Div EMITENTE - Fim
        	
        	// Div DESTINATARIO / CLIENTE - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("DESTREM")){
        		System.out.println(" #################################################### ");
        		System.out.println(" DESTREM : ");
        		System.out.println(div);
        	} // Div DESTINATARIO / CLIENTE - Fim
        	
        	// Div TOTAIS - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("TOTAIS")){
        		System.out.println(" #################################################### ");
        		System.out.println(" TOTAIS : ");
        		System.out.println(div);
        	} // Div TOTAIS - Fim
        	
        	// Div TRANSPORTE - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("TRANSPORTE")){
        		System.out.println(" #################################################### ");
        		System.out.println(" TRANSPORTE : ");
        		System.out.println(div);
        	} // Div TRANSPORTE - Fim
        	
        	// Div COBRANCA - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("COBRANCA")){
        		System.out.println(" #################################################### ");
        		System.out.println(" COBRANCA : ");
        		System.out.println(div);
        	} // Div COBRANCA - Fim
        	
        	// Div INFORMACOES ADICIONAIS - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("INF")){
        		System.out.println(" #################################################### ");
        		System.out.println(" INF : ");
        		System.out.println(div);
        	} // Div INFORMACOES ADICIONAIS - Fim
        	*/
        	
        	// Div PRODUTOS - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("PROD")){
        		
        		System.out.println(" #################################################### ");
        		System.out.println(" PROD : ");
        		//System.out.println(div);
        		
        		Elements tds = div.getElementsByTag("td");
        		for(Element td : tds){
        			if(td.attr("class").toUpperCase().contentEquals("FIXO-PROD-SERV-NUMERO")){
        				if(td.child(0).tagName().contentEquals("span")){        					
        					
        					int nroCampo = 1;
        					Produto prod = new Produto();
        					
        					Element pai = td.parent();
        					Elements dados = pai.getElementsByTag("span");
        					// System.out.println(pai);
        					    
        					for(Element dado : dados){        						        						        						
        						
        						// SEQUENCIA PRODUTO
        						if (nroCampo == 1){
        							prod.setCodigo(dado.html());
        						} else if (nroCampo == 2){ 	// DESCRICAO
        							prod.setDescricao(dado.html());
        						} else if (nroCampo == 3){ 	// QUANTIDADE (QTD)
        							prod.setQuantidade(Double.parseDouble(dado.html().replace(',', '.')));
        						} else if (nroCampo == 4){ 	// UNIDADE (UC)
        							prod.setUnidade(dado.html());
        						} else if (nroCampo == 5){ 	// VALOR UNITÁRIO
        							prod.setValorUnitario(Double.parseDouble(dado.html().replace(',', '.')));
        						}
        						
        						nroCampo++;
        					}
        					
        					System.out.println(prod.toString());
        					
        				}        				
        			}
        		}
        		
        		
        	} // Div PRODUTOS - Fim
        	
        }
        
        
	} // fim do executarRS()

}
