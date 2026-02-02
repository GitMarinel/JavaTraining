package m5_activity3;

public class Student {

	private String name;
	private int age;
	private String email;
	
	public  Student () {	}
	
	public Student (String name, int age, String email) {
		this.setName(name);
		this.setAge(age);
		this.setEmail(email);
	}
	
	//Get
	public String getName()
	{
		return this.name;
	}	
	public int getAge()
	{
		return this.age;
	}	
	public String getEmail()
	{
		return this.email;
	}	
	
	//Set
	public void setName(String name) 
	{
		this.name = name;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }

}
