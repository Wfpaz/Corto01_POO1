package com.sv.udb.clases;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
/**
 *
 * @author Walter
 */
public class ClsJFigura extends JComponent {
    
    private final ImageIcon image= new ImageIcon( getClass().getResource("/com/sv/udb/images/Imagen.png"));           
    private int y=0;
    private final Dimension d = new Dimension(100,100);
    
    /** Constructor de clase */
    public ClsJFigura()
    {
        setSize(d);
        setPreferredSize(d);
        setVisible(true);
    }
    
    /** Actualiza coordenada en Y */
    public void updateY(int value)
    {
        y = value;
        repaint();
    }
    
    @Override
    public void paint (Graphics g){
        super.paint(g);
        g.drawImage(image.getImage(), 0, y, 100, 690, this);                
	g.dispose();
    }
 
}
