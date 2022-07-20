package com.techelevator.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The Search Domain is a list of files to be read and indexed by the Search Engine.
 *
 * Folders are NOT recursively searched.
 */
public class SearchDomain {

	private String folder;
	private List<String> files;

	/**
	 * Create a Search Domain of a folder
	 *
	 * @param folder
	 * @throws SearchDomainException
	 */
	public SearchDomain(String folder) throws SearchDomainException {
		this.folder = folder;
		this.files = buildDomain();
	}

	public String getFolder() {
		return folder;
	}

	public List<String> getFiles() {
		return files;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for (String file : files) {
			sb.append(file);
			sb.append("\n");
		}
		return sb.toString();
	}

	/**
	 * Folders are NOT recursively searched.
	 *
	 * @return
	 * @throws SearchDomainException
	 */
	private List<String> buildDomain() throws SearchDomainException {
		List<String> files = new ArrayList<>();
		// Step Three: Complete the buildDomain method

		try{
			String path = System.getProperty("user.dir") + "\\exercise\\" + folder;

			File[] fileNames = new File(path).listFiles();
			for(File file: fileNames) {
				if (file.isFile()) {
					//System.out.println("SearchDomain: "+file.getAbsolutePath());
					files.add(folder+"\\"+file.getName());
				}else{
					throw new SearchDomainException("File is not a file");
				}
			}
		}catch (SearchDomainException e){
			throw new SearchDomainException(e.getMessage());
		}catch (Exception e){
			System.out.println("Folder not found");
		}



		return files;
	}

}
