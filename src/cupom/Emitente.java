package cupom;

public class Emitente {

	private String razaoSocial;
	private String nomeFantasia;
	private String CNPJ;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;
	private String endereco;
	private String logradouro;
	private String bairro;
	private String CEP;
	private String municipio;
	private String telefone;
	private String UF;
	private String pais;
	private String CNAEFiscal;
	
	public Emitente(){
	}
	
	public Emitente(String razaoSocial, String nomeFantasia, String cNPJ, String inscricaoEstadual, String endereco) {
		super();
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		CNPJ = cNPJ;
		this.inscricaoEstadual = inscricaoEstadual;
		this.endereco = endereco;
	}
	
	public Emitente(String nomeFantasia, String endereco) {
		super();
		this.nomeFantasia = nomeFantasia;
		this.endereco = endereco;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}
	
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	
	public String getCNPJ() {
		return CNPJ;
	}
	
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUF() {
		return UF;
	}

	public void setUF(String uF) {
		UF = uF;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCNAEFiscal() {
		return CNAEFiscal;
	}

	public void setCNAEFiscal(String cNAEFiscal) {
		CNAEFiscal = cNAEFiscal;
	}

	@Override
	public String toString() {
		return "Emitente [razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", CNPJ=" + CNPJ
				+ ", inscricaoEstadual=" + inscricaoEstadual + ", inscricaoMunicipal=" + inscricaoMunicipal
				+ ", endereco=" + endereco + ", logradouro=" + logradouro + ", bairro=" + bairro + ", CEP=" + CEP
				+ ", municipio=" + municipio + ", telefone=" + telefone + ", UF=" + UF + ", pais=" + pais
				+ ", CNAEFiscal=" + CNAEFiscal + "]";
	}
	
}
