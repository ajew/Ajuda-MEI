package ajudamei.allan_arthur.com.ajuda_mei.caixa.registro.venda_produto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Allan on 22/06/2017.
 */

public class DatabaseRegistroVenda extends SQLiteOpenHelper {

    final static String TABLE_NAME = "vendas_registradas";
    final static String _ID = "_id";

    final static String ITEM_DESCRICAO = "descricao";
    final static String ITEM_DATA = "data";
    final static String ITEM_PRECO = "preco";

    final private static String CREATE_CMD =

            "CREATE TABLE "+TABLE_NAME+" (" + _ID
                    + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ITEM_DESCRICAO + " TEXT NOT NULL, "
                    + ITEM_PRECO + " TEXT NOT NULL, "
                    + ITEM_DATA + " TEXT NOT NULL "
                    + ")";

    final private static String NAME = "vendas_db";
    final private static Integer VERSION = 1;
    final private Context mContext;

    public DatabaseRegistroVenda(Context context) {
        super(context, NAME, null, VERSION);
        this.mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Venda item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DatabaseRegistroVenda.ITEM_DESCRICAO, item.getDescricao());
        values.put(DatabaseRegistroVenda.ITEM_PRECO, item.getPreco());
        values.put(DatabaseRegistroVenda.ITEM_DATA, item.getData());

        db.insertWithOnConflict(TABLE_NAME, null, values, SQLiteDatabase.CONFLICT_IGNORE);
        db.close();
    }

    public List<Venda> getAllItens(){
        List<Venda> aux = new ArrayList<Venda>();

        String selectQuery = "SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                Venda temp = new Venda(cursor.getString(1),Double.parseDouble(cursor.getString(2)), cursor.getString(3), 999, "tipo");
                aux.add(temp);

            } while (cursor.moveToNext());
        }
        cursor.close();

        return aux;
    }
}