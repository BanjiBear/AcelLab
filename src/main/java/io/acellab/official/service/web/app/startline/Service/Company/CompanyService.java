package io.acellab.official.service.web.app.startline.Service.Company;

import io.acellab.official.service.web.app.startline.Dto.Company.CompanyMemberDto;
import io.acellab.official.service.web.app.startline.Entity.UserEntity;
import io.acellab.official.service.web.app.startline.Status.ResponseFactory;

import java.util.List;

public interface CompanyService {

    public ResponseFactory<CompanyMemberDto> findCompanyMembersByUsername(String username);

}
