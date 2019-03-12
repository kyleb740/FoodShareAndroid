package foodshare.kyle740.github.io.foodshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FoodListActivity extends AppCompatActivity {
    // Declare View Vars
    private Button goToEditPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);

        // Assign Views from layout file to variables
        goToEditPage = (Button) findViewById(R.id.edit);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Button clicked to go to Food List page
                startActivity(new Intent(FoodListActivity.this, EditFood.class));
            }
        };
        goToEditPage.setOnClickListener(listener);
    }
}
