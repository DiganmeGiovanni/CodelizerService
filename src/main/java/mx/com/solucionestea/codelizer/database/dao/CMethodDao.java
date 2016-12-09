package mx.com.solucionestea.codelizer.database.dao;

import mx.com.solucionestea.codelizer.database.models.CMethod;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by giovanni on 8/12/16.
 */
@Transactional
public interface CMethodDao extends CrudRepository<CMethod, Long> {
}
