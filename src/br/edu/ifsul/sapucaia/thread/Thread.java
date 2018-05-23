package br.edu.ifsul.sapucaia.thread;

public class Thread implements Runnable {
    private String var = "";
    private String rav = "";

    public void setVar(String var) {
        this.var = var;
    }

    public String getVar() {
        return this.var;
    }

    public void setRav(String rav) {
        this.rav = rav;
    }

    public String getRav() {
        return this.rav;
    }

    @Override
    public synchronized void run() {

    }
}