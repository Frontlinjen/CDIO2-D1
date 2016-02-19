package interfaces;

public interface IGUI {
	public String getPassword();
	public int getUID();
	public String getName();
	public String getIni();
	public String getCpr();
	public void showMessage(String message);
	public String getUserString(String message);
	public int getUserSelection(String... strings);
}
