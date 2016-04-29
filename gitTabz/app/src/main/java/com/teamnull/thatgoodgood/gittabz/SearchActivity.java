package com.teamnull.thatgoodgood.gittabz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.jar.Attributes;

// import ssu.cs370.lab2.R;
// import ssu.cs370.lab2.model.RecipeModel;

public class SearchActivity extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;
    private TextView FirstTextView;
    private TextView SecondTextView;
    private TextView ThirdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchEditText = (EditText)findViewById(R.id.searchEditText);
        FirstTextView = (TextView)findViewById(R.id.recipeNameTextView);
        SecondTextView = (TextView)findViewById(R.id.recipeCuisineTextView);
        ThirdTextView = (TextView)findViewById(R.id.recipeDescriptionTextView);
        searchButton = (Button)findViewById(R.id.searchButton);

        // SecondTextView.setText("Recipe Cuisine");
        // FirstTextView.setText("Recipe Name");
        // ThirdTextView.setText("recipe Description");

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                // RecipeModel rmodel = getMockRecipeData();
            }

        });

    }
/*
    private RecipeModel getMockRecipeData () {
        RecipeModel recipeModel = new RecipeModel();

        recipeModel.setCategory("Main Dish");
        recipeModel.setCuisine("Japanese");
        recipeModel.setDescription("Great\tbasic Chicken\tTeriyaki\trecipe. Better\tthan\tthe\tbottled\tstuff.");
        recipeModel.setPrimaryIngredient("Chicken");
        recipeModel.setReviewCount(34);
        recipeModel.setStarRating(4);
        recipeModel.setImageUrl("http://redirect.bigoven.com/pics/rs/640/chicken-teriyaki-10.jpg");
        recipeModel.setRecipeName("Chicken Teryaki");

        return recipeModel;
    }
*/
}
