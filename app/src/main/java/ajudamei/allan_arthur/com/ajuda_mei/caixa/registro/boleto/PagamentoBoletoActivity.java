package ajudamei.allan_arthur.com.ajuda_mei.caixa.registro.boleto;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import ajudamei.allan_arthur.com.ajuda_mei.R;

public class PagamentoBoletoActivity extends Activity {

    private DatabaseRegistroBoleto db;
    private ListView itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_boleto);

        db = new DatabaseRegistroBoleto(this);

        itens = (ListView) findViewById(R.id.lista_registro_boleto);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuItem trocar = menu.add(0, 0, 0, "Adicionar");
        trocar.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(PagamentoBoletoActivity.this, AdicionarBoletoActivity.class);
        startActivity(intent);
        return (super.onOptionsItemSelected(item));
    }

    @Override
    protected void onStart() {
        super.onStart();
//        List<Boleto> temp = db.getAllItens();
//        Toast.makeText(getApplicationContext(), "Qnt de itens: " + temp.size(), Toast.LENGTH_SHORT).show();
//        BoletoAdapter regAdapter = new BoletoAdapter(PagamentoBoletoActivity.this, R.layout.boletolista, temp);
//        if (temp != null) {
//            itens.setAdapter(regAdapter);
//        }
    }
}
