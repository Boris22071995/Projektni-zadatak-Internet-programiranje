package org.unibl.program.Service;

import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Activity;
import org.unibl.program.Entity.Requests.ActivityRequest;

import java.util.List;
import java.util.Optional;

@Service
public interface ActivityService {
    List<Activity> getAll();
    Activity createActivity(ActivityRequest activityRequest);
    Optional<Activity> getActivity(Integer id);
    void delete(Integer id);
}
