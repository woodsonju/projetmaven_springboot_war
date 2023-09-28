package fr.dawan.calculatriceweb.web;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import fr.dawan.calculatriceweb.CalculatriceWebApplication;

/**
 * Cette classe permet à votre application Spring Boot de fonctionner 
 * correctement lorsqu'elle est déployée dans un conteneur de servlet comme Tomcat
 * 
 * Lorsque vous générez un fichier WAR à partir de votre application Spring Boot 
 * et le déploiez dans un conteneur de servlet tel que Tomcat, le conteneur 
 * de servlet recherche une classe qui étend SpringBootServletInitializer 
 * (cette classe WebInitializer dans votre cas) et utilise la méthode configure 
 * pour déterminer comment initialiser votre application.
 * 
 * @author Admin stagiaire
 *
 */
public class WebInitializer extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CalculatriceWebApplication.class);
	}
	
}


