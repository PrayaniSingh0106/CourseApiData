package io.java.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//annotation means that whatever we return is gonna get converted to json automatically and sent back as HTTP Response
public class TopicController {

	@Autowired
	private TopicService topicService;

	// POST is to create new TOPIC
	// PUT is to update a topic
	// Delete
	// GET /topics to get all topics
	// GET /topics/id to get a topic

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopcis();
	}

	@RequestMapping("/topics/{foo}")
	// ("foo") not required if id in place of foo in above line
	public Topic getTopic(@PathVariable("foo") String id) {

		return topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	// tells spring mvc that the request payloD WILL contain json representation of
	// Topic instance. So convert json to instance and pass to this method
	public void addTopic(@RequestBody Topic topic) {

		topicService.addTopic(topic);
	}

	// We give @RequestBody because requestBody will contain the updated topic, from which
	// we will fetch the id so that we make chnages to the particular record(hence PathVariable)
	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {

		topicService.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {

		topicService.deleteTopic(id);
	}
}
