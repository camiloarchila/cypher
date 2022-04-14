package edu.eci.cvds.services;
import com.google.inject.Injector;

import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisRecursoDAO;
import edu.eci.cvds.services.impl.ECILibraryServicesImpl;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ECILibraryServicesFactory {
    private static ECILibraryServicesFactory instance = new ECILibraryServicesFactory();

    private static Optional<Injector> optInjector = Optional.empty();

    private ECILibraryServicesFactory() {
    }

    private Injector myBatisInjector(String env, String pathResource, JdbcHelper jdbcHelper) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                install(jdbcHelper);
                setClassPathResource(pathResource);
                bind(ECILibraryServices.class).to(ECILibraryServicesImpl.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);

            }
        });
    }


    public static ECILibraryServicesFactory getInstance() {
        return instance;
    }

    public ECILibraryServices getECILibraryServices() {
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml",JdbcHelper.MySQL));
        }

        return optInjector.get().getInstance(ECILibraryServices.class);
    }
}