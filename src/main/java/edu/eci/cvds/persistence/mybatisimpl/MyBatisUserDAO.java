package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.UserDAO;
import org.apache.ibatis.exceptions.PersistenceException;
import edu.eci.cvds.persistence.mappers.UserMapper;
import java.util.List;

public class MyBatisUserDAO implements UserDAO {

    @Inject
    private UserMapper UserMapper;


}
