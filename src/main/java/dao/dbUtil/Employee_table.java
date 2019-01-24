package dao.dbUtil;
import javax.persistence.*;
@Entity
@Table(name = "Employee_table")
public class Employee_table {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name,country,city,zipcode;
	float salary;


}