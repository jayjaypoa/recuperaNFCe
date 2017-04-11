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
		
		Localidade local = new Localidade("RS");
		System.out.println(local.getURL());
		
		urlFinal = local.getURL().replace("@CHAVE@", chave);
		
		System.out.println(urlFinal);
		
		urlFinal = "https://www.sefaz.rs.gov.br/ASP/AAE_ROOT/NFE/SAT-WEB-NFE-COM_2.asp?chaveNFe=43170433014556019024652090000079951878545252&HML=false";
		
		System.out.println("1 =========================================================");
		
		URL paginaBase = new URL(urlFinal);
        BufferedReader in = new BufferedReader(
        		new InputStreamReader(paginaBase.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
	
	} // fim do executarRS()

}
