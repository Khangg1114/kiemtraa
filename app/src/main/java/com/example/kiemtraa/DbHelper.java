package com.example.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QLSanPham", null, 7);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(MaSP INTEGER PRIMARY KEY AUTOINCREMENT, " + "TenSP TEXT, GiaTien REAL, Image TEXT)";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES(1, 'Bun Bo', '35000', 'https://amthuc10phut.vn/wp-content/uploads/2023/07/bun-ca-moi-3.jpg')," +
                "(2, 'Com Tam', '30000', 'https://i.ytimg.com/vi/cJu6tFJe_Gc/maxresdefault.jpg')," +
                "(3, 'Hu Tieu ', '25000', 'https://i1-giadinh.vnecdn.net/2023/05/15/Buoc-8-Thanh-pham-1-8-8366-1684125654.jpg?w=1020&h=0&q=100&dpr=1&fit=crop&s=qDCDua07MoEIbJ4Mdk0isw')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
}