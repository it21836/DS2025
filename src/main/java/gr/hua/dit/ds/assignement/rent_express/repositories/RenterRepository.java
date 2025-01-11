package gr.hua.dit.ds.assignement.rent_express.repositories;

import gr.hua.dit.ds.assignement.rent_express.entities.Owner;
import gr.hua.dit.ds.assignement.rent_express.entities.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenterRepository extends JpaRepository<Renter, Integer> {
}
