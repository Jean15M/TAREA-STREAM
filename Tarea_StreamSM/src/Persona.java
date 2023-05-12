/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author Joseline
 */
public class Persona {
    static ArrayList <Persona> listaPer = new ArrayList<Persona>();
    private String primer_nom;
    private String primer_ape;
    private String segund_ape;
 
    public Persona(String primer_nom, String primer_ape, String segund_ape) {
        this.primer_nom = primer_nom;
        this.primer_ape = primer_ape;
        this.segund_ape = segund_ape;
    }

    public Persona() {
    }

    public String getPrimer_nom() {
        return primer_nom;
    }

    public void setPrimer_nom(String primer_nom) {
        this.primer_nom = primer_nom;
    }

    public String getPrimer_ape() {
        return primer_ape;
    }

    public void setPrimer_ape(String primer_ape) {
        this.primer_ape = primer_ape;
    }

    public String getSegund_ape() {
        return segund_ape;
    }

    public void setSegund_ape(String segund_ape) {
        this.segund_ape = segund_ape;
    }

    @Override
    public String toString() {
        return "Persona{" + "primer_nom=" + primer_nom + ", primer_ape=" + primer_ape + ", segund_ape=" + segund_ape + '}';
    }
    
    public static void leerTxt(String direccion) {

        try {
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String[] personas;
            String bfRead;
            Instant tiempo_inic = Instant.now();
            while((bfRead = bf.readLine()) != null){
                personas = bfRead.split(" ");
                Persona p1 = new Persona();
                p1.setPrimer_nom(personas[0]);
                p1.setPrimer_ape(personas[1]);
                p1.setSegund_ape(personas[2]);
                listaPer.add(p1);
                
                
            }
            Instant tiempo_fin = Instant.now();
            long total = (long)(ChronoUnit.MILLIS.between(tiempo_inic, tiempo_fin));
            System.out.println("TIEMPO DEL PROCESO DE CARGA: "+total+" MILISEGUNDOS");
        } catch (Exception ex) {
            System.err.println("Archivo no encontrado");
        }
    }
    
}
