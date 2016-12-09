package mx.com.solucionestea.codelizer.controllers;

import com.github.javaparser.ParseException;
import mx.com.solucionestea.codelizer.core.DirsAnalyzer;
import mx.com.solucionestea.codelizer.core.visitors.TEAVisitor;
import mx.com.solucionestea.codelizer.database.dao.*;
import mx.com.solucionestea.codelizer.database.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 *
 * Created by giovanni on 7/12/16.
 */
@Controller
public class CodelizerServiceController {

    @Autowired
    private AnalysisDao analysisDao;

    @Autowired
    private CFileDao cFileDao;

    @Autowired
    private CModuleDao cModuleDao;

    @Autowired
    private PModuleDao pModuleDao;

    @Autowired
    private ProjectDao projectDao;

    @RequestMapping("/create")
    @ResponseBody
    public String createProject() {

        // Create project
        Project project = new Project();
        project.setName("GWatchlist");
        projectDao.save(project);

        // Create project module
        PModule pModule = new PModule();
        pModule.setName("GWatchlist");
        pModule.setPath("/home/giovanni/Sources/Java/GWatchlist/src");
        pModule.setProject(project);
        pModuleDao.save(pModule);

        return project.getName();
    }

    @RequestMapping("/analize")
    @ResponseBody
    public String analize() {

        // Retrieve first project
        Project project = projectDao.findOne(1L);

        // Create a new analysis for this project
        Analysis analysis = new Analysis();
        analysis.setProject(project);
        analysis.setStartTime(new Date());
        analysisDao.save(analysis);

        // Analyze each project's module
        for (PModule pModule : project.getpModules()) {

            // Create a cModule
            CModule cModule = new CModule();
            cModule.setAnalysis(analysis);
            cModule.setpModule(pModule);
            cModuleDao.save(cModule);

            // Retrieve all module files
            List<CFile> javaFiles = DirsAnalyzer.getJavaFiles(cModule.getpModule().getPath());
            for (CFile cFile : javaFiles) {
                cFile.setcModule(cModule);
                try {
                    new TEAVisitor().visitFile(cFile);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            }
            cFileDao.save(javaFiles);

            // Retrieve all classes from files


            // Retrieve all methods from classes

        }


        return project.getName();
    }

}
