package data;

public class OperatoerDTO {
    private int oprId;                     
    private String oprNavn;                
    private String ini;   //Initialer               
    private int cpr;                 
    private String password;
    
    public OperatoerDTO(int oprId, String oprNavn, String ini, int cpr, String password){
    	this.oprId = oprId;
    	this.oprNavn = oprNavn;
    	this.ini = ini;
    	this.cpr = cpr;
    	this.password = password;
    }
    
    public int getID(){
    	return oprId;
    }
    
    public String getNavn() {
    	return oprNavn;
    }
    
    public String getIni() {
    	return ini;
    }
    
    public int getCpr() {
    	return cpr;
    }
    
    public String getPassword(){
    	return password;
    }
    
    public void setID(int newId){
    	oprId = newId;
    }
    
    public void setNavn(String navn){
    	oprNavn = navn;
    }
    
    public void setIni(String ini){
    	this.ini = ini;
    }
    
    public void setCpr(int cpr){
    	this.cpr = cpr;
    }
    
    public void setPassword(String password){
    	this.password = password;
    }
}
