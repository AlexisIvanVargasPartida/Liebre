package com.example.alex.tpdm_u4_liebre_alexisvargas;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView res;
    Button btn;
    Boolean bandera = true;
    Thread thread;
    int tortuga = 0;
    int liebre = 0;
    String cad="",msj="",msj2="";

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn =(Button)findViewById(R.id.btn);
        res=(TextView)findViewById(R.id.res);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugar();
            }
        });
    }//onCreate

    public void jugar(){
        thread = new Thread(){
            public void run(){
                while(bandera) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int r1 = (int) (Math.random()*100)+1;

                    if(r1 >= 0 && r1 <= 50){
                        tortuga+=3;
                        msj = "avance rapido";
                    }else{
                        if(r1 > 50 && r1 <=70){
                            tortuga-=6;
                            msj = "resbalo";
                            if(tortuga<0){
                                tortuga = 0;
                            }
                        }else{
                            tortuga+=1;
                            msj = "avance lento";
                        }
                    }
                    int r2 = (int) (Math.random()*100)+1;

                    if(r2 >= 0 && r2<=20){
                        msj2 = "duerme";
                    }
                    if (r2>20 && r2<=40){
                        liebre+=9;
                        msj2 = "gran salto";
                    }
                    if(r2 >40 && r2<=50){
                        liebre-=12;
                        msj2 = "resbalon grande";
                        if(liebre<0){
                            liebre = 0;
                        }
                    }
                    if(r2 >50 && r2<=80){
                        liebre += 1;
                        msj2 = "pequeño salto";
                    }
                    if(r2 > 80){
                        liebre-=2;
                        msj2 = "resbalon pequeño";
                        if(liebre<0){
                            liebre = 0;
                        }
                    }

                    if(liebre >= 70){
                        liebre = 70;
                        bandera = false;
                        msj2 = "Ganador";
                    }

                    if(tortuga >= 70){
                        tortuga = 70;
                        bandera = false;
                        msj = "Ganador";

                    }


                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            cad+="Liebre: "+liebre+" "+msj2+", tortuga "+tortuga+" "+msj+".\n";
                            res.setText(cad);
                        }
                    });


                    try {
                        sleep(300);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
    }//jugar
}//class
