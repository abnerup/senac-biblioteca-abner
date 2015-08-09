/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.exemplos.colecoes;

import br.senac.pessoa.model.Pessoa;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gerson
 */
public class ComoUsarHashMap {
    
    public static void main(String[] args) {
        
        
        /**
         * Utilizando para facilitar a busca de informações que possuem
         * um relação Chave = Valor. Onde a chave é um identificador único
         * de um Objeto qualquer. A própria chave é um Objeto.
         * Por exemplo, o objeto Pessoa possui a chave "Long id" e o valor
         * poderia ser o próprio objeto Pessoa.
         */ 
        HashMap<Long, Pessoa> hashPessoa = new HashMap<>();
        
        List<Pessoa> pessoas = getPessoas();
        
        for(Pessoa pessoa : pessoas){
            hashPessoa.put(pessoa.getId(), pessoa);
        }
        
        Iterator<Long> iteratorPessoa = hashPessoa.keySet().iterator();
        while(iteratorPessoa.hasNext()){
            Long id = iteratorPessoa.next();
            Pessoa pessoa = hashPessoa.get(id);
            System.out.println(pessoa.getNome());
        }
        
        
        
    }
    
    public static List<Pessoa> getPessoas(){
        
        return Arrays.asList(new Pessoa(10L, "Carmen"),
                new Pessoa(610L, "Laura"),
                new Pessoa(110L, "Ivo"),
                new Pessoa(102L, "Adam"),
                new Pessoa(110L, "Pedro"),
                new Pessoa(1L, "Angelo"),
                new Pessoa(140L, "Wallace"),
                new Pessoa(105L, "Maria"),
                new Pessoa(1044L, "Bianca"),
                new Pessoa(120L, "Lirio"),
                new Pessoa(1110L, "Natan"),
                new Pessoa(111110L, "Marcio"));
    }
    
}
