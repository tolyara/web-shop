package models;

public class Manufacturer {
	
	/* ID производителя */
//	private int id;
	
	/* Название производителя */
	private String name;

	public Manufacturer(String manufacturerName) {
		super();
//		this.id = id;
		this.name = manufacturerName;
	}

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String manufacturerName) {
		this.name = manufacturerName;
	}
	
	

}
