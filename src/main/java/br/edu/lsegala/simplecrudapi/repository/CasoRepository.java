package br.edu.lsegala.simplecrudapi.repository;

import br.edu.lsegala.simplecrudapi.model.Caso;
import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoRepository extends DatastoreRepository<Caso, Long> {
}
