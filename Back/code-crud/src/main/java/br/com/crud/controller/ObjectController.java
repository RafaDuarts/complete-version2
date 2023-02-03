package br.com.crud.controller;

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

import java.util.List;
import br.com.crud.service.ObjectService;
import br.com.dto.ObjectDto;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;



@Path("objects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ObjectController {
    
    @Inject
    ObjectService service;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listObject(){
        List<PanacheEntityBase> objects = service.listObjects();

        return Response.ok(objects).build();
    }

    @POST
    public Response saveObject(ObjectDto dto){

        Object object = service.saveObject(dto);

        return Response.ok(object).status(201).build();

    }

    @PUT
    @Path("{id}")
    public Response updateObject(@PathParam("id") Long id, ObjectDto dto){

        service.updateObject(id, dto);

        return Response.status(204).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeObject(@PathParam("id") Long id){

        service.removeObject(id);

        return Response.status(204).build();

    }

    @GET
    @Path("/busca/{nome}")
    public Response listObjectName(@PathParam("nome") String nome){
        
        List<PanacheEntityBase> objects = service.listObjectsName(nome);

        return Response.ok(objects).build();
    }
}
