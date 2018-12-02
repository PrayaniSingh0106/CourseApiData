package io.java.topic;

import org.springframework.data.repository.CrudRepository;

//Spring data JPA will be providing the class
//The two generic types are the table Topic and the type of primary key "id"
public interface TopicRepo extends CrudRepository<Topic, String>{

	
	//getAllTopics()
	//getTopic(String id)
	//updateTopic(Topic t)
	//deleteTopic(String id)
}
