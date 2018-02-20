/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Cayalav
 */
import javax.swing.JProgressBar;

/**
 *
 * @author caya
 */
public class CargaVentana extends Thread {

    JProgressBar progreso;

    public CargaVentana(JProgressBar progreso) {
        super();
        this.progreso = progreso;
    }

    public void run() {
        for (int i = 0; i <= 100; i++) {
            progreso.setValue(i);
            pausa(0);
        }

    }

    public void pausa(int mlseg) {
        try {
            Thread.sleep(mlseg);
        } catch (Exception e) {

        }
    }

}
