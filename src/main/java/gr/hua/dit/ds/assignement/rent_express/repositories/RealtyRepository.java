package gr.hua.dit.ds.assignement.rent_express.repositories;

import gr.hua.dit.ds.assignement.rent_express.entities.Realty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealtyRepository extends JpaRepository<Realty, Integer> {
}