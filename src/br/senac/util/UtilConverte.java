package br.senac.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alunos
 */
public class UtilConverte {
 
    public static void main(String[] args) throws ParseException{
        System.out.println(toDate("07/08/2015"));
        Long.parseLong("");
        
        
    }
    public static java.util.Date toDate(Object valor) throws ParseException{
        
        if(valor == null || valor.toString().equals(""))
            return null;
        
        if(valor instanceof java.util.Date)
            return (java.util.Date)valor;
        
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
        
        return sd.parse(valor.toString());
    }    
}
