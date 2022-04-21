package solution;

public class Bank {

	//Note: type, city, state - can be made enum.  Kept String for solution simplicity

	private int id;
	private String name;
	private String type;	
	private String city;
	private String state;
	private long zip;

	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}

	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return this.type;
	}

	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return this.city;
	}

	public void setState(String state){
		this.state = state;
	}
	public String getState(){
		return this.state;
	}

	public void setZip(long zip){
		this.zip = zip;
	}
	public long getZip(){
		return this.zip;
	}
}