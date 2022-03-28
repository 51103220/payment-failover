package com.sacombank.payment.domain;

public class PaymentEvent {

    private PaymentEventMetadata metadata;
	
	private String eventId;
	private String timestamp;
	private String mTI;
	private String processingCode;
	private String payload;


    public String getEventId() {
        return eventId;
    }
    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
    public PaymentEventMetadata getMetadata() {
        return metadata;
    }
    public void setMetadata(PaymentEventMetadata metadata) {
        this.metadata = metadata;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getmTI() {
        return mTI;
    }
    public void setmTI(String mTI) {
        this.mTI = mTI;
    }
    public String getProcessingCode() {
        return processingCode;
    }
    public void setProcessingCode(String processingCode) {
        this.processingCode = processingCode;
    }
    public String getPayload() {
        return payload;
    }
    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getInfo(){
        return String.format("flowId=%s eventId=%s state=%s", getMetadata().getFlowId(), getEventId(), getMetadata().getState());
    }
}
