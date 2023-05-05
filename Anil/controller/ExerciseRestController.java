package com.workoutwarrior.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.System.Logger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workoutwarrior.model.Exercise;
import com.workoutwarrior.model.ExercisePayload;

@RestController
@RequestMapping("/exercises")
public class ExerciseRestController {
	

	
	private static HttpURLConnection connection;
	
	
	@PostMapping("/getExercise")
	public List<Exercise> getExercise(@RequestBody ExercisePayload payload) {
		
		StringBuilder urlString = new StringBuilder("https://api.api-ninjas.com/v1/exercises?");
		
		if (payload.getName() != null) {
		    urlString.append("name=").append(payload.getName());
		}

		if (payload.getDifficulty() != null) {
		    if (urlString.charAt(urlString.length() - 1) == '?') {
		        urlString.append("difficulty=").append(payload.getDifficulty());
		    } else {
		        urlString.append("&difficulty=").append(payload.getDifficulty());
		    }
		}

		if (payload.getEquipment() != null) {
		    if (urlString.charAt(urlString.length() - 1) == '?') {
		        urlString.append("equipment=").append(payload.getEquipment());
		    } else {
		        urlString.append("&equipment=").append(payload.getEquipment());
		    }
		}

		if (payload.getMuscle() != null) {
		    if (urlString.charAt(urlString.length() - 1) == '?') {
		        urlString.append("muscle=").append(payload.getMuscle());
		    } else {
		        urlString.append("&muscle=").append(payload.getMuscle());
		    }
		}

		if (payload.getType() != null) {
		    if (urlString.charAt(urlString.length() - 1) == '?') {
		        urlString.append("type=").append(payload.getType());
		    } else {
		        urlString.append("&type=").append(payload.getType());
		    }
		}

		
		
		System.out.println(urlString.toString());
		
		try {
			URL url=new URL(urlString.toString());
			connection=(HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("GET");
		
			connection.setRequestProperty("X-Api-Key", "rJRnpA3B95FLT0/juX/B3A==wxt6Y7bWXcOh2sU1");
			connection.setRequestProperty("accept", "application/json");
			
			InputStream responseStream = connection.getInputStream();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(responseStream));
			String inputLine;
			StringBuilder response = new StringBuilder();
			while ((inputLine = in.readLine()) != null) {
			    response.append(inputLine);
			}
			
			ObjectMapper mapper = new ObjectMapper();
			
			System.out.println(response.toString());
			
			
			List<Exercise> exercises = mapper.readValue(response.toString(), new TypeReference<List<Exercise>>(){});
			
			
			return exercises;
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Exercise>();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<Exercise>();

		}
		
		
		
		
		
		
		
		
	}
}
