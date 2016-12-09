package mx.com.solucionestea.codelizer.database.dao;

import mx.com.solucionestea.codelizer.database.models.CModule;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 *
 * Created by giovanni on 7/12/16.
 */
@Transactional
public interface CModuleDao extends CrudRepository<CModule, Long> {
}
