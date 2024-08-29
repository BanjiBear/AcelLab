package io.acellab.official.service.web.app.startline.Repository;

import io.acellab.official.service.web.app.startline.Dto.Company.CompanyMemberDto;
import io.acellab.official.service.web.app.startline.Entity.CompanyEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("CompanyRepository")
public interface CompanyRepository extends CrudRepository<CompanyEntity, Long> {

    //find the company information by enter any username that they are joined the company.
    @Query(value = "SELECT c.id AS id, c.name, c.email, c.icon, c.address, c.region, c.country, c.team_size, c.website, c.short_intro, c.background, c.field, c.segmented_field, c.financing_round FROM company c INNER JOIN companyMembers cm ON cm.companyId = c.id INNER JOIN crm_user u ON u.id = cm.userId WHERE u.username = :username", nativeQuery = true)
    Optional<CompanyEntity> findCompanyByUsername(@Param("username") String username);

    @Query(value = "SELECT crm_user.avatar as avatar, crm_user.username as username, crm_user.status as status, companyMembers.CompanyPosition as companyPosition, companyMembers.Permission as permission FROM crm_user INNER JOIN companyMembers ON crm_user.id = companyMembers.userId INNER JOIN company ON company.id = companyMembers.companyId WHERE company.id = :companyId", nativeQuery = true)
    List<CompanyMemberDto> findMembersByCompanyId(@Param("companyId") Long companyId);

}
