package io.java.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

//Spring data JPA will be providing the class
//The two generic types are the table Topic and the type of primary key "id"
public interface CourseRepo extends CrudRepository<Course, String>{

	
	//getAllTopics()
	//getTopic(String id)
	//updateTopic(Topic t)
	//deleteTopic(String id)
	
	public List<Course> findByTopicId(String topicId); 
}
