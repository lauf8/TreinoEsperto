package esperto.treino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import esperto.treino.Helper.Convercao;
import esperto.treino.Model.Aluno;

public class Detalhar_Aluno extends AppCompatActivity {

    Button criar_ficha;
    TextView nome_aluno;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhar_aluno);
        Intent it = getIntent();
        String id = it.getStringExtra("id");

        Aluno aluno = new Aluno(Detalhar_Aluno.this);
        Cursor cursor =aluno.detalhar(id);
        criar_ficha = findViewById(R.id.btn_add_avaliacao_aluno);
        nome_aluno = findViewById(R.id.nome_aluno_detalhar);
        String nome = cursor.getString(cursor.getColumnIndex("nome"));
        nome_aluno.setText(nome);




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