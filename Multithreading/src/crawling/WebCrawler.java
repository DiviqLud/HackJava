package crawling;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class WebCrawler {
	private final AbstractQueue<URI> visitedUrls = new ConcurrentLinkedQueue<URI>();
	private ThreadPoolExecutor manager;
	//private ForkJoinPool pool;
	private URI startLocation;
	private String needle;

	public WebCrawler(ThreadPoolExecutor manager, URI startLocation, String needle) {
		this.manager = manager;
		this.startLocation = startLocation;
		this.needle = needle;
	}

	public void crawl(URI currentLocation, final String needle)
			throws URISyntaxException, InterruptedException,
			ExecutionException, IOException {
		String urlContents = downloadContents(currentLocation);
		//visitedUrls.add(currentLocation);

		if (urlContents.contains(needle)) {
			System.out.println(currentLocation);
		} else {
			for (String link : modifiedListOfLinks(getAllLinks(urlContents))) {
				final URI asUri = normalizeLink(currentLocation, link);
				if (!visitedUrls.contains(asUri)
						&& isInsideDomain(currentLocation, asUri)) {
					startNewThread(asUri, needle);
				}
			}
		}
		if (manager.getQueue().size() == 0) {
			manager.shutdown();
		}
	}
	
	public synchronized void startNewThread(URI link, String needle) {
		visitedUrls.add(link);
		manager.execute(new RequestThread(this, link, needle));
	}

	private static boolean isInsideDomain(URI currentLocation, URI asUrl)
			throws URISyntaxException {
		return currentLocation.getHost().equals(asUrl.getHost());
	}

	private URI normalizeLink(URI currentLocation, String link)
			throws MalformedURLException, URISyntaxException {
		URI uri = new URI(link);
		if (uri.getScheme() != null && uri.getHost() != null) {
			return uri;
		}
		return URIUtils.resolve(currentLocation, uri);
	}

	public static String downloadContents(URI currentLocation)
			throws URISyntaxException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		System.out.println(Thread.currentThread().getName()
				+ " is currently crawling : " + currentLocation);
		HttpGet get = new HttpGet(currentLocation);
		try {
			HttpResponse response = httpClient.execute(get);
			String contents = IOUtils.toString(response.getEntity()
					.getContent());
			return contents;
		} catch (IOException e) {
			e.printStackTrace();
			// IO Error when connecting to the server, whatever, just return
			// empty contents
			return "";
		}
	}

	public static List<String> getAllLinks(String content) {
		List<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}
		return resultList;
	}

	public static void eraseDuplicatingItems(List<String> subUrls) {
		List<String> visited = new ArrayList<String>();
		for (int i = 0; i < subUrls.size(); i++) {
			if (!visited.contains(subUrls.get(i))) {
				visited.add(subUrls.get(i));
			}
		}
		subUrls.clear();
		subUrls.addAll(visited);

	}

	public static List<String> modifiedListOfLinks(List<String> subUrls)
			throws IOException, URISyntaxException {
		List<String> result = subUrls;
		eraseDuplicatingItems(result);
		List<String> modifiedResult = new ArrayList<String>();
		for (int j = 0; j < result.size(); j++) {
			if (!result.get(j).contains("../")) {
				modifiedResult.add(result.get(j));
			}
		}

		result.clear();
		result = modifiedResult;
		return result;
	}
}