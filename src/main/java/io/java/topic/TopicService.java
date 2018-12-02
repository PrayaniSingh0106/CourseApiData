package io.java.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Business Service - Singleton in Spring. Other controllers are dependent on it and hence it's dependency is injected to other classes trhough spring
//First instance of all @Service annotated classes are made in the beginning so that dependency injection can happen with @Autowired in other classes
@Service
public class TopicService {


	@Autowired
	private TopicRepo topicRepo;
	
	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("java","Core Java","Core Java Description"),
			new Topic("javascript", "Javascript", "JavaScript Description")
			));
	
	public List<Topic> getAllTopcis(){
		List<Topic> t = new ArrayList<>();
		topicRepo.findAll().forEach(t::add);
		return t;
	}
	
	public Topic getTopic(String id) {
		//return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepo.findById(id).get();
	}

	public void addTopic(Topic topic) {
		topicRepo.save(topic);
	}

	public void updateTopic(String id, Topic topic) {
		
		/*for(int i = 0; i< topics.size(); i++) {
			Topic t = topics.get(i);
			
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}*/
		topicRepo.save(topic);
	}

	public void deleteTopic(String id) {
		topicRepo.deleteById(id);
		//topics.removeIf(t -> t.getId().equals(id));
	}
}
