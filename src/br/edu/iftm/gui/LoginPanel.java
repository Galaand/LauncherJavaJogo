package br.edu.iftm.gui;


import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.edu.iftm.gui.components.Botao;
import br.edu.iftm.gui.components.TelaPanel;

public class LoginPanel extends TelaPanel{

    private final JButton botaoLogin;

    public LoginPanel(JPanel telas, JFrame janela){
        super(telas, janela);
        
        JLabel mensagem = new JLabel("Conteudo do Login panel");

        JTextField txtLogin = new JTextField();
        txtLogin.setBounds(1920 / 2, 500, 150, 30);

        JTextField txtPassword = new JTextField();
        txtPassword.setBounds(1920 / 2, 550, 150, 30);

        botaoLogin = new Botao("Fazer Login");
        botaoLogin.addActionListener(this);

        this.add(mensagem);
        this.add(botaoLogin);
        this.add(txtLogin);
        this.add(txtPassword);
       
    }

    @Override
    public void executarBotao(ActionEvent e){
        trocarTela("Tela Principal");
    }
}
