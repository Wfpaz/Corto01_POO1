package com.sv.udb.clases;
import java.util.Random;
import javax.swing.SwingWorker;
import com.sv.udb.clases.ClsJFigura;
/**
 *
 * @author Walter
 */
public class ClsJugar extends SwingWorker<Integer, Void>{

    private ClsJFigura jfigura;
    private int value=0;
    private int wait = 6; //milisegundos
    
    /** Constructor de clase */
    public ClsJugar(ClsJFigura jc)
    {
        jfigura = jc;        
    }    
     
    @Override
    protected Integer doInBackground() throws Exception {
        int giros=0;        
        Random random = new Random();
        int n  = random.nextInt(7) + 1;
        int rotate  = random.nextInt(5) + 2;
        while( giros < rotate)//rotacion
        {
            giros++;
            value = 0;            
            for(int i=0;i<( n*10 );i++)
            {
                value -=10;
                jfigura.updateY(value);    
                Thread.sleep(wait);                       
            }         
            wait +=10;
        }                   
        return value;
    }
    
}
