package edu.eci.cvds.services;
import com.google.inject.Injector;

import edu.eci.cvds.persistence.RecursoDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisRecursoDAO;
import edu.eci.cvds.services.impl.ECILibraryServicesImpl;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ECILibraryServicesFactory {

    private static ECILibraryServicesFactory instance = new ECILibraryServicesFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(ECILibraryServices.class).to(ECILibraryServicesImpl.class);
                bind(RecursoDAO.class).to(MyBatisRecursoDAO.class);
            }
        });
    }

    private ECILibraryServicesFactory(){
        optInjector = Optional.empty();
    }

    public ECILibraryServices getECILibraryServices(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ECILibraryServices.class);
    }


    public static ECILibraryServicesFactory getInstance(){
        return instance;
    }

}
