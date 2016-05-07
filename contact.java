package shared;

import java.io.Serializable;

//for contact

public class contact implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String firstname;
	
	private String lastname;
	
	private int age;
	
	private Address add;
	
	public contact()
	{
		
	}
	
	public contact(String firstname,String lastname,int age,Address add)
	{
		super();
		this.firstname=firstname;
		this.lastname=lastname;
		this.age=age;
		this.add=add;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}
	
	
	
}
