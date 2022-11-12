import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
	public String foldername;
	public  File folder;
	public List<String> result;	
	public String chemin;
	public FileManager(String foldername, File folder) {
		super();
		this.foldername = foldername;
		folder = new File(foldername);
		this.folder = folder;
		result = new ArrayList<>();
	}
	public FileManager(File folder) {
		super();
		this.folder = folder;
		foldername=folder.getName();
		result = new ArrayList<>();
	}
	public FileManager(String foldername) {
		super();
		this.foldername = foldername;
		result = new ArrayList<>();
	}
	public FileManager(String chemin,String foldername){
		super();
		this.chemin = chemin;
		this.foldername = foldername;

	}
	public String getFoldername() {
		return foldername;
	}
	public void setFoldername(String foldername) {
		this.foldername = foldername;
	}
	public File getFolder() {
		return folder;
	}
	public void setFolder(File folder) {
		this.folder = folder;
	}


	public List<String> listAllFiles() throws ExceptionHandler {
		try {
			folder = new File(foldername);
			search( folder, result);
			return result;

		} catch (Exception e) {
			throw new ExceptionHandler(e.hashCode(),e.getMessage());
		}
	}

	public List<String> listFilesInRoot() throws ExceptionHandler {
		try {

			searchInRoot(folder, result);
			return result;

		} catch (Exception e) {
			e.getStackTrace();
			throw new ExceptionHandler(e.hashCode(),e.getMessage());
		}
	}


	public boolean AddFile(String filename) throws ExceptionHandler {
		try {

			File file= new File(filename);


			if (!file.exists()) {
				file.createNewFile();



			} else {
				throw new ExceptionHandler(3,"File  exist!");
			}
			return true;










		} catch (Exception e) {
			e.getStackTrace();
			throw new ExceptionHandler(e.hashCode(),e.getMessage());


		}
	}

	public boolean SearchFile(String filename) throws ExceptionHandler {
		try {
			File file= new File(filename);

			if (file.exists()) {
				return true;
			} else {
				throw new ExceptionHandler(1,"File doesn't exist!");
			}


		} catch (Exception e) {
			e.getStackTrace();
			throw new ExceptionHandler(e.hashCode(),e.getMessage());
		}
	}


	public boolean DeleteFile(String filename) throws ExceptionHandler {
		try {
			File file= new File(filename);
			if (file.exists()) {
				file.delete();
			} else {
				throw new ExceptionHandler(2,"File doesn't exist!"); 
			}
			return true;
		} catch (Exception e) {
			e.getStackTrace();
			throw new ExceptionHandler(e.hashCode(),e.getMessage());
		}
	}



	private  void searchInRoot( final File folder, List<String> result) {
		for (final File f : folder.listFiles()) {

			if (f.isFile()) {
				result.add(f.getAbsolutePath());
			}

		}
	}


	private  void search(final File folder, List<String> result) {
		for (final File f : folder.listFiles()) {

			if (f.isDirectory()) {
				search(f, result);
			}

			if (f.isFile()) {
				result.add(f.getAbsolutePath());
			}

		}
	}





}
