package com.fsd.workout.controller;

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
import com.fsd.workout.entities.Category;
import com.fsd.workout.service.CategoryService;
import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = FsdApplication.class)
@WebMvcTest(value = CategoryController.class, secure = false)
public class CategoryControllerTest {
	public static final String CONTENT_TYPE = "Content-type";
	public static final ResultMatcher OK = status().isOk();
	public static final ResultMatcher RESPONSE_FORMAT = content().contentType(MediaType.APPLICATION_JSON_UTF8);
	
	public static final String PATH = "/api/category/";
	 private String categoryName;
 
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	CategoryController controller;

	@MockBean
	CategoryService service;
   

	private Category category = new Category(categoryName);
	
	@Before
	public void setUp() throws Exception {
		category.setCategoryId(1l);
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void thatGetListOfCategory() throws Exception {

		List<Category> categoryList = new ArrayList<Category>();
		categoryList.add(category);
		given(service.getCategoryDetails()).willReturn(categoryList);

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
	public void thatCreateCategoryWhenPassingCategoryInformation() throws Exception {
		given(service.addCategory(Mockito.any(Category.class))).willReturn(category);
		String content = new Gson().toJson(category);
		this.mockMvc.perform(post(PATH).contentType(MediaType.APPLICATION_JSON).content(content)).andExpect(OK)
				.andExpect(jsonPath("$.categoryName").value(categoryName)).andReturn();
		}
	
	
	@Test
	public void thatDeleteCategoryWhenPassinCategoryId() throws Exception {
		Long SOME_CategoryId = 1l;
		this.mockMvc.perform(delete(PATH + "/" + SOME_CategoryId).contentType(MediaType.APPLICATION_JSON))
				.andExpect(OK).andReturn();
	}

	

}
