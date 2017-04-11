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
		
		System.out.println("1 =========================================================");
		
		URL paginaBase = new URL(urlFinal);
        BufferedReader in = new BufferedReader(
        		new InputStreamReader(paginaBase.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
        
        System.out.println("2 =========================================================");
        
        String url = urlFinal;
        URL obj = new URL(url);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        
        // add request header
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0  etc.");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.8");
        con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        con.setRequestProperty("Connection", "keep-alive");
        con.setRequestProperty("Accept", "*/*");
        con.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");

     // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes("chaveNFe=43170293015006002833651120000969211356021104");
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();

        BufferedReader bufferIn = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        inputLine = "";
        StringBuffer response = new StringBuffer();

        while ((inputLine = bufferIn.readLine()) != null) {
            response.append(inputLine);
        }
        bufferIn.close();
        
        //if password is not correct, my form should return false
//        if (response.toString().equals("false"))
//            System.out.println("FALSE  <----------");
//        else 
//        	System.out.println("TRUE <----------");

        
        System.out.println("3 =========================================================");
        
        
        //Making http get request
        HttpClient httpClientDefault1 = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(urlFinal);
        
        //setup headers (Server understand request throw by some browser)
        //httpPost.setHeader("Connection", "keep-alive");
        //httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; rv:9.0.1) Gecko/20100101 Firefox/9.0.1");
        //httpPost.setHeader("Accept", " text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        //httpPost.setHeader("Accept-Language", "en-us,en;q=0.5");
        //httpPost.setHeader("Host", "ec2-23-20-44-83.compute-1.amazonaws.com");
        //httpPost.setHeader("Referer",resultUrl+resultUrlAsp);
        
        // Set parameters
        ArrayList<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
        nameValuePair.add(new BasicNameValuePair("key",""));
        nameValuePair.add(new BasicNameValuePair("txtenroll","095020693015"));
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));
        //Send request

        HttpResponse httpRespnse = httpClientDefault1.execute(httpPost);
        //Get Response body

        if(httpRespnse.getStatusLine().getStatusCode() != 200) {
            InputStream in2 =  httpRespnse.getEntity().getContent();
            byte b[] = new byte[1024] ;
            StringBuilder html = new StringBuilder("");
            while(in2.read(b) != -1) {
                html.append((new String(b)).toString());
                b = new byte[1024];
            }
            System.out.println(html);
        }
	
	} // fim do executarRS()

}
