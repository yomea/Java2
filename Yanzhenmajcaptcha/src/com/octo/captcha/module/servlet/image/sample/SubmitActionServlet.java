package com.octo.captcha.module.servlet.image.sample;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitActionServlet extends HttpServlet
{
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String userCaptchaResponse = request.getParameter("japtcha");
    response.setContentType("text/html;charset=utf-8");
    boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, userCaptchaResponse);
    if (captchaPassed)
      response.getWriter().write("captcha passed");
    else {
      response.getWriter().write("captcha failed");
    }
    response.getWriter().write("<br/><a href='index.jsp'>Try again</a>");
  }
}