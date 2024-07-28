package br.edu.iftm.gui.components;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TelaPanel extends JPanel implements ActionListener{

    private final JPanel telas;
    private final CardLayout controleTela;
    private final JFrame janela;
    private boolean wasMax = true;
    private boolean wasRestored;

    public TelaPanel(JPanel telas, JFrame janela){
        this.telas = telas;
        this.controleTela = (CardLayout)telas.getLayout();
        this.janela = janela;
        this.setLayout(null);

        janela.setExtendedState(JFrame.NORMAL);
        janela.setSize(400, 300);
        janela.setLocationRelativeTo(null);
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    
        setBackground(Color.decode("#202028"));
        
        Images closeButton = new Images("window-close.png");
        closeButton.setBounds(1890,0,36,36);

        Images maximizeButton = new Images("window-maximize.png");
        maximizeButton.setBounds(1850,0,36,36);

        Images minimizeButton = new Images("window-minimize.png");
        minimizeButton.setBounds(1810,0,36,36);
        
        closeButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                janela.dispose();
            }
        });

        maximizeButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                if (janela.getExtendedState() == JFrame.MAXIMIZED_BOTH) {
                    janela.setExtendedState(JFrame.NORMAL); // Volta ao estado normal
                    closeButton.setBounds(370,0,20,20);
                    maximizeButton.setBounds(340,0,20,20);
                    minimizeButton.setBounds(310,0,20,20);
                    wasMax = false;
                } else {
                    janela.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza
                    closeButton.setBounds(1890,0,36,36);
                    maximizeButton.setBounds(1850,0,36,36);
                    minimizeButton.setBounds(1810,0,36,36);
                    wasMax = true;
                }
            }
        });

        minimizeButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                janela.setExtendedState(JFrame.ICONIFIED);
                wasRestored = true;
            }
        });
        
        janela.addWindowStateListener((WindowStateListener) new WindowAdapter() { 
            @Override
            public void windowStateChanged(WindowEvent e) {
                int oldState = e.getOldState();
                int newState = e.getNewState();

                if ((oldState & JFrame.ICONIFIED) != 0 && (newState & JFrame.ICONIFIED) == 0 && wasRestored) {
                    if(wasMax){
                        System.out.println("I was there");
                        janela.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximiza
                        closeButton.setBounds(1890,0,36,36);
                        maximizeButton.setBounds(1850,0,36,36);
                        minimizeButton.setBounds(1810,0,36,36);
                    }else if(!wasMax){
                        System.out.println("I was here");
                        janela.setExtendedState(JFrame.NORMAL); // Primeiro, define o estado como normal
                        janela.setSize(400, 300); // Define o tamanho da janela
                        janela.setLocationRelativeTo(null); // Reposiciona a janela no centro da tela (opcional)
                        closeButton.setBounds(370,0,20,20);
                        maximizeButton.setBounds(340,0,20,20);
                        minimizeButton.setBounds(310,0,20,20);
                    }
                }
            }
        });
        
        this.add(closeButton);
        this.add(maximizeButton);
        this.add(minimizeButton);
    
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        executarBotao(e);
    }

    protected void executarBotao(ActionEvent e){
    //
    }

    protected void trocarTela(String identificadorTela){
        controleTela.show(telas,identificadorTela);
    }

}
