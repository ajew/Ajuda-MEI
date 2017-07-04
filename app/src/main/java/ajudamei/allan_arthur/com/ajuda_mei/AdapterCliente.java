package ajudamei.allan_arthur.com.ajuda_mei;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by arthur on 03/07/17.
 */

public class AdapterCliente extends ArrayAdapter<Cliente> {

    public AdapterCliente(Context context, int resource, List<Cliente> objects) {
        super(context, resource, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if( convertView == null ){
            LayoutInflater inflater;
            inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dataregistro, parent, false);
        }

        Cliente temp = getItem(position);

        TextView data = (TextView) convertView.findViewById(R.id.txt_data);
        data.setText("Nome: " + temp.getNome());
        TextView qnt = (TextView) convertView.findViewById(R.id.txt_telefone);
        qnt.setText("Telefone: " + temp.getTelefone());

        return convertView;
    }
}
