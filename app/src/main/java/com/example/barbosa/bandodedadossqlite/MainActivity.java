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
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas ( id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

            //para apagar a tabela toda
            // bancoDados.execSQL("DROP TABLE pessoas");

            //PARA APAGAR UMA LINHA(REGISTRO)
            bancoDados.execSQL("DELETE FROM pessoas WHERE id = 3");

            //PARA APAGAR todos os registro de uma tabela
            bancoDados.execSQL("DELETE FROM pessoas ");


            //Inserir dados
            //bancoDados.execSQL("INSERT INTO pessoas( nome, idade) VALUES ('Rebeca', 20)");
          // bancoDados.execSQL("INSERT INTO pessoas( nome, idade) VALUES ('Joao', 23)");

            // bancoDados.execSQL("UPDATE pessoas SET nome = 'Luciano Lindo' WHERE nome = 'Luciano'");

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
                    "SELECT * FROM pessoas " +
                            " WHERE 1=1 ";



            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //Indices da tebela

           int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();

            while (cursor != null) {

                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);


                Log.i("RESULTADO - id ", id + " / nome: " + nome + " / idade: " + idade);

                cursor.moveToNext();
            }


        } catch (Exception e) {

            e.printStackTrace();

        }
    }
}
