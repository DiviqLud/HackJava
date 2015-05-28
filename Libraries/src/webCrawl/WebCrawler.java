package webCrawl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class WebCrawler {

	private static List<String> getAllLinks(String content) {
		ArrayList<String> resultList = new ArrayList<>();
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			resultList.add(matcher.group(1));
		}
		return resultList;
	}
	
	public static String htmlFromUrl(String url) throws IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		HttpResponse response = httpClient.execute(request);
		HttpEntity entity = response.getEntity();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				entity.getContent()));

		StringBuilder html = new StringBuilder();
		String line;

		while ((line = br.readLine()) != null) {
			html.append(line);
		}
		
		return html.toString();
	}

	public static List<String> searchForLinks(String url) throws IOException {
		return getAllLinks(htmlFromUrl(url));
	}

	public static boolean searchForNeedle(String url, String needle)
			throws IOException {
		String html = htmlFromUrl(url);

		if (html.toString().contains(needle) == true) {
			System.out.println(url);
			return true;
		}

		return false;
	}

	public static void outgoingLinks(List<String> subUrls) {
		List<String> modLinks = new ArrayList<String>();
		for (int i = 0 ; i < subUrls.size(); i++) {
			if (!subUrls.get(i).contains("http")) {
				modLinks.add(subUrls.get(i));
			}
		}
		subUrls.clear();
		subUrls.addAll(modLinks);
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
		outgoingLinks(result);
		eraseDuplicatingItems(result);
		List<String> modifiedResult = new ArrayList<String>();
		for (int j = 0; j < result.size(); j++) {
			if (!result.get(j).contains("../"))  {
				modifiedResult.add(result.get(j));
			}
		}

		result.clear();
		result = modifiedResult;
		return result;
	}

	public static Queue<String> addElements(Queue<String> urls,
			List<String> subUrls) throws IOException, URISyntaxException {
		List<String> modifiedSubUrls = modifiedListOfLinks(subUrls);
		subUrls.clear();
		subUrls = modifiedSubUrls;
		for (int i = 0; i < subUrls.size(); i++) {
			urls.add(subUrls.get(i));
		}
		return urls;
	}

	public static void crawl(String url, String needle) throws IOException, URISyntaxException {
		Queue<String> urls = new LinkedList<String>();
		urls.add("");
		List<String> allLinks = new ArrayList<String>();
		List<String> visitedLinks = new ArrayList<String>();
		while (!urls.isEmpty()) {
			String currentUrl = url + urls.poll(); // ""
			if (!visitedLinks.contains(currentUrl)) {
				visitedLinks.add(currentUrl);
				if (searchForNeedle(currentUrl, needle) == true) {
					break;
				}
				allLinks = searchForLinks(currentUrl);
				addElements(urls, allLinks);
				System.out.println(urls.toString());
			}
		}
	}

	public static void main(String[] args) throws IOException, URISyntaxException {
		crawl("http://www.vitibet.com/", "Trencin");

	}
}
