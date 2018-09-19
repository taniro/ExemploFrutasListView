package br.ufrn.eaj.tads.exemplofrutaslistview.banco;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import br.ufrn.eaj.tads.exemplofrutaslistview.R;


@Database(entities = {Fruta.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract FrutaDao frutaDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "fruta_database.sqlite")
                            .allowMainThreadQueries()
                            .build();

                }
            }
        }

        //deleta todas
        INSTANCE.frutaDao().deleteAll();

        Fruta f1 = new Fruta("Laranja", R.drawable.fruit);
        Fruta f2 = new Fruta("Maca", R.drawable.fruit);
        Fruta f3 = new Fruta("Pera", R.drawable.fruit);
        Fruta f4 = new Fruta("Uva", R.drawable.fruit);
        Fruta f5 = new Fruta("Goiaba", R.drawable.fruit);
        Fruta f6 = new Fruta("Melao", R.drawable.fruit);
        Fruta f7 = new Fruta("Limao", R.drawable.fruit);
        Fruta f8 = new Fruta("Graviola", R.drawable.fruit);
        Fruta f9 = new Fruta("Açaí", R.drawable.fruit);
        Fruta f10 = new Fruta("Tomate", R.drawable.fruit);
        Fruta f11 = new Fruta("Jaboticaba", R.drawable.fruit);
        Fruta f12 = new Fruta("Acerola", R.drawable.fruit);
        Fruta f13 = new Fruta("Manga", R.drawable.fruit);
        Fruta f14 = new Fruta("Kiwi", R.drawable.fruit);
        Fruta f15 = new Fruta("Morango", R.drawable.fruit);

        //cadastra novamente
        INSTANCE.frutaDao().inserirAll(new Fruta[]{f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15});

        return INSTANCE;
    }
}
