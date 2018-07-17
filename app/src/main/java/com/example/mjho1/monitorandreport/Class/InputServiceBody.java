package com.example.mjho1.monitorandreport.Class;

import com.bluelinelabs.logansquare.LoganSquare;

public class InputServiceBody {
    public static final String TAG = InputServiceBody.class.getSimpleName();

    private int ClientSeq;//Client seq
    private String SecCode;//Sec code
    private String WorkerName;//Worker name values
    private String ServiceName;//Service name values
    private int TimeOut;//TimeOut values
    private String MWLoginID;//MWLoginID values
    private String MWLoginPswd;//MWLoginPswd values
    private String AppLoginID;   //AppLoginID values
    private String AppLoginPswd;   //AppLoginPswd values (Password has been encrypt)
    private String IPPrivate;   //IPPrivate values
    private String IPPublic;   //IPPublic values
    private String ClientSentTime;   //ClientSentTime values
    private String Lang;     //Client language
    private String MdmTp;     //Media type

    //Update 14 June 2016
    private String CltVersion = "1.0.0";    //Client version
    private String AprStat;    //Approve status
    private String Operation;    //Q: Query, I: Insert, U: Update, :anguished: Delete, E: Export, P: Print
    private String CustMgnBrch = "";     //Customer management branch
    private String CustMgnAgc = "";     //Customer management Agency
    private String BrkMgnBrch = "";     //BrokerInfo management branch
    private String BrkMgnAgc = "";     //BrokerInfo management Agency
    //END Update 14 June 2016

    //Update July 04
    private String LoginBrch = "";        //Login branch
    private String LoginAgnc = "";        //Login Agency
    //Update 30 June 2016
    private String AcntNo = "";//So Tai Khoan
    private String SubNo = "";//Tieu Khoan
    private String BankCd = "";//Ma Ngan Hang
    //END Update 30 June

    private String AprSeq;
    private String MakerDt;

    private String[] InVal;  //List of input values
    private int TotInVal;    //Total input values

    private String AprIP;
    private String AprID;
    private String AprAmt;

    private String PCName;

    private String Otp = "";

    private DataCryption dataCryption;

    public InputServiceBody(String[] inVal, String appLoginID, String appLoginPswd, String workerName, String serviceName) throws Exception{
        dataCryption = new DataCryption();
        Consts.clientSeq += 1;
        this.ClientSeq = Consts.clientSeq;
        this.MWLoginID = Consts.MW_LOGIN_ID;
        this.MWLoginPswd = dataCryption.encryptString(Consts.MW_LOGIN_PSWD);
        this.AppLoginID = appLoginID;
        this.AppLoginPswd = appLoginPswd;//Password has been encrypt
        this.IPPrivate = "";
        this.IPPublic = "";
        this.ClientSentTime = "0";
//        if (GlobalApplication.getInstance().getBestPingPongTime() == NumberUtils.MAXTIME)
//            this.ClientSentTime = "0";
//        else {
//            Calendar nowCalendar = Calendar.getInstance();
//            Calendar lastestPingPong = GlobalApplication.getInstance().getLastestPingPongRequest();
//            Date nowDate = nowCalendar.getTime();
//            Date lastestPingDate = lastestPingPong.getTime();
//            Date serverDate = DateTimeUtils.convert_to_date(GlobalApplication.getInstance().getServerTime(), "yyyyMMddHHmmss");
//
//            long lClientSendTime = (nowDate.getTime() - lastestPingDate.getTime()) + serverDate.getTime();
//
//            Date dateClientSendTime = new Date(lClientSendTime);
//
//            String sDateClientSendTime = DateTimeUtils.convert_to_yyyyMMddHHmmss_without_forward_slash(dateClientSendTime);
//
//            this.ClientSentTime = sDateClientSendTime;
//        }
        this.Lang = "V";
        this.MdmTp = Consts.MdmTp;
        this.InVal = inVal;
        this.TotInVal = inVal.length;
            this.SecCode = "075";
        this.WorkerName = workerName;
        this.ServiceName = serviceName;
        this.AcntNo = "";
        this.SubNo = "";
        this.BankCd = "";
        this.AprSeq = "";
//        this.AprIP = GlobalApplication.getInstance().getIpAddress();
//        if (GlobalApplication.getInstance().getmUserInfoItem() == null)
//            this.AprID = "";
//        else
//            this.AprID = GlobalApplication.getInstance().getmUserInfoItem().getC0();
        this.AprAmt = "";
        this.MakerDt = "";
        this.Operation = "Q";
        this.AprStat = "N";
        this.CltVersion = Consts.clientVersion;
        this.TimeOut = Consts.TIMEOUT_SECOND;

//        if (GlobalApplication.getInstance().getmUserInfoItem() != null) {
//            this.Otp = GlobalApplication.getInstance().getOtp();
//            if (StringUtils.isNullString(this.Otp))
//                this.Otp = "NONE";
//        }
//        else {
//            this.Otp = "";
//        }
    }

