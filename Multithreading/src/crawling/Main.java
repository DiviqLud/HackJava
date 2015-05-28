package crawling;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException,
			ExecutionException {
		ThreadPoolExecutor manager = (ThreadPoolExecutor) Executors.newFixedThreadPool(8);
		ForkJoinPool pool = new ForkJoinPool();

		//URI startLocation = new URI("http://www.mysmallwebpage.com/");
		//String needle = "the inevitable post-lunch shut-eye";
		String needle = "Револвираща";
		URI startLocation = new URI("http://www.ebusiness.free.bg/");
		WebCrawler crawler = new WebCrawler(manager, startLocation, needle);
		
		crawler.startNewThread(startLocation, needle);
		
		
		//crawler.crawl(startLocation, needle);
		
	}
}
