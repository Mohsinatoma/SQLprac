package DBprac.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "Employee_table")
@Getter
@Setter


public class User {
	int eid;
	String name,country,city,zipcode;
	float salary;
	
	public User(int eid,String n,String c, String cc,String zc,float s) {
		this.eid=eid;
		this.name=n;
		this.country=c;
		this.city=cc;
		this.zipcode=zc;
		this.salary=s;
	}
	
	
         
}
