package br.gov.pa.prodepa.treinamentos.concursos.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author thiago.soares (thiago.soares.jr@gmail.com)
 *
 */
public class ExceptionDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private int statusCode;
  private String status;
  private String message;

  private List<Validation> validations = new ArrayList<Validation>();

  private String trace;
  
  public ExceptionDTO() {
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<Validation> getValidations() {
    return validations;
  }

  public void setValidations(List<Validation> validations) {
    this.validations = validations;
  }

  public String getTrace() {
    return trace;
  }

  public void setTrace(String trace) {
    this.trace = trace;
  }
  
  

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "BusinessExceptionDTO [mensagem=" + message + ", trace=" + trace + ", validations=" + validations + "]";
  }

}