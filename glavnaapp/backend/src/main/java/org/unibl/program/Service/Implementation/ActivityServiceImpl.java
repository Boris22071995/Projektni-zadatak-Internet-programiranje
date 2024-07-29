package org.unibl.program.Service.Implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.program.Entity.Activity;
import org.unibl.program.Entity.Requests.ActivityRequest;
import org.unibl.program.Repository.ActivityRepository;
import org.unibl.program.Service.ActivityService;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    @Override
    public Activity createActivity(ActivityRequest activityRequest) {
        Activity activity = Activity.builder().idActivity(activityRequest.getIdActivity())
                                              .excersise(activityRequest.getExcersise())
                                              .weight(activityRequest.getWeight())
                                              .intesity(activityRequest.getIntesity())
                                              .duration(activityRequest.getDuration())
                                              .date(activityRequest.getDate())
                                              .result(activityRequest.getResult())
                                              .diaryidDiary(activityRequest.getDiaryidDiary()).build();
        Activity saved = activityRepository.save(activity);
        return saved;
    }

    @Override
    public Optional<Activity> getActivity(Integer id) {
        log.info("Getting activity with id: " + id);
        return activityRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        activityRepository.deleteById(id);
    }
}
