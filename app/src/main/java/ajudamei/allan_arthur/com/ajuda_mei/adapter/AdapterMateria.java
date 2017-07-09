package ajudamei.allan_arthur.com.ajuda_mei.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import ajudamei.allan_arthur.com.ajuda_mei.R;
import ajudamei.allan_arthur.com.ajuda_mei.domain.item.Item;
import ajudamei.allan_arthur.com.ajuda_mei.domain.item.ItemMateriaPrima;

/**
 * Created by Allan on 31/05/2017.
 */

public class AdapterMateria extends ArrayAdapter<ItemMateriaPrima> {

    public AdapterMateria(Context context, int resource, List<ItemMateriaPrima> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if( convertView == null ){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.itemlista, parent, false);
        }

        Item temp = getItem(position);
        ImageView img = (ImageView) convertView.findViewById(R.id.imagem);
        img.setImageBitmap(temp.getFoto());
        TextView nome = (TextView) convertView.findViewById(R.id.nome);
        nome.setText("Nome: " + temp.getNome());
        TextView tamanho = (TextView) convertView.findViewById(R.id.tamanho);
        tamanho.setText("Tamanho: " + temp.getTamanho());
        TextView preco = (TextView) convertView.findViewById(R.id.preco_und);
        preco.setText("Preço: R$" + String.valueOf(temp.getPreco()));
        TextView qnt = (TextView) convertView.findViewById(R.id.quantidade);
        qnt.setText("Qtd: " + String.valueOf((int)temp.getQuantidade()));
        //qnt.setText("Data: " + temp.getData());

        return convertView;
    }
}
