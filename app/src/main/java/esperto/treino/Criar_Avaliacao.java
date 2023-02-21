package esperto.treino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import esperto.treino.Model.Aluno;

public class Criar_Avaliacao extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView nome_aluno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_avaliacao);
        Spinner spinner = findViewById(R.id.campo_genero_avaliacao);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genero, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        Intent it = getIntent();
        String id = it.getStringExtra("id");

        Aluno aluno = new Aluno(Criar_Avaliacao.this);
        Cursor cursor =aluno.detalhar(id);
        String nome = cursor.getString(cursor.getColumnIndex("id"));
        nome_aluno = findViewById(R.id.nome_aluno_avaliacao);
        nome_aluno.setText(nome);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

