/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.exemplos.colecoes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Gerson
 */
public class ComoUsarArrayList {
    
    
    public static void main(String[] args) {
        
        /**
         * Como ArrayList implementa List, posso criar um ArrayList 
         * e atribuir a uma variável do tipo List. Utilizei Generics <Long>
         * para indicar só redebrá tipos Long. Oitenda inicializa a lista com
         * um array de oitenta elementtos. Para explorar o código fonte do 
         * ArrayList, posicione o cursor do mouse no mesmo e clique em F3.
         */
        List<Long> lista = new ArrayList<>(80);
        
        /**
         * Repeita a ordem de inclusão, ao percorrer, faz com que os elementos
         * fiquem na mesma posição em que foram inseridos. Permite elementos
         * duplicados (iguais) e nulos.
         * Dependendo do problema, pode ser um pouco mais lento do que
         * um HashSet (não respeita a ordem e não permite valores duplicados e nulos).
         */
        lista.add(50L); //Adiciona um elemento na posição 0
        lista.add(10L); //Adiciona um elemento na posição 1
        lista.add(10L); //Adiciona mais um elemento na posição 2
        lista.add(null); //Adiciona mais um elemento na posição 3
        lista.add(1, 10000L); //Adiciona mais um elemento na posição 1 e desloca todos os outros
        lista.add(-999L); //Adiciona mais um elemento na posição 5
        
        //Percorrer com for padrão
        for(int i = 0; i < lista.size(); i++){
            System.out.println(i + ": " + lista.get(i));
        }
        
        System.out.println("\nforeach");
        //Percorrer com foreach tradicional do java
        for(Long numero : lista){
            System.out.println(numero);
        }
        
        System.out.println("\nIterator");
        /* Percorrer a lista com Iterator
         * Permite a remoção de elementos enquanto os mesmos são percorridos
         * utilizando semântica adequada
        */
        Iterator<Long> iterator = lista.iterator();
        while(iterator.hasNext()){
            Long numero = iterator.next();
            if(new Long(10).equals(numero) || numero == null){
                iterator.remove();
            }
            System.out.println(numero);
        }
        
        /**
         * Ordena a lista. Isso só funciona porque todas as classes
         * Wrapper (encapsulam tipos primitivos) que já implementam por padrão 
         * a interface Comparable. Acesse o fonte da classe Long e confira.
         * Caso contrário geraria erro. A outra solução seria você implementar um 
         * Comparator e passar por padrâmetro.
         */
        Collections.sort(lista);
        
        //Percorrer com lambda
        System.out.println("\nLambda");
        lista.forEach((numero) -> System.out.println(numero));
        
        /**
         * Usando Comparator para ordena de forma inversa a lista.
         * Ou seja, com isso foi sobreescrita a lógica de ordenação
         */
        Collections.sort(lista, new Comparator<Long>(){
            public int compare(Long o1, Long o2) {
                if(o1 > 02)
                    return -1;
                else if(o1 < o2)
                    return 1;
                else
                    return 0;
            }
        });
        System.out.println("\nLambda");
        lista.forEach((numero) -> System.out.println(numero));
        
    }
    
}
