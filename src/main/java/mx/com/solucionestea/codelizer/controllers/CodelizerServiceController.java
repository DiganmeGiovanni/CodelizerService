package mx.com.solucionestea.codelizer.controllers;

import com.github.javaparser.ParseException;
import mx.com.solucionestea.codelizer.core.DirsAnalyzer;
import mx.com.solucionestea.codelizer.core.visitors.TEAVisitor;
import mx.com.solucionestea.codelizer.database.dao.AnalysisDao;
import mx.com.solucionestea.codelizer.database.dao.CFileDao;
import mx.com.solucionestea.codelizer.database.models.Analysis;
import mx.com.solucionestea.codelizer.database.models.CFile;
import mx.com.solucionestea.codelizer.database.models.PModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
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

    @RequestMapping("/codelize")
    @ResponseBody
    public String codelize(@RequestParam("analysisId") int analysisId) {

        // Retrieve analysis
        Analysis analysis = analysisDao.findOne(analysisId);
        List<PModule> pModules = analysis.getProject().getpModules();

        // Analyze each project's module
        for (PModule pModule : pModules) {

            // Retrieve all module files
            List<CFile> javaFiles = DirsAnalyzer.getJavaFiles(pModule.getPath());
            for (CFile cFile : javaFiles) {
                cFile.setpModule(pModule);
                cFile.setAnalysis(analysis);

                try {

                    // Subtract code from file
                    new TEAVisitor().visitFile(cFile);
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            }
            cFileDao.save(javaFiles);
        }

        return "Ok";
    }

}
