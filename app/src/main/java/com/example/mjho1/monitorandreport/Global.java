package com.example.mjho1.monitorandreport;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.mjho1.monitorandreport.Class.IOServiceHandle;
import com.example.mjho1.monitorandreport.Class.InputServiceBody;
import com.example.mjho1.monitorandreport.Class.SocketServiceResponse;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.LinkedHashMap;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

import static com.example.mjho1.monitorandreport.Class.Consts.clientSeq;

public class Global extends Application {

    // --- Variables are declared here ---
    // -----------------------------------

    private Integer backBtnCounter;
    public Socket globalSocket;
    private static Global mInstance= null;
    public boolean isSocketConnected=false;
    private LinkedHashMap<String, SocketServiceResponse> socketRequestHashMap = new LinkedHashMap<>();

    // --- Getters and setters here ---
    // --------------------------------

    public Integer getBackBtnCounter() { return backBtnCounter; }
    public void setBackBtnCounter(Integer backBtnCounter) { this.backBtnCounter = backBtnCounter; }
    public Socket getGlobalSocket() { return globalSocket; }
    public void setGlobalSocket(Socket globalSocket) { this.globalSocket = globalSocket; }
    public static synchronized Global getInstance() {
        if(null == mInstance){ mInstance = new Global(); }
        return mInstance; }

    {
        try{
            IO.Options socketOptions = new IO.Options();
            socketOptions.forceNew = false;
            socketOptions.reconnection = true;
            socketOptions.transports = new String[] { "polling", "websocket" };

//            globalSocket= IO.socket("https://trading.bsi.com.vn",socketOptions);
            globalSocket= IO.socket("http://altisss.vn:5551",socketOptions);
        }catch (URISyntaxException e){
            throw new RuntimeException(e);
        }
    }

    // --- Main body here ---
    // ----------------------

    @Override
    public void onCreate(){
        super.onCreate();

        backBtnCounter=0;

        globalSocket.on(Socket.EVENT_CONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket.io",">>>>>>>>> The socket is now connected <<<<<<<<<<");
                isSocketConnected=true;
//                Toast.makeText(get,"Socket connected.",Toast.LENGTH_SHORT)
//                        .show();
            }
        })
                .on("MKT_INFO_RES",messageClassification)
                .on("MKT_INFO",messageClassification)
                .on("NTF_MSG",messageClassification)
                .on("SYS_MSG",messageClassification)
                .on("RES_MSG",messageClassification)
                .on(Socket.EVENT_DISCONNECT, new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                Log.i("Socket.io",">>>>>>>>> The socket is now disconnected <<<<<<<<<<");
                isSocketConnected=false;
//                Toast.makeText(getApplicationContext(),"Socket disconnected.",Toast.LENGTH_SHORT)
//                        .show();

            }
        });
        globalSocket.connect();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSocketServiceResponse(SocketServiceResponse socketServiceResponse) {
        String KEY_GET_STOCK_LIST="ABC";
        if (socketServiceResponse.getOptionalKey().equals(KEY_GET_STOCK_LIST)) {
            sendLoginRequest();
        }
    }

    // --- Custom functions are declared here ---
    // ------------------------------------------

    private Emitter.Listener messageClassification=new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            try{
                JSONObject data = (JSONObject) args[0];
                Log.i("",data.toString());

                switch (data.getString("MsgTp")){
                    case "":
                        break;
                    default: Log.i("","");
                        break;
                }

            }catch (JSONException e){}
        }
    };

    public void socketEmit(String optionalKey, String socketHeader, InputServiceBody inputServiceBody){
        SocketServiceResponse socketServiceResponse = new SocketServiceResponse();
        socketServiceResponse.setF1ClientSeq(String.valueOf(inputServiceBody.getClientSeq()));
        socketServiceResponse.setOptionalKey(optionalKey);
        socketRequestHashMap.put(String.valueOf(inputServiceBody.getClientSeq()), socketServiceResponse);

        socketEmit(optionalKey, socketHeader, inputServiceBody.getServiceBodyJson());
    }

    public void socketEmit(String optionalKey, String socketHeader, String sJson){
        SocketServiceResponse socketServiceResponse = new SocketServiceResponse();
        socketServiceResponse.setF1ClientSeq(String.valueOf(clientSeq));
        socketServiceResponse.setOptionalKey(optionalKey);

        socketRequestHashMap.put(String.valueOf(clientSeq), socketServiceResponse);

        socketEmit(socketHeader, sJson);
    }

    public void sendLoginRequest(){

    }

    public void socketEmit(String socketHeader, String sJson){
        globalSocket.emit(socketHeader, sJson);
    }
}
