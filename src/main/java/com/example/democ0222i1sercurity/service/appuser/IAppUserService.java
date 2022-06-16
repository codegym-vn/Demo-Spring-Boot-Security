package com.example.democ0222i1sercurity.service.appuser;

import com.example.democ0222i1sercurity.model.AppUser;
import com.example.democ0222i1sercurity.service.GeneralService;

public interface IAppUserService extends GeneralService<AppUser> {
    AppUser findByName(String name);
}
