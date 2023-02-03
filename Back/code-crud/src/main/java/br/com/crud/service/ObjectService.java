package br.com.crud.service;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import br.com.crud.entity.Object;
import br.com.dto.ObjectDto;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@ApplicationScoped
public class ObjectService {
    
    public List<PanacheEntityBase> listObjects(){
        return Object.listAll();
    }

    @Transactional
    public Object saveObject(ObjectDto dto){

        Object object = new Object();

        object.setNome(dto.getNome());
        object.setEmail(dto.getEmail());
        object.setTelefone(dto.getTelefone());
        object.persist();

        return object;

    }

    @Transactional
    public void updateObject(Long id, ObjectDto dto){

        Object object = new Object();

        Optional<Object> objectOp = Object.findByIdOptional(id);

        if(objectOp.isEmpty()){
            throw new NullPointerException("Nao encontrado");
        }

        object = objectOp.get();

        object.setNome(dto.getNome());
        object.setEmail(dto.getEmail());
        object.setTelefone(dto.getTelefone());
        object.persist();

    }

    @Transactional
    public void removeObject(Long id){

        Optional<Object> objectOp = Object.findByIdOptional(id);
        
        if(objectOp.isEmpty()){
            throw new NullPointerException("Nao encontrado");
        }

        Object object = objectOp.get();

        object.delete();

    }

    @Transactional
    public List<PanacheEntityBase> listObjectsName(String name){

        return Object.find("nome",name).list();
    }



}