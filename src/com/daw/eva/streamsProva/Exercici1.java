/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daw.eva.streamsProva;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.util.*;
import org.apache.commons.io.filefilter.TrueFileFilter;


/**
 *
 * @author eva
 */
public class Exercici1 {
    static String pathDirArrel = "fitxers_examen/";
    static String pathDirExercici1 = "exercici1/";
    static String nomDirPatata = "patata";
    static String pathDirACopiar = "dirACopiar";

    
    
    private static void copiarNomEnFitxer(String nomFileTrobat, int tipusFile, StringBuilder permisosFile, PrintWriter pw)  {
        if (tipusFile == 0) {
            pw.println("DIRECTORI: " + nomFileTrobat + ", " + permisosFile);
        } else {
            pw.println("FITXER: " + nomFileTrobat + ", " + permisosFile);
        }
    }
    
    public static void main(String[] args) {
       
    	
      
    	File directoriArrel = new File(pathDirArrel);
        File directoriPatata = new File(pathDirArrel + pathDirExercici1 + nomDirPatata);
        File directoriACopiar = new File(pathDirArrel + pathDirACopiar);
    	File fitxerIndex = new File(pathDirArrel + pathDirExercici1 + nomDirPatata + "/index.txt");
        
        
        boolean creat;
        FileWriter fw = null;
        PrintWriter pw = null;
        StringBuilder permisosFile = new StringBuilder("---, ");
        File fitxerIndex2;
        
    
        System.out.println("directori = " + pathDirArrel + pathDirExercici1 + nomDirPatata);
        if (!directoriPatata.exists()) {
            try {
                System.out.println("No existeix el directori");
                creat = directoriPatata.mkdir();
                System.out.println("d.mkdir() = " + creat);
                
                FileUtils.forceMkdir(directoriPatata);
                if (directoriPatata.exists()) {
                    System.out.println(directoriPatata.getAbsolutePath() + " creat amb FileUtils.forceMkdir() .");
                }
                
                fitxerIndex.createNewFile();
                System.out.println("fitxerIndex.exists() = " + fitxerIndex.exists());
                
                ArrayList<String> dadesAEscriure = new ArrayList<String>();
                dadesAEscriure.add("patata");
                dadesAEscriure.add("fregida");
                FileUtils.writeLines(fitxerIndex, "UTF-8", dadesAEscriure, true);
                
                FileUtils.copyDirectoryToDirectory(directoriACopiar, directoriPatata);
                
                FileUtils.copyFileToDirectory(fitxerIndex, directoriArrel);
                fitxerIndex = FileUtils.getFile(directoriArrel, "index.txt");
                
                boolean append = true;
                fw = new FileWriter(fitxerIndex, append);
                pw = new PrintWriter(fw, true);
                
                Iterator it = FileUtils.iterateFilesAndDirs(directoriPatata, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
                // Segons l'ajuda el TrueFileFilter.INSTANCE determina tots els fitxers i directoris.
                while (it.hasNext()) {
                    File fileTmp = (File) it.next();
                    System.out.println(fileTmp.getName());
                    
                    if (fileTmp.canRead()) permisosFile.setCharAt(0, 'r');
                    if (fileTmp.canWrite()) permisosFile.setCharAt(1, 'w');
                    if (fileTmp.canExecute()) permisosFile.setCharAt(2, 'x');
                    if (fileTmp.isHidden()){
                        permisosFile.append("OCULT, ");
                    }
                    permisosFile.append("tamany = ");
                    permisosFile.append(FileUtils.sizeOf(fileTmp));
                    permisosFile.append(" bytes.");
                    
                    
                    if (fileTmp.isDirectory()) {
                        copiarNomEnFitxer(fileTmp.getName(), 0, permisosFile, pw);
                    } else {
                        copiarNomEnFitxer(fileTmp.getName(), 1, permisosFile, pw);
                    }
                    
                    permisosFile = new StringBuilder("---, ");
                }
                
                FileUtils.cleanDirectory(directoriPatata);            // Esborrar el seu contingut sense esborrar el directoriPatata.
                
                FileUtils.copyFileToDirectory(fitxerIndex, directoriPatata);
                
                fitxerIndex2 = FileUtils.getFile(directoriPatata, "index.txt");
                if ((FileUtils.contentEqualsIgnoreEOL(fitxerIndex, fitxerIndex2, "UTF-8")) == true) {
                    System.out.println("Els 2 fitxers index.txt són iguals.");
                } else {
                    System.out.println("Els 2 fitxers index.txt NO són iguals.");
                }
                
            } catch (IOException ex) {
                Logger.getLogger(Exercici1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
