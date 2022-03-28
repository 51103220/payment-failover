package com.sacombank.payment.domain;

public class PaymentTargetState {
    private String success;
    private String failed;
    private String timedOut;
    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
    public String getFailed() {
        return failed;
    }
    public void setFailed(String failed) {
        this.failed = failed;
    }
    public String getTimedOut() {
        return timedOut;
    }
    public void setTimedOut(String timedOut) {
        this.timedOut = timedOut;
    }
}
