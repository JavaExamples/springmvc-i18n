package org.example.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

/**
 * 国际化控制器
 */
@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private CookieLocaleResolver resolver;

	/**
	 * 语言切换
	 */
	@RequestMapping("language")
	public ModelAndView language(HttpServletRequest request, HttpServletResponse response, String language) {
		language = language.toLowerCase();
		if (language == null || language.equals("")) {
			return new ModelAndView("redirect:/");
		} else {
			if (language.equals("zh_cn")) {
				resolver.setLocale(request, response, Locale.CHINA);
			} else if (language.equals("en")) {
				resolver.setLocale(request, response, Locale.ENGLISH);
			} else {
				resolver.setLocale(request, response, Locale.CHINA);
			}
		}

		return new ModelAndView("redirect:/");
	}

	/**
	 * 演示一些消息
	 */
	@RequestMapping("something")
	public void something() {
	}

	/**
	 * 换页面
	 */
	@RequestMapping("welcome")
	public void welcome() {
	}

}
