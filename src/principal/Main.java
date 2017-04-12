package principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cupom.NFCe;
import cupom.Produto;
import parse.SefazRS;
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
		String chave = "43170293015006002833651120000969211356021104";
		// String chave = "43170433014556019024652090000079951878545252";
		// String chave = "43170402765561000379650100000283951000283958";
		
		Localidade local = new Localidade("RS");
		//System.out.println(local.getURL());
		
		urlFinal = local.getURL().replace("@CHAVE@", chave);
		
		System.out.println("Processando NFCe : " + urlFinal);
		
		System.out.println("1 =========================================================");

		URL paginaBase = new URL(urlFinal);
        BufferedReader in = new BufferedReader(
        		new InputStreamReader(paginaBase.openStream()));

        String inputLine;
        String html = "";
        while ((inputLine = in.readLine()) != null){
        	html += inputLine;
            // System.out.println(inputLine);            
        }
        in.close();
		SefazRS sefazRS = new SefazRS(html);
		
        System.out.println("2 =========================================================");
        
        // Abre o HTML a partir do arquivo para não bloquear o IP de origem na SEFAZ
        // File file = new File("C:\\temp\\NFCe_EXEMPLO.txt");
        //SefazRS sefazRS = new SefazRS(file);
        
        System.out.println("3 =========================================================");
        
        // realzia o processamento da NF
        sefazRS.execute();
        
	} // fim do executarRS()

}
