package pw.elka.faustyna.services;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

	@Autowired
	RestClient restClient;

	public String getNews() {
		JSONObject response = new JSONObject(restClient.get("/zmbm/blog/category/aktualnosci/?json=1"));
		return response.getJSONArray("posts").toString();
	}

	public String getPage(String pageId) {
		JSONObject response = new JSONObject(restClient.get("/zmbm/" + pageId + "?json=1"));
		return response.getJSONObject("page").toString();
	}
}
