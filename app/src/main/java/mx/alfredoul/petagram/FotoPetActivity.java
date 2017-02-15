package mx.alfredoul.petagram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alfredoul on 15/02/17.
 */

public class FotoPetActivity extends AppCompatActivity {
    private ImageView ivPhoto;
    private TextView tvRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_foto);

        Bundle parametros = getIntent().getExtras();
        Integer foto = parametros.getInt("foto");
        Integer rate = parametros.getInt("rate");

        ivPhoto = (ImageView) findViewById(R.id.ivFoto);
        tvRate  = (TextView) findViewById(R.id.tvRate);

        ivPhoto.setImageResource(foto);
        tvRate.setText(String.valueOf(rate));

    }
}