package br.com.desafio.util;

import org.hibernate.Session;
import org.junit.Test;

import br.com.desafio.util.HibernateUtil;

public class HibernateUtilTest {
	@Test
	public void conectar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		sessao.close();
		
	}
}
