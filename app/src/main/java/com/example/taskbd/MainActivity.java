package com.example.taskbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase bancoDados; //criando um objeto database para manipular o banco no programa

    EditText Edit_nome;
    EditText Edit_idade;
    EditText Edit_temperatura;
    EditText Edit_tosse;
    EditText Edit_enxaqueca;
    CheckBox check_italia;
    CheckBox check_china;
    CheckBox check_indonesia;
    CheckBox check_portugal;
    CheckBox check_estados_unidos;
    EditText Edit_visitados;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        criarBancoDados();//o metodo sera chamado assim que iniciar o app

        Edit_nome = findViewById(R.id.Edit_nome);
        Edit_idade = findViewById(R.id.Edit_idade);
        Edit_temperatura = findViewById(R.id.Edit_temperatura);
        Edit_tosse = findViewById(R.id.Edit_tosse);
        Edit_enxaqueca = findViewById(R.id.Edit_enxaqueca);
        check_italia = findViewById(R.id.italia);
        check_china = findViewById(R.id.china);
        check_indonesia = findViewById(R.id.indonesia);
        check_portugal = findViewById(R.id.portugal);
        check_estados_unidos = findViewById(R.id.estados_unidos);
        Edit_visitados = findViewById(R.id.Edit_visitados);
        botao = findViewById(R.id.botao);


        botao.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }


        });

    }

    public void inserirDados() {
        try {
            bancoDados = openOrCreateDatabase("taskdb", MODE_PRIVATE, null);
            bancoDados.execSQL("INSERT INTO prontuario (nome) VALUES (" +
                    Edit_nome.getText().toString() +
                    Edit_idade.getText().toString() +
                    Edit_temperatura.getText().toString() +
                    Edit_tosse.getText().toString() +
                    Edit_enxaqueca.getText().toString() +
                    check_italia.getText().toString() +
                    check_china.getText().toString() +
                    check_indonesia.getText().toString() +
                    check_portugal.getText().toString() +
                    check_estados_unidos.getText().toString() +
                    Edit_visitados.getText().toString() +
                    ")");
        } catch (Exception erro) {

        }


    }

    public void criarBancoDados() {
        try {
            bancoDados = openOrCreateDatabase("taskdb", MODE_PRIVATE, null);
            //a primeira vez que eu executar este comando ele vai criar o banco,
            //das proximas vezes ele só irá abrir já que ja foi criado
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS prontuario(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    ", nome VARCHAR" +
                    ", idade FLOAT" +
                    ", temperatura_corporal FLOAT" +
                    ", dias_tosse FLOAT" +
                    ", dias_enxaqueca FLOAT" +
                    ", italia BOOLEAN" +
                    ", china BOOLEAN" +
                    ", indonesia BOOLEAN" +
                    ", portugal BOOLEAN" +
                    ", estados_unidos BOOLEAN" +
                    ", qnt_tempovisita FLOAT)");

            bancoDados.close();//fecho a conexão

        } catch (Exception erro) { //catch caso der erro mostra na tela

        }


    }


}



