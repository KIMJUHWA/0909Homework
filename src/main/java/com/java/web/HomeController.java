package com.java.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired
	SqlSession sql;
	
	@RequestMapping(value = "/")
	public String home(Model m) {
		List<HomeBean> list = sql.selectList("noticeboard.select");
		m.addAttribute("list", list);
		return "home";
	}
	/*
	@RequestMapping(value = "/insert")
	public String insert(HomeBean hb) {
		
//		String title = req.getParameter("title");
//		String text = req.getParameter("text");
//	
//		hb.setTitle(title);
//		hb.setText(text);
		System.out.println(hb.toString());
		int insert = sql.insert("noticeboard.insert", hb);
		
		if(insert == 0) {
			System.out.println("실패");
		} 
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/update")
	public String update(HomeBean hb) {
//		int no = Integer.parseInt(req.getParameter("no"));
//		String title = req.getParameter("title");
//		String text = req.getParameter("text");
//		
//		hb.setNo(no);
//		hb.setTitle(title);
//		hb.setText(text);
		System.out.println(hb.toString());
		sql.update("noticeboard.update", hb);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HomeBean hb) {
//		int no = Integer.parseInt(req.getParameter("no"));
//		String title = req.getParameter("title");
//		String text = req.getParameter("text");
//		
//		hb.setNo(no);
//		hb.setTitle(title);
//		hb.setText(text);
		System.out.println(hb.toString());
		sql.delete("noticeboard.delete", hb);
		
		return "redirect:/";
	}
	*/
	@RequestMapping(value = "/{key}")
	public String crud(@PathVariable("key") String key, HomeBean hb) {
		
		int sqlResult = 0;
		System.out.println(hb.toString());
		switch (key) {
		case "insert":
			sqlResult = sql.insert("noticeboard.insert", hb);
			break;
		case "update":
			sqlResult = sql.update("noticeboard.update", hb);
			break;
		case "delete":
			sqlResult = sql.delete("noticeboard.delete", hb);
			break;

		default:
			break;
		}
		
		if(sqlResult == 0) {
			System.out.println(key + " : SqlSession 오류");
		}
		
		return "redirect:/";
	}
	
}
