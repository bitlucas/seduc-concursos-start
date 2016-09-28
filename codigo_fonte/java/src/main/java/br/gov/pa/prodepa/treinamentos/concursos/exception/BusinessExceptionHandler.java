package br.gov.pa.prodepa.treinamentos.concursos.exception;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


/**
 * 
 * @author thiago.soares (thiago.soares.jr@gmail.com) 
 *
 */
@Provider
public class BusinessExceptionHandler implements ExceptionMapper<BusinessException> {

  @Override
  public Response toResponse(BusinessException exception) {
    
    exception.printStackTrace();
    
    ExceptionDTO dto = new ExceptionDTO();
    
    dto.setMessage(exception.getMessage());
    
    if(exception.getValidations() != null && !exception.getValidations().isEmpty()) {
      dto.setValidations(exception.getValidations());
      /*dto.setValidations(new ArrayList<Validation>());
      for(Validation val : exception.getValidations()) {
        dto.getErros().add(new Validation(val));
      }*/
    }
    
    dto.setStatus(Status.BAD_REQUEST.name());
    dto.setStatusCode(Status.BAD_REQUEST.getStatusCode());
    
    return Response.status(Status.BAD_REQUEST).entity(dto).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_TYPE.withCharset("utf-8")).build(); 
  }

}