    public String getOtp() {
        return Otp;
    }

    public void setOtp(String otp) {
        Otp = otp;
    }

    public int getClientSeq() {
        return ClientSeq;
    }

    public void setClientSeq(int clientSeq) {
        ClientSeq = clientSeq;
    }

    public String getSecCode() {
        return SecCode;
    }

    public void setSecCode(String secCode) {
        SecCode = secCode;
    }

    public String getWorkerName() {
        return WorkerName;
    }

    public void setWorkerName(String workerName) {
        WorkerName = workerName;
    }

    public String getServiceName() {
        return ServiceName;
    }

    public void setServiceName(String serviceName) {
        ServiceName = serviceName;
    }

    public int getTimeOut() {
        return TimeOut;
    }

    public void setTimeOut(int timeOut) {
        TimeOut = timeOut;
    }

    public String getMWLoginID() {
        return MWLoginID;
    }

    public void setMWLoginID(String MWLoginID) {
        this.MWLoginID = MWLoginID;
    }

    public String getMWLoginPswd() {
        return MWLoginPswd;
    }

    public void setMWLoginPswd(String MWLoginPswd) {
        this.MWLoginPswd = MWLoginPswd;
    }

    public String getAppLoginID() {
        return AppLoginID;
    }

    public void setAppLoginID(String appLoginID) {
        AppLoginID = appLoginID;
    }

    public String getAppLoginPswd() {
        return AppLoginPswd;
    }

    public void setAppLoginPswd(String appLoginPswd) {
        AppLoginPswd = appLoginPswd;
    }

    public String getIPPrivate() {
        return IPPrivate;
    }

    public void setIPPrivate(String IPPrivate) {
        this.IPPrivate = IPPrivate;
    }

    public String getIPPublic() {
        return IPPublic;
    }

    public void setIPPublic(String IPPublic) {
        this.IPPublic = IPPublic;
    }

    public String getClientSentTime() {
        return ClientSentTime;
    }

    public void setClientSentTime(String clientSentTime) {
        ClientSentTime = clientSentTime;
    }

    public String getLang() {
        return Lang;
    }

    public void setLang(String lang) {
        Lang = lang;
    }

    public String getMdmTp() {
        return MdmTp;
    }

    public void setMdmTp(String mdmTp) {
        MdmTp = mdmTp;
    }

    public String getCltVersion() {
        return CltVersion;
    }

    public void setCltVersion(String cltVersion) {
        CltVersion = cltVersion;
    }

    public String getAprStat() {
        return AprStat;
    }

    public void setAprStat(String aprStat) {
        AprStat = aprStat;
    }

    public String getOperation() {
        return Operation;
    }

    public void setOperation(String operation) {
        Operation = operation;
    }

    public String getCustMgnBrch() {
        return CustMgnBrch;
    }

    public void setCustMgnBrch(String custMgnBrch) {
        CustMgnBrch = custMgnBrch;
    }

    public String getCustMgnAgc() {
        return CustMgnAgc;
    }

    public void setCustMgnAgc(String custMgnAgc) {
        CustMgnAgc = custMgnAgc;
    }

    public String getBrkMgnBrch() {
        return BrkMgnBrch;
    }

    public void setBrkMgnBrch(String brkMgnBrch) {
        BrkMgnBrch = brkMgnBrch;
    }

    public String getBrkMgnAgc() {
        return BrkMgnAgc;
    }

    public void setBrkMgnAgc(String brkMgnAgc) {
        BrkMgnAgc = brkMgnAgc;
    }

    public String getLoginBrch() {
        return LoginBrch;
    }

    public void setLoginBrch(String loginBrch) {
        LoginBrch = loginBrch;
    }

    public String getLoginAgnc() {
        return LoginAgnc;
    }

    public void setLoginAgnc(String loginAgnc) {
        LoginAgnc = loginAgnc;
    }

    public String getAcntNo() {
        return AcntNo;
    }

    public void setAcntNo(String acntNo) {
        AcntNo = acntNo;
    }

    public String getSubNo() {
        return SubNo;
    }

    public void setSubNo(String subNo) {
        SubNo = subNo;
    }

    public String getBankCd() {
        return BankCd;
    }

