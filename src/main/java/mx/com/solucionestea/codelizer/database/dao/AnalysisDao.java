package mx.com.solucionestea.codelizer.database.dao;

import mx.com.solucionestea.codelizer.database.models.Analysis;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 *
 * Created by giovanni on 7/12/16.
 */
@Transactional
public interface AnalysisDao extends CrudRepository<Analysis, Long> {
}
