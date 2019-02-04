package com.mavs.activity.repository;

import com.mavs.activity.model.Activity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * CRUD Activity Repository
 */
@Repository
public interface ActivityRepository extends PagingAndSortingRepository<Activity, String> {

    List<Activity> findByType(String type);

}
