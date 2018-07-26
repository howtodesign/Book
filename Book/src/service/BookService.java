package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Component;

@Component
public class BookService {

	public String bookSearch(String keyword) {

		String clientId = "DFvznd4AejpuPjFlI3Cz";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "D2xpoLUFNT";// 애플리케이션 클라이언트 시크릿값";
		try {
			String text = URLEncoder.encode(keyword, "UTF-8");
			 String apiURL =
			 "https://openapi.naver.com/v1/search/book.xml?query="+ text; //

			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) { 
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { 
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
				
			}
			br.close();
			return response.toString();
		
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
}
