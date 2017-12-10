package org.launchcode.attendtrac.Models.data;

import org.launchcode.attendtrac.Models.Attendee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AttendeeDao extends CrudRepository<Attendee, Integer> {
}
