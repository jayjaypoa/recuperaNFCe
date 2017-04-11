package cupom;

public class Cobranca {

	private String formaPagamento;
	private Double valorPagamento;
	private String tipoIntegracao;
	private String CNPJCredenciadora;
	private String bandeiraOperadora;
	private String numeroAutorizacao;
	
	public Cobranca(){
	}
	
	public Cobranca(String formaPagamento, Double valorPagamento, String tipoIntegracao, String cNPJCredenciadora,
			String bandeiraOperadora, String numeroAutorizacao) {
		super();
		this.formaPagamento = formaPagamento;
		this.valorPagamento = valorPagamento;
		this.tipoIntegracao = tipoIntegracao;
		CNPJCredenciadora = cNPJCredenciadora;
		this.bandeiraOperadora = bandeiraOperadora;
		this.numeroAutorizacao = numeroAutorizacao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Double getValorPagamento() {
		return valorPagamento;
	}

	public void setValorPagamento(Double valorPagamento) {
		this.valorPagamento = valorPagamento;
	}

	public String getTipoIntegracao() {
		return tipoIntegracao;
	}

	public void setTipoIntegracao(String tipoIntegracao) {
		this.tipoIntegracao = tipoIntegracao;
	}

	public String getCNPJCredenciadora() {
		return CNPJCredenciadora;
	}

	public void setCNPJCredenciadora(String cNPJCredenciadora) {
		CNPJCredenciadora = cNPJCredenciadora;
	}

	public String getBandeiraOperadora() {
		return bandeiraOperadora;
	}

	public void setBandeiraOperadora(String bandeiraOperadora) {
		this.bandeiraOperadora = bandeiraOperadora;
	}

	public String getNumeroAutorizacao() {
		return numeroAutorizacao;
	}

	public void setNumeroAutorizacao(String numeroAutorizacao) {
		this.numeroAutorizacao = numeroAutorizacao;
	}

	@Override
	public String toString() {
		return "Cobranca [formaPagamento=" + formaPagamento + ", valorPagamento=" + valorPagamento + ", tipoIntegracao="
				+ tipoIntegracao + ", CNPJCredenciadora=" + CNPJCredenciadora + ", bandeiraOperadora="
				+ bandeiraOperadora + ", numeroAutorizacao=" + numeroAutorizacao + "]";
	}
	
}
