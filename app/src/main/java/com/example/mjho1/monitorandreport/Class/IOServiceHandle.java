package com.example.mjho1.monitorandreport.Class;

import android.content.Context;
import android.util.Log;

import com.example.mjho1.monitorandreport.Global;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by nguyennam on 8/23/17.
 */

public class IOServiceHandle {

    String TAG = IOServiceHandle.class.getSimpleName();

    private String[] inVal;
    private String workerName;
    private String serviceName;
    private InputServiceBody inputServiceBody;
    private String optionalKey;
    private String serviceSocketHeader;

    Context context;

    /*
        Truyền context -> show loading
        Trong mọi trường hợp đều truyền OrderSubAccount

        inVal là tham số service
        optionalKey dùng để lưu hashmap trong Global để khi dữ liệu trả về, dựa vào optionalKey này để trả đúng màn hình (Dùng even bus)
     */

    public IOServiceHandle(Context context, String optionalKey, String socketHeader, String workerName, String serviceName, String[] inVal) {
        this(optionalKey, socketHeader, workerName, serviceName, inVal);

        this.context = context;
    }

    public IOServiceHandle(String optionalKey, String socketHeader, String workerName, String serviceName) {
        this(optionalKey, socketHeader, workerName, serviceName, new String[]{});
    }

    public IOServiceHandle(String optionalKey, String socketHeader, String workerName, String serviceName, String[] inVal) {
        this.optionalKey = optionalKey;
        this.serviceSocketHeader = socketHeader;
        this.workerName = workerName;
        this.serviceName = serviceName;
        this.inVal = inVal;
        try {
            initParams();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initParams() throws Exception {
        inputServiceBody = new InputServiceBody(inVal,
                "Android",
                "",
                this.workerName,
                this.serviceName);
    }

//    public void setSubAccountInfo(SubAccountInfo subAccountInfo) {
//        if (subAccountInfo != null) {
//            inputServiceBody.setLoginBrch(subAccountInfo.get_22BrkMgnBrch());
//            inputServiceBody.setLoginAgnc(subAccountInfo.get_23BrkMgnAgc());
//        }
//        else {
//            inputServiceBody.setLoginBrch("");
//            inputServiceBody.setLoginAgnc("");
//        }
//    }
//
    public void socketEmit(){
        if (!Global.getInstance().isSocketConnected){
            Log.d(TAG, "socketEmit 2");
            SocketServiceResponse socketServiceResponse = new SocketServiceResponse();
            socketServiceResponse.setOptionalKey(optionalKey);
            socketServiceResponse.setF6Result("0");
            socketServiceResponse.setF5Message("Vui lòng kiểm tra lại kết nối của bạn hoặc liên hệ bộ phận IT để được giải đáp.");
            EventBus.getDefault().post(socketServiceResponse);
        }
        else {
            Log.d(TAG, "socketEmit 3");
            Global.getInstance().socketEmit(optionalKey, serviceSocketHeader, inputServiceBody);
        }
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setMakerDt(String makerDt) {
        inputServiceBody.setMakerDt(makerDt);
    }

    public void setAprSeq(String aprSeq) {
        inputServiceBody.setAprSeq(aprSeq);
    }

    public void setAprStat(String aprStat) {
        inputServiceBody.setAprStat(aprStat);
    }

    public void setAprAmt(String aprAmt) {
        inputServiceBody.setAprAmt(aprAmt);
    }

    public void setAprIP(String aprIP) {
        inputServiceBody.setAprIP(aprIP);
    }

    public void setAprID(String aprID) {
        inputServiceBody.setAprID(aprID);
    }

    public void setOperation(String sOperation) {
        inputServiceBody.setOperation(sOperation);
    }

    public String getOptionalKey() {
        return optionalKey;
    }

    public InputServiceBody getInputServiceBody() {
        return inputServiceBody;
    }

    public String getWorkerName() {
        return workerName;
    }

    public String[] getInVal() {
        return inVal;
    }
}
