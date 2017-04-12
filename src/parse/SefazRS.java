package parse;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cupom.NFCe;
import cupom.Produto;

public class SefazRS {
	
	private File file;
	private String html;	
	private Document doc;
	
	public SefazRS(String html){
		this.html = html;
	}
	
	public SefazRS(File file){
		this.file = file;
	}
	
	public void execute() throws IOException {
		
		// parse HTML
		if(this.html == null && this.file.exists()){
			this.doc = Jsoup.parse(this.file, "ISO-8859-1"); // por arquivo
		} else {
			this.doc = Jsoup.parse(this.html); // por string 
		}
		
		// cria o objeto da nota fiscal
		NFCe notaFiscal = new NFCe();        
		
		//Element content = doc.getElementById("content");
        //Elements links = content.getElementsByTag("td");
        Elements divs = doc.getElementsByTag("div");
        for (Element div : divs) {
/*
        	// Div NFe - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("NFE")){
        		System.out.println(" #################################################### ");
        		System.out.println(" NFE : ");
        		System.out.println(div);
        	} // Div NFe - Fim        	
        	
        	// Div EMITENTE - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("EMITENTE")){
        		System.out.println(" #################################################### ");
        		System.out.println(" EMITENTE : ");
        		System.out.println(div);
        	} // Div EMITENTE - Fim
        	
        	// Div DESTINATARIO / CLIENTE - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("DESTREM")){
        		System.out.println(" #################################################### ");
        		System.out.println(" DESTREM : ");
        		System.out.println(div);
        	} // Div DESTINATARIO / CLIENTE - Fim
        	
        	// Div TOTAIS - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("TOTAIS")){
        		System.out.println(" #################################################### ");
        		System.out.println(" TOTAIS : ");
        		System.out.println(div);
        	} // Div TOTAIS - Fim
        	
        	// Div TRANSPORTE - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("TRANSPORTE")){
        		System.out.println(" #################################################### ");
        		System.out.println(" TRANSPORTE : ");
        		System.out.println(div);
        	} // Div TRANSPORTE - Fim
        	
        	// Div COBRANCA - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("COBRANCA")){
        		System.out.println(" #################################################### ");
        		System.out.println(" COBRANCA : ");
        		System.out.println(div);
        	} // Div COBRANCA - Fim
        	
        	// Div INFORMACOES ADICIONAIS - Inicio
        	if(div.attr("id").toUpperCase().contentEquals("INF")){
        		System.out.println(" #################################################### ");
        		System.out.println(" INF : ");
        		System.out.println(div);
        	} // Div INFORMACOES ADICIONAIS - Fim
        	
        	// System.out.println(div);
*/        	
        
        	// Parse dos PRODUTOS
        	if(div.attr("id").toUpperCase().contentEquals("PROD")){
        		ArrayList<Produto> listagem = this.processarProdutos(div);
            	notaFiscal.setProdutos(listagem);
        	}
        	
        } // fim do for das divs
        
        // imprime no console a lista de produtos
        System.out.println("QTD DE PRODUTOS = " + notaFiscal.getProdutos().size());
        int numPrd = 0;
        for(Produto p : notaFiscal.getProdutos()){
        	numPrd++;
        	System.out.println("PRODUTO " + numPrd + " ===> " + p.toString());
        }
		
	} // fim do execute
	
	
	private ArrayList<Produto> processarProdutos(Element div){
		
		// cria a listagem de produtos
		ArrayList<Produto> listaProdutos = new ArrayList<Produto>();
		
		System.out.println(" #################################################### ");
		System.out.println(" PROD : ");
		
		int qtdProdutos = 0;
		int nroTabela = 0;
		
		Integer id = 0;
		String codigo = "";
		String NCM = "";
		String EAN = "";
		String descricao = "";
		Double quantidade = 0.0;
		String unidade = "";
		Double valorUnitario = 0.0;
		Double valorTotal = 0.0;
		
		Elements tables = div.getElementsByTag("table");
		for (Element table : tables){
			
			// ignora a tabela de cabecalho (primeira tabela - indice 0)
			if (nroTabela > 0){
				
				// Imprime as tables no console...
    			// System.out.println("TABELA " + nroTabela + ":\n" + table.html() + "\n\n");
    			
				// contador, descricao, unidade e valor
				// Class : fixo-prod-serv-numero,
				// fixo-prod-serv-descricao, fixo-prod-serv-qtd, 
				// fixo-prod-serv-uc, fixo-prod-serv-vb
				if (nroTabela == 1){
					
					// System.out.println("ENTROU NA TABELA 1");
					// System.out.println("NRO TABELA : " + nroTabela + "\n" + table.html() +"\n\n");
					
					Elements colunas = table.getElementsByTag("td");
					for(Element coluna : colunas){
						
						String atributoColuna = coluna.attr("class").toUpperCase();
						
						// contador
						if (atributoColuna.contentEquals("FIXO-PROD-SERV-NUMERO")){
							// System.out.println("A = " + coluna.text());
							id = Integer.parseInt(coluna.text());
			        		codigo = id.toString();					        		
						// descricao									
						} else if (atributoColuna.contentEquals("FIXO-PROD-SERV-DESCRICAO")){
							// System.out.println("B = " + coluna.text());
							descricao = coluna.text();
						// quantidade
						} else if (atributoColuna.contentEquals("FIXO-PROD-SERV-QTD")){
							// System.out.println("C  = " + coluna.text());
			        		quantidade = Double.parseDouble(coluna.text().replace(',', '.'));
						// unidade
						} else if (atributoColuna.contentEquals("FIXO-PROD-SERV-UC")){
							// System.out.println("D = " + coluna.text());
							unidade = coluna.text();
						// valor
						} else if (atributoColuna.contentEquals("FIXO-PROD-SERV-VB")){
							// System.out.println("E = " + coluna.text());
							valorTotal = Double.parseDouble(coluna.text().replace(',', '.'));
							valorUnitario = valorTotal/quantidade;
						}
						
					} // fim do for-each das colunas
				
				// Codigo do produto, NCM, CEST,
				// CFOP, Valor Desconto, Valor Total Frete,
				// Valor Seguro, EAN, Unidade Comercial,
				// Quantidade Comercial, EAN Tributavel,
				// Valor Unitario de Comercializacao,
				// Nro Pedido Compra, PIS, CST e COFINS 
				} else if (nroTabela == 2){
					
					// System.out.println("ENTROU NA TABELA 2");
					// System.out.println("NRO TABELA : " + nroTabela + "\n" + table.html() +"\n\n");
					
					int contAux = 0;
					Elements colunas = table.getElementsByTag("td");
					for(Element colunaAux : colunas){
						if (contAux > 0){
							
							// obtem o nome da coluna
							String nomeColuna = colunaAux.getElementsByTag("label").text();
							nomeColuna = nomeColuna.toUpperCase().trim();
							String valorColuna = colunaAux.getElementsByTag("span").text();
							
							// System.out.println("$$$" + nomeColuna + " - " + valorColuna + "$$$");
							
							if (nomeColuna.equalsIgnoreCase("CÓDIGO DO PRODUTO")){
								codigo = valorColuna;
							} else if (nomeColuna.equalsIgnoreCase("CÓDIGO NCM")){
								NCM = valorColuna;
							} else if (nomeColuna.equalsIgnoreCase("CÓDIGO EAN COMERCIAL")){
								EAN = valorColuna;
							}
							
						}
						contAux++;
					}
					
				// Codigo do Produto, NCM, CEST, CFOP
				} else if (nroTabela == 3){
					
					// IGNORAR - Motivo: DADOS NAO NECESSARIOS
					// System.out.println("ENTROU NA TABELA 3");
					
				// EAN Comercial, Unidade Comercial, Quantidade Comercial,
				// EAN Tributavel, Unidade Tributavel, Quantidade Tributavel
				// e Valor Unitario de Comercializacao
				} else if (nroTabela == 4){
					
					// IGNORAR - Motivo: DADOS NAO NECESSARIOS
					// System.out.println("ENTROU NA TABELA 4");
					
				// Origem da Mercadoria, Tributacao ICMS,
				// Valor da BC do ICMS ST retido e 
				// Valor ICMS ST retido
				} else if (nroTabela == 5){
					
					// IGNORAR - Motivo: DADOS NAO NECESSARIOS
					// System.out.println("ENTROU NA TABELA 5");
					
				// CST
				} else if (nroTabela == 6){
					
					// IGNORAR - Motivo: DADOS NAO NECESSARIOS
					// System.out.println("ENTROU NA TABELA 6");
						        							
				// CST
				} else if (nroTabela == 7){

					// IGNORAR - Motivo: DADOS NAO NECESSARIOS	    
					// System.out.println("ENTROU NA TABELA 7");
				
				} // fim dos if-else das tables dos produtos
					        			
			} // fim do if nroTabela > 0
			
			// incrementa variavel de controle
			nroTabela++;
			        			
			// Cada produto possui no maximo 7 tables,
			// portanto, recomeca a contagem caso atinga este limite
			if (nroTabela > 7){
				
				// cria o objeto do produto
				Produto produto = new Produto();
				produto.setId(id);
				produto.setCodigo(codigo);
				produto.setDescricao(descricao);
				produto.setEAN(EAN);
				produto.setNCM(NCM);
				produto.setQuantidade(quantidade);
				produto.setUnidade(unidade);
				produto.setValorUnitario(valorUnitario);
				produto.setValorTotal(valorTotal);
				
				// adiciona o produto gerado na lista de produtos
				listaProdutos.add(produto);
				
				// redefine a variavel de controle
				// para navegar nos demais produtos
				nroTabela = 1;
				
			} // fim do if (nroTabela > 7)
			
		} // fim for-each dos tables
        
        return listaProdutos;
		
	} // fim do processarProdutos()

}
