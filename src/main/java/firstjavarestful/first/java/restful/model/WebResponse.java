package firstjavarestful.first.java.restful.model;

public class WebResponse<T> {

    int code;

    String status;

    T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }



    public WebResponse(int code, String status, T data) {
        this.code = code;
        this.status = status;
        this.data = data;
    }
}
