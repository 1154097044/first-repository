package com.xy.Broadcast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SendBroadcastActivity extends AppCompatActivity {

    private EditText etSendMsg;
    private Button sendBroadcastMsg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        initView();
        /**
         * 当我们点击完广播以后，这个方法就会被调用
         */
        if(sendBroadcastMsg != null){
            sendBroadcastMsg.setOnClickListener(v -> {
                //被调用之后，我们就去发广播
                String content = etSendMsg.getText().toString();
                Intent intent = new Intent();
                intent.setAction(Constants.ACTION_SEND_MSG);
                intent.putExtra(Constants.KEY_CONTENT,content);
                //发送广播
                sendBroadcast(intent);
            });
        }
    }

    private void initView() {
        etSendMsg = (EditText) findViewById(R.id.et_send_msg);
        sendBroadcastMsg = (Button) findViewById(R.id.send_broadcast_msg);
    }

}
