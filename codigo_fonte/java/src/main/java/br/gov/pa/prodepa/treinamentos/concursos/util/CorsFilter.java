package br.gov.pa.prodepa.treinamentos.concursos.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Filter for Enabes Cors
 *  
 * @author thiago.soares (thiago.soares.jr@gmail.com)
 * 
 * TODO Ainda não funcionou corretamente
 */
public class CorsFilter implements Filter {


  @Override
  public void init(FilterConfig arg0) throws ServletException {
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

    /*((HttpServletResponse)response).addHeader("Access-Control-Allow-Origin", "*");
    ((HttpServletResponse)response).addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, PATCH, DELETE"); //POST, GET, PUT, UPDATE, OPTIONS
    ((HttpServletResponse)response).addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With");
    ((HttpServletResponse)response).addHeader("Access-Control-Allow-Credentials", "true");*/
    
    ((HttpServletResponse)response).addHeader("Access-Control-Allow-Origin", "*");
    ((HttpServletResponse)response).addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, UPDATE, DELETE, OPTIONS"); //POST, GET, PUT, UPDATE, OPTIONS
    ((HttpServletResponse)response).addHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, Origin, Authorization");
    //((HttpServletResponse)response).addHeader("Access-Control-Allow-Credentials", "true");
    
    
    filterChain.doFilter(request, response);
  }

  @Override
  public void destroy() { }
  
}
