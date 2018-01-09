package com.mvc.common.controller;

import com.mvc.common.model.Position;
import com.mvc.common.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/positions")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public List<Position> getAll() {
        return positionService.findAll();
    }

    @RequestMapping(value = {"/all","/all/{type}"},method = RequestMethod.GET)
    public ModelAndView showAll(@PathVariable Map<String, String> pathVariablesMap, HttpServletRequest req) {

        String type = pathVariablesMap.get("type");
        PagedListHolder<Position> positionList = null;
        if (null == type) {
            // First Request, Return first set of list
            List<Position> positions = positionService.findAll();
            positionList = new PagedListHolder<Position>();
            positionList.setSource(positions);
            positionList.setPageSize(20);
            req.getSession().setAttribute("positions",  positionList);
        } else if ("next".equals(type)) {
            // Return next set of list
            positionList = (PagedListHolder<Position>) req.getSession()
                    .getAttribute("positions");
            positionList.nextPage();
        } else if ("prev".equals(type)) {
            // Return previous set of list
            positionList = (PagedListHolder<Position>) req.getSession()
                    .getAttribute("positions");
            positionList.previousPage();
        } else {
            // Return specific index set of list
            positionList = (PagedListHolder<Position>) req.getSession()
                    .getAttribute("positions");
            int pageNum = Integer.parseInt(type);
            positionList.setPage(pageNum);
        }
        ModelAndView mv = new ModelAndView("positionsmanager");
        return  mv;
    }


}
