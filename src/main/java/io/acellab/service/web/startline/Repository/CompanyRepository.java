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
	
	@Query(value = "SELECT DISTINCT c.* FROM company c "
			+ "LEFT JOIN companyfundings cf ON c.id = cf.company_id WHERE "
			+ "(:company_name = '' "
				+ "OR c.company_name LIKE %:company_name% "
				+ "OR c.introduction LIKE %:company_name%) "
			+ "AND (:location = '' OR c.headquarter LIKE %:location%) "
			+ "AND (:industry = '' OR c.industry LIKE %:industry%) "
			+ "AND (:funding_round = '' OR cf.funding_round = :funding_round)", nativeQuery = true)
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
	
	@Query(value = "SELECT DISTINCT cp.* FROM company cp "
			+ "JOIN bookmark b ON b.company_id = cp.id "
			+ "WHERE b.user_id = :id", nativeQuery = true)
	ArrayList<CompanyInfo> getBookmarkCompanyListByUserID(@Param("id") Long id);
	
	@Query(value = "SELECT DISTINCT cp.id FROM company cp "
			+ "JOIN bookmark b ON b.company_id = cp.id "
			+ "WHERE b.user_id = :id", nativeQuery = true)
	ArrayList<Long> getBookmarkCompanyIDsByUserID(@Param("id") Long id);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM bookmark WHERE user_id = :user_id and company_id = :company_id", nativeQuery = true)
	void deleteBookmarkByUserIDAndCompanyID(Long user_id, Long company_id);

}
