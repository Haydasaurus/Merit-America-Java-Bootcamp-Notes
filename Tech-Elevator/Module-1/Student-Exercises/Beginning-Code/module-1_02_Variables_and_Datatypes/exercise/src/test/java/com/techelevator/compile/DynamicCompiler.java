package com.techelevator.compile;

import javax.tools.*;
import java.io.IOException;
import java.util.Arrays;

public class DynamicCompiler {

	private String sourceCode;

	public String assembleSourceCode(String studentCode, String lastVarType, String lastVarName) {
	    String methodName = "";
        switch (lastVarType) {
            case "boolean" :
                methodName = "getBooleanResult";
                break;
            case "byte" :
                methodName = "getByteResult";
                break;
            case "char" :
                methodName = "getCharResult";
                break;
            case "double" :
                methodName = "getDoubleResult";
                break;
            case "float" :
                methodName = "getFloatResult";
                break;
            case "int" :
                methodName = "getIntResult";
                break;
            case "long" :
                methodName = "getLongResult";
                break;
            case "String" :
                methodName = "getStringResult";
                break;
        }
        String assembledSourceCode = "public class Test implements com.techelevator.compile.ITest{" +
            "public " + lastVarType + " " + methodName + "(){" +
            studentCode +
            "return " + lastVarName + ";}}";
	    return assembledSourceCode;
    }


	public Class<ITest> compile(String sourceCode) throws Exception  {
	
		this.sourceCode = sourceCode;
		
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        DiagnosticCollector<JavaFileObject> diagnostics =
                new DiagnosticCollector<>();

        String className = "Test";

        final JavaByteObject byteObject = new JavaByteObject(className);

        StandardJavaFileManager standardFileManager =
                compiler.getStandardFileManager(diagnostics, null, null);

        JavaFileManager fileManager = createFileManager(standardFileManager,
                                                                 byteObject);

        JavaCompiler.CompilationTask task = compiler.getTask(null,
                fileManager, diagnostics, null, null, getCompilationUnits(className));

        if (!task.call()) {
            diagnostics.getDiagnostics().forEach(System.out::println);
        }
        fileManager.close();

        ClassLoader inMemoryClassLoader = createClassLoader(byteObject);
        Class<ITest> test = (Class<ITest>) inMemoryClassLoader.loadClass(className);
        return test;

	}

	
    private JavaFileManager createFileManager(StandardJavaFileManager fileManager, JavaByteObject byteObject) {
    	
        return new ForwardingJavaFileManager<StandardJavaFileManager>(fileManager) {
            @Override
            public JavaFileObject getJavaFileForOutput(Location location,
                                                       String className, JavaFileObject.Kind kind,
                                                       FileObject sibling) throws IOException {
                return byteObject;
            }
        };
    }

    private ClassLoader createClassLoader(final JavaByteObject byteObject) {
    	
        return new ClassLoader() {
            @Override
            public Class<?> findClass(String name) throws ClassNotFoundException {
                //no need to search class path, we already have byte code.
                byte[] bytes = byteObject.getBytes();
                return defineClass(name, bytes, 0, bytes.length);
            }
        };
    }

    private Iterable<? extends JavaFileObject> getCompilationUnits(String className) {
        JavaStringObject stringObject =
                new JavaStringObject(className, sourceCode);
        return Arrays.asList(stringObject);
    }

}
