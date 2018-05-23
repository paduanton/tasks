package br.edu.ifsul.sapucaia.notebook;
import javax.management.InvalidAttributeValueException;
/*
 * 
 * @author Antonio J�nior
 */
public class Notebook{
    private int Id, capacidade_memoria, capacidade_disco;
    private String lembrete = null, marca, modelo, cor, usuario, pwd;
    private double peso;
    private boolean logado = false;
    
    public Notebook(){
    }
    
    public Notebook(int id, String marca, String modelo, int capacidade_memoria, int capacidade_disco,
            String cor, String usuario, String pwd, double peso)
    {
    	this.Id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.capacidade_memoria = capacidade_memoria;
        this.capacidade_disco = capacidade_disco;
        this.cor = cor;
        this.usuario = usuario;
        this.pwd = pwd;
        this.peso = peso;
    }
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getLembrete() throws NullPointerException{
    	if(this.lembrete == null){
            throw new NullPointerException("Insira o Lembrete primeiro!");
        }else{
            return this.lembrete;
        }
    }

    public void setLembrete(String lembrete) throws InvalidAttributeValueException{
        if(lembrete.length() >= 40){
            this.lembrete = lembrete;
        }else{
        	throw new InvalidAttributeValueException("M�nimo 40 caracteres!");
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getCapacidade_memoria() {
        return capacidade_memoria;
    }

    public void setCapacidade_memoria(int capacidade_memoria) {
        this.capacidade_memoria = capacidade_memoria;
    }

    public int getCapacidade_disco() {
        return capacidade_disco;
    }

    public void setCapacidade_disco(int capacidade_disco) {
        this.capacidade_disco = capacidade_disco;
    }
    
    @Override
    public String toString(){
        return "This is "+usuario+"'s notebook";
    }
    
    public void ligar(){
        System.out.println("Iniciando o Sistema Operacional...\n\n");
    }
    
    public int localizar(String palavra){
        int num = 0;
        String[] palavras = getLembrete().split(" "); 
        
        for (int i = 0; i < palavras.length; i++) {
            if(palavra.equalsIgnoreCase(palavras[i])){ 
               num++;
            }
        }
        return  num;
    }
    
    public void lembreteInfo(){
    	String[] palavras = getLembrete().split(" ");
    	int char_palavras = 0, media_char = 0;
    	int num_palavras = palavras.length;
    	
    	for(String palavra : palavras){
    		char_palavras += palavra.length();
    	}
    	
    	if(num_palavras != 0){
    		media_char = char_palavras/num_palavras; 
    	}
    	
    	System.out.println("Tamanho do Lembrete: "+getLembrete().length()+" caracteres.");
    	System.out.println("Quantidade de palavras: "+num_palavras);
    	System.out.println("M�dia de caracteres por palavra: "+media_char);
    }
    
    public void logout(){
    	if(this.isLogado()){
    		setLogado(false);
    		System.out.println("\n\nAt� logo "+getUsuario()+".");
    	}
    }
    
    public String logar(String user, String psw){
    	if(this.getUsuario().equals(user) && this.getPwd().equals(psw)){
    		this.setLogado(true); 
    		return "Seja bem vindo usu�rio "+user+"!";
    	}else{
    		this.setLogado(false);
    		return "Usu�rio Invalido!";
    	}
    }
    
    public void createLembrete(String lembrete) throws InvalidAttributeValueException{
        if(this.lembrete == null){
            this.setLembrete (lembrete);
        }else{
            this.updateLembrete(lembrete);
        }
    }
    public String recoveryLembrete(){
        return getLembrete();
    }
    
    public boolean updateLembrete(String novo_valor) throws InvalidAttributeValueException{
        if(this.getLembrete() == null){
            return false;
        }else{
            this.setLembrete(novo_valor);
            return true;
        }
    }
    public void deleteLembrete() throws InvalidAttributeValueException{
        this.lembrete = null;
    }

	public boolean isLogado() {
		return logado;
	}

	private void setLogado(boolean logado) {
		this.logado = logado;
	}
}