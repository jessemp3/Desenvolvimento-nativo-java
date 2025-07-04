package com.nativo.linearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exe1Activity extends AppCompatActivity implements View.OnClickListener {

    private final ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exe1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // uma alternativa pegando com viewHolder e id
        viewHolder.button1 = findViewById(R.id.loginButton);
        viewHolder.button2 = findViewById(R.id.registerButton);
        viewHolder.emailEditText = findViewById(R.id.editTextEmail);
        viewHolder.passwordEditText = findViewById(R.id.editTextPassword);

        viewHolder.button1.setOnClickListener(this);
        viewHolder.button2.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.loginButton) {

           String email = viewHolder.emailEditText.getText().toString();
           String password = viewHolder.passwordEditText.getText().toString();

            if(!email.isEmpty() && !password.isEmpty()) {
                Bundle bundle = new Bundle();
                bundle.putString("email", email);

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtras(bundle); // o putExtras é usado para passar varios dados entre activities
                startActivity(intent);
            }else {
                Toast.makeText(this, "Informe os dados", Toast.LENGTH_SHORT).show();
            }

        } else if(view.getId() == R.id.registerButton) {
            Toast.makeText(this, getString(R.string.register), Toast.LENGTH_SHORT).show();
        }

    }

    private static class ViewHolder{
        EditText emailEditText;
        EditText passwordEditText;
        Button button1;
        Button button2;
    }
}