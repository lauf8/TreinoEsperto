package esperto.treino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

public class Detalhar_Aluno extends AppCompatActivity {

    Button criar_ficha;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhar_aluno);
        Intent it = getIntent();
        String id = it.getStringExtra("id");

        criar_ficha = findViewById(R.id.btn_add_avaliacao_aluno);

        criar_ficha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Detalhar_Aluno.this, Criar_Avaliacao.class);
                intent.putExtra("id", id);
                startActivity(intent);
            }
        });


    }
}