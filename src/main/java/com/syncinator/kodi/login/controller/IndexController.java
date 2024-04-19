package com.syncinator.kodi.login.controller;

import com.syncinator.kodi.login.util.Utils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String login(HttpServletRequest request) throws IOException {
		request.setAttribute("sourceid", Utils.getSourceId(request));
		return "index";
	}
	
	@RequestMapping("/auth-success")
	public String success() throws IOException {
		return "auth-success";
	}
	
	@RequestMapping("/failure")
	public String failure() throws IOException {
		return "auth-failure";
	}
	
	@RequestMapping("/privacypolicy")
	public String privacypolicy() throws IOException {
		return "privacypolicy";
	}
}
