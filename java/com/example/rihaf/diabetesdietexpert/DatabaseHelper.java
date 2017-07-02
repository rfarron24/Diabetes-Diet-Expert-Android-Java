package com.example.rihaf.diabetesdietexpert;

import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rihaf on 12/11/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="diabetesdietexpertbetasq2.db"; //CREATE NAME OF THE DATABASE//
                                                        //DATABASE CAN ONLY BE CREATED ONCE//

    //-------------------CREATE COLOUMNS ON TABLE: TABLE_DAILYKAL-------------------------------------------//
    public static final String TABLE_DAILYKAL ="dailycalorie_table";//CREATE NAME OF A TABLE INSIDE DB//
    //TABLE CAN BE CREATED MULTIPLE TIMES//
    public static final String COL_1P ="ID16"; //COLOUMN 1 ON TABLE//
    public static final String COL_2P ="DAILYCALORIE";//COLOUMN 2//

//-------------------CREATE COLOUMNS ON TABLE: antropometric_table-------------------------------------------//
    public static final String TABLE_NAME ="antopometric_table";//CREATE NAME OF A TABLE INSIDE DB//
    //TABLE CAN BE CREATED MULTIPLE TIMES//
    public static final String COL_1 ="ID"; //COLOUMN 1 ON TABLE//
    public static final String COL_2 ="TINGGI";//COLOUMN 2//
    public static final String COL_3 ="BERAT";//COLOUMN 3//
    public static final String COL_4 ="IMT";//COLOUMN 4//
    public static final String COL_5 ="KATEGORI";//COLOUMN 5//
    public static final String COL_6 ="USIA";//COLOUMN 6//
    public static final String COL_7 ="JENISKELAMIN";//COLOUMN 7//
    public static final String COL_8 ="AKTIVITAS";//COLOUMN 7//


    //-------------------CREATE COLOUMNS ON TABLE: golongan_diet-------------------------------------------//
    public static final String GOL_DIET ="golongan_diet";//CREATE NAME OF A TABLE INSIDE DB//

    public static final String COLOUMN_ID ="IDGOL"; //COLOUMN 1 ON TABLE//
    public static final String COLOUMN_GOL ="GOLDIET"; //COLOUMN 1 ON TABLE//
    public static final String COLOUMN_WAKTU ="WAKTU";//COLOUMN 2//
    public static final String COLOUMN_KALORI ="KALORI";//COLOUMN 3//
    public static final String COLOUMN_KARBO ="KARBOHIDRAT";//COLOUMN 4//
    public static final String COLOUMN_PROTEIN ="PROTEIN";//COLOUMN 5//
    public static final String COLOUMN_SAYUR ="SAYUR";//COLOUMN 6//
    public static final String COLOUMN_BUAH ="BUAH";//COLOUMN 7//
    public static final String COLOUMN_SUSU ="SUSU";//COLOUMN 7//


//-------------------CREATE COLOUMNS ON TABLE: table_foodlist-------------------------------------------//

    public static final String TABLE_FOODLIST ="table_foodlist";//CREATE NAME OF A TABLE INSIDE DB//

    public static final String COL_1I ="ID9"; //COLOUMN 1 ON TABLE//
    public static final String COL_2I ="NAMA";//COLOUMN 2//
    public static final String COL_3I ="PORSI";//COLOUMN 3//
    public static final String COL_4I ="KALPORSI";//COLOUMN 4//
    public static final String COL_5I ="KALGRAM";//COLOUMN 5//
    public static final String COL_6I ="PROTEIN";//COLOUMN 6//
    public static final String COL_7I ="LEMAK";//COLOUMN 7//
    public static final String COL_8I ="KARBOHIDRAT";//COLOUMN 7//

    //-------------------CREATE COLOUMNS ON TABLE: table_mealtime-------------------------------------------//
    public static final String TABLE_MEALTIME ="table_mealtime";//CREATE NAME OF A TABLE INSIDE DB//

    public static final String COL_1Z ="ID20"; //COLOUMN 1 ON TABLE//
    public static final String COL_2Z ="TANGGAL";//COLOUMN 2//
    public static final String COL_3Z ="WAKTUMAKAN";//COLOUMN 2//
    public static final String COL_4Z ="MAKANAN";//COLOUMN 3//
    public static final String COL_5Z ="PORSI";//COLOUMN 4//
    public static final String COL_6Z ="KALORI";//COLOUMN 5//
    public static final String COL_7Z ="QTY";//COLOUMN 5//
    public static final String COL_8Z ="TOTKAL";//COLOUMN 5//


    //------------------WHENEVER THIS CONSTURCTOR BELOW IS CALLED, THE DATABASE WILL BE CREATED------------------------//
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();

    }
