package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitProjectActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_project);

        Context context_submit_project_activity = this;

        Button button_submit_project=findViewById(R.id.submit_project_button);

        TextView underlineText = findViewById(R.id.text_project_submission);
        underlineText.setPaintFlags(underlineText.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        Dialog dialog = new Dialog(context_submit_project_activity);//Dialog Fragment
        dialog.setContentView(R.layout.popup_yes);

        FloatingActionButton button_popup_close = dialog.findViewById(R.id.popup_image_button_close);
        Button button_pop_up_yes = dialog.findViewById(R.id.popup_button_yes);




        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        RequestInterface request = retrofit.create(RequestInterface.class);



        button_submit_project.setOnClickListener(new View.OnClickListener() {
            EditText tv_fname,tv_lname,tv_email,tv_github;
            String tvs_fname,tvs_lname,tvs_email,tvs_github;


            @Override
            public void onClick(View v) {
                tv_fname = findViewById(R.id.editTextFirstName);
                tv_lname = findViewById(R.id.editTextLastName);
                tv_email = findViewById(R.id.editTextEmailAddress);
                tv_github =findViewById(R.id.editTextProjectOnGitHub);

                dialog.show();


                button_popup_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });


                button_pop_up_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvs_fname = tv_fname.getText().toString().trim();
                        tvs_lname = tv_lname.getText().toString().trim();
                        tvs_email = tv_email.getText().toString().trim();
                        tvs_github =tv_github.getText().toString().trim();



                            Call<Void> call = request.sendDetails(tvs_fname,tvs_lname,tvs_email,tvs_github);
                            call.enqueue(new Callback<Void>(){

                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.isSuccessful()){
                                dialog.setContentView(R.layout.popup_success);
                                dialog.show();
                                }else{
                                    dialog.setContentView(R.layout.popup_fail);
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.d("Error","Throwable said"+ t.getMessage());
                                dialog.setContentView(R.layout.popup_fail);
                                dialog.show();
                                call.cancel();
                            }
                        });
                    }
                });


            }
        });




    }
}