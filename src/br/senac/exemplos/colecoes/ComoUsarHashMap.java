/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.exemplos.colecoes;

import br.senac.pessoa.model.PessoaFisica;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Gerson
 */
public class ComoUsarHashMap {
    
    public static void main(String[] args) {
        
        
        /**
         * Utilizado para resolver problemas que possuem
         * uma relação Chave=Valor. Onde a chave é um identificador único
         * de um Objeto qualquer. A própria chave é um Objeto.
         * Por exemplo, o objeto PessoaFisica possui a chave "Long id" e o valor
         * poderia ser o próprio objeto PessoaFisica.
         * No HashMap, pode-se colocar qualquer objeto na chave e qualquer
         * objeto no valor.
         * 
         * A ordem dos elementos inseridos não é mantida,
         * se precisar manter a ordem a partir de determinado
         * critério de ordenação, utilize o TreeMap
         */ 
        HashMap<Long, PessoaFisica> hashPessoaFisica = new HashMap<>();
        
        List<PessoaFisica> pessoas = getPessoaFisicas();
        for(PessoaFisica pessoa : pessoas){
            hashPessoaFisica.put(pessoa.getId(), pessoa);
        }
        
        Iterator<Long> iteratorPessoaFisica = hashPessoaFisica.keySet().iterator();
        while(iteratorPessoaFisica.hasNext()){
            Long id = iteratorPessoaFisica.next();
            PessoaFisica pessoa = hashPessoaFisica.get(id);
            System.out.println(id + " - " + pessoa.getNome());
        }
        
        System.out.println("Outra forma de percorrer"); 
        Object[] ids = hashPessoaFisica.keySet().toArray();
        for(Object id : ids){
           PessoaFisica pessoa = hashPessoaFisica.get(id);
           System.out.println(id + " - " + pessoa.getNome());
        }    
        
        TreeMap<Long, PessoaFisica> treePessoaFisica = new TreeMap<>();
        for(PessoaFisica pessoa : pessoas){
            treePessoaFisica.put(pessoa.getId(), pessoa);
        }
        
        /**
         * Lembrando que o Long já implementa a classe Comparable
         * por isso a ordenação ocorre corretamente.
         * Se Long, que é a chave do TreeMap, não tivesse implementado Comparable, ao
         * executar ocorreria uma Exceção:
         * java.lang.ClassCastException: br.senac.pessoa.model.PessoaFisica cannot be cast to java.lang.Comparable
         */
        System.out.println("TreeMap usa um critério de ordenação na chave");
        iteratorPessoaFisica = treePessoaFisica.keySet().iterator();
        while(iteratorPessoaFisica.hasNext()){
            Long id = iteratorPessoaFisica.next();
            PessoaFisica pessoa = hashPessoaFisica.get(id);
            System.out.println(id + " - " + pessoa.getNome());
        }
        
        /**
         * HashMap agrupando pessoas por Sexo
         */
        HashMap<String, ArrayList<PessoaFisica>> hashPessoaFisicaSexo = new HashMap<>();
        for(PessoaFisica pessoa : pessoas){
            if(!hashPessoaFisicaSexo.containsKey(pessoa.getSexo())){
                hashPessoaFisicaSexo.put(pessoa.getSexo(), new ArrayList<>());
            }
            hashPessoaFisicaSexo.get(pessoa.getSexo()).add(pessoa);
        }
        
        System.out.println("\nImprimindo pessoas agrupadas por Sexo e ordenadas por nome");
        Iterator<String> keys = hashPessoaFisicaSexo.keySet().iterator();
        while(keys.hasNext()){
            String sexo = keys.next();
            System.out.println("Sexo: " + sexo);
            ArrayList<PessoaFisica> pessoasOrdNome = hashPessoaFisicaSexo.get(sexo);
            //Ordenar usando Lambda. Note que a classe String já tem implementado o compareTo da interface Comparable
            Collections.sort(pessoasOrdNome, (PessoaFisica p1, PessoaFisica p2) -> p1.getNome().compareTo(p2.getNome()));
            for(PessoaFisica pessoa : pessoasOrdNome){
                System.out.println(pessoa.getId() + " - " + pessoa.getNome());
            }
        }
        
    }
    
    public static List<PessoaFisica> getPessoaFisicas(){
        
        return Arrays.asList(new PessoaFisica(10L, "Carmen", "F"),
                new PessoaFisica(610L, "Laura", "F"),
                new PessoaFisica(110L, "Ivo", "M"),
                new PessoaFisica(102L, "Adam", "M"),
                new PessoaFisica(110L, "Pedro", "M"),
                new PessoaFisica(1L, "Angelo", "M"),
                new PessoaFisica(140L, "Wallace", "M"),
                new PessoaFisica(105L, "Maria", "F"),
                new PessoaFisica(1044L, "Bianca", "F"),
                new PessoaFisica(120L, "Lenini", "M"),
                new PessoaFisica(1110L, "Natan", "M"),
                new PessoaFisica(111110L, "Marcio", "M"));
    }
    
}
