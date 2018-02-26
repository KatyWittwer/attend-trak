package org.launchcode.attendtrac.Models.data;

import org.launchcode.attendtrac.Models.Forms.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//this is an interface
@Repository
@Transactional
//parameterized interface stores the objects, and the keys are ints(Ids)
public interface UserDao extends CrudRepository<User, Integer>{
}
