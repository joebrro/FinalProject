package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.finalproject.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
public class RecipePageActivity extends AppCompatActivity {
    //array list object hold data for recipes
    private ArrayList<RecipeActivity> listRecipe =new ArrayList<>();
    Menu menu;
    ListView theList;
    int positionClicked =0;
    BaseAdapter listAdapter;
    Toolbar tBar;
    String userFilter;
    ProgressBar progressBar
    private static final String TOAST = "TOAST";
    private static final String SNACK = "SNACK";
    private static final String ALERT = "ALERT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_list_page);

         tBar = (Toolbar)findViewById(R.id.navigation_toolbar);
        tBar.setTitle(" "+userFilter);
        setSupportActionBar(tBar);
        //loction of progress bar
         progressBar = findViewById(R.id.progress_bar);
        //progressBar is visbable to see placeholder
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(50);
        //fake data for use until data can be retreved
        listRecipe.add(new RecipeActivity("Closet Cooking","http://food2fork.com/view/35611","Strawberry and Balsamic Grilled Chicken Salad","http://www.closetcooking.com/2012/05/strawberry-and-balsamic-grilled-chicken.html","35611","http://static.food2fork.com/Strawberry2Band2BBalsamic2BGrilled2BChicken2BSalad2B5002B05455fa48e36.jpg",99.99975934380963,"http://closetcooking.com"));
        listRecipe.add(new RecipeActivity("All Recipes","http://food2fork.com/view/2425", "Baked Chicken Nuggets","http://allrecipes.com/Recipe/Baked-Chicken-Nuggets/Detail.aspx","2425","http://static.food2fork.com/9880830335.jpg",99.99992455567956,"http://allrecipes.com"));
        listRecipe.add(new RecipeActivity("BBC Good Food","http://food2fork.com/view/2776bb","Goat's cheese & thyme stuffed chicken","http://www.bbcgoodfood.com/recipes/3925/goats-cheese-and-thyme-stuffed-chicken","2776bb","http://static.food2fork.com/3925_MEDIUM30a4.jpg",99.99655858829465, "http://www.bbcgoodfood.com"));
        //locate list view
        ListView recipeListView =findViewById(R.id.the_recipe_list);
        recipeListView.setAdapter(listAdapter=new MyOwnAdapter());
        recipeListView.setOnItemClickListener( ( lv, vw, pos, id) ->{

            Toast.makeText( RecipePageActivity.this,
                    "You clicked on: " + listRecipe.get(pos).getTitle(), Toast.LENGTH_SHORT).show();
            Snackbar.make(vw,"the publisher is "+listRecipe.get(pos).getPublisher(),Snackbar.LENGTH_LONG).show();
        } );
    }

//    Button runAlert = (Button)findViewById(R.id.runAlert);
//        runAlert.setOnClickListener( cl -> {
//        String query = Uri.encode(search.getText().toString() ); //Have to encode strings to send in URL
//        this.runQuery(query, ALERT);
//    });

    private void runQuery(String query, String responseType)
    {
        MyNetworkQuery theQuery = new MyNetworkQuery(responseType);
        theQuery.execute();//new String [] {"A", "B", "C", "D"} );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.recipe_menu_page, menu);
        return true;
    }



    private class MyNetworkQuery extends AsyncTask<String, Integer, String> {
        String responseType;
        public MyNetworkQuery(String s)
        {
            responseType = s;
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            ProgressBar progressBar=findViewById(R.id.progress_bar);
            progressBar.setVisibility(View.VISIBLE);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected String doInBackground(String... strings) {
            String ret = null;

            String queryURL = "http://torunski.ca/FinalProjectLasagna.json";
            queryURL = "http://torunski.ca/FinalProjectChickenBreast.json";

            try {       // Connect to the server:
                URL url = new URL(queryURL);
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inStream = urlConnection.getInputStream();

                //Set up the JSON object parser:
                // json is UTF-8 by default
                BufferedReader reader = new BufferedReader(new InputStreamReader(inStream, "UTF-8"), 8);
                StringBuilder sb = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    sb.append(line + "\n");
                }
                String result = sb.toString();

            }
            catch(MalformedURLException mfe){ ret = "Malformed URL exception"; }
            catch(IOException ioe)          { ret = "IO Exception. Is the Wifi connected?";}
            //What is returned here will be passed as a parameter to onPostExecute:
            return ret;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.recipe_page_menu_link:

                break;
//            case R.id.car_charger_page_menu_link:
//                Intent goToCarChargerFinder = new Intent(RecipePageActivity.this, CarChargerFinder.class);
//                RecipePageActivity.this.startActivityForResult(goToCarChargerFinder, 10);
//                break;
//            case R.id.currency_exchange_page_menu_link:
//                Intent goToCurrencyExchange = new Intent(RecipePageActivity.this, CurrencyExchangeMain.class);
//                RecipePageActivity.this.startActivityForResult(goToCurrencyExchange, 10);
//                break;
//            case R.id.news_page_menu_link:
//                Intent goToNewsPage = new Intent(RecipePage.this, NewsPage.class);
//                RecipePageActivity.this.startActivityForResult(goToNewsPage, 10);
//                break;
        }
        return true;
    }

    private class MyOwnAdapter extends BaseAdapter {
        //the size of the array list we made earlier
        @Override
        public int getCount() {
            return listRecipe.size();
        }
        //get a specific item in the list
        public RecipeActivity getItem(int position){
            return listRecipe.get(position);
        }
        //gets the position of the item
        @Override
        public long getItemId(int position) {
            return position;
        }
        //sets the individual row of the list
        public View getView(int position, View old, ViewGroup parent) {
            View newView=old;

            if(old==null)
                newView = getLayoutInflater().inflate(R.layout.recipe_list_row, null);

            TextView RecipeTitle=newView.findViewById(R.id.recipe_title);
            RecipeActivity thisRow=getItem(position);

            RecipeTitle.setText(new StringBuilder().append("@string/").append(thisRow.getTitle()).toString());

            //return the row:
            return newView;
        }
    }

}