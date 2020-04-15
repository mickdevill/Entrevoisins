package com.openclassrooms.entrevoisins.ui.neighbour_list;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

public  class favariteAcc extends AppCompatActivity  {

    ImageView avatar;

    TextView Name;

    TextView name_card;

    TextView facebook;

    FloatingActionButton favoriteButton;

    private NeighbourApiService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acaunt);



        avatar = findViewById(R.id.imageavatar);
        Name = findViewById(R.id.textView6);
        name_card = findViewById(R.id.textView4);
        favoriteButton = findViewById(R.id.addToFavBtn);
facebook = findViewById(R.id.textView3);

        Neighbour neighbour = getIntent().getParcelableExtra("sosed");

        Name.setText(neighbour.getName());
        name_card.setText(neighbour.getName());
      facebook.setText("www.facebook.us/" + neighbour.getName());
        Glide.with(avatar)
                .load(neighbour.getAvatarUrl())
                .apply(RequestOptions.centerCropTransform())
                .into(avatar);

        service = DI.getNeighbourApiService();





        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (service.getFavoriteNeibours().contains(neighbour)){
                    service.deleteFavNeibour(neighbour);
                    favoriteButton.setImageResource(R.drawable.fav_def);
                }
                else { service.addFavNeibour(neighbour);
                    favoriteButton.setImageResource(R.drawable.fav_true);
                }
            }
        });
if (service.getFavoriteNeibours().contains(neighbour)){
    favoriteButton.setImageResource(R.drawable.fav_true);
}else {favoriteButton.setImageResource(R.drawable.fav_def);}

    }
}
