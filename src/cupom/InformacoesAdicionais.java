package cupom;

public class InformacoesAdicionais {

	private String formatoImpressaoDANFE;
	private String qrCode;
	
	public InformacoesAdicionais(){
	}

	public String getFormatoImpressaoDANFE() {
		return formatoImpressaoDANFE;
	}

	public void setFormatoImpressaoDANFE(String formatoImpressaoDANFE) {
		this.formatoImpressaoDANFE = formatoImpressaoDANFE;
	}

	public String getQrCode() {
		return qrCode;
	}

	public void setQrCode(String qrCode) {
		this.qrCode = qrCode;
	}

	@Override
	public String toString() {
		return "InformacoesAdicionais [formatoImpressaoDANFE=" + formatoImpressaoDANFE + ", qrCode=" + qrCode + "]";
	}
	
}
