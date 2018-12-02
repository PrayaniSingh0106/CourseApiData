package io.java.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Business Service - Singleton in Spring. Other controllers are dependent on it and hence it's dependency is injected to other classes trhough spring
//First instance of all @Service annotated classes are made in the beginning so that dependency injection can happen with @Autowired in other classes
@Service
public class CourseService {

	@Autowired
	private CourseRepo courseRepo;


	public List<Course> getAllCourses(String topicId) {
		List<Course> t = new ArrayList<>();
		courseRepo.findByTopicId(topicId).forEach(t::add);
		return t;
	}

	public Course getCourse(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return courseRepo.findById(id).get();
	}

	public void addCourse(Course course) {
		courseRepo.save(course);
	}

	public void updateCourse(Course course) {

		/*
		 * for(int i = 0; i< topics.size(); i++) { Topic t = topics.get(i);
		 * 
		 * if(t.getId().equals(id)) { topics.set(i, topic); return; } }
		 */
		courseRepo.save(course);
	}

	public void deleteCourse(String id) {
		courseRepo.deleteById(id);
		// topics.removeIf(t -> t.getId().equals(id));
	}
}
