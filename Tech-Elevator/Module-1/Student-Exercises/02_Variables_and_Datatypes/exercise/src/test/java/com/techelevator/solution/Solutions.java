package com.techelevator.solution;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solutions {

	Map<String, Solution> solutions = new HashMap<>(); 
	
	public Solutions(Reader reader) throws IOException {
		try (BufferedReader br = new BufferedReader(reader)){
			Pattern problemStatementStartPattern = Pattern.compile("^\\/[*]\\s+Exercise(?<ID>\\s+\\d+)"); // Example: "/* Exercise 1"
			Pattern problemStatementEndPattern = Pattern.compile("\\*\\/");
			boolean inProblemStatement = false;
			boolean inSolution = false;
			String id = "";
			String code = "";
			String currentLine;
			while ((currentLine = br.readLine()) != null) {
				currentLine = currentLine.trim();
				if (currentLine.length() == 0 || currentLine.equals("}")) {
					continue;
				}
				Matcher m = problemStatementStartPattern.matcher(currentLine);
				if (m.find()) {
					if (inSolution) {
						//Add the current solution, and reset code in preparation for the next solution just found
						solutions.put(id, new Solution(id, code));
						code = "";
					}
					id = m.group("ID").trim();
					inProblemStatement = true;
					inSolution = false;
					continue;
				}					
				else {
					m = problemStatementEndPattern.matcher(currentLine);
					if (m.find() && inProblemStatement) {
						inProblemStatement = false;
						inSolution = true;
						continue;
					}					
				}
				if (inSolution) {
					code += currentLine + System.lineSeparator();
				}
			}
			if (inSolution && code.length() > 0) {
				//EOF while still in a solution, add the solution as it is, and hope for the best :-)
				solutions.put(id, new Solution(id, code));
			}
		}
		catch (IOException e) {
			throw e;
		}
	}
	
	public String getSolutionCode(String id) {
		Solution s = solutions.get(id);
		return s != null? s.getCode() : null; //Return null if solution not found by id
	}
}
