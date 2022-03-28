package com.sacombank.payment.domain;

public class PaymentEventMetadata {
    private String fromChannel;
    private String flowId;
    private String timestamp;
    private String state;
    PaymentTargetState nextStates;
    private String replyTo;
    private String responseCode;
    private String additionalData;
    private String signature;
    
    public String getFromChannel() {
        return fromChannel;
    }
    public void setFromChannel(String fromChannel) {
        this.fromChannel = fromChannel;
    }
    public String getFlowId() {
        return flowId;
    }
    public void setFlowId(String flowId) {
        this.flowId = flowId;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public PaymentTargetState getNextStates() {
        return nextStates;
    }
    public void setNextStates(PaymentTargetState nextStates) {
        this.nextStates = nextStates;
    }
    public String getReplyTo() {
        return replyTo;
    }
    public void setReplyTo(String replyTo) {
        this.replyTo = replyTo;
    }
    public String getResponseCode() {
        return responseCode;
    }
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    public String getAdditionalData() {
        return additionalData;
    }
    public void setAdditionalData(String additionalData) {
        this.additionalData = additionalData;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
}
