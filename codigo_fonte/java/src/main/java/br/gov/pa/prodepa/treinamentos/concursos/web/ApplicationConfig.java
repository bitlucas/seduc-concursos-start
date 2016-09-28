package br.gov.pa.prodepa.treinamentos.concursos.web;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

/**
 * 
 * @author thiago.soares (thiago.soares.jr@gmail.com)
 *
 */
@ApplicationScoped
public class ApplicationConfig implements Serializable{

	private static final long serialVersionUID = 5912688940876237544L;
	
	private Long id;
	private String mainPage;
	private Boolean devMode;
	
	public ApplicationConfig() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

  public Boolean getDevMode() {
    return devMode;
  }

  public void setDevMode(Boolean devMode) {
    this.devMode = devMode;
  }
	

}
