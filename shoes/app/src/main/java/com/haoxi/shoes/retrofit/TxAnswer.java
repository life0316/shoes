package com.haoxi.shoes.retrofit;

/**
 * Created by Administrator on 2017\12\29 0029.
 */

public class TxAnswer {

    public int ret;
    public String msg;
    public AnswerData data;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public AnswerData getData() {
        return data;
    }

    public void setData(AnswerData data) {
        this.data = data;
    }

    public class AnswerData {
        String session;
        String answer;

        public String getSession() {
            return session;
        }

        public void setSession(String session) {
            this.session = session;
        }

        public String getAnswer() {
            return answer;
        }

        public void setAnswer(String answer) {
            this.answer = answer;
        }
    }


}
