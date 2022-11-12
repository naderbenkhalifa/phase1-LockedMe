import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
public class Phase1 {
	static ArrayList<String> arr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		System.out.println("Application Name : LockedMe");
		System.out.println("Application Version :1.0");
		System.out.println("Developper Name: Ben Khalifa Nader");

		FileManager filemanager;
		boolean exit=false;

		while(!exit) {
			switch (menu()) {
			case 1:
				System.out.println("please,enter the name folder:" );
				Scanner sc1 = new Scanner(System.in);
				String foldername=sc1.nextLine();
				try {
					filemanager = new FileManager(foldername);
					List<String> result = filemanager.listAllFiles();
					displayFiles(result);

				} catch(ExceptionHandler eh){
					System.out.println("Error, Code:" + eh.hashCode() + " list not found!");
				}
				break;
			case 2:
				boolean b=false;
				while (!b) {	

					switch (submenu()) {
					case 1:

						System.out.println("please,enter the file name to add:" );
						Scanner sc2 = new Scanner(System.in);
						String fileaddename=sc2.nextLine();
						try {

							filemanager = new FileManager(fileaddename);

							if(filemanager.AddFile(fileaddename)) {
								System.out.println("File added successfully." );
							}


						} catch(ExceptionHandler eh){
							System.out.println("Error, Code:" + eh.hashCode() +" "+"Failure to add the file!"  );


						}
						break;
					case 2:
						System.out.println("please,enter the file name to delete:" );
						Scanner sc3 = new Scanner(System.in);
						String filedeletename=sc3.nextLine();

						try {
							filemanager = new FileManager(filedeletename);
							if(filemanager.DeleteFile(filedeletename)) {
								System.out.println("File successfully deleted." );
							}
						} catch (ExceptionHandler eh) {

							System.out.println("Error, Code:" + eh.hashCode()+" " +"File unsuccessfully deleted." );
							;



						}



						break;
					case 3:
						System.out.println("please,enter the file name to search" );
						Scanner sc4= new Scanner(System.in);
						String filesearchname=sc4.nextLine();
						try {

							filemanager = new FileManager(filesearchname);

							if(filemanager.SearchFile(filesearchname)) {
								System.out.println("File found successfully." );
							} 


						} catch(ExceptionHandler eh){
							System.out.println("Error, Code:" + eh.hashCode() +" "+"File not found!" );
						}
						break;

					case 4:
						b=true;
						break;
					default:
						System.out.println("Please, select an option");
					}
				}
				b=true;
				break;

			case 3:
				exit=true;
				System.out.println("\n Thank you for using our application!" + "\n Goodbye.");
				break;
			default:
				System.out.println("Please, select an option");
			}
		}	
	}



	public static void displayFiles(List<String> arr) {
		String temp;
		for(int i=0;i<arr.size();i++){
			for(int j=i+1;j<arr.size();j++){
				if(arr.get(i).compareTo(arr.get(j))>0){

					temp=arr.get(i);
					arr.set(i, arr.get(j));
					arr.set(j,temp );   

				}

			}
		}
		for (String s : arr) {
			System.out.println(s);
		}
	}






	static int menu() {
		System.out.println("\n Main Menu:"+

				"\n please enter number to proceed"+
				"\n 1-SearchAllFiles"+
				"\n 2-File Operation"+

				"\n 3-Exist"+
				"\n input:");
		Scanner sc= new Scanner(System.in);
		int a =sc.nextInt();
		return a;

	}
	static int submenu(){
		System.out.println(  "\n You are in File Operation" + "\n 1-Create file"+"\n 2-Delete file"+"\n 3-Search file"+"\n 4-Return to main menu"+"\n Please, select an operation:");
		Scanner sc= new Scanner(System.in);
		int a =sc.nextInt();
		return a;


	}

}
