package com.techelevator.parse;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;

import java.util.ArrayList;
import java.util.List;

public class DynamicParser {

    public List<String>  parse(String sourceCode) {

        List<String> varTypeNames = new ArrayList<>();

        // Set up a minimal type solver that only looks at the classes used to run this sample.
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());

        // Configure JavaParser to use type resolution
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);

        CompilationUnit cu = StaticJavaParser.parse(sourceCode);
        cu.findAll(MethodDeclaration.class).forEach(mt -> {
            mt.findAll(VariableDeclarationExpr.class).forEach(vr -> {
                varTypeNames.add(vr.getVariable(0).getType().toString() + ":" + vr.getVariable(0).getName());
            });
        });
        return varTypeNames;

    }
}
