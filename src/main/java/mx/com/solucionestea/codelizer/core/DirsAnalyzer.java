package mx.com.solucionestea.codelizer.core;

import mx.com.solucionestea.codelizer.database.models.CFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains methods to analise and retrieve files recursively
 * from given paths
 *
 * Created by giovanni on 7/12/16.
 */
public class DirsAnalyzer {

    public static List<CFile> getJavaFiles(String rootPath) {

        //
        // Retrieve all java files into given path
        File root = new File(rootPath);
        ArrayList<CFile> javaFiles = new ArrayList<>();
        appendFilesFrom(root, javaFiles);

        return javaFiles;
    }

    private static void appendFilesFrom(File root, List<CFile> files) {

        // If file is a directory analyze it recursively
        if (root.isDirectory()) {
            File[] innerFiles = root.listFiles();
            if (innerFiles != null) {
                for (File file : innerFiles) {
                    appendFilesFrom(file, files);
                }
            }

        } else if (root.getAbsolutePath().endsWith(".java")) {
            CFile cFile = new CFile();
            cFile.setFileName(root.getName());
            cFile.setPath(root.getAbsolutePath());

            files.add(cFile);
        }
    }
}
