package mx.com.solucionestea.codelizer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * Created by giovanni on 7/12/16.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {

        String root = "/home/giovanni/Sources";
        File file = new File(root);
        if (file.isDirectory()) {
            return "File is a directory";
        } else {
            return "File is not a directory";
        }
    }

    @RequestMapping("/parser")
    public String analize() {
        FileInputStream in = null;
        try {
            in = new FileInputStream("/home/giovanni/Sources/Java/Raw/hello.java");

            Parser parser = new Parser(in);
            parser.listMethods();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return "Check your console";
    }
}
