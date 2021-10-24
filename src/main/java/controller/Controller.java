package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 모든 컨트롤러는 이 인터페이스를 구현하여 사용한다.
 * */
public interface Controller {
	ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException; 
}
