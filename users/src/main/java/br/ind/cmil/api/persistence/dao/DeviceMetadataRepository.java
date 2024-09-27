package br.ind.cmil.api.persistence.dao;

import br.ind.cmil.api.persistence.model.DeviceMetadata;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Administrativo
 */
public interface DeviceMetadataRepository extends JpaRepository<DeviceMetadata, String> {

    List<DeviceMetadata> findByUserId(Long userId);
}
