package br.edu.iftm.model;

import org.json.JSONObject;

public class Jogo {
    private String name;
    private String path;
    private String icone;
    private String fundo;

    public Jogo(String name,String path,String icone,String fundo){
        this.name = name;
        this.path = path;
        this.icone = icone;
        this.fundo = fundo;
    }

    public Jogo(JSONObject jsonObject){
        this.name = jsonObject.getString("name");
        this.path = jsonObject.getString("path");
        this.icone = jsonObject.getString("icone");
        this.fundo = jsonObject.getString("fundo");
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    public String getIcone() {
        return icone;
    }
    public void setIcone(String icone) {
        this.icone = icone;
    }
    public String getFundo() {
        return fundo;
    }
    public void setFundo(String fundo) {
        this.fundo = fundo;
    }
}
