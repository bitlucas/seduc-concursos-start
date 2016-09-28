package br.gov.pa.prodepa.treinamentos.concursos.web.rest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class EstadoResourceTest {

  @Test
  public void testCreate() {
   
    
    List<String> list = new ArrayList<>();
    
    list.add("thiago");
    list.add("thiago");
    
    System.out.println(list);
    
    Set<String> set = new HashSet<>();
    
    set.add("thiago");
    set.add("thiago");
    set.add("massao");
    set.add("thiago");
    
    System.out.println(set);
    
    //set.remove("massao");
    
  }

}
