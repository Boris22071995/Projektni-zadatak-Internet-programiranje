package org.unibl.program.Controller;

import io.swagger.models.auth.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.unibl.program.Entity.Activity;
import org.unibl.program.Entity.Requests.ActivityRequest;
import org.unibl.program.Service.ActivityService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping
    public List<Activity> getAll(){
        return activityService.getAll();
    }

    @PostMapping
    public ResponseEntity<Activity> createActivity(@Valid @RequestBody ActivityRequest activityRequest) {
        Activity activity = activityService.createActivity(activityRequest);
        return new ResponseEntity<>(activity, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activity> getActivity(@PathVariable("id") Integer id) {
        Optional<Activity> activity = activityService.getActivity(id);
        return activity.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        activityService.delete(id);
    }
}
