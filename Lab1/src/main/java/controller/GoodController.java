package controller;

import dao.GoodDAO;
import model.Good;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GoodController {
    @Autowired
    GoodDAO dao;

    @RequestMapping("/GoodAddForm")
    public String showForm(Model m) {
        m.addAttribute("command", new Good());
        return "GoodAddForm";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("Good") Good good) {
        dao.save(good);
        return "redirect:/ViewGoods";
    }


    @RequestMapping("/ViewGoods")
    public String ViewGoods(Model m) {
        List<Good> list = dao.getGoods();
        m.addAttribute("list", list);
        return "ViewGoods";
    }


    @RequestMapping(value = "/EditGood/{id}")
    public String edit(@PathVariable int id, Model m) {
        Good good = dao.getGoodById(id);
        m.addAttribute("command", good);
        return "GoodEditForm";
    }


    @RequestMapping(value = "/EditGood", method = RequestMethod.POST)
    public String saveEdited(@ModelAttribute("good") Good good) {
        dao.update(good);
        return "ViewGoods";
    }

    @RequestMapping(value = "/DeleteGood/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        dao.delete(id);
        return "ViewGoods";
    }
}
