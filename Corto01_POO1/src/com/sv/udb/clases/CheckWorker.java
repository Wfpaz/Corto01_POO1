package com.sv.udb.clases;
import java.awt.Color;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
/**
 *
 * @author Walter
 */
public class CheckWorker extends SwingWorker<Boolean, Void>{
    
    private JLabel label;
    private JLabel boton;
    SwingWorker swingWorkerA;
    SwingWorker swingWorkerB;
    SwingWorker swingWorkerC;
    
    /**
     * Constructor de clase
     */
    public CheckWorker(SwingWorker a, SwingWorker b, SwingWorker c, JLabel lb, JLabel btn)
    {
        this.swingWorkerA=a;
        this.swingWorkerB=b;
        this.swingWorkerC=c;
        label = lb;
        boton = btn;
    }
    
    @Override
    protected Boolean doInBackground() throws Exception {
        
        int val1= (Integer) swingWorkerA.get(); 
        int val2= (Integer) swingWorkerB.get(); 
        int val3= (Integer) swingWorkerC.get();         
        if( val1== -200 && val2 == -200 && val3 == -200)
        {            
            return true;//gana
        }        
        else
        {            
            return false;//pierde
        }        
    }
    
    @Override
    protected void done(){   
        try {
            //segun resultado de juego actualiza interfaz
            if( get() )
            {
                label.setText( "Ganaste!" );                
            }
            else
            {
                label.setText( "Perdiste!" );                
            }           
            boton.setEnabled(true);
        } catch (InterruptedException ex) {
            System.err.println("InterruptedException: " + ex.getMessage());
        } catch (ExecutionException ex) {
            System.err.println("ExecutionException: " + ex.getMessage());
        }
    }
    
}
