package com.example.alivv.tpdm_u4_practica1_alexisvargas;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ronda,j1suma,j2suma,j3suma;
    ImageView d1j1,d2j1,d1j2,d2j2,d1j3,d2j3;
    TextView rondaj1,rondaj2,rondaj3;
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ronda=(EditText)findViewById(R.id.ronda);
        j1suma=(EditText)findViewById(R.id.j1suma);
        j2suma=(EditText)findViewById(R.id.j2suma);
        j3suma=(EditText)findViewById(R.id.j3suma);
        rondaj1=(TextView)findViewById(R.id.tiroj1);
        rondaj2=(TextView)findViewById(R.id.tiroj2);
        rondaj3=(TextView)findViewById(R.id.tiroj3);
        d1j1=(ImageView)findViewById(R.id.j1d1);
        d2j1=(ImageView)findViewById(R.id.j1d2);
        d1j2=(ImageView)findViewById(R.id.j2d1);
        d2j2=(ImageView)findViewById(R.id.j2d2);
        d1j3=(ImageView)findViewById(R.id.j3d1);
        d2j3=(ImageView)findViewById(R.id.j3d2);



        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzar();
            }
        });

    }

    public void lanzar(){

        Thread thread = new Thread() {
            public void run() {
                int c=0;
                final int[] p1 = {0};
                final int[] p2 = {0};
                final int[] p3 = {0};
                while (c<4) {//cliclo infinito si se deja como While true

                    final int finalC = c;
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            //randoms para j1
                            int ld1 = (int)(Math.random()*6)+1;
                            cambiaimg(ld1,d1j1);
                            int ld2 = (int)(Math.random()*6)+1;
                            cambiaimg(ld2,d2j1);
                            int suma1=ld1+ld2;
                            p1[0] +=suma1;
                            //j2
                            int abc = (int) (Math.random() * 6) + 1;
                            cambiaimg(abc,d1j2);
                            int cde = (int) (Math.random() * 6) + 1;
                            cambiaimg(cde,d2j2);
                            int suma2=abc+cde;
                            p2[0] +=suma2;
                            //j3
                            int qwe = (int) (Math.random() * 6) + 1;
                            cambiaimg(qwe,d1j3);
                            int asd = (int) (Math.random() * 6) + 1;
                            cambiaimg(asd,d2j3);
                            int suma3=qwe+asd;
                            p3[0] +=suma3;

                            ronda.setText((finalC+1)+"");
                            rondaj1.setText("tiro "+(finalC+1));
                            rondaj2.setText("tiro "+(finalC+1));
                            rondaj3.setText("tiro "+(finalC+1));
                            j1suma.setText(suma1+"");
                            j2suma.setText(suma2+"");
                            j3suma.setText(suma3+"");
                            if(finalC ==3){
                                if(p1[0]>p2[0] && p1[0]>p3[0]){
                                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                                    alertDialogBuilder.setTitle("Ganador!!!\njugador 1: "+p1[0])
                                            .setMessage("perdedores\njugador 2: "+p2[0]+"\njugador 3: "+p3[0])
                                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            }).create().show();

                                    //Toast.makeText(MainActivity.this,"ganador p1:"+p1[0],Toast.LENGTH_SHORT).show();
                                }
                                if(p2[0]>p1[0] && p2[0]>p3[0]){
                                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                                    alertDialogBuilder.setTitle("Ganador!!!\njugador 2: "+p2[0])
                                            .setMessage("perdedores\njugador 1: "+p1[0]+"\njugador 3: "+p3[0])
                                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            }).create().show();
                                    //Toast.makeText(MainActivity.this,"ganador p2:"+p2[0],Toast.LENGTH_SHORT).show();
                                }
                                if(p3[0]>p2[0] && p3[0]>p1[0]){
                                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
                                    alertDialogBuilder.setTitle("Ganador!!!\njugador 3: "+p3[0])
                                            .setMessage("perdedores\njugador 1: "+p1[0]+"\njugador 2: "+p2[0])
                                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    dialog.dismiss();
                                                }
                                            }).create().show();
                                    //Toast.makeText(MainActivity.this,"ganador p3:"+p3[0],Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                    c++;

                    try {
                        sleep(1000);//se establece para poner un tiempo de descanzo para la ejecucion en milisegundos
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        thread.start();
    }

    public void cambiaimg(int val,ImageView img){
        if (val==1){
            img.setImageResource(R.drawable.d1);
        }
        if (val==2){
            img.setImageResource(R.drawable.d2);
        }
        if (val==3){
            img.setImageResource(R.drawable.d3);
        }
        if (val==4){
            img.setImageResource(R.drawable.d4);
        }
        if (val==5){
            img.setImageResource(R.drawable.d5);
        }
        if (val==6){
            img.setImageResource(R.drawable.d6);
        }

    }

}