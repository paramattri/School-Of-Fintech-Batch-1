import java.util.Scanner;
public class Assignment1Question6Participant {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter The Number Of Participants: ");
		int noOfParticipants = sc.nextInt();
		int ids[] = new int[noOfParticipants];
		System.out.println("Enter the Ids: ");
		for(int i = 0; i < ids.length; i++) {
			ids[i] = sc.nextInt();
		}
		
		System.out.println("Enter ID to Search: ");
		int searchId = sc.nextInt();
		boolean found = false;
		
		if(searchId != 0) {
			
			for(int id : ids) {
				if(searchId == id) {
					found = true;
					break;
				}else {
					continue;
				}
			}
			if(found) {
				System.out.println("Participant with ID "+searchId+" exists");
			}else
				System.out.println("Participant with ID "+searchId+" does not exist");
			
		}else
			System.out.println("Program Terminated");
	}	

}
