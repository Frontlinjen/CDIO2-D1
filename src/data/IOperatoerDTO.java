package data;

public interface IOperatoerDTO {
	int getID();                     
	String getNavn();                
	String getIni();   //Initialer               
	int getCpr();                 
	String getPassword();
	void setID(int newId);
	void setNavn(String navn);
	void setIni(String ini);
	void setCpr(int cpr);
	void setPassword(String password);
}
