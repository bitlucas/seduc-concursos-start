package br.gov.pa.prodepa.treinamentos.concursos.exception;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * @author thiago.soares (thiago.soares.jr@gmail.com) 
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "code",
    "field",
    "message"
})
@XmlRootElement(name = "Error_DTO")
public class Validation {

  @XmlElement(required = true)
  private String code;
  
  @XmlElement(required = true)
  private String field;
  
  @XmlElement(required = true)
  private String message;

  public Validation() {
    super();
  }
  
  public Validation(String message) {
    super();
    this.message = message;
  }

  public Validation(String field, String message) {
    super();
    this.field = field;
    this.message = message;
  }

  public Validation(String code, String field, String message) {
    super();
    this.code = code;
    this.field = field;
    this.message = message;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "ErrorDTO [code=" + code + ", field=" + field + ", message=" + message + "]";
  }
  
}