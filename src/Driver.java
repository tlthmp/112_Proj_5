
/* Ty Thompson
4/25/16
Honor Policy
Drew helped me
*/
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) throws IOException, NullPointerException {

		ArrayList<Sorority> srat = new ArrayList<Sorority>();

		Scanner input = new Scanner(new File("sororityList.txt"));
		int index;
		PrintWriter pwr = new PrintWriter("Faber.txt");
		while (input.hasNextLine()) {
			String in = input.nextLine();
			String[] Token = in.split(",");
			srat.add(new Sorority(Token[0], Token[1].trim()));
		}

		input.close();

		System.out.print(srat.size());

		Scanner scan = new Scanner(new File("pledgeList.txt"));
		while (scan.hasNextLine()) {
			String in2 = scan.nextLine();
			String[] Delim = in2.split(",");
			for (int i = 0; i < srat.size(); i++) {
				if (srat.get(i).getLetters().equals(Delim[3]))

					srat.get(i).addPledge(Delim[0], Delim[1], Double.parseDouble(Delim[2]));
			}

		}
		System.out.println("Welcome to Proj5");
		System.out.println("");
		System.out.println("Here is the data unsorted: ");
		System.out.println("");
		for (int i = 0; i < srat.size(); i++) {
			srat.get(i).printData();

		}
		System.out.println("");
		System.out.println(
				"_________________________________________________________________________________________________");
		System.out.println("");
		System.out.println("");
		System.out.println("Here is the data sorted in descending order: ");
		System.out.println("");
		for (int i = 0; i < srat.size(); i++) {

			srat.get(i).mergeSort(0, srat.get(i).getPledges().size() - 1);
			srat.get(i).printData();
			System.out.println("");
			srat.get(i).calcGPA(null);
			srat.get(i).calcList(null);

			for(int i1 = 0; i1 < srat.size();i1++){
				
				pwr.println(srat.get(i1).getName());
				pwr.println(srat.get(i1).getLetters());
				pwr.println(srat.get(i1).getPledges());
				pwr.println("Total Number of Students in this Sorority: " + srat.get(i1).count);
				pwr.println();
				
			}
			pwr.close();

		}
	}
}
