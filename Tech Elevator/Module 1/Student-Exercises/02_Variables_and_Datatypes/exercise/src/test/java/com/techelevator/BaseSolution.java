package com.techelevator;

import com.techelevator.compile.DynamicCompiler;
import com.techelevator.compile.ITest;
import com.techelevator.parse.DynamicParser;
import com.techelevator.solution.Solutions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Base Class for all solution tests. This abstraction allows each test class to focus
 * on the results of the exercise
 */
public abstract class BaseSolution {

    private static final String FILE_PATH = "src/main/java/com/techelevator/Exercises.java";
    private static Solutions solutions;
    private DynamicParser dp = new DynamicParser();
    String solutionCode;
    String code;
    String sourceCode;
    List<String> varTypeNames = new ArrayList<>();
    String[] parts;
    String lastVarType;
    String lastVarName;
    DynamicCompiler dc = new DynamicCompiler();
    String assembleSourceCode;
    Class<ITest> test;
    ITest iTest;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        // Load the Solutions
        try (FileReader fr = new FileReader(FILE_PATH)) {
            solutions = new Solutions(fr);
        }
    }

    @BeforeEach
    public void setup(TestInfo testInfo) throws Exception {
        String displayName = testInfo.getDisplayName().replace("()","");
        solutionCode =  displayName.replaceAll("testSolution","");
        code = solutions.getSolutionCode(solutionCode);

        if( !code.isEmpty() ) {
            // Find the type and name of the variable the student declared.
            sourceCode = "public class Test {" + "public void doSomething(){" + code + "}}";
            varTypeNames = dp.parse(sourceCode);
            parts = varTypeNames.get(varTypeNames.size()-1).split(":");
            lastVarType = parts[0];
            lastVarName = parts[1];

            // Assemble the "runnable" source code using the student's solution, and the last variable type and name
            assembleSourceCode = dc.assembleSourceCode(code, lastVarType, lastVarName);

            // Compile the assembled source and create a new instance of the ITest class
            test = dc.compile(assembleSourceCode);
            iTest = test.newInstance();

            assertTrue(varTypeNames.size() > 0, "You must declare at least one variable.");
            assertTrue((checkCamelCasing(varTypeNames)),"All variable names must be camel cased.");
        } else {
            throw new RuntimeException("Exercise {" + solutionCode + "} is incomplete.");
        }


    }

    private boolean checkCamelCasing(List<String> varTypeNames) {
        Pattern camelCasePattern = Pattern.compile("^[a-z]+((\\d)|([A-Z0-9][a-z0-9]+))*([A-z]+)$");
        for (String varTypeName : varTypeNames) {
            String[] parts = varTypeName.split(":");
            String varName = parts[1];
            Matcher m = camelCasePattern.matcher(varName);
            if (m.find() == false) {
                return false;
            };
        }
        return true;
    }
}
