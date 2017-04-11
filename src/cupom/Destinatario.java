package cupom;

public class Destinatario {

	private String nome;
	private String CPF;
	private String endereco;
	private String logradouro;
	private String bairro;
	private String CEP;
	private String municipio;
	private String telefone;
	private String UF;
	private String pais;
	private String email;
	
	public Destinatario() {
	}
	
	public Destinatario(String nome, String cPF, String endereco) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Destinatario [nome=" + nome + ", CPF=" + CPF + ", endereco=" + endereco + ", logradouro=" + logradouro
				+ ", bairro=" + bairro + ", CEP=" + CEP + ", municipio=" + municipio + ", telefone=" + telefone
				+ ", UF=" + UF + ", pais=" + pais + ", email=" + email + "]";
	}
	
}
