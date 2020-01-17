package com.example.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    NotificationManagerCompat notificationManagerCompat;
    Button btn1, btn2;
    private int counter = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        Channel channel = new Channel(this);
        channel.channel();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotificaiton1();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayNotificaiton2();
            }
        });


    }

    private void DisplayNotificaiton1(){
        Notification notification = new NotificationCompat.Builder(this, Channel.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_announcement_black_24dp)
                .setContentTitle("First message")
                .setContentText("First message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(counter,notification);
        counter += 1;
    }

    private void DisplayNotificaiton2(){
        Notification notification = new NotificationCompat.Builder(this, Channel.CHANNEL_2)
                .setSmallIcon(R.drawable.ic_message_black_24dp)
                .setContentTitle("Second message")
                .setContentText("Second message body")
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();
        notificationManagerCompat.notify(counter,notification);
        counter += 1;
    }
}
