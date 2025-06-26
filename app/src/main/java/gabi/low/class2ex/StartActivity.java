package gabi.low.class2ex;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartActivity extends AppCompatActivity {
    public EditText pl1;
    public  EditText pl2;
    public  Button start;
    public SharedPreferences sharedPref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        intit();

        sharedPref = this.getSharedPreferences("myName", MODE_PRIVATE);
        if(sharedPref.contains("pName"))
        {
           String name = sharedPref.getString("pName", "");
           pl2.setText(name);
        }
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f = pl1.getText().toString();
                String s = pl2.getText().toString();
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                intent.putExtra("first", f);
                intent.putExtra("second", s);
                SharedPreferences.Editor preferencesEditor = sharedPref.edit();
                preferencesEditor.putString("pName", s);
                preferencesEditor.commit();
                startActivity(intent);
            }
        });
    }

    private void intit() {
        pl1 = findViewById(R.id.first);
        pl2 = findViewById(R.id.second);
        start = findViewById(R.id.go);
    }
}