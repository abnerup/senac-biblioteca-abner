package br.senac.importar;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import br.senac.pessoa.model.PessoaFisica;
import br.senac.util.UtilConverte;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.Iterator;

/**
 *
 * @author Alunos
 */
public class Importador {
    
    
    public static void main(String args[]) throws IOException, ParseException, Exception{
        
        importarPessoasFisica();
    }
    
    public static HashSet<PessoaFisica> importarPessoasFisica() throws Exception{
        Path caminho = Paths.get("resources\\PessoasFísicas.csv");
        String conteudo = new String(Files.readAllBytes(caminho));
        System.out.println(conteudo);
        
        String[] linhas = conteudo.split("\n");
        HashSet<PessoaFisica> hashSetPessoaFisica = new HashSet();
        PessoaFisica pessoa = null;
        for(int i = 0; i < linhas.length; i++){
            //Pula a primeira linha pois é o cabeçalho
            if(i == 0)
                continue;
            String coluna[] = linhas[i].split(";");
            //Processando uma linha
            pessoa = new PessoaFisica();
            hashSetPessoaFisica.add(pessoa);
            for(int f = 0; f < coluna.length; f++){
                //Processando as colunas
                switch(f){
                    case 0:
                        pessoa.setNome(coluna[f]);
                        break;
                    case 3:
                        pessoa.setSexo(coluna[f].substring(0, 1));
                        break;
                    case 4:
                        pessoa.setDtNascimento(UtilConverte.toDate(coluna[f]));
                        break;
                }
            }
        }
        Iterator<PessoaFisica> pessoas = hashSetPessoaFisica.iterator();
        while(pessoas.hasNext()){
            PessoaFisica pessoaFisica = pessoas.next();
            System.out.println(pessoaFisica.getNome() + " - " + pessoaFisica.getSexo());
        }
        System.out.println(hashSetPessoaFisica.size());        
        return hashSetPessoaFisica;
    }
    
}
