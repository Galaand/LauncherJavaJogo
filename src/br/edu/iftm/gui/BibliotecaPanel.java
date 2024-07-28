package br.edu.iftm.gui;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.JSONArray;
import org.json.JSONObject;

import br.edu.iftm.gui.components.TelaPanel;
import br.edu.iftm.model.Jogo;

public class BibliotecaPanel extends TelaPanel {

    private final JButton botaoPrincipal;
    private ArrayList<Jogo> jogos;
    private String jsonJogos;
    
    public BibliotecaPanel(JPanel telas, JFrame janela){
        super(telas, janela);
        this.jogos = new ArrayList<Jogo>();

        botaoPrincipal = new JButton("Voltar");
        botaoPrincipal.addActionListener(this);
        botaoPrincipal.setBounds(0,0,100,30);

        carregarJogos();

        this.add(botaoPrincipal);
    }

    private void carregarJogos(){
        try {
            jsonJogos = lerJsonJogos();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsonArrayJogos = new JSONArray(jsonJogos);
        for (int i = 0; i < jsonArrayJogos.length(); i++) {
            JSONObject jogoJObject = (JSONObject) jsonArrayJogos.get(i);
            jogos.add(new Jogo(jogoJObject));
        }
        for (Jogo jogo : jogos) {
            System.out.println(jogo.getIcone());
        }
    }

    private String lerJsonJogos() throws IOException{

        File arquivoJson = new File("gameList.json");
        StringBuilder conteudoArquivo = new StringBuilder();

        try {
            BufferedReader leitor = new BufferedReader(new FileReader(arquivoJson));

            String linha = leitor.readLine();
            while (linha != null) {
                conteudoArquivo.append(linha);
                linha = leitor.readLine();
            }
            leitor.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conteudoArquivo.toString();
    }

    @Override
    public void executarBotao(ActionEvent e){
        trocarTela("Tela Login");
    }
}
