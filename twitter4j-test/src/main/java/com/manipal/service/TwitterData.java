package com.manipal.service;

import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.manipal.config.KafkaConfiguration;
import com.manipal.config.TwitterConfiguration;

import twitter4j.FilterQuery;
import twitter4j.HashtagEntity;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;

@Service
public class TwitterData {
	
	@Autowired
	private TwitterConfiguration twitterConfiguration;
	
//	@Autowired
//	private KafkaConfiguration kafkaConfiguration;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	LinkedBlockingQueue<Status> queue = new LinkedBlockingQueue<Status>(100);
	
	public void searchTweets() throws TwitterException{
		
		Twitter twitter = twitterConfiguration.twitterInstance();
		Query query = new Query("#Chelsea");
	    QueryResult result = twitter.search(query);
	    //System.out.println("Hiiiii");
	    //System.out.println(result);
	    List<String> tweets = result.getTweets().stream()
	    	      .map(item -> item.getText())
	    	      .collect(Collectors.toList());
	    for(String tweet : tweets) {
	    	System.out.println(tweet);
	    }
		
	}
	
	public void searchStreamTweets() throws TwitterException{
		
		TwitterStream twitterStream = twitterConfiguration.twitterStreamInstance();
		StatusListener listener = new StatusListener() {

			@Override
		    public void onStatus(Status status) {
		        System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
		    }
		    @Override
		    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		        System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
		    }
		    @Override
		    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		        System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
		    }
		    @Override
		    public void onScrubGeo(long userId, long upToStatusId) {
		        System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
		    }
		    @Override
		    public void onStallWarning(StallWarning warning) {
		        System.out.println("Got stall warning:" + warning);
		    }
		    @Override
		    public void onException(Exception ex) {
		        ex.printStackTrace();
		    }
		};
	    
	    twitterStream.addListener(listener);
	    //FilterQuery filterQuery = new FilterQuery("#Chelsea");
	    //twitterStream.filter(filterQuery);
	    twitterStream.sample();
		//Query query = new Query("#Chelsea");
		
	}
	
public void sendDataToKafka() throws TwitterException, InterruptedException{
		
		TwitterStream twitterStream = twitterConfiguration.twitterStreamInstance();
		StatusListener listener = new StatusListener() {

			@Override
		    public void onStatus(Status status) {
				queue.offer(status);
		        //System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
		    }
		    @Override
		    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
		        System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
		    }
		    @Override
		    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
		        System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
		    }
		    @Override
		    public void onScrubGeo(long userId, long upToStatusId) {
		        System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
		    }
		    @Override
		    public void onStallWarning(StallWarning warning) {
		        System.out.println("Got stall warning:" + warning);
		    }
		    @Override
		    public void onException(Exception ex) {
		        ex.printStackTrace();
		    }
		};
	    
	    twitterStream.addListener(listener);
	    //FilterQuery filterQuery = new FilterQuery("#घन्टा_होगा_भारत_बंद");
	    //twitterStream.filter(filterQuery);
	    twitterStream.sample("en");
	    
	    Thread.sleep(5000);
	    
//	    Status ret = queue.poll();
//	    if(ret == null)
//	    	Thread.sleep(100);
//	    else {
//	    	
//	    }	    
	    
	    
	    int i = 0;
	    
	    while(i < 200) {
	         Status ret = queue.poll();
	         System.out.println("IN WHILE LOOP ------> "+"I VALUE IS:   "+i+" .........."+ret);
	         
	         if (ret == null) {
	            Thread.sleep(100);
	            //i++;
	         }else {
	            for(HashtagEntity hashtage : ret.getHashtagEntities()) {
	               System.out.println("Hashtag: " + hashtage.getText());
	               kafkaTemplate.send("twitter-test", hashtage.getText());
	               i++;
//	               kafkaTemplate.send(new ProducerRecord<String, String>(
//	                  top-icName, Integer.toString(j++), hashtage.getText()));
	            }
	         }
	      }
	    //twitterStream.sample();
		//Query query = new Query("#Chelsea");    
		
	}
}
