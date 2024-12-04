package co.kh.dev;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "myfirstServlet", urlPatterns = { "/myfirstServlet" })
@WebServlet("/myfirstServlet" )
public class MyfirstServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	//디폴트 생성자	
    public MyfirstServlet() {
        super();
        System.out.println("시작할때 처음 한번 초기화");
    }


    @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	super.service(request, response);
    	doGet(request, response);
//    	requestTest(request,response);
    	System.out.println("service running");
	
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet running");
		//1. 브라우저에서 데이터 가져온다 2.분석해서 crud 3. response의 output or writer 으로 전단
		//1. 사용자 요청 정보를 받아야한다. request 일단 생략
		//2. DB연동해서 crud 진행
		//3-1. 서버에서 클라이언트 문자를 보내기 위한 문자셋 진행.
		response.setCharacterEncoding("UTF-8");
		//3-2. 브라우저에게 text/html charset=UTF-8 이라고 알려줘야한다.
		response.setContentType("text/html;charset=UTF-8");
		//3-3. 출력스트림을 결정한다. (1Byte,2Byte)
		PrintWriter out = response.getWriter();
		out.print("<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "<h1>jsp study 하자</h1>\r\n"
				+ new java.util.Date()
				+ "</body>\r\n"
				+ "</html>");
	
		out.flush();
	}

}
