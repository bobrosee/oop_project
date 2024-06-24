public class User {
        private int level;
        private String mail;
        private String username;
        private String password;
        private short sec_question;
        private String sec_answer;
        private String nickname;

    public User(String mail, String username, String password, short sec_question, String sec_answer,String nickname) {
        this.mail = mail;
        this.username = username;
        this.password = password;
        this.sec_question = sec_question;
        this.sec_answer = sec_answer;
        this.nickname = nickname;
        this.level = 1;
    }


}
