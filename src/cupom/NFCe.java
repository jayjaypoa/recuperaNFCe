package cupom;

import java.util.Date;
import java.util.List;

public class NFCe {

	private String chave;
	private Emitente emitente;
	private Destinatario destinatario;
	private List<Produto> produtos;
	private Cobranca cobranca;
	private InformacoesAdicionais informacoesAdicionais;
	private String modelo;
	private String serie;
	private Integer numero;
	private Date dataEmissao;
	private Date dataEntradaSaida;
	private Double valorTotal;
	private String presencaComprador;
	private String naturezaOperacao;
	private String tipoOperacao;
	private String formaPagamento;
	private String digestValue;
	private String protocoloNFe;
	private Date dataAutorizacaoNFe;
	private Date dataInclusaoBDNFe;
	
	public NFCe(){
	}
	
	public NFCe(String chave, Emitente emitente, Destinatario destinatario, List<Produto> produtos, Cobranca cobranca,
			InformacoesAdicionais informacoesAdicionais, String modelo, String serie, Integer numero, Date dataEmissao,
			Date dataEntradaSaida, Double valorTotal, String presencaComprador, String naturezaOperacao,
			String tipoOperacao, String formaPagamento, String digestValue, String protocoloNFe,
			Date dataAutorizacaoNFe, Date dataInclusaoBDNFe) {
		super();
		this.chave = chave;
		this.emitente = emitente;
		this.destinatario = destinatario;
		this.produtos = produtos;
		this.cobranca = cobranca;
		this.informacoesAdicionais = informacoesAdicionais;
		this.modelo = modelo;
		this.serie = serie;
		this.numero = numero;
		this.dataEmissao = dataEmissao;
		this.dataEntradaSaida = dataEntradaSaida;
		this.valorTotal = valorTotal;
		this.presencaComprador = presencaComprador;
		this.naturezaOperacao = naturezaOperacao;
		this.tipoOperacao = tipoOperacao;
		this.formaPagamento = formaPagamento;
		this.digestValue = digestValue;
		this.protocoloNFe = protocoloNFe;
		this.dataAutorizacaoNFe = dataAutorizacaoNFe;
		this.dataInclusaoBDNFe = dataInclusaoBDNFe;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public Emitente getEmitente() {
		return emitente;
	}

	public void setEmitente(Emitente emitente) {
		this.emitente = emitente;
	}

	public Destinatario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Cobranca getCobranca() {
		return cobranca;
	}

	public void setCobranca(Cobranca cobranca) {
		this.cobranca = cobranca;
	}

	public InformacoesAdicionais getInformacoesAdicionais() {
		return informacoesAdicionais;
	}

	public void setInformacoesAdicionais(InformacoesAdicionais informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getDataEntradaSaida() {
		return dataEntradaSaida;
	}

	public void setDataEntradaSaida(Date dataEntradaSaida) {
		this.dataEntradaSaida = dataEntradaSaida;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getPresencaComprador() {
		return presencaComprador;
	}

	public void setPresencaComprador(String presencaComprador) {
		this.presencaComprador = presencaComprador;
	}

	public String getNaturezaOperacao() {
		return naturezaOperacao;
	}

	public void setNaturezaOperacao(String naturezaOperacao) {
		this.naturezaOperacao = naturezaOperacao;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getDigestValue() {
		return digestValue;
	}

	public void setDigestValue(String digestValue) {
		this.digestValue = digestValue;
	}

	public String getProtocoloNFe() {
		return protocoloNFe;
	}

	public void setProtocoloNFe(String protocoloNFe) {
		this.protocoloNFe = protocoloNFe;
	}

	public Date getDataAutorizacaoNFe() {
		return dataAutorizacaoNFe;
	}

	public void setDataAutorizacaoNFe(Date dataAutorizacaoNFe) {
		this.dataAutorizacaoNFe = dataAutorizacaoNFe;
	}

	public Date getDataInclusaoBDNFe() {
		return dataInclusaoBDNFe;
	}

	public void setDataInclusaoBDNFe(Date dataInclusaoBDNFe) {
		this.dataInclusaoBDNFe = dataInclusaoBDNFe;
	}

	@Override
	public String toString() {
		return "NFCe [chave=" + chave + ", emitente=" + emitente + ", destinatario=" + destinatario + ", produtos="
				+ produtos + ", cobranca=" + cobranca + ", informacoesAdicionais=" + informacoesAdicionais + ", modelo="
				+ modelo + ", serie=" + serie + ", numero=" + numero + ", dataEmissao=" + dataEmissao
				+ ", dataEntradaSaida=" + dataEntradaSaida + ", valorTotal=" + valorTotal + ", presencaComprador="
				+ presencaComprador + ", naturezaOperacao=" + naturezaOperacao + ", tipoOperacao=" + tipoOperacao
				+ ", formaPagamento=" + formaPagamento + ", digestValue=" + digestValue + ", protocoloNFe="
				+ protocoloNFe + ", dataAutorizacaoNFe=" + dataAutorizacaoNFe + ", dataInclusaoBDNFe="
				+ dataInclusaoBDNFe + "]";
	}
	
}
