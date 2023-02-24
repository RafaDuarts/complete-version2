package br.com;

import java.util.List;
import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("objects")
public class GreetingResource {

    private List<Object> objects = new ArrayList<Object>();

    public GreetingResource(){

    Object ob1 = new Object("Brasil", "Estadio Bento Freitas");
    Object ob2 = new Object("Grêmio", "Arena do Gremio");
    Object ob3 = new Object("Internacional", "Estadio Beira Rio");
    Object ob4 = new Object("Ypiranga", "Estadio Colosso da Lagoa");
    Object ob5 = new Object("Caxias", "Estadio Centenario");
    Object ob6 = new Object("Juventude", "Estadio Alfredo Jaconi");
    Object ob7 = new Object("São José", "Estadio Passo D'areia");
    Object ob8 = new Object("Avenida", "Estadio dos Eucaliptos");
    Object ob9 = new Object("Novo Hamburgo", "Estadio do Vale");
    Object ob10 = new Object("São Luiz", "Estadio 19 de outubro");
    Object ob11 = new Object("Esportivo", "Estadio Montanha dos Vinhedos");
    Object ob12 = new Object("Aimoré", "Estadio Cristo Rei");


    
    objects.add(ob1);
    objects.add(ob2);
    objects.add(ob3);
    objects.add(ob4);
    objects.add(ob5);
    objects.add(ob6);
    objects.add(ob7);
    objects.add(ob8);
    objects.add(ob9);
    objects.add(ob10);
    objects.add(ob11);
    objects.add(ob12);


    }

    public GreetingResource(List<Object> objects){
        this.objects = objects;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object> getObjects(){
        return objects;
    }
    
    // public void addObject(Object object){
    //     objects.add(object);
    // }

    @Path("/{name}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Object buscaNome(@PathParam("name") String name){
        List<Object> obj = new ArrayList<Object>();

        for(int i=0; i < objects.size(); i++){
            if(objects.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                Object obj1 = new Object(objects.get(i).getName(), objects.get(i).getDescription());
                obj.add(obj1);
            }
        }
        return (Object) obj;
    }


}