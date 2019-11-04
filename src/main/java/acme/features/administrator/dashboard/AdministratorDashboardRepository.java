
package acme.features.administrator.dashboard;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorDashboardRepository extends AbstractRepository {

	@Query("select count(a) from Announcement a")
	Integer countAnnouncement();

	@Query("select count(c) from Companyrecord c")
	Integer countCompanyRecord();

	@Query("select count(i) from Investorrecord i")
	Integer countInvestorRecords();

	@Query("select min(r.reward.amount) from Request r where r.deadline > current_timestamp()")
	Double minActiveRequest();

	@Query("select max(r.reward.amount) from Request r where r.deadline > current_timestamp()")
	Double maxActiveRequest();

	@Query("select avg(r.reward.amount) from Request r where r.deadline > current_timestamp()")
	Double avgActiveRequest();

	@Query("select stddev(r.reward.amount) from Request r where r.deadline > current_timestamp()")
	Double stDerivationActiveRequest();

	@Query("select min(r.rangeMin.amount) from Offer r where r.deadline > current_timestamp()")
	Double minRangeMinActiveOffer();

	@Query("select max(r.rangeMin.amount) from Offer r where r.deadline > current_timestamp()")
	Double maxRangeMinActiveOffer();

	@Query("select avg(r.rangeMin.amount) from Offer r where r.deadline > current_timestamp()")
	Double avgRangeMinActiveOffer();

	@Query("select stddev(r.rangeMin.amount) from Offer r where r.deadline > current_timestamp()")
	Double stDerivationRangeMinActiveOffer();

	@Query("select min(r.rangeMax.amount) from Offer r where r.deadline > current_timestamp()")
	Double minRangeMaxActiveOffer();

	@Query("select max(r.rangeMax.amount) from Offer r where r.deadline > current_timestamp()")
	Double maxRangeMaxActiveOffer();

	@Query("select avg(r.rangeMax.amount) from Offer r where r.deadline > current_timestamp()")
	Double avgRangeMaxActiveOffer();

	@Query("select stddev(r.rangeMax.amount) from Offer r where r.deadline > current_timestamp()")
	Double stDerivationRangeMaxActiveOffer();

}
