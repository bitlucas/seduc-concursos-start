package br.gov.pa.prodepa.treinamentos.concursos.web.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;


import org.jboss.resteasy.plugins.providers.jackson.ResteasyJackson2Provider;


import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

@Provider
public class JacksonConfigurator extends ResteasyJackson2Provider{

    @Override
    public void writeTo(Object value, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String,Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
        //get the Object Mapper
        ObjectMapper mapper = locateMapper(type, mediaType);
        
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        
        mapper.registerModule(new Hibernate4Module());
        
        // Suppress null properties in JSON output
        mapper.setSerializationInclusion(Include.NON_NULL);

        super.writeTo(value, type, genericType, annotations, mediaType, httpHeaders, entityStream);
    }
}