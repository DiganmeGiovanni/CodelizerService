package mx.com.solucionestea.codelizer.database.dao;

import mx.com.solucionestea.codelizer.database.models.PModule;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 *
 * Created by giovanni on 7/12/16.
 */
@Transactional
public interface PModuleDao extends CrudRepository<PModule, Long> {

    public List<PModule> findByProjectId(int projectId);
}
