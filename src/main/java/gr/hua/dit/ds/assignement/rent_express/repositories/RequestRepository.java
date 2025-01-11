package gr.hua.dit.ds.assignement.rent_express.repositories;

import gr.hua.dit.ds.assignement.rent_express.entities.Owner;
import gr.hua.dit.ds.assignement.rent_express.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer> {
}
