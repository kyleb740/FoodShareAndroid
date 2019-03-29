package foodshare.kyle740.github.io.foodshare;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import foodshare.kyle740.github.io.foodshare.data.Food;
import foodshare.kyle740.github.io.foodshare.data.FoodDao;
import foodshare.kyle740.github.io.foodshare.data.FoodDatabase;
import foodshare.kyle740.github.io.foodshare.data.FoodApp;

public class FoodViewActivity extends AppCompatActivity implements MyFoodAdapter.OnItemClick{

    //Variable for Room Database
    private FoodDatabase database;
    private List<Food> foods;

    //Variables for the recyclerview
    private MyFoodAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private RecyclerView recyclerView;

    // Declare View Var
    private Button backButton;
    private int pos;

    //Click listener for edit
    private View.OnClickListener listen = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivityForResult(new Intent(FoodViewActivity.this,EditActivity.class),100);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_view);

        // Assign Button from layout file to variable
        backButton = (Button) findViewById(R.id.back_button);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Button clicked to go back to Main page
                startActivity(new Intent(FoodViewActivity.this, MainActivity.class));
            }
        };
        backButton.setOnClickListener(listener);


        //Binds the view item variables to the view using the ID
        recyclerView = findViewById(R.id.full_recycler_view);

        //Variable reference to the database
        database = ((FoodApp) getApplicationContext()).getDatabase(this);

        //Calls the setupRecyclerView method
        setupRecyclerView();
    }

    //recyclerView setup
    private void setupRecyclerView(){

        linearLayoutManager = new LinearLayoutManager(this);
        //Database DAO getAllFood to populate adapter
        adapter = new MyFoodAdapter(database.foodDao().getAllFood(), FoodViewActivity.this);

        recyclerView.setLayoutManager(linearLayoutManager);
        //Recycler view us adapter
        recyclerView.setAdapter(adapter);
        //Refresh Adapter
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(final int pos) {
        new AlertDialog.Builder(FoodViewActivity.this)
                .setTitle("Select Options")
                .setItems(new String[]{"Update"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                                FoodViewActivity.this.pos = pos;
                                startActivityForResult(
                                        new Intent(FoodViewActivity.this,
                                                EditActivity.class),
                                        100);
                    }
                }).show();

    }

}


//.putExtra("food", FoodDao.getFoodByName("food"))