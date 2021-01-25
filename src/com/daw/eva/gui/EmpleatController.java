package com.daw.eva.gui;

import java.util.Set;
import java.util.TreeSet;

public class EmpleatController {
    Set<Empleat> empleados = new TreeSet<Empleat>(); 

    public void afegirEmpleat(Empleat e)throws ValidationEmpleatException {
        validarEmpleat(e);
        empleados.add(e);
    }
	
    private void validarEmpleat(Empleat e) throws ValidationEmpleatException {
        ValidationEmpleatException exceptionTmp = new ValidationEmpleatException();
        
        if (e.getNom().equals(null) || e.getNom().equals("") || !e.getNom().matches(".*[0-9]+.*")){
            exceptionTmp.addError("nom incorrecte");
        }
        
        if (e.getCognom1()== null  || e.getCognom1().equals("") ||  !e.getCognom1().matches(".*[0-9]+.*")){
            exceptionTmp.addError("cognom 1 incorrecte");
        }
        
        if (e.getCognom2()==null  || e.getCognom2().equals("") ||  !e.getCognom2().matches(".*[0-9]+.*")){
            exceptionTmp.addError("cognom 2 incorrecte");
        }
        
        if( e.getDni()==null  || e.getDni().equals("") ||  validaDNI(e.getDni())){
            exceptionTmp.addError("dni incorrecte");
        }

        if (e.getJornadaLaboral()==-1){
            exceptionTmp.addError("jornada incorrecte");
        }
        
        if (e.getSalari()==-1){
            exceptionTmp.addError("salari incorrecte");
        }
        
        if (e.getCodiEmpleat()==-1){
            exceptionTmp.addError("codi incorrecte");
        }
        
        if(exceptionTmp.hasErrors()){
            throw exceptionTmp;     
            //Com llança l'excepció, a llavors no s'executarà la següent linia
            //de afegirEmpleat() i com ningú en aquesta classe tracta l'excepció
            //perquè no hi ha un try-catch ni en validarEmpleat() ni en afegirEmpleat()
            //l'excepció puja per les crides a classes i mètodes fins que arriba a
            //GUI.java que tè un try-catch i captura l'excepció aquí llançada.
        }
    }

    private boolean validaDNI(String dni) {
        boolean valida = false;
        char taula [] = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        int valor = Integer.parseInt(dni.substring(0, dni.length()-2));
        char caracter = dni.charAt(dni.length()-1);
        int sum = 0;
        
        while(valor > 0){
            sum = sum%10;
            valor = valor/10;
        }
        if (taula[sum%23]==caracter)valida=true;

        return valida;
    }
	
}
