
package acme.features.anonymous.investorrecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investorrecords.Investorrecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnonymousInvestorRecordRepository extends AbstractRepository {

	@Query("select s from Investorrecord s")
	Collection<Investorrecord> findMany();

	@Query("select s from Investorrecord s where s.id = ?1")
	Investorrecord findOneById(int id);
}
