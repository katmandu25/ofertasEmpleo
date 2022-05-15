package com.katmandu.empleos.util;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

public class Utilidades {

  public static String guardarArchivo(MultipartFile multiPart, String ruta) {
// Obtenemos el nombre original del archivo.
    String nombreOriginal = multiPart.getOriginalFilename();
// Quitamos espacios
    nombreOriginal = nombreOriginal.replace(" ", "-");
    String nombreFinal= ramdomAlphaNumeric(8)+nombreOriginal;
    try {
// Formamos el nombre del archivo para guardarlo en el disco duro.
      File imageFile = new File(ruta + nombreFinal);
      System.out.println("Archivo: " + imageFile.getAbsolutePath());
//Guardamos fisicamente el archivo en HD.
      multiPart.transferTo(imageFile);
      return nombreFinal;
    }
    catch (IOException e) {
      System.out.println("Error " + e.getMessage());
      return null;
    }
  }

  /*
  Metodo para generar una cadena aleatoria de longitud N
   */
  public static String ramdomAlphaNumeric(int count){
    String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder builder = new StringBuilder();
    while (count -- !=0){
      int character = (int)(Math.random()*CARACTERES.length());
      builder.append(CARACTERES.charAt(character));
    }
    return builder.toString();
  }

}
