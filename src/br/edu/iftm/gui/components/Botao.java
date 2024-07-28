package br.edu.iftm.gui.components;

import javax.swing.JButton;
import java.awt.Color;

public class Botao extends JButton{
    public Botao(String texto){
       
        super(texto);
        this.setBounds(1920 / 2, 600, 150, 30);
        this.setBackground(Color.decode("#6d5dd3"));
        this.setFocusPainted(false);
        this.setBorderPainted(false);
    
    }
}