//------------------BELOW IS THE METHOD TO CREATE THE NAME OF antropometric_table'S COLOUMNS------------------------//
    @Override
    public void onCreate(SQLiteDatabase db) {
//TABLE INSIDE THE DATABASE WILL BE CREATED WHENEVER THIS FUNCTION IS CALLED BY AN ACTIVITY CLASS//

        db.execSQL("create table " + TABLE_MEALTIME +" (ID20 INTEGER PRIMARY KEY AUTOINCREMENT, TANGGAL NUMERIC, WAKTUMAKAN TEXT, MAKANAN TEXT, PORSI REAL, KALORI REAL, QTY TEXT, TOTKAL REAL)");

        db.execSQL("create table " + TABLE_DAILYKAL +" (ID16 INTEGER PRIMARY KEY AUTOINCREMENT, DAILYCALORIE TEXT)");
        db.execSQL("create table " + GOL_DIET +" (IDGOL INTEGER PRIMARY KEY AUTOINCREMENT, GOLDIET NUMERIC, WAKTU TEXT, KALORI TEXT, KARBOHIDRAT TEXT, PROTEIN TEXT, SAYUR TEXT, BUAH TEXT, SUSU TEXT)");
        db.execSQL("INSERT INTO  " + GOL_DIET + " (IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (1, 1, 'Sarapan', 150, 'Nasi Putih 50 gr', 'Ikan 40 gr', 'Sayur 100 gr', ' ', ' ')");
        db.execSQL("INSERT INTO " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (2, 1, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (3, 1, 'Makan Siang', 500, 'Nasi Putih 100 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 50 gr', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (4, 1, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (5, 1, 'Makan Malam', 425, 'Nasi Putih 100 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");

        db.execSQL("INSERT INTO " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (6, 2, 'Sarapan', 300, 'Nasi Putih 100 gr', 'Ikan 40 gr', 'Sayur 100 gr', ' ', ' ')");
        db.execSQL("INSERT INTO " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (7, 2, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (8, 2, 'Makan Siang', 500, 'Nasi Putih 100 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (9, 2, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (10, 2, 'Makan Malam', 425, 'Nasi Putih 100 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");

        db.execSQL("INSERT INTO " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (11, 3, 'Sarapan', 337, 'Nasi Putih 100 gr', 'Ikan 40 gr & Tempeh 25 gr', 'Sayur 100 gr', ' ', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (12, 3, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (13, 3, 'Makan Siang', 675, 'Nasi Putih 100 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (14, 3, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (15, 3, 'Makan Malam', 425, 'Nasi Putih 100 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");

        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (16, 4, 'Sarapan', 337, 'Nasi Putih 100 gr', 'Ikan 40 gr & Tempeh 25 gr', 'Sayur 100 gr', ' ', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (17, 4, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (18, 4, 'Makan Siang', 675, 'Nasi Putih 200 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (19, 4, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (20, 4, 'Makan Malam', 600, 'Nasi Putih 200 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");

        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (21, 5, 'Sarapan', 475, 'Nasi Putih 150 gr', 'Ikan 40 gr & Tempeh 25 gr', 'Sayur 100 gr', ' ', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (22, 5, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (23, 5, 'Makan Siang', 675, 'Nasi Putih 200 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (24, 5, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (25, 5, 'Makan Malam', 650, 'Nasi Putih 200 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");

        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (26, 6, 'Sarapan', 512, 'Nasi Putih 150 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', ' ', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (27, 6, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (28, 6, 'Makan Siang', 812, 'Nasi Putih 250 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (29, 6, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (30, 6, 'Makan Malam', 737, 'Nasi Putih 250 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");


        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (31, 7, 'Sarapan', 587, 'Nasi Putih 150 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', 'Susu 1 gls')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (32, 7, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (33, 7, 'Makan Siang', 900, 'Nasi Putih 300 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (34, 7, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (35, 7, 'Makan Malam', 737, 'Nasi Putih 250 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");

        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (36, 8, 'Sarapan', 612, 'Nasi Putih 200 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', 'Susu 1 gls')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (37, 8, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (38, 8, 'Makan Siang', 900, 'Nasi Putih 300 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (39, 8, 'Selingan', 50, ' ', ' ', ' ', 'Buah 50 gr', ' ')");
        db.execSQL("INSERT INTO  " + GOL_DIET + "(IDGOL, GOLDIET, WAKTU , KALORI , KARBOHIDRAT , PROTEIN , SAYUR , BUAH, SUSU) VALUES (40, 8, 'Makan Malam', 737, 'Nasi Putih 250 gr', 'Ikan 40 gr & Tempeh 50 gr', 'Sayur 100 gr', 'Buah 50 gr', ' ')");

        db.execSQL("create table " + TABLE_NAME +" (ID INTEGER PRIMARY KEY AUTOINCREMENT,TINGGI REAL, BERAT REAL, IMT DOUBLE, KATEGORI TEXT, USIA INTEGER, JENISKELAMIN TEXT, AKTIVITAS TEXT)");

        db.execSQL("create table " + TABLE_FOODLIST +" (ID9 INTEGER PRIMARY KEY AUTOINCREMENT,NAMA TEXT, PORSI TEXT, KALPORSI REAL, KALGRAM REAL, PROTEIN TEXT, LEMAK TEXT, KARBOHIDRAT TEXT)");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (1, 'Nasi Putih', '1 Piring 100 gram', 178.0, 1.78,'2.1', '0.1', '40.6')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (2, 'Bubur Nasi', '1 Piring 100 gram', 140.0, 1.40,'2.2', '2.8', '31.6')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (3, 'Nasi Beras Merah', '1 Piring 100 gram', 149.0, 1.49,'2.8', '0.4', '32.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (4, 'Bubur Tinutuan', '1 Piring 100 gram', 156.0, 1.56,'2.3', '0.2', '15.6')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (5, 'Nasi Goreng', '1 Piring 100 gram', 276.0, 2.76,'3.2', '30.2', '4.8')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (6, 'Roti Tawar Putih', '1 Iris 20 gram', 49.6, 2.48,'1.6', '0.24', '10')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (7, 'Jagung Manis Rebus', '1 Tongkol 131 gram', 168.9, 1.29,'5.3', '1.7', '39.6')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (8, 'Jagung Putih Rebus', '1 Tongkol 17 gram', 21.93, 1.29,'0.69', '0.2', '5.1')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (9, 'Sayur Bayam Rebus', '1 Mangkuk 145 gram', 276.0, 2.76,'3.2', '30.2', '4.8')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (10, 'Roti Tawar Putih', '1 Iris 20 gram', 33.5, 0.23,'33.35', '0.87', '5.36')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (11, 'Sayur Kacang Panjang Tumis', '1 sdm 15 gram', 22.5, 1.5,'0.375', '1.875', '1.05')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (12, 'Sayur Kangkung Tumis', '1 sdm 11.4 gram', 5.92, 0.52,'0.20', '0.41', '0.34')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (13, 'Sayur Asam', '1 Mangkuk 150 gram', 43.0, 0.29,'1.5', '9.0', '7.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (14, 'Telur Mata Sapi', '1 58 gram', 233.5, 3.83,'8.81', '19.21', '4.84')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (15, 'Telur Rebus', '1 60 gram', 92.4, 1.54,'7.32', '0.0', '0.0')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (16, 'Telur Dadar', '1  56.8 gram', 142.56, 2.51,'9.25', '11.01', '0.79')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (17, 'Sayur Sop', '1 Mangkuk 195 gram', 52.65, 0.27,'2.53', '3.9', '1.9')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (18, 'Daging Sapi', '1 Ptg 15.6 gram', 67.5, 4.33,'8.58', '1.404', '0.0')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (19, 'Daging Kambing', '1 ptg 15 gram', 126.5, 1.26,'4.2', '9.4', '6.2')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (20, 'Ayam Goreng Paha', '1 ptg 100 gram', 275.0, 2.75,'37.4', '12.2', '1.34')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (21, 'Ayam Goreng Dada', '1 ptg 100 gram', 297.0, 2.97,'35.9', '15.2', '1.6')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (22, 'Ayam Goreng Sayap', '1 ptg 100 gram', 297.0, 2.97,'35.9', '15.2', '1.6')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (23, 'Ikan Cakalang', '1 porsi 100 gram', 148.65, 1.48,'10.0', '9.8', '6.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (24, 'Ikan Mujair', '1 porsi 100 gram', 274.0, 4.16,'30.9', '15.7', '0.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (25, 'Ikan Tongkol', '1 porsi 100 gram', 117.0, 1.17,'23.2', '2.7', '0.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (26, 'Ikan Tuna', '1 porsi 100 gram', 128.0, 1.28,'25.6', '9.5', '0.5')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (27, 'Cumi-cumi', '1 ekor 64 gram', 169.6, 5.65,'23.0', '6.0', '5.7')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (28, 'Sate Ayam', '1 tusuk 15 gram', 34.05, 2.27,'10.0', '9.8', '5.0')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (29, 'Sate Sapi', '1 tusuk 15 gram', 32.05, 2.19,'10.7', '7.8', '7.7')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (30, 'Sate Kambing', '1 tusuk 15 gram', 31.05, 2.11,'10.8', '9.9', '7.5')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (31, 'Apel', '1 buah 100 gram', 85.0, 0.5,'0.9', '6.5', '6.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (32, 'Anggur', '1 buah 100 gram', 530.0, 0.3,'0.3', '0.5', '0.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (33, 'Alpukat', '1 buah 100 gram', 87.0, 0.8,'0.45', '0.6', '0.6')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (34, 'Durian', '1 buah 17.5 gram', 23.45, 134.0,'0.43', '0.52', '4.9')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (35, 'Mangga', '1  buah 100 gram', 44.0, 0.44,'0.5', '0.7', '3.2')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (36, 'Jeruk', '1 buah 50 gram', 22.0, 0.22,'0.2', '0.5', '0.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (37, 'Manggis', '1 buah 50 gram', 50.4, 0.63,'0.2', '0.5', '0.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (38, 'Nanas',  '1 buah 450 gram', 234.0, 0.52,'0.2', '0.5', '0.5')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (39, 'Pisang', '1  buah 75 gram', 74.0, 0.99,'0.5', '0.7', '3.2')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (40, 'Pepaya', '1 potong 100 gram', 46.0, 0.46,'0.2', '0.5', '0.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (41, 'Salak', '1 buah 75 gram', 57.4, 0.77,'0.3', '0.5', '0.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (42, 'Semangka',  '1 buah 175 gram', 42.0, 0.28,'0.2', '0.5', '0.5')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (43, 'Sirsak', '1  buah 100 gram', 65.0, 0.65,'1.1', '0.3', '16.2')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (44, 'Susu Sapi', '1 gelas 300 ml', 122.0, 0.61,'6.4', '7.5', '8.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (45, 'Susu Kedelai', '1 gelas 300 ml', 82.4, 0.41,'7.2', '5.5', '10.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (46, 'Gado Gado',  '1 porsi 150 gram', 205.0, 1.52,'9.15', '4.8', '31.5')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (47, 'Tahu', '1  ptg 50 gram', 65.0, 0.65,'6.5', '5.7', '7.2')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (48, 'Tempeh', '1 potong 50 gram', 46.0, 0.46,'8.2', '8.5', '6.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (49, 'Pisang Goreng', '1 buah 45 gram', 127.4, 0.52,'5.3', '2.5', '9.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (50, 'Bakwan',  '1 25 gram', 42.0, 5.28,'6.2', '8.5', '9.2')");

        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (51, 'Mie Goreng', '1  porsi 120 gram', 365.0, 3.65,'5.1', '0.3', '316.2')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (52, 'Mie Rebus', '1 poris 120 gram', 420.0, 4.61,'4.4', '7.5', '348.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (53, 'Martabak', '1 potong 100 gram', 182.4, 1.82,'5.2', '5.5', '110.5')");
        db.execSQL("INSERT INTO table_foodlist(ID9, NAMA , PORSI , KALPORSI , KALGRAM , PROTEIN , LEMAK, KARBOHIDRAT) VALUES (54, 'Siomay',  '1 porsi 230 gram', 205.0, 2.52,'9.15', '4.8', '91.4')");



    }

//-----BELOW IS THE METHOD TO REMOVE A TABLE WITH THE SAME NAME AS antropometric_table IF IT WAS PREVIOUSLY EXISTED------//
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+GOL_DIET);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_MEALTIME);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DAILYKAL);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_FOODLIST);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
//****
//****
//****
//****
//****
//------------------------START : METHOD TO INSERT DATA VALUES FROM INPUT TEXT TO TABLE antropometric_table------------------------------//



    public boolean insertData(String tb, String bb, String imt, String kategori, String usia, String jeniskelamin, String aktivitas){
        SQLiteDatabase db = this.getWritableDatabase(); //WHENEVER THIS CONSTURCTOR BELOW IS CALLED, THE DATABASE WILL BE CREATED//
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, tb); //PLACE THE INPUT DATA TO THE COLOUMN//
        contentValues.put(COL_3, bb);
        contentValues.put(COL_4, imt);
        contentValues.put(COL_5, kategori); //PLACE THE INPUT DATA TO THE COLOUMN//
        contentValues.put(COL_6, usia);
        contentValues.put(COL_7,jeniskelamin);
        contentValues.put(COL_8,aktivitas);
        long result =  db.insert(TABLE_NAME,null ,contentValues); //IF DATA IS NOT INPUT THIS METHOD WILL RETURN VALUE OF -1//
        if (result == -1)
            return false;
        else
            return true;
    }


    public boolean insertDataDailyCalorie(String kalorie){
        SQLiteDatabase db = this.getWritableDatabase(); //WHENEVER THIS CONSTURCTOR BELOW IS CALLED, THE DATABASE WILL BE CREATED//
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2P, kalorie); //PLACE THE INPUT DATA TO THE COLOUMN//
        long result =  db.insert(TABLE_DAILYKAL,null ,contentValues); //IF DATA IS NOT INPUT THIS METHOD WILL RETURN VALUE OF -1//
        if (result == -1)
            return false;
        else
            return true;
    }


    public boolean insertDataFoodlist(String nama, String porsi, String kaloriporsi, String kalorigram, String proteinfood, String lemakfood, String karbofood){
        SQLiteDatabase db = this.getWritableDatabase(); //WHENEVER THIS CONSTURCTOR BELOW IS CALLED, THE DATABASE WILL BE CREATED//
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2I, nama); //PLACE THE INPUT DATA TO THE COLOUMN//
        contentValues.put(COL_3I, porsi);
        contentValues.put(COL_4I, kaloriporsi);
        contentValues.put(COL_5I, kalorigram); //PLACE THE INPUT DATA TO THE COLOUMN//
        contentValues.put(COL_6I, proteinfood);
        contentValues.put(COL_7I,lemakfood);
        contentValues.put(COL_8I,karbofood);
        long result =  db.insert(TABLE_FOODLIST,null ,contentValues); //IF DATA IS NOT INPUT THIS METHOD WILL RETURN VALUE OF -1//
        if (result == -1)
            return false;
        else
            return true;
    }


    public boolean insertDataMealTime(String tanggalbreakfast, String waktumakan, String makananbreakfast, String porsibreakfast, String kaloribreakfast, String qty, String kaltotal){
        SQLiteDatabase db = this.getWritableDatabase(); //WHENEVER THIS CONSTURCTOR BELOW IS CALLED, THE DATABASE WILL BE CREATED//
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2Z, tanggalbreakfast); //PLACE THE INPUT DATA TO THE COLOUMN//
        contentValues.put(COL_3Z, waktumakan);
        contentValues.put(COL_4Z, makananbreakfast);
        contentValues.put(COL_5Z, porsibreakfast);
        contentValues.put(COL_6Z, kaloribreakfast); //PLACE THE INPUT DATA TO THE COLOUMN//
        contentValues.put(COL_7Z, qty);
        contentValues.put(COL_8Z, kaltotal);

        long result =  db.insert(TABLE_MEALTIME,null ,contentValues); //IF DATA IS NOT INPUT THIS METHOD WILL RETURN VALUE OF -1//
        if (result == -1)
            return false;
        else
            return true;
    }
//------------------------END : METHOD TO INSERT DATA VALUES FROM INPUT TEXT TO TABLE antropometric_table------------------------------//
//****
//****
//****
//****
//****
//----------------------START OF : NEW CURSOR METHOD TO VIEW TABLE VALUES AS POP-UP VIEW FROM BUTTON "VIEW"-------------------------//

    public Cursor getJournalHistory(String historydate) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_MEALTIME + "WHERE TANGGAL = "+ historydate, null);
        return res;
    }


//----------------DO NOT FUCKING MESS WITH THIS DB METHOD BELOW ------//
// THIS METHOD IS TO CHECK WHICH ACTIVITY TO OPEN IF USER HAS ALREADY INPUT DATA OR NOT!!!!-----------//
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
//----------------ONCE AGAIN I REPEAT, DO NOT FUCKING MESS WITH THE SCRIPT ABOVE. ENOUGH!!!! ------//

    public Cursor getDailyCalorieData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_DAILYKAL, null);
        return res;
    }


    public String getDailyCalorie() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("SELECT "+COL_2P+" FROM "+TABLE_DAILYKAL,null);
        String sum="";
        for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext()){
            sum=cr.getString(cr.getColumnIndex(COL_2P));
        }
        cr.close();
        return sum;
    }


    public String getIdUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("SELECT "+COL_1+" FROM "+TABLE_NAME,null);
        String sum="";
        for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext()){
            sum=cr.getString(cr.getColumnIndex(COL_1));
        }
        cr.close();
        return sum;
    }
    public String getNameJournalDiet(String CidJournal) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select MAKANAN from table_mealtime where ID20 = "+ CidJournal, null );
        String sum="";
        for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext()){
            sum=cr.getString(cr.getColumnIndex("MAKANAN"));
        }
        cr.close();
        return sum;
    }

    public String getPortionJournalDiet(String CidPortion) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select PORSI from table_mealtime where ID20 = "+ CidPortion, null );
        String sum="";
        for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext()){
            sum=cr.getString(cr.getColumnIndex("PORSI"));
        }
        cr.close();
        return sum;
    }

    public String getCalJournalDiet(String CidCal) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select KALORI from table_mealtime where ID20 = "+ CidCal, null );
        String sum="";
        for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext()){
            sum=cr.getString(cr.getColumnIndex("KALORI"));
        }
        cr.close();
        return sum;
    }
//-----------------------------------GET GOLDIET NUMBER FROM GOLDIET COLOUMN ACCORDING TO GOLDIET TEXTVIEW---------------//
public Cursor getGolonganDiet (String goldiet) {
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor res = db.rawQuery("select WAKTU, KALORI, KARBOHIDRAT, PROTEIN, SAYUR, BUAH, SUSU from golongan_diet where GOLDIET = "+ goldiet, null );
    return res;

}
//-----------------------------------GET GOLDIET NUMBER FROM GOLDIET COLOUMN ACCORDING TO GOLDIET TEXTVIEW---------------//


    public String getNameFoodlist(String Cid) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select NAMA from table_foodlist where ID9 = "+ Cid, null );
        String sum="";
        for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext()){
            sum=cr.getString(cr.getColumnIndex("NAMA"));
        }
        cr.close();
        return sum;
    }


    public String getPortionFoodlist(String Cid) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select PORSI from table_foodlist where ID9 = "+ Cid, null );
        String sum="";
        for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext()){
            sum=cr.getString(cr.getColumnIndex("PORSI"));
        }
        cr.close();
        return sum;
    }


    public String getCalFoodlist(String Cid) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cr = db.rawQuery("select KALPORSI from table_foodlist where ID9 = "+ Cid, null );
        String sum="";
        for(cr.moveToFirst();!cr.isAfterLast();cr.moveToNext()){
            sum=cr.getString(cr.getColumnIndex("KALPORSI"));
        }
        cr.close();
        return sum;
    }


    public int getRemainingCalorie(String tanggal) {

    SQLiteDatabase db = this.getWritableDatabase();

     Cursor cr =  db.rawQuery("SELECT SUM(TOTKAL) AS myTotal FROM table_mealtime WHERE TANGGAL = " + tanggal, null);

   cr.moveToFirst();
     int i = cr.getInt(cr.getColumnIndex("myTotal"));
      cr.close();
       return i;

  }



    //----------------------END OF : NEW CURSOR METHOD TO VIEW TABLE VALUES AS POP-UP VIEW FROM BUTTON "VIEW"-------------------------//
//****
//****
//****
//****
//****
//-----------------------------------------START OF : UPDATE DATA IN antropometric_table METHOD--------------------------------------------------------//
public boolean updateData(String id,String tb, String bb, String imt, String kategori, String usia, String jeniskelamin, String aktivitas) {
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues contentValues = new ContentValues();
    contentValues.put(COL_1, id);
    contentValues.put(COL_2, tb); //PLACE THE INPUT DATA TO THE COLOUMN//
    contentValues.put(COL_3, bb);
    contentValues.put(COL_4, imt);
    contentValues.put(COL_5, kategori); //PLACE THE INPUT DATA TO THE COLOUMN//
    contentValues.put(COL_6, usia);
    contentValues.put(COL_7, jeniskelamin);
    contentValues.put(COL_8, aktivitas);
    db.update(TABLE_NAME, contentValues, "id = ?", new String[]{id});
    return true;
}


   // public boolean updateData1300(String id2,String waktu, String kalori, String karbohidrat, String protein, String sayur, String buah, String susu) {
   //     SQLiteDatabase db = this.getWritableDatabase();
    //    ContentValues contentValues = new ContentValues();
    //    contentValues.put(COL_1B, id2);
  //      contentValues.put(COL_2B, waktu); //PLACE THE INPUT DATA TO THE COLOUMN//
  //      contentValues.put(COL_3B, kalori);
  //      contentValues.put(COL_4B, karbohidrat);
   ///     contentValues.put(COL_5B, protein); //PLACE THE INPUT DATA TO THE COLOUMN//
  //      contentValues.put(COL_6B, sayur);
  //      contentValues.put(COL_7B, buah);
  //      contentValues.put(COL_8B, susu);
  //      db.update(TABLE_1300, contentValues, "id2 = ?", new String[]{id2});
  //      return true;
 //   }

    public boolean updateDataDailyCalorie(String id16, String finalkalori) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1P, id16);
        contentValues.put(COL_2P, finalkalori); //PLACE THE INPUT DATA TO THE COLOUMN//
        db.update(TABLE_DAILYKAL, contentValues, "ID16 = ?", new String[]{id16});
        return true;
    }


    public boolean updateDataFoodlist(String id9, String nama, String porsi, String kaloriporsi, String kalorigram, String proteinfood, String lemakfood, String karbofood){
        SQLiteDatabase db = this.getWritableDatabase(); //WHENEVER THIS CONSTURCTOR BELOW IS CALLED, THE DATABASE WILL BE CREATED//
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1I, id9);
        contentValues.put(COL_2I, nama); //PLACE THE INPUT DATA TO THE COLOUMN//
        contentValues.put(COL_3I, porsi);
        contentValues.put(COL_4I, kaloriporsi);
        contentValues.put(COL_5I, kalorigram); //PLACE THE INPUT DATA TO THE COLOUMN//
        contentValues.put(COL_6I, proteinfood);
        contentValues.put(COL_7I,lemakfood);
        contentValues.put(COL_8I,karbofood);
        db.update(TABLE_FOODLIST, contentValues, "ID9 = ?", new String[]{id9});
        return true;
    }

//----------------------------END OF : UPDATE DATA IN antropometric_table METHOD----------------------------------------------------------------//
//****
//****
//****
    public Integer deleteData(String id){
        SQLiteDatabase db = this.getWritableDatabase();
       return db.delete(TABLE_NAME, "ID = ?", new String [] {id}); //String [] is the symbol of Array that is String in data type//


    }
//****
//****
//----------------------OLD CURSOR METHOD TO VIEW TABLE VALUES AS LISTVIEW FROM BUTTON LIHAT DATA SAYA-------------------------//
    public Cursor getInformation(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections = {COL_2, COL_3, COL_4, COL_5, COL_6, COL_7, COL_8};
      cursor =  db.query(TABLE_NAME, projections, null, null, null, null, null);
        return cursor;
    }



    public Cursor getFoodList(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections = {COL_2I, COL_3I, COL_4I, COL_5I, COL_6I, COL_7I, COL_8I};
        cursor = db.query(TABLE_FOODLIST, projections, null, null, null, null, null);
        return cursor;
    }

    public Cursor getJournalDiet2(SQLiteDatabase db)
    {
        Cursor cursor;
        String[] projections = {COL_3Z, COL_4Z, COL_5Z, COL_6Z, COL_7Z, COL_8Z};
        cursor = db.query(TABLE_MEALTIME, projections, null, null, null, null, null);
        return cursor;
    }


    public Cursor getJournalDiet3(String datelog)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        String TABLE = TABLE_MEALTIME;
        String[] projections = {COL_3Z, COL_4Z, COL_5Z, COL_6Z, COL_7Z, COL_8Z};
        String WHERE =  COL_2Z + "=" + datelog;
        cursor = db.query(TABLE, projections, WHERE, null, null, null, null);
        return cursor;
    }


    public Cursor getJournalDietHistory(String datehistory)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor;
        String TABLE = TABLE_MEALTIME;
        String[] projections = {COL_3Z, COL_4Z, COL_5Z, COL_6Z, COL_7Z, COL_8Z};
        String WHERE =  COL_2Z + "=" + datehistory;
        cursor = db.query(TABLE, projections, WHERE, null, null, null, null);
        return cursor;
    }


//000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000//


//------------------------START : METHOD TO INSERT DATA VALUES FROM INPUT TEXT TO TABLE antropometric_table------------------------------//



//------------------------END : METHOD TO INSERT DATA VALUES FROM INPUT TEXT TO TABLE antropometric_table------------------------------//

}

