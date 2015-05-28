package crawling;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;

public class RequestThread implements Runnable {
	private WebCrawler crawler;
	private URI currentLocation;
	private String needle;

	public RequestThread(WebCrawler crawler, URI currentLocation, String needle) {
		this.crawler = crawler;
		this.currentLocation = currentLocation;
		this.needle = needle;

	}

	@Override
	public void run() {
		try {
			crawler.crawl(currentLocation, needle);
		} catch (URISyntaxException | InterruptedException | ExecutionException
				| RejectedExecutionException | IOException e) {
		}

	}

}
