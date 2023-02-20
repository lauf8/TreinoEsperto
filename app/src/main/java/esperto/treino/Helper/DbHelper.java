package esperto.treino.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TreinoEsperto.dv", null, 1);
    }

    public DbHelper(Context context){
        super(context, "TreinoEsperto.dv", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreateUser = "create table users (id INTEGER PRIMARY KEY AUTOINCREMENT, user VARCHAR(25), password VARCHAR(10));";
        db.execSQL(sqlCreateUser);
        String sqlCreateAluno = "create table alunos (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR(50), password VARCHAR(10),endereco VARCHAR(50));";
        db.execSQL(sqlCreateAluno);
        String sqlCreateAvaliacao = "create table avaliacoes (id INTEGER PRIMARY KEY AUTOINCREMENT, id_aluno INTEGER, altura REAL,peso REAL, idade INTEGER,ombro INTEGER,peito INTEGER, braco_esquerdo INTEGER,braco_direito INTEGER,cintura INTEGER, quadril INTEGER, coxa_esquerda INTEGER, coxa_direita INTEGER,genero VARCHAR(15), data DATE,FOREIGN KEY(id_aluno) REFERENCES alunos(id));";
        db.execSQL(sqlCreateAvaliacao);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table if exists users ;";
        String sql1 = "drop table if exists alunos ;";
        String sql2 = "drop table if exists avaliacoes ;";
        db.execSQL(sql);
        db.execSQL(sql1);
        db.execSQL(sql2);
        onCreate(db);

    }

    public boolean login(String user, String password){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM users WHERE user=? AND password = ?", new String[] {user, password});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
}

