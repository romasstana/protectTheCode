package com.github.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/*
	TODO
	Добавить WebApplicationContext для тестов +
	Добавить MockMvc +
	Создать метод с аннотацией @Before которая создает mockMvc на основе webApplicationContext
	Написать метод тестирования метода /employee
		Должен проверяться HTTP статус ответа
		Должен проверять contentType ответа
		Должно проверять значение поля "name"
		Должно проверять значение поля "designation"
		Должно проверять значение поля "salary"
		Должно проверять значение поля "empId"
*/
public class TestWebApp extends SpringBootHelloWorldTests {

	// your solution
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;
    @Before
    public void before() throws Exception {
        System.out.println("WAC = " + webApplicationContext);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void employeeExist() throws Exception{
        mockMvc.perform(get("/employee"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name", Matchers.is("emp1")))
                .andExpect(jsonPath("$.designation", Matchers.is("manager")))
                .andExpect(jsonPath("$.empId", Matchers.is("1")))
                .andExpect(jsonPath("$.salary", Matchers.is(Double.valueOf(3000))));
    }
}
