package com.manipal.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manipal.model.Tweet;
import com.manipal.service.TweetService;
import com.manipal.util.CurrentUserNameUtil;

@Controller
public class TweetController {
	
	@Autowired
	private TweetService tweetService;
	
	@GetMapping("/twitter/user/{userName}/tweet")
	public String addTweet(@PathVariable String userName, Model model) {
		model.addAttribute("userName", userName);
		Tweet tweet = new Tweet();
		model.addAttribute("tweetOb", tweet);
		return "add-tweet";
	}
	
	
	@PostMapping("/twitter/user/{userName}/tweet")
	public String addTweet(@PathVariable String userName, @ModelAttribute("tweetOb") Tweet tweetOb, BindingResult result , RedirectAttributes redirectAttrs) {
				
		if(tweetOb.getTweet().length() == 0) {
			System.out.println("------>Error Here");
			return "add-tweet";
		}			
		
		if(userName.equals(CurrentUserNameUtil.getCurrentUserName())) {
			tweetOb.setUserName(userName);
			tweetOb.setCreationTime(LocalDateTime.now());
			tweetService.addOrUpdateTweet(tweetOb);
			redirectAttrs.addAttribute("userName", userName);
			return "redirect:/twitter/user/{userName}";
			
		}
		
		return "add-tweet";
	}
	
	@GetMapping("/twitter/user/{userName}/tweets")
	public String retrieveTweetsByUserName(@PathVariable String userName, Model model){
			List<Tweet> tweets = tweetService.retrieveTweetsByUserName(userName);
			model.addAttribute("tweets", tweets);
			model.addAttribute("userName",userName);
			return "RetrieveTweet";
	}
	
	@GetMapping("/twitter/tweets")
	public String retrieveAllTweets(Model model, @Param("keyword") String keyword){
		List<Tweet> tweets = tweetService.retrieveAllTweets(keyword);
		model.addAttribute("tweets", tweets);
		model.addAttribute("userName",CurrentUserNameUtil.getCurrentUserName());
		model.addAttribute("keyword", keyword);
		return "retrieve-all-tweets";
	}
	
	
	@GetMapping("/twitter/user/{userName}/tweetId/{tweetId}")
	public String deleteTweetById(@PathVariable String userName, @PathVariable int tweetId, RedirectAttributes redirectAttrs) {
		
		redirectAttrs.addAttribute("userName", userName);
		if(userName.equals(CurrentUserNameUtil.getCurrentUserName())) {
			tweetService.deleteTweetById(tweetId);
			return "redirect:/twitter/user/{userName}/tweets";
		}
		return "redirect:/twitter/user/{userName}/tweets";
	}
	
	@GetMapping("/twitter/user/{userName}/tweet/{tweetId}")
	public String updateTweet(@PathVariable String userName, @PathVariable int tweetId, Model model) {
		model.addAttribute("userName", userName);
		model.addAttribute("tweetId", tweetId);
		Tweet tweet = new Tweet();
		model.addAttribute("tweetOb", tweet);
		return "update-tweet";
	}
	
	@PostMapping("/twitter/user/{userName}/tweet/{tweetId}")
	public String updateTweet(@PathVariable String userName, @PathVariable int tweetId, @ModelAttribute("tweetOb") Tweet tweetOb, BindingResult result , RedirectAttributes redirectAttrs) {
		
		if(tweetOb.getTweet().length() == 0) {
			return "update-tweet";
		}
		
		if(userName.equals(CurrentUserNameUtil.getCurrentUserName())) {
			Tweet tweet = tweetService.retrieveTweetsByTweetId(tweetId);
			tweet.setTweet(tweetOb.getTweet());
			tweetService.addOrUpdateTweet(tweet);
			redirectAttrs.addAttribute("userName", userName);
			return "redirect:/twitter/user/{userName}";
		}
		
		return "update-tweet";
	}
	
	@GetMapping("/twitter/trending")
	public String trendingTweets(Model model){
		LinkedHashMap<String, String> trendingTweets = tweetService.trendingTweets();
		model.addAttribute("trendingTweets", trendingTweets);
		model.addAttribute("userName", CurrentUserNameUtil.getCurrentUserName());
		return "trending-tweets";
	}
	
}
