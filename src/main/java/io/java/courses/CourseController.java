package io.java.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.java.topic.Topic;

@RestController
//annotation means that whatever we return is gonna get converted to json automatically and sent back as HTTP Response
public class CourseController {

	@Autowired
	private CourseService courseService;

	// POST is to create new TOPIC
	// PUT is to update a topic
	// Delete
	// GET /topics to get all topics
	// GET /topics/id to get a topic

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	// ("foo") not required if id in place of foo in above line
	public Course getCourse(@PathVariable String id) {

		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	// tells spring mvc that the request payloD WILL contain json representation of
	// Topic instance. So convert json to instance and pass to this method
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	// We give @RequestBody because requestBody will contain the updated topic, from which
	// we will fetch the id so that we make chnages to the particular record(hence PathVariable)
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{id}")
	public void deleteTopic(@PathVariable String id) {

		courseService.deleteCourse(id);
	}
}
