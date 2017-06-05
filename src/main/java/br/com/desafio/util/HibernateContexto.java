package br.com.desafio.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import br.com.desafio.util.HibernateUtil;

public class HibernateContexto implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes().close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		HibernateUtil.getFabricaDeSessoes();
		
	}

}
