package loadBalancer.model;

public class Request {

    private int requestId;

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public Request(int requestId) {
        this.requestId = requestId;
    }
}
