package rss.practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * Servlet implementation class NewsGenerator
 */
@WebServlet("/NewsGenerator")
public class NewsGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String HTMLSTART = "<html><body>";
	private static final String HTMLEND = "</body></html>";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(HTMLSTART);
		out.println("<h1>SPORT NEWS</h1>");
		URL url = new URL("http://www.sportal.bg/uploads/rss_category_2.xml");
        HttpURLConnection httpcon = (HttpURLConnection)url.openConnection();
        // Reading the feed
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed;
		try {
			feed = input.build(new XmlReader(httpcon));
			List entries = feed.getEntries();
			Iterator itEntries = entries.iterator();
			while (itEntries.hasNext()) {
				SyndEntry entry = (SyndEntry) itEntries.next();
				out.println("<div>" + "<h3>" + "<a href=" + entry.getLink() + "\">" + entry.getTitle() + "</a>"  + "</h3>" + "</div>");
				out.println("<div>Publish Date: " + entry.getPublishedDate() + "</div></br>");
				out.println("<div>" + entry.getDescription().getValue() + "</div></br>");
				out.println();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (FeedException e) {
			e.printStackTrace();
		}
        
        out.println(HTMLEND);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
