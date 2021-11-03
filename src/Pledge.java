
public class Pledge {
private String studName;
private String htown;
private double grade;

public Pledge(String name, String town, double gpa){
	 studName = name;
	 htown = town;
	 grade = gpa;
	
}
public void setName(String n){
	studName = n;
}
public void setTown(String t){
	htown = t;
}
public void setGPA(double g){
	grade = g;
}
public String getName(){
	return studName;
}
public String getTown(){
	return htown;
}
public double getGPA(){
	return grade;
}
public String toString(){
	return studName + ", " + htown + ", " + grade; 
}


}
