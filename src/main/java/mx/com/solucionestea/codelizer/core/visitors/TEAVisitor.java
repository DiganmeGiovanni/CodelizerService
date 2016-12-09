package mx.com.solucionestea.codelizer.core.visitors;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import mx.com.solucionestea.codelizer.database.models.CClass;
import mx.com.solucionestea.codelizer.database.models.CFile;
import mx.com.solucionestea.codelizer.database.models.CMethod;
import mx.com.solucionestea.codelizer.database.models.CParameter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Visits a given file and subtracts its inner classes and methods
 *
 * Created by giovanni on 8/12/16.
 */
public class TEAVisitor extends VoidVisitorAdapter<Object> {

    /** The file currently being analyzed */
    private CFile currentFile;

    /** The list of classes found inside {@see #currentFile} */
    private List<CClass> classes;

    /** The class currently being analyzed */
    private CClass currentClass;

    /** The list of methods found inside {@link #currentClass} */
    private List<CMethod> methods;

    public void visitFile(CFile cFile) throws IOException, ParseException {
        this.currentFile = cFile;
        CompilationUnit cUnit = JavaParser.parse(new File(currentFile.getPath()));

        classes = new ArrayList<>();
        this.visit(cUnit, null);
        currentFile.setClasses(classes);
    }

    /**
     * Called when a class or interface is found inside compilation unit
     * @param node Node representing the class
     * @param argument Object argument
     */
    @Override
    public void visit(ClassOrInterfaceDeclaration node, Object argument) {

        // Construct CClass with node info
        CClass cClass = new CClass();
        cClass.setName(node.getName());
        cClass.setcFile(currentFile);

        // Add class to file classes
        classes.add(cClass);

        // Retrieve class inner methods
        currentClass = cClass;
        methods = new ArrayList<>();
        super.visit(node, argument);
        cClass.setMethods(methods);
    }

    @Override
    public void visit(MethodDeclaration node, Object argument) {

        // Construct CMethod with node info
        CMethod cMethod = new CMethod();
        cMethod.setName(node.getName());
        cMethod.setType(node.getType().toString());
        cMethod.setcClass(currentClass);
        cMethod.setAccess("public");


        // Subtract method params
        cMethod.setParameters(new ArrayList<>());
        for (Parameter parameter : node.getParameters()) {

            CParameter cParam = new CParameter();
            cParam.setName(parameter.getName());
            cParam.setType(parameter.getType().toString());
            cParam.setcMethod(cMethod);
            cMethod.getParameters().add(cParam);
        }

        // Add to methods list
        methods.add(cMethod);
    }
}












