package com;

import com.mvc.common.controller.PersonController;
import com.mvc.common.dao.PersonDao;
import com.mvc.common.model.Person;
import com.mvc.common.service.PersonService;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;

import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static
        org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static
        org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class PersonControllerTest {

    @Test
    public void testShowAllPersons() throws Exception {
        List<Person> personList = createPersonList();
        PersonService personService = mock(PersonService.class);
        when(personService.findAll()).thenReturn(personList);
        PersonController personController = new PersonController();
        personController.setPersonService(personService);
        MockMvc mockMvc = standaloneSetup(personController).setSingleView(new InternalResourceView("/WEB-INF/pages/personsmanager.jsp")).build();

        mockMvc.perform(get("/persons/all")).andExpect(view().name("personsmanager"));

        //        .andExpect(model().attributeExists("persons"))
        //        .andExpect(model().attribute("persons", hasItems(personList.toArray())));
    }

    private List<Person> createPersonList() {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person();
        person1.setId(1);
        person1.setName("mkyong");
        person1.setGender("m");
        Person person2 = new Person();
        person2.setId(2);
        person2.setName("alex");
        person2.setGender("m");
        Person person3 = new Person();
        person3.setId(3);
        person3.setName("joel");
        person3.setGender("f");
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        return personList;
    }

    @Test
    public void testShowPickedPerson() throws Exception {
        Person expectedPerson = new Person();
        expectedPerson.setId(1);
        expectedPerson.setName("mkyong");
        expectedPerson.setGender("m");
        PersonService personService = mock(PersonService.class);
        when(personService.findById(1)).thenReturn(expectedPerson);
        PersonController personController = new PersonController();
        personController.setPersonService(personService);
        MockMvc mockMvc = standaloneSetup(personController).setSingleView(new InternalResourceView("/WEB-INF/pages/person.jsp")).build();
        mockMvc.perform(get("/persons/1"))
                .andExpect(view().name("person"))
                .andExpect(model().attributeExists("person"))
                .andExpect(model().attribute("person",expectedPerson));

        mockMvc.perform(get("/persons/6"))
                .andExpect(view().name("redirect:/persons"));

    }

    @Test
    public void testProcessUpdate() throws Exception {

    }

    @Test
    public void testNewPerson() throws Exception {

    }

    @Test
    public void testProcessSave() throws Exception {

    }
}