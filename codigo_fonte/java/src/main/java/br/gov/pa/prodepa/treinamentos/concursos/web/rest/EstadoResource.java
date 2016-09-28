package br.gov.pa.prodepa.treinamentos.concursos.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.gov.pa.prodepa.treinamentos.concursos.model.Estado;

/**
 * REST controller for managing Estado.
 */
@Path("/estados")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EstadoResource {

    private final Logger log = LoggerFactory.getLogger(EstadoResource.class);
        
    /**
     * POST  /estados : Create a new estado.
     *
     * @param estadoDTO the estadoDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new estadoDTO, or with status 400 (Bad Request) if the estado has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @POST
    @Path("/")
    public Response create(Estado estado) throws URISyntaxException {
        log.debug("REST request to save Estado : {}", estado);
        return Response.created(new URI("/estados/" + estado.getId())).build();
    }
    
    
    

    /**
     * PUT  /estados : Updates an existing estado.
     *
     * @param estado the estadoDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated estadoDTO,
     * or with status 400 (Bad Request) if the estadoDTO is not valid,
     * or with status 500 (Internal Server Error) if the estadoDTO couldnt be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PUT
    @Path("/")
    public Response update(Estado estado) throws URISyntaxException {
        log.debug("REST request to update Estado : {}", estado);
        return Response.ok().entity(estado).build();
    }

    /**
     * GET  /estados : get all the estados.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of estados in body
     * @throws URISyntaxException if there is an error to generate the pagination HTTP headers
     */
    @GET
    @Path("/")
    public Response getAll() throws URISyntaxException {
        log.debug("REST request to get a page of Estados");
        
        List<Estado> lista = Arrays.asList(new Estado(1L, "Pará", "PA"), new Estado(2L, "Maranhão", "MA"));
        
        return Response.ok().entity(lista).build();
    }
    
    @POST
    @Path("/search")
    public Response search(Estado estado) throws URISyntaxException {
        log.debug("REST request to save Estado : {}", estado);
        
        List<Estado> lista = Arrays.asList(new Estado(1L, "Pará", "PA"), new Estado(2L, "Maranhão", "MA"));
        
        return Response.ok().entity(lista).build();
    }

    /**
     * GET  /estados/:id : get the "id" estado.
     *
     * @param id the id of the estadoDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the estadoDTO, or with status 404 (Not Found)
     */
    @GET
    @Path("/{id}")
    public Response getOne(@PathParam("id") Long id) {
        log.debug("REST request to get Estado : {}", id);
        
        Estado estado = new Estado(1L, "Pará", "PA");
        
        if(estado == null) {
          return Response.status(Status.NOT_FOUND).build();
        }
        
        return Response.ok().entity(estado).build();
    }

    /**
     * DELETE  /estados/:id : delete the "id" estado.
     *
     * @param id the id of the estadoDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        log.debug("REST request to delete Estado : {}", id);
        
        return Response.ok().entity("{\"message\":\"O registro foi removido.\"}").build();
    }

}
