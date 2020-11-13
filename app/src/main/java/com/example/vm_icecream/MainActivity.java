package com.example.vm_icecream;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionEntry;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    RadioButton radCoklat,radVanilla,radStroberi,radMilo,radMatcha,radCoco,radKacang,radOreo;
    RadioGroup radGrup_rasa;

    Button btnProses, btnLimaribu , btnSepuluhribu;
    TextView txtHasil, txtKembalian, txtTotal, txtTampilkanUang;

    int total = 0;
    int eskrimA = 5000; // harga original (semua rasa) tanpa topping
    int eskrimB = 10000; // harga original dengan topping (semua rasa dan topping )


    String rasaCoklat ="Coklat";
    String rasaVanilla = "Vanilla";
    String rasaStroberi = "Stroberi";
    String topCoco = "Coco Crunch";
    String topMilo = "Milo";
    String topMatcha = "Matcha";
    String topKacang = "Kacang";
    String topOreo = "Oreo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        radCoklat = findViewById(R.id.radCoklat);
        radStroberi = findViewById(R.id.radStroberi);
        radVanilla = findViewById(R.id.radVanilla);
        radMilo = findViewById(R.id.radMilo);
        radMatcha = findViewById(R.id.radMatcha);
        radCoco = findViewById(R.id.radCoco);
        radKacang = findViewById(R.id.radKacang);
        radOreo = findViewById(R.id.radOreo);

        btnProses = findViewById(R.id.btnProses);
        btnLimaribu = findViewById(R.id.btnLimaribu);
        btnSepuluhribu= findViewById(R.id.btnSepuluhribu);

        txtHasil = findViewById(R.id.txtHasil);
        txtTotal = findViewById(R.id.txtTotal);
        txtTampilkanUang = findViewById(R.id.txtTampilkanUang);

        txtKembalian = findViewById(R.id.txtKembalian);
    }

    public void coklatOnClick(View view) {
        Toast.makeText(this, "Anda memilih rasa Cokelat", Toast.LENGTH_SHORT).show();


        //Jika terjadi perpindahan ke rasa cokelat maka untuk semua pilihan topping akan direset
        if (radCoklat.isChecked()){
            radMilo.setChecked(false);
            radMatcha.setChecked(false);
            radKacang.setChecked(false);
            radCoco.setChecked(false);
            radOreo.setChecked(false);
        }

        total = eskrimA;

        radCoklat.setClickable(true); //Agar tidak terjadi penambahan harga ketika di klik terus menerus
        txtTotal.setText("Rp." + Integer.toString(total));
    }

    public void vanOnClick(View view) {
        Toast.makeText(this, "Anda memilih rasa Vanilla", Toast.LENGTH_SHORT).show();

        //Jika terjadi perpindahan ke rasa vanilla maka untuk semua pilihan topping akan direset
        if (radVanilla.isSelected()){
            radMilo.setChecked(false);
            radMatcha.setChecked(false);
            radKacang.setChecked(false);
            radCoco.setChecked(false);
            radOreo.setChecked(false);
        }
        total = eskrimA;
        radVanilla.setClickable(true); //Agar tidak terjadi penambahan harga ketika di klik terus menerus
        txtTotal.setText("Rp. " + Integer.toString(total));
    }

    public void stroOnClick(View view) {
        Toast.makeText(this, "Anda memilih rasa Stroberi", Toast.LENGTH_SHORT).show();

        //Jika terjadi perpindahan ke rasa stroberi maka untuk semua pilihan topping akan direset
        if (radStroberi.isChecked()){
            radMilo.setChecked(false);
            radMatcha.setChecked(false);
            radKacang.setChecked(false);
            radCoco.setChecked(false);
            radOreo.setChecked(false);
        }
        total = eskrimB;
        radStroberi.setClickable(true); //Agar tidak terjadi penambahan harga ketika di klik terus menerus
        txtTotal.setText("Rp." + Integer.toString(total));
    }

    public void miloOnClick(View view) {
        Toast.makeText(this, "Topping Milo Dipilih", Toast.LENGTH_SHORT).show();

        //Agar yang tercek hanya milo saja
        if (radMilo.isChecked()){
            radMatcha.setChecked(false);
            radCoco.setChecked(false);
            radKacang.setChecked(false);
            radOreo.setChecked(false);
        }

        total = eskrimB;

        //Proses seleksi pengkategorian es krim tipe B (yaitu dengan topping)

        if (radMilo.isChecked() && radCoklat.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        } else if (radMilo.isChecked() && radVanilla.isChecked() ){
            txtTotal.setText("Rp. " + Integer.toString(total));
        } else if (radMilo.isChecked() && radStroberi.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        }
    }

    public void matOnClick(View view) {
        Toast.makeText(this, "Topping Matcha Dipilih", Toast.LENGTH_SHORT).show();

        if (radMatcha.isChecked()){
            radMilo.setChecked(false);
            radCoco.setChecked(false);
            radKacang.setChecked(false);
            radOreo.setChecked(false);
        }

        total = eskrimB;

        //Proses seleksi pengkategorian es krim tipe B (yaitu dengan topping)
        if (radMatcha.isChecked()&& radCoklat.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        } else if (radMatcha.isChecked() && radVanilla.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        } else if (radMatcha.isChecked() && radStroberi.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        }

    }

    public void cocoOnClick(View view) {
        Toast.makeText(this, "Topping Coco Crunch Dipilih", Toast.LENGTH_SHORT).show();

        if (radCoco.isChecked()){
            radMilo.setChecked(false);
            radMatcha.setChecked(false);
            radKacang.setChecked(false);
            radOreo.setChecked(false);
        }

        total = eskrimB;

        //Proses seleksi pengkategorian es krim tipe B (yaitu dengan topping)
        if (radCoco.isChecked() && radCoklat.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        } else if (radCoco.isChecked() && radVanilla.isChecked() ){
            txtTotal.setText("Rp. " + Integer.toString(total));
        } else if (radCoco.isChecked() && radStroberi.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        }

    }

    public void kacangOnClick(View view) {
        Toast.makeText(this, "Topping Kacang Dipilih", Toast.LENGTH_SHORT).show();

        if (radKacang.isChecked()){
            radMilo.setChecked(false);
            radMatcha.setChecked(false);
            radCoco.setChecked(false);
            radOreo.setChecked(false);
        }

        total = eskrimB;

        //Proses seleksi pengkategorian es krim tipe B (yaitu dengan topping)
        if (radKacang.isChecked() && radCoklat.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        } else if (radKacang.isChecked() && radVanilla.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        } else if (radKacang.isChecked() && radStroberi.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        }

    }

    public void oreoOnClick(View view) {
        Toast.makeText(this, "Topping Oreo Dipilih ", Toast.LENGTH_SHORT).show();

        if (radOreo.isChecked()){
            radMilo.setChecked(false);
            radMatcha.setChecked(false);
            radKacang.setChecked(false);
            radCoco.setChecked(false);
        }

        total = eskrimB;

        //Proses seleksi pengkategorian es krim tipe B (yaitu dengan topping)

        if (radOreo.isChecked() && radCoklat.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        } else if (radOreo.isChecked() && radVanilla.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        } else if (radOreo.isChecked() && radStroberi.isChecked()){
            txtTotal.setText("Rp. " + Integer.toString(total));
        }

    }

    public void buat (View view) {
        if (txtTampilkanUang.getText().toString().isEmpty()){
            Toast.makeText(this, "Uang Masih Kosong", Toast.LENGTH_SHORT).show();
        } else {
            if (radCoklat.isChecked()) {
                if (radCoklat.isChecked() && radMilo.isChecked()){
                    message("Es krim rasa coklat topping milo diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaCoklat + " topping " + topMilo + " sudah siap ");
                } else if (radCoklat.isChecked() && radMatcha.isChecked()){
                    message("Es krim rasa coklat topping matcha diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaCoklat + " topping " + topMatcha + " sudah siap ");
                } else if (radCoklat.isChecked() && radCoco.isChecked()) {
                    message("Es krim rasa coklat topping coco crunch diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaCoklat + " topping " + topCoco + " sudah siap ");
                } else if (radCoklat.isChecked() && radKacang.isChecked()){
                    message("Es krim rasa coklat topping kacang diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaCoklat + " topping " + topKacang + " sudah siap ");
                } else if (radCoklat.isChecked()&&radOreo.isChecked()){
                    message("Es krim rasa coklat topping oreo diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaCoklat + " topping " + topOreo + " sudah siap ");
                } else {
                    message("Es krim rasa coklat diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaCoklat + " sudah siap ");
                }
            } else if (radVanilla.isChecked()){
                if (radVanilla.isChecked() && radMilo.isChecked()){
                    message ("Es krim rasa vanilla topping milo diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaVanilla + " topping " + topMilo + " sudah siap ");
                } else if (radVanilla.isChecked() && radMatcha.isChecked()){
                    message("Es krim rasa vanilla topping matcha diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaVanilla + " topping " + topMatcha + " sudah siap ");
                } else if (radVanilla.isChecked() && radCoco.isChecked()) {
                    message("Es krim rasa vanilla topping coco crunch diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaVanilla + " topping " + topCoco + " sudah siap ");
                } else if (radVanilla.isChecked() && radKacang.isChecked()){
                    message("Es krim vanilla topping kacang diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaVanilla + " topping " + topKacang + " sudah siap ");
                } else if (radVanilla.isChecked()&& radOreo.isChecked()){
                    message("Es krim rasa vanilla topping oreo diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaCoklat + " topping " + topOreo + " sudah siap ");
                } else {
                    Toast.makeText(this, "Es krim vanilla diproses", Toast.LENGTH_SHORT).show();
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaVanilla + " sudah siap ");
                }
            } else if (radStroberi.isChecked()){
                if (radStroberi.isChecked() && radMilo.isChecked()){
                    message ("Es krim rasa stroberi topping milo diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaStroberi + " topping " + topMilo + " sudah siap ");
                } else if (radStroberi.isChecked() && radMatcha.isChecked()){
                    message("Es krim rasa stroberi topping matcha diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaStroberi + " topping " + topMatcha + " sudah siap ");
                } else if (radStroberi.isChecked() && radCoco.isChecked()) {
                    message("Es krim rasa stroberi topping coco crunch diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaStroberi + " topping " + topCoco + " sudah siap ");
                } else if (radStroberi.isChecked() && radKacang.isChecked()){
                    message("Es krim rasa stroberi topping kacang diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaStroberi + " topping " + topKacang + " sudah siap ");
                } else if (radStroberi.isChecked()&&radOreo.isChecked()){
                    message("Es krim rasa stroberi topping oreo diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaStroberi + " topping " + topOreo + " sudah siap ");
                } else {
                    message("Es krim rasa stroberi diproses");
                    txtTampilkanUang.setText("");
                    txtHasil.setText("Es krim rasa " + rasaStroberi + " sudah siap ");
                }
            }
        }
    }

    private void message( String message_proses) {
        Toast.makeText(this, message_proses, Toast.LENGTH_LONG).show();
    }

    private void alert(String message_error) {
        Toast.makeText(this, message_error, Toast.LENGTH_SHORT).show();
    }


    public void btnSepuluhribuOnClick(View view) {
        txtTampilkanUang.setText("Uang Anda Rp. 10000");
        if (total == 10000) {
                btnProses.setClickable(true);
                txtKembalian.setText("Uang anda sudah pas");


        } else {
            // Jika ada yang memesan es krim dengan harga 5000
                btnProses.setClickable(true);
                int kembalian = 0;
                kembalian = 10000 - total;
                txtKembalian.setText("Kembalian Anda" + " Rp " + kembalian);
        }
    }

    public void btnLimaribuOnClick(View view) {
        txtTampilkanUang.setText("Uang Anda Rp. 5000 ");
        if (total > 5000){
            Toast.makeText(this, "Uang anda kurang. Silahkan ambil uang anda di tempat kembalian dan masukkan kembali seusai dengan harga",
                        Toast.LENGTH_LONG).show();
            txtTampilkanUang.setText("Uang Anda Kurang");
            btnProses.setClickable(false);

            //Uang pengguna akan keluar
            txtKembalian.setText("Rp. 5000");
        } else if (total == 5000) {
            btnProses.setClickable(true);
            txtKembalian.setText("Uang anda sudah pas");
        }


    }

    public void ambilUang(View view) {
        txtKembalian.setText(" ");
    }

    public void ambilEskrim(View view) {
        txtHasil.setText(" ");
    }

    public void konfirmasi(View view) {
        //untuk mengunci pilihan dari pengguna
        radCoklat.setClickable(false);
        radVanilla.setClickable(false);
        radStroberi.setClickable(false);
        radMilo.setClickable(false);
        radMatcha.setClickable(false);
        radCoco.setClickable(false);
        radKacang.setClickable(false);
        radOreo.setClickable(false);

        Toast.makeText(this, "Pilihan anda telah terkonfirmasi", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Jika ingin membatalkan, tekan tombol batal", Toast.LENGTH_SHORT).show();

    }

    public void batal(View view) {
        Toast.makeText(this, "Silahkan memilih lagi", Toast.LENGTH_SHORT).show();
        radCoklat.setClickable(true);
        radVanilla.setClickable(true);
        radStroberi.setClickable(true);
        radMilo.setClickable(true);
        radMatcha.setClickable(true);
        radCoco.setClickable(true);
        radKacang.setClickable(true);
        radOreo.setClickable(true);

        txtTotal.setText("");
    }
}