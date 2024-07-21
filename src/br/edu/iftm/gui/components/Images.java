package br.edu.iftm.gui.components;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Images extends JLabel{
    public Images(String name){
        super();
        ImageIcon icon = new ImageIcon(Images.class.getResource("/images/" + name)); 
        setIcon(icon);
        repaint();
    }
}
