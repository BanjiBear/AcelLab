package io.acellab.official.service.web.app.startline.Service.Company;

import io.acellab.official.service.web.app.startline.Dto.Company.CompanyMemberDto;
import io.acellab.official.service.web.app.startline.Entity.CompanyEntity;
import io.acellab.official.service.web.app.startline.Repository.CompanyRepository;
import io.acellab.official.service.web.app.startline.Repository.UserRepository;
import io.acellab.official.service.web.app.startline.Status.ResponseFactory;
import io.acellab.official.service.web.app.startline.Status.Status;
import io.acellab.official.service.web.app.startline.Util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    @Transactional
    public ResponseFactory<CompanyMemberDto> findCompanyMembersByUsername(String username) {

        Optional<CompanyEntity> searchCompany = companyRepository.findCompanyByUsername(username);

        if (searchCompany.isEmpty()) {
            return ResponseUtil.createResponse(Status.DATA_NOT_FOUND, new ArrayList<CompanyMemberDto>());
        }

        Long companyId = searchCompany.get().getId();

        List<CompanyMemberDto> members = companyRepository.findMembersByCompanyId(companyId);

        if (members.isEmpty()) {
            return ResponseUtil.createResponse(Status.DATA_NOT_FOUND, new ArrayList<CompanyMemberDto>());
        } else {
            return ResponseUtil.createResponse(Status.DATA_FOUND, members);
        }
    }

}
