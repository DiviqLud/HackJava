package jsonInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;

public class GetContent {
	public static String getContent(URL url) throws ClientProtocolException, IOException {
		HttpClient httpclient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url.toString());
		HttpResponse response = httpclient.execute(request);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		
		String content = br.readLine();
		
		br.close();
		return content;
	}
}
