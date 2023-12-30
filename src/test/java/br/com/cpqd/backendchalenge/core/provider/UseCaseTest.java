package br.com.cpqd.backendchalenge.core.provider;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.cpqd.backendchalenge.InformeBoundary;
import br.com.cpqd.backendchalenge.core.domain.InformeDiario;
import br.com.cpqd.backendchalenge.dataprovider.InformeProvider;


public class UseCaseTest {


	private InformeBoundary pinheiroBoundary;

	@Before
	public void setup() {	
		pinheiroBoundary = new InformeProvider();

	}

	@Test
	public void deveObterOsDadosdeInformesDiario() {

		List<InformeDiario> all = pinheiroBoundary.getAll();
		Assert.assertEquals(124080, all.size());
	}
	
	@Test
	public void deveSomarResgatesPorCNPJ() {
		Map<String, BigDecimal> resgatesPorCNPJ = pinheiroBoundary.somarResgatesPorCNPJ();
		
		for(Entry<String, BigDecimal> resgate : resgatesPorCNPJ.entrySet()) {
			System.out.println("CNPJ: "  + resgate.getKey());
			System.out.println("Soma Resgate: " + resgate.getValue());
		}
		
		//Assert.assertEquals(new BigDecimal(93808.35), resgatesPorCNPJ.get("18.085.943/0001-20"));
		
	}


}