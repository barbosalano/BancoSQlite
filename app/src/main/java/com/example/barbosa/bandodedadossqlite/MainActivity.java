package com.example.barbosa.bandodedadossqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");

            //Inserir dados

            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Roberto', 20)");
            //bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Juju', 23)");

            //recuperar os dados
            /*String consulta =
                    "SELECT nome, idade FROM pessoas" +
                    "WHERE nome = 'Luciano' AND idade = 30 ";*/

            /*String consulta =
                    "SELECT nome, idade FROM pessoas" +
                    "WHERE idade >= 35 OR idade = 18";*/

            /*String consulta =
                    " SELECT nome, idade FROM pessoas " +
                     " WHERE nome IN ('Roberto', 'Luciano')";*/

            /*String consulta =
                    " SELECT nome, idade FROM pessoas " +
                    " WHERE idade BETWEEN 20 AND 60";*/

            String consulta =
                    " SELECT nome, idade FROM pessoas " +
                    " WHERE 1=1 ORDER BY nome ASC LIMIT 2";



            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //Indices da tebela

            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null){

                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - nome ", nome + "idade: " + idade);

                cursor.moveToNext();
            }


        }catch (Exception e){

            e.printStackTrace();

        }
    }
}
