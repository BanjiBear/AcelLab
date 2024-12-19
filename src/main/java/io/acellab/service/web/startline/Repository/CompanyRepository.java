package io.acellab.service.web.startline.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.acellab.service.web.startline.Entity.CompanyInfo;
import io.acellab.service.web.startline.Entity.UserInfo;

@Repository("CompanyRepository")
public interface CompanyRepository extends CrudRepository<CompanyInfo, Long> {

	@Query(value = "SELECT * FROM company", nativeQuery = true)
	ArrayList<CompanyInfo> getAllCompany();
	
	@Query(value = "SELECT * FROM company WHERE " +
	           "(:company_name = '' OR company_name LIKE %:company_name% "
	           				+ "OR introduction LIKE %:company_name%) AND " +
	           "(:location = '' OR headquarter LIKE %:location%) AND " +
	           "(:industry = '' OR industry LIKE %:industry%) AND " +
	           "(:funding_round = '' OR funding_round1 = :funding_round "
	           				+ "OR funding_round2 = :funding_round "
	           				+ "OR funding_round3 = :funding_round "
	           				+ "OR funding_round4 = :funding_round "
	           				+ "OR funding_round5 = :funding_round)", nativeQuery = true)
	ArrayList<CompanyInfo> getCompaniesBySearchParams(
			@Param("company_name") String company_name,
			@Param("location") String location,
			@Param("industry") String industry,
			@Param("funding_round") String funding_round);
	
	@Query(value = "SELECT * FROM company WHERE id = :id", nativeQuery = true)
	Optional<CompanyInfo> getCompanyById(@Param("id") Long id);
	
	@Query(value = "SELECT company_id FROM bookmark WHERE user_id = :userId", nativeQuery = true)
	ArrayList<Long> getBookmarkListByUserId(@Param("userId") Long userId);
	
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO bookmark (user_id, company_id) VALUES (:userId, :companyId);", nativeQuery = true)
	void addBookmarkByUserIdAndCompanyId(@Param("userId") Long userId, @Param("companyId") Long companyId);

}
