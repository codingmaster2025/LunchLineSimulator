
public class Student implements Cloneable{

	private String name;
	private double money;

	public Student() {

	}

	public Student(String name, double money) {
		this.name = name;
		this.money = money;
	}

	public void setName(String newName) {
		name = newName;
	}

	public String getName() {
		return name;
	}

	public void setMoney(double newMoney) {
		money = newMoney;
	}

	public double getMoney() {
		return money;
	}

	public String toString() {
		
		
		return getName()+"\t$"+getMoney();
	}
	
	
	public Student clone() {
		Student s=(Student)(this.clone());
		return s;
		
	}
	

	public boolean equals(Object o) {
		if (o instanceof Student) {
			Student student = (Student) o;

			return student.name.equals(name) && student.money == money;
		}
		return false;
	}

}
