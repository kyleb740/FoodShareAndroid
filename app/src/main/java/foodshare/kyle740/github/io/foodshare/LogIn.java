package foodshare.kyle740.github.io.foodshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity {
    // Declare View Vars
    private Button goToListPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Assign Views from layout file to variables
        goToListPage = (Button) findViewById(R.id.login);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Button clicked to go to Food List page
                startActivity(new Intent(LogIn.this, FoodListActivity.class));
            }
        };
        goToListPage.setOnClickListener(listener);
    }
}
