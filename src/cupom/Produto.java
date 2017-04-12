package cupom;

public class Produto {

	private Integer id;
	private String codigo;
	private String NCM;
	private String EAN;
	private String descricao;
	private Double quantidade;
	private String unidade;
	private Double valorUnitario;
	// private Double valorTotal;
	
	public Produto(){
	}
	
	public Produto( Integer id, String codigo, String nCM, String eAN, 
					String descricao, Double quantidade, String unidade, 
					Double valorUnitario){ // Double valorTotal
		super();
		this.id = id;
		this.codigo = codigo;
		NCM = nCM;
		EAN = eAN;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.unidade = unidade;
		this.valorUnitario = valorUnitario;
		// this.valorTotal = valorTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNCM() {
		return NCM;
	}

	public void setNCM(String nCM) {
		NCM = nCM;
	}

	public String getEAN() {
		return EAN;
	}

	public void setEAN(String eAN) {
		EAN = eAN;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	/*
	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	*/

	@Override
	public String toString() {
		return "Produto [id=" + id + ", codigo=" + codigo + ", NCM=" + NCM + ", EAN=" + EAN + ", descricao=" + descricao
				+ ", quantidade=" + quantidade + ", unidade=" + unidade + ", valorUnitario=" + valorUnitario
				//+ ", valorTotal=" + valorTotal 
				+ "]";
	}
	
}
