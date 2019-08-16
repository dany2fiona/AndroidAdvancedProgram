//package com.dany.advance.main.strictmodetest;
//
//import android.os.Bundle;
//import android.os.Handler;
//import android.os.Looper;
//import android.os.Message;
//import android.support.v7.app.AppCompatActivity;
//import android.widget.TextView;
//
//import com.dany.advance.R;
//
//public class StrictmodetestActivity extends AppCompatActivity {
//    private TextView tv;
//    final Boolean[] jj = new Boolean[]{true};
//    private Handler mHandler = new Handler(Looper.getMainLooper()){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            tv.setText("前"+msg.arg2+"数之和为："+msg.arg1);
//            jj[0] = true;
//        }
//    };
//    private Thread mHThread;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        tv = findViewById(R.id.tv);
//        mHThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int i=0;
//                int sum = 0;
//                while(i<1000000){
//                    if(jj[0]){
//                        jj[0] = false;
//                        i++;
//                        sum += i;
//                        Message message = mHandler.obtainMessage();
//                        message.what = 11;
//                        message.arg1 = sum;
//                        message.arg2 = i;
//                        mHandler.sendMessageDelayed(message,100);
//                    }
//                }
//            }
//        });mHThread.start();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mHandler.removeMessages(11);
//        mHandler = null;
//        mHThread.stop();
//        mHThread = null;
//    }
//}
