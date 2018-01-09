package com.mvc.common.controller;

import com.mvc.common.model.Person;
import com.mvc.common.service.PersonService;
import com.mvc.common.service.valid.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    private static final Logger LOGGER = Logger.getLogger(PersonController.class.getName());

    @RequestMapping(value = {"/all", "/all/{type}"}, method = RequestMethod.GET)
    public ModelAndView showAllPersons(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req) {

        String type = pathVariablesMap.get("type");
        PagedListHolder<Person> personList = null;
        if (null == type) {
            // First Request, Return first set of list
            List<Person> persons = personService.findAll();
            personList = new PagedListHolder<Person>();
            personList.setSource(persons);
            personList.setPageSize(50);
            req.getSession().setAttribute("persons",  personList);
        } else if ("next".equals(type)) {
            // Return next set of list
            personList = (PagedListHolder<Person>) req.getSession()
                    .getAttribute("persons");
            personList.nextPage();
        } else if ("prev".equals(type)) {
            // Return previous set of list
            personList = (PagedListHolder<Person>) req.getSession()
                    .getAttribute("persons");
            personList.previousPage();
        } else {
            // Return specific index set of list
            personList = (PagedListHolder<Person>) req.getSession()
                    .getAttribute("persons");
            int pageNum = Integer.parseInt(type);
            personList.setPage(pageNum);
        }

        ModelAndView mv = new ModelAndView("personsmanager");
        return  mv;

    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.GET)
    public String showPickedPerson(@PathVariable int personId, ModelMap model) {
        Person person = personService.findById(personId);
        if (person == null) {
            LOGGER.log(Level.WARNING, "Person not found id=" + personId);
            throw new EmptyResultDataAccessException("Person not found", 1);
        }
        model.addAttribute(person);
        return "person";
    }

    @RequestMapping(value = "/{personId}", method = RequestMethod.POST)
    public String processUpdatePerson(Person person, @PathVariable int personId, Errors errors) {
        PersonValidator personValidator = new PersonValidator();
        personValidator.validate(person, errors);
        if (errors.hasErrors()) {
            LOGGER.log(Level.WARNING, "Person: " + person.toString());
            return "person";
        }
        person.setId(personId);
        personService.update(person);
        return "redirect:/persons";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String newPerson(ModelMap model) {
        model.addAttribute(new Person());
        return "person";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String processSavePerson(@Valid Person person, Errors errors) {
        if (errors.hasErrors()) {
            return "person";
        }
        personService.save(person);
        return "redirect:/persons";
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String resolver() {
        return "redirect:/persons";
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
