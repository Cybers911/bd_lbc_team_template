package com.eduardo.project.dependency;

import com.eduardo.project.activity.*;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {DaoModule.class})
public interface ServiceComponent {
    CreateCornPestActivity provideCreateCornPestActivity();
    GetCornPestsActivity provideGetCornPestsActivity();
    UpdateCornPestActivity provideUpdateCornPestActivity();

    CreateWheatPestActivity provideCreateWheatPestActivity();
    GetWheatPestsActivity provideGetWheatPestsActivity();
    UpdateWheatPestActivity provideUpdateWheatPestActivity();
}
