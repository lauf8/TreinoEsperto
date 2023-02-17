package esperto.treino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Aluno_Index extends AppCompatActivity {
    Button cadastro_alunos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_index);

        cadastro_alunos = findViewById(R.id.add_alunos);

        cadastro_alunos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Aluno_Index.this, Cadastrar_Alunos.class);
                startActivity(intent);
            }
        });
    }


}