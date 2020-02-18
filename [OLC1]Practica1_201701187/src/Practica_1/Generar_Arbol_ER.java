package Practica_1;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Generar_Arbol_ER {

    public void Crear(String titulo, String Texto) {

        File archivo;
        PrintWriter Escribir;

        archivo = new File( titulo + ".txt");

        if (!archivo.exists()) {

            try {
                archivo.createNewFile();
                Escribir = new PrintWriter(archivo, "utf-8");
                Escribir.println(Texto);
                Escribir.close();

            } catch (IOException ex) {
                Logger.getLogger(Generar_Arbol_ER.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            try {

                Escribir = new PrintWriter(archivo, "utf-8");
                Escribir.println(Texto);
                Escribir.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        String text = "dot -Tpng " + archivo.getName() + " -o " + titulo + ".png";

        CMD(text);

    }

    private void CMD(String cmd) {
        Process proceso;
        try {
            proceso = Runtime.getRuntime().exec(cmd);
            proceso.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String line = "";
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
