package com.employeeDept.demo.utils;


import org.springframework.stereotype.Component;

@Component
public class CustomResponse {
	private Status status;
	private Object data;
	
	public CustomResponse(){
	}
	
	public CustomResponse(Status status, Object data){
		this.status = status;
		this.data = data;
	}
	
	public CustomResponse generateCustomResponse(int code, String type, String message, Object data) {
		Status stat = new Status(code,message,type);
		CustomResponse response = new CustomResponse(stat, data);
		return response;
		
	}
	
	// Getters and Setters
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
	
	
	
	// Nested Status class
    public static class Status {
        private int code;
        private String message;
        private String type;

        public Status() {}

        public Status(int code, String message, String type) {
            this.code = code;
            this.message = message;
            this.type = type;
        }

        // Getters and Setters
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}
