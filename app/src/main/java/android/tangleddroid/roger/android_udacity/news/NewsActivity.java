package android.tangleddroid.roger.android_udacity.news;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.tangleddroid.roger.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    // creating array list for our categories,
    // different news and category recycler view.
    private RecyclerView categoriesRV;
    private ArrayList<CategoriesModal> categoriesModalArrayList;
    private ArrayList<NewsModal> popularNewsArrayList, sportsNews, techNews;
    private CategoriesRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        categoriesRV = findViewById(R.id.newsRecycler);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        categoriesRV.setLayoutManager(manager);

        categoriesModalArrayList = new ArrayList<>();
        sportsNews = new ArrayList<>();
        techNews = new ArrayList<>();
        popularNewsArrayList = new ArrayList<>();

        adapter = new CategoriesRecyclerAdapter(categoriesModalArrayList, this);
        categoriesRV.setAdapter(adapter);

        getPopularNews(popularNewsArrayList, categoriesModalArrayList);
        getSportsNews(categoriesModalArrayList, sportsNews);
        getTechnews(categoriesModalArrayList, techNews);

        adapter.notifyDataSetChanged();
    }

    private void getSportsNews(ArrayList<CategoriesModal> categoriesModals, ArrayList<NewsModal> sportsNews) {

        Log.e("TAG", "SIZE IS " + categoriesModalArrayList.size());
        String url = "https://jsonkeeper.com/b/U1BV";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(NewsActivity.this);

        // in this case the data we are getting is in the form
        // of array so we are making a json array request.
        // below is the line where we are making an json array
        // request and then extracting data from each json object.

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("TAG", "SPORTS RESPONSE IS " + response);

                try {
                    String category = response.getString("newsCategory");
                    JSONArray newsArray = response.getJSONArray("news");

                    for (int i = 0; i < newsArray.length(); i++) {
                        JSONObject newsObj = newsArray.getJSONObject(i);
                        String newsTitle = newsObj.getString("newsTitle");
                        String newsDesc = newsObj.getString("newsDesc");
                        String newsImg = newsObj.getString("newsImg");
                        sportsNews.add(new NewsModal(newsTitle, newsDesc, newsImg));
                    }

                    categoriesModals.add(new CategoriesModal(category, sportsNews));
                    Log.e("TAG", "MODALS = " + sportsNews.size() + "\n" + categoriesModals.size());
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewsActivity.this, "Fail to get Data", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }

    private void getTechnews(ArrayList<CategoriesModal> categoriesModals, ArrayList<NewsModal> techNews) {

        // ArrayList<CategoriesModal> categoriesModals = null;
        String url = "https://jsonkeeper.com/b/ZCWD";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(NewsActivity.this);

        // in this case the data we are getting is in the form
        // of array so we are making a json array request.
        // below is the line where we are making an json array
        // request and then extracting data from each json object.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.e("TAG", "TECH RESPONSE IS " + response);
                try {
                    String category = response.getString("newsCategory");
                    JSONArray newsArray = response.getJSONArray("news");
                    for (int i = 0; i < newsArray.length(); i++) {
                        JSONObject newsObj = newsArray.getJSONObject(i);
                        String newsTitle = newsObj.getString("newsTitle");
                        String newsDesc = newsObj.getString("newsDesc");
                        String newsImg = newsObj.getString("newsImg");
                        techNews.add(new NewsModal(newsTitle, newsDesc, newsImg));
                    }

                    categoriesModals.add(new CategoriesModal(category, techNews));
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewsActivity.this, "Fail to get Data", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }

    private void getPopularNews(ArrayList<NewsModal> popularNewsArrayList, ArrayList<CategoriesModal> categoriesModals) {
        String url = "https://jsonkeeper.com/b/ZCWD";

        // creating a new variable for our request queue
        RequestQueue queue = Volley.newRequestQueue(NewsActivity.this);

        // in this case the data we are getting is in the form
        // of array so we are making a json array request.
        // below is the line where we are making an json array
        // request and then extracting data from each json object.
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.e("TAG", "POPULAR NEWS RESPONSE IS " + response);
                try {
                    String category = response.getString("newsCategory");
                    JSONArray newsArray = response.getJSONArray("news");
                    for (int i = 0; i < newsArray.length(); i++) {
                        JSONObject newsObj = newsArray.getJSONObject(i);
                        String newsTitle = newsObj.getString("newsTitle");
                        String newsDesc = newsObj.getString("newsDesc");
                        String newsImg = newsObj.getString("newsImg");
                        popularNewsArrayList.add(new NewsModal(newsTitle, newsDesc, newsImg));
                    }

                    categoriesModals.add(new CategoriesModal(category, popularNewsArrayList));
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(NewsActivity.this, "Fail to get Data", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }
}