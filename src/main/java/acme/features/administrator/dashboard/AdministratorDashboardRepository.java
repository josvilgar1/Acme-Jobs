
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

	@Query("select g.sector, count(g) from Companyrecord g group by g.sector")
	Object[] sectores();

	@Query("select min(r.reward.amount),max(r.reward.amount),avg(r.reward.amount),stddev(r.reward.amount) from Request r")
	List<Double> minMaxAvgStDerivationActiveRequest();

	@Query("select stddev(r.rangeMax.amount) from Offer r where r.deadline > current_timestamp()")
	Double stDerivationRangeMaxActiveOffer();


}
