package com.fsd.workout.controller;


import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fsd.workout.FsdApplication;
import com.fsd.workout.entities.WorkOutCollection;
import com.fsd.workout.service.WorkOutCollectionActiveService;
import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = FsdApplication.class)
@WebMvcTest(value = WorkOutCollectionController.class, secure = false)

public class WorkOutCollectionControllerTest {
	public static final String CONTENT_TYPE = "Content-type";
	public static final ResultMatcher OK = status().isOk();
	public static final ResultMatcher RESPONSE_FORMAT = content().contentType(MediaType.APPLICATION_JSON_UTF8);
	
	public static final String PATH = "/api/workout/";
	private String title= "title";
	private String note = "note";
	private Float cbm = 2.2f;
	private Long categoryId = 1l;
 
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	WorkOutCollectionController controller;

	@MockBean
	WorkOutCollectionActiveService service;
   

	private WorkOutCollection workOutCollection = new WorkOutCollection(title,note,cbm,categoryId);
	
	@Before
	public void setUp() throws Exception {
		workOutCollection.setWorkoutId(1l);;
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void thatGetListOfWorkOutsWhenFetchChallengeList() throws Exception {

		List<WorkOutCollection> workoutList = new ArrayList<WorkOutCollection>();
		workoutList.add(workOutCollection);
		given(service.getWorkOutActiveDetails()).willReturn(workoutList);

		ResultMatcher hasRecord = jsonPath("$").isArray();
		MvcResult result = this.mockMvc
				.perform(get(PATH).accept(MediaType.APPLICATION_JSON).header(CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(OK)
				.andExpect(RESPONSE_FORMAT)
				.andExpect(hasRecord)
				.andReturn();

		String jsonString = result.getResponse().getContentAsString();
		DocumentContext context = JsonPath.parse(jsonString);
		int length = context.read("$.length()");
		assertThat(length, org.hamcrest.CoreMatchers.is(1));
	}
	
	@Test
	public void thatGetWorkOutsWhenPassinWorkOutId() throws Exception {

		Long SOME_WorkOutId = 1l;
		given(service.getWorkOutDetailsById(SOME_WorkOutId)).willReturn(workOutCollection);
		MvcResult result = this.mockMvc.perform(get(PATH + "/" + SOME_WorkOutId).accept(MediaType.APPLICATION_JSON)
				.header(CONTENT_TYPE, MediaType.APPLICATION_JSON)).andExpect(OK).andExpect(RESPONSE_FORMAT).andReturn();
		String jsonString = result.getResponse().getContentAsString();
		WorkOutCollection role = new Gson().fromJson(jsonString, WorkOutCollection.class);
		assertThat(role, org.hamcrest.CoreMatchers.is(notNullValue()));
	}
	
	

	@Test
	public void thatCreateWorkOutWhenPassingWorkOutInformation() throws Exception {
		given(service.addWorkOut(Mockito.any(WorkOutCollection.class))).willReturn(workOutCollection);
		String content = new Gson().toJson(workOutCollection);
		this.mockMvc.perform(post(PATH).contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(OK)
				.andExpect(jsonPath("$.title").value(title)).andReturn();
		}
	
	
	@Test
	public void thatDeleteWorkOutsWhenPassinWorkOutId() throws Exception {
		Long SOME_WorkOutId = 1l;
		this.mockMvc.perform(delete(PATH + "/" + SOME_WorkOutId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(OK).andReturn();
	}

	
}
