package util;

public class Localidade {

	private String uf;
	private String url;
	
	public Localidade(String uf) throws Exception {
		this.uf = uf;
		this.determinaURL();
	}
	
	public String getUF() {
		return uf;
	}
	
	public void setUF(String uf) {
		this.uf = uf;		
	}
	
	public String getURL() {
		return this.url;
	}
	
	public void setURL(String url) {
		this.url = url;
	}
	
	private void determinaURL() throws Exception {

		String params = "";
		
		// RIO GRANDE DO SUL - RS (Sefaz RS)
		if (this.getUF().equalsIgnoreCase("RS")){
			// params = "?chaveNFe=@CHAVE@";
			// this.setURL("https://www.sefaz.rs.gov.br/ASP/AAE_ROOT/NFE/SAT-WEB-NFE-NFC_1.asp" + params);
			params = "?chaveNFe=@CHAVE@&HML=false";
			this.setURL("https://www.sefaz.rs.gov.br/ASP/AAE_ROOT/NFE/SAT-WEB-NFE-COM_2.asp" + params);
		}
		
		if (this.getURL().isEmpty())
			throw new Exception("UF ainda não configurada! "
					+ "(Valor informado: " + this.getUF() + ")");
		
	} // fim do determinaURL()

	@Override
	public String toString() {
		return "Localidade [getUF()=" + getUF() + ", getURL()=" + getURL() + "]";
	}
	
}
