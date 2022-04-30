package com.techelevator;


import com.techelevator.search.SearchDomain;
import com.techelevator.search.SearchEngine;
import com.techelevator.search.SearchEngineException;
import com.techelevator.util.TELog;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;

public class Application {
	private static Map<Integer,String> filesWithIndex = new HashMap<>();

	public static void main(String[] args) {

		try {

			// Step Two: Create TELog, and log the start of the application.
			//
			TELog.log("Search application started");


			// Step Four: Instantiate a Search Domain
			//
			SearchDomain searchDomain = new SearchDomain("data");
			System.out.println(searchDomain.toString());

			// Step Six: Single word search
			//
			SearchEngine searchEngine = new SearchEngine(searchDomain);
			//searchForaSingleWord(searchEngine);
			searchEngine.indexFiles();
			filesWithIndex = searchEngine.getListOfFilesWithIndex();
			List<String> fileNamesContainsWord = new ArrayList<>();
			System.out.println("This is the search for single word");
			System.out.println("***********************************");
			System.out.println("File names containing squirrel is: ");
					fileNamesContainsWord =	searchEngine.search("squirrel");
			for (String fileName: fileNamesContainsWord) {
				System.out.println(fileName);
			}

			// Step Seven: Multiple word search
			System.out.println("This is multiple words search domain");
			System.out.println("***********************************");
			searchForaMultipleWords(searchEngine);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void searchForaMultipleWords(SearchEngine searchEngine) {
		String multipleWords = "telephone line ";
		System.out.println("The searching word is "+multipleWords);
		String[] multipleWordsList = multipleWords.split(" ");
		List<String> listOfLineContaingWords = new ArrayList<>();
		File searchFile = new File("C:\\Users\\Treblig\\Documents\\Programming\\Repos\\Module-One\\Projects\\module-1-pair-programming-4\\exercise\\logs\\search.log");

		try(Scanner dataFile = new Scanner(searchFile)){
			for(String word:multipleWordsList){
				boolean isWordFound  = true;

				while (dataFile.hasNextLine()) {
					String lineOfInput = dataFile.nextLine();
					if (lineOfInput.contains(word)) { // check if line has your finding word
						//System.out.println(lineOfInput);
						String[] fileIndex = lineOfInput.split(":");
						listOfLineContaingWords.add(fileIndex[1]);
						isWordFound = true;
						break;
					}
				}
			}

		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		if(multipleWordsList.length==0){
			System.out.println("No input word");
		}else if(multipleWordsList.length==listOfLineContaingWords.size() ){
			printTheFilenameofMultipleWord(listOfLineContaingWords);
		}else{
			System.out.println(" all the words did not found in the file");
			return;
		}

	}

	private static void printTheFilenameofMultipleWord(List<String> listOfLineContaingWords) {
		String[] fileIndexarray = new String[listOfLineContaingWords.size()];
		List<String> fileIndexArray = new ArrayList<>();
		List<Integer> commonFileIndexList = new ArrayList<>();
		//int j =0;
		//System.out.println(listOfLineContaingWords.get(0));
		for(String fileIndex: listOfLineContaingWords){
			String[] arrayOfFileIndexandWord = fileIndex.split(",");
			StringBuilder sb= new StringBuilder();
			for(String index: arrayOfFileIndexandWord){
				sb.append(index.substring(1,2));
			}
			fileIndexArray.add(sb.toString());
			//System.out.println(sb);
		}
		for(int i=0;i<6;i++){
			boolean isFileExist = true;
			for(int j=0;j<fileIndexArray.size();j++){
				if(fileIndexArray.get(j).contains((Integer.toString(i)))){
					isFileExist=isFileExist && true;
				}else {
					isFileExist = isFileExist && false;
				}
			}
			if(isFileExist){
				//System.out.println("File "+ i+"esixt");
				commonFileIndexList.add(i);
			}
		}
		getDistanceOfWordsOrder(commonFileIndexList,listOfLineContaingWords);

	}

	private static void getDistanceOfWordsOrder(List<Integer> commonFileIndexList, List<String> listOfLineContaingWords) {
		Map<Integer,StringBuilder> allComonFilesWithDistance = new HashMap<>();
		for(int i: commonFileIndexList){
			//System.out.println("i+ "+i);
			StringBuilder distanceIndex = new StringBuilder(" ");
			for(String distance:listOfLineContaingWords){
				String fileIndexWithLine = String.valueOf(i)+"-";
				if(distance.contains(fileIndexWithLine)){
					int fileIndex = distance.indexOf(fileIndexWithLine);
					int indexOfComma = 0;
					if(distance.substring(fileIndex+1).contains(",")){
						indexOfComma = distance.indexOf(",",fileIndex+1);
					}else {
						indexOfComma = distance.indexOf("]",fileIndex+1);
					}
					distanceIndex = new StringBuilder(distance.substring(fileIndex + 2, indexOfComma)+" ");
					if(!allComonFilesWithDistance.containsKey(i)){
						allComonFilesWithDistance.put(i,distanceIndex);
						//System.out.println(distanceIndex);
					}else {
						StringBuilder existingDistance = allComonFilesWithDistance.get(i);
						existingDistance=existingDistance.append(distanceIndex)	;
						//System.out.println(distanceIndex);
						allComonFilesWithDistance.put(i,existingDistance);
					}
				}
			}

		}
//		for(Map.Entry<Integer,StringBuilder> entry: allComonFilesWithDistance.entrySet()){
//			System.out.println(entry.getKey()+"  "+entry.getValue());
//		}
		fileContaingWordsInOrderOrNot(allComonFilesWithDistance);

	}

	private static void fileContaingWordsInOrderOrNot(Map<Integer, StringBuilder> allComonFilesWithDistance) {
		Map<Integer,int[]> finalFileWithDistance = new HashMap<>();
		for(Map.Entry<Integer, StringBuilder> entry: allComonFilesWithDistance.entrySet()){
			int key = entry.getKey();
			String value = entry.getValue().toString();
			int[] arr = Stream.of(value.split(" ")).mapToInt(Integer::parseInt).toArray();
			//System.out.println(Arrays.toString(arr));
			int preElement = -1;
			boolean status = true;
			for(int element: arr){
				if(element>preElement){
					preElement = element;
					status = status;
				}else {
					status = false;
				}
			}
			if(status){
				finalFileWithDistance.put(key,arr);
			}
		}
		if(finalFileWithDistance.isEmpty()){
			System.out.println("No file found");
		}else {
			rankTheFile(finalFileWithDistance);
//			for(Map.Entry<Integer,int[]> entry: finalFileWithDistance.entrySet()){
//				System.out.println(entry.getKey()+ " "+ Arrays.toString(entry.getValue()));
//			}
		}
	}

	private static void rankTheFile(Map<Integer,int[]> finalFileWithDistance) {
		Map<Integer,Integer> fileIndexWithOrder = new HashMap<>();
		for(Map.Entry<Integer,int[]> entry: finalFileWithDistance.entrySet()){
			//System.out.println(entry.getKey()+ " "+ Arrays.toString(entry.getValue()));
			int[] arr = entry.getValue();
			int preElemnt = 0;
			int subtract=0;
			for(int element: arr){
				subtract = element-preElemnt;
				preElemnt = element;
			}
			//System.out.println(subtract);
			fileIndexWithOrder.put(entry.getKey(), subtract);
		}
//		for(Map.Entry<Integer,Integer> entry: fileIndexWithOrder.entrySet()) {
//			//System.out.println(entry.getKey() + " " + (entry.getValue()));
//			Integer min = Collections.min(fileIndexWithOrder.values());
//			System.out.println(min);
//		}
		printTheFile(fileIndexWithOrder);
	}

	private static void printTheFile(Map<Integer, Integer> fileIndexWithOrder) {
		int length = fileIndexWithOrder.size();
		for(int i=0;i<length;i++){
			int key =0;
			int value=0;
			Integer min = Collections.min(fileIndexWithOrder.values());
			//System.out.println(min);
			for(Map.Entry<Integer,Integer> entry: fileIndexWithOrder.entrySet()){
				if(entry.getValue().equals(min)){
					key = entry.getKey();
					value = entry.getValue();
				}
			}
			System.out.println(filesWithIndex.get(key));
			fileIndexWithOrder.remove(key,value);
		}
		//System.out.println(fileIndexWithOrder.size()+"size");
	}

	private static void searchForaSingleWord(SearchEngine searchEngine) throws SearchEngineException {

		try {
			searchEngine.indexFiles();
			List<String> fileNamesContainsWord = new ArrayList<>();
			fileNamesContainsWord = searchEngine.search("lary");
			if(!fileNamesContainsWord.isEmpty()){
				for (String fileName : fileNamesContainsWord) {
					System.out.println("File names containing:" + fileName);
				}
			}else{
				System.out.println("No file found");
			}
		} catch (SearchEngineException e) {
			new SearchEngineException(e.getMessage());
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
