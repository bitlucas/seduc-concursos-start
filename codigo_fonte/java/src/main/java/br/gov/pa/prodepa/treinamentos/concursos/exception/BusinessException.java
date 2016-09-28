package br.gov.pa.prodepa.treinamentos.concursos.exception;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.WebFault;

/**
 * 
 * @author thiago.soares (thiago.soares.jr@gmail.com) 
 *
 */
@WebFault(name="BusinessExceptionFault", targetNamespace= "http://prodepa.pa.gov.br/apis/simas/Exceptions")
public class BusinessException extends Exception {

  private static final long serialVersionUID = -5022967813902834759L;

  private String id;
  private List<Validation> validations = new ArrayList<Validation>();
  
  public BusinessException() {
    super();
  }

  public BusinessException(String message) {
    super(message);
    this.validations = new ArrayList<Validation>();
    this.validations.add(new Validation(message));
  }
  
  public BusinessException(Throwable cause) {
    super(cause);
    this.validations = new ArrayList<Validation>();
    this.validations.add(new Validation(cause.getMessage()));
  }

  public BusinessException(String message, Throwable cause) {
    super(message, cause);
    this.validations = new ArrayList<Validation>();
    this.validations.add(new Validation(message));
  }
  
  
  public BusinessException(List<Validation> validations) {
    super();
    this.validations = validations;
  }
  
  public BusinessException(String message, List<Validation> validations) {
    super(message);
    this.validations = validations;
  }
  
  public BusinessException(List<Validation> validations, Throwable cause) {
    super(cause);
    this.validations = validations;
  }
  
  public BusinessException(String message, List<Validation> validations, Throwable cause) {
    super(message, cause);
    this.validations = validations;
  }

  public List<Validation> getValidations() {
    return validations;
  }

  public void setValidations(List<Validation> validations) {
    this.validations = validations;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "BusinessException ["
            + "validations=" + validations 
            + "#\n#"
            + ", Class=" + getClass() 
            + ", Cause=" + getCause() 
            + ", Message=" + getMessage() 
            + ", LocalizedMessage=" + getLocalizedMessage()
            + "]";
  }
  
  
  
  
}