    public void setBankCd(String bankCd) {
        BankCd = bankCd;
    }

    public String getAprSeq() {
        return AprSeq;
    }

    public void setAprSeq(String aprSeq) {
        AprSeq = aprSeq;
    }

    public String getMakerDt() {
        return MakerDt;
    }

    public void setMakerDt(String makerDt) {
        MakerDt = makerDt;
    }

    public String[] getInVal() {
        return InVal;
    }

    public void setInVal(String[] inVal) {
        InVal = inVal;
    }

    public int getTotInVal() {
        return TotInVal;
    }

    public void setTotInVal(int totInVal) {
        TotInVal = totInVal;
    }

    public DataCryption getDataCryption() {
        return dataCryption;
    }

    public void setDataCryption(DataCryption dataCryption) {
        this.dataCryption = dataCryption;
    }

    public String getAprAmt() {
        return AprAmt;
    }

    public void setAprAmt(String aprAmt) {
        AprAmt = aprAmt;
    }

    public String getAprIP() {
        return AprIP;
    }

    public void setAprIP(String aprIP) {
        AprIP = aprIP;
    }

    public String getAprID() {
        return AprID;
    }

    public void setAprID(String aprID) {
        AprID = aprID;
    }

    //getInValJson
    private String getInValJson(){
        String inValJson = "";
        for (int i = 0; i < getInVal().length; i++){
            if (i != getInVal().length - 1)
                inValJson += "\"" + getInVal()[i] + "\",";
            else
                inValJson += "\"" + getInVal()[i] + "\"";
        }
        return inValJson;
    }

    //Create json
    public String getServiceBodyJson(){
        String json;
        json = "{"
                + "\"ClientSeq\":" + getClientSeq() + ","
                + "\"MWLoginID\":" + "\"" + getMWLoginID() + "\"" +","
                + "\"MWLoginPswd\":" + "\"" + getMWLoginPswd() + "\"" + ","
                + "\"AppLoginID\":" + "\"" + getAppLoginID() + "\"" + ","
                + "\"AppLoginPswd\":" + "\"" + getAppLoginPswd() + "\"" + ","
                + "\"IPPrivate\":" + "\"" + getIPPrivate() + "\"" + ","
                + "\"IPPublic\":" + "\"" + getIPPublic() + "\"" + ","
                + "\"Lang\":" + "\"" + getLang() + "\"" + ","
                + "\"MdmTp\":" + "\"" + getMdmTp() + "\"" + ","
                + "\"ClientSentTime\":" + "\"" + getClientSentTime() + "\"" + ","
                + "\"InVal\":" + "["
                    + getInValJson()
                    + "],"
                + "\"TotInVal\":" + getTotInVal() + ","
                + "\"SecCode\":" + "\"" + getSecCode() + "\"" + ","
                + "\"WorkerName\":" + "\"" + getWorkerName() + "\"" + ","
                + "\"ServiceName\":" + "\"" + getServiceName() + "\"" + ","
                + "\"AcntNo\":" + "\"" + getAcntNo() + "\"" + ","
                + "\"SubNo\":" + "\"" + getSubNo() + "\"" + ","
                + "\"BankCd\":" + "\"" + getBankCd() + "\"" + ","
                + "\"Operation\":" + "\"" + getOperation() + "\"" + ","
                + "\"CltVersion\":" + "\"" + getCltVersion() + "\"" + ","
                + "\"LoginBrch\":" + "\"" + getLoginBrch() + "\"" + ","
                + "\"LoginAgnc\":" + "\"" + getLoginAgnc() + "\"" + ","
                + "\"AprStat\":" + "\"" + getAprStat() + "\"" + ","
                + "\"AprSeq\":" + "\"" + getAprSeq() + "\"" + ","
                + "\"AprIP\":" + "\"" + getAprIP() + "\"" + ","
                + "\"AprID\":" + "\"" + getAprID() + "\"" + ","
                + "\"AprAmt\":" + "\"" + getAprAmt() + "\"" + ","
//                + "\"PCName\":" + "\"" + Consts.getDeviceName() + "\"" + ","
                + "\"MakerDt\":" + "\"" + getMakerDt() + "\"" + ","
                + "\"Otp\":" + "\"" + getOtp() + "\"" + ","
                + "\"TimeOut\":" + getTimeOut()
                + "}";
//        Log.d(TAG, "getServiceBodyJson: " +  json);
        return json;
    }

    public String getServiceBodyJsonLib(InputServiceBody inputServiceBody) throws Exception{
        return LoganSquare.serialize(inputServiceBody);
    }
}
