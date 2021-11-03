import java.text.DecimalFormat;
import java.util.ArrayList;
public class Sorority {
DecimalFormat df = new DecimalFormat("#.##");
public int count = 0;
private String sname;
private Double sGPA;
private String abrev;
private ArrayList<Pledge> pledges = new ArrayList<Pledge>();
public Sorority(String name, String letters){
	sname = name;
	abrev = letters;
}

public void setName(String n){
	sname = n;
	
}
public void setLetters(String l){
	abrev = l;
}
public void addPledge(String n, String h, double g) {
	pledges.add(new Pledge(n,h,g));
	count++;
	
}
public String getName(){
	return sname;
}
public String getLetters(){
	return abrev;
}
public ArrayList<Pledge> getPledges(){
	return pledges;
}
public void setPledges(){
	this.pledges = pledges;
}

public int getSize(){
	
	return pledges.size();

}

public void printData() {
	System.out.println("_________________________________________________________________________________________________");
	System.out.println();
	System.out.println("Sorority Name:   " + sname);
	System.out.println("Greek Letters:   " + abrev);
	System.out.println();
	System.out.println("List of Members:");
	System.out.println();
	for(int i = 0; i < pledges.size(); i++){
		
		System.out.println(i + ". " + pledges.get(i).toString());

	}
	
}

public Double calcGPA(Double G){
	double sum = 0;
	for(int i = 0; i < pledges.size(); i++){
		sum += pledges.get(i).getGPA();
	}
	sGPA = sum/pledges.size();
	String formatted = df.format(sGPA);
	System.out.println("The Sororities overall GPA is: " + formatted);
	
	return sGPA;
	
	
}

public void mergeSort(int min, int max){
	if( min < max){
		int mid = (min + max)/2;
		mergeSort(min,mid);
		mergeSort(mid + 1, max);
		merge(min,mid,max);
	}
}
public void merge(int first, int mid, int last){
	Pledge[] temp = new Pledge[pledges.size()];
	int f1 = first;
	int l1 = mid;
	int f2 = mid + 1;
	int l2 = last;
	int index = f1;
	while(f1 <= l1 && f2 <= l2){
		if(pledges.get(f1).getGPA() > pledges.get(f2).getGPA()){
			temp[index] = pledges.get(f1);
			f1++;
		}else{
			temp[index] = pledges.get(f2);
			f2++;
		}
		index++;
	}
	while(f1 <= l1){
		temp[index] = pledges.get(f1);
		f1++;
		index++;
	}
	while(f2 <= l2){
		temp[index] = pledges.get(f2);
		f2++;
		index++;
	}
	for(index = first; index <= last; index++){
		pledges.set(index, temp[index]);
	}
}
	

	
	

public void swap(int left, int right){
	Pledge temp = pledges.get(left);
	pledges.set(left, pledges.get(right));
	pledges.set(right, temp);
	
}
public void calcList(Double G){
	if(sGPA > 3.50){
		System.out.println("Congratulations, " + sname + "! You have qualified for the Chancellors list!");
	}
	if(sGPA > 3.00 && sGPA < 3.50){
		System.out.println("Congratulations, " + sname + "! You have qualified for the Honors Roll list!");
	}
	if(sGPA > 2.50 && sGPA < 3.00){
		System.out.println("Congratulations, " + sname + "! You have qualified for the Free Spirited list!");
	}
	if(sGPA > 2.00 && sGPA < 2.50){
		System.out.println("Congratulations, " + sname + "! You have qualified for the Party House!");
	}
	
	
}




}
