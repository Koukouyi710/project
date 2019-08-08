package com.neuedu.pojo;

import com.neuedu.annotation.Column;
import com.neuedu.annotation.Table;

import java.util.Date;

@Table("neuedu_user")
public class UserInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_user.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_user.username
     *
     * @mbggenerated
     */

    @Column("username")
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_user.password
     *
     * @mbggenerated
     */

    @Column("password")
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_user.email
     *
     * @mbggenerated
     */
    @Column("email")
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_user.phone
     *
     * @mbggenerated
     */
    @Column("phone")
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_user.question
     *
     * @mbggenerated
     */
    @Column("question")
    private String question;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_user.answer
     *
     * @mbggenerated
     */
    @Column("answer")
    private String answer;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_user.role
     *
     * @mbggenerated
     */
    private Integer role;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_user.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column neuedu_user.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_user.id
     *
     * @return the value of neuedu_user.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_user.id
     *
     * @param id the value for neuedu_user.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_user.username
     *
     * @return the value of neuedu_user.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_user.username
     *
     * @param username the value for neuedu_user.username
     *
     * @mbggenerated
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_user.password
     *
     * @return the value of neuedu_user.password
     *
     * @mbggenerated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_user.password
     *
     * @param password the value for neuedu_user.password
     *
     * @mbggenerated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_user.email
     *
     * @return the value of neuedu_user.email
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_user.email
     *
     * @param email the value for neuedu_user.email
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_user.phone
     *
     * @return the value of neuedu_user.phone
     *
     * @mbggenerated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_user.phone
     *
     * @param phone the value for neuedu_user.phone
     *
     * @mbggenerated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_user.question
     *
     * @return the value of neuedu_user.question
     *
     * @mbggenerated
     */
    public String getQuestion() {
        return question;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_user.question
     *
     * @param question the value for neuedu_user.question
     *
     * @mbggenerated
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_user.answer
     *
     * @return the value of neuedu_user.answer
     *
     * @mbggenerated
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_user.answer
     *
     * @param answer the value for neuedu_user.answer
     *
     * @mbggenerated
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_user.role
     *
     * @return the value of neuedu_user.role
     *
     * @mbggenerated
     */
    public Integer getRole() {
        return role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_user.role
     *
     * @param role the value for neuedu_user.role
     *
     * @mbggenerated
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_user.create_time
     *
     * @return the value of neuedu_user.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_user.create_time
     *
     * @param createTime the value for neuedu_user.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column neuedu_user.update_time
     *
     * @return the value of neuedu_user.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column neuedu_user.update_time
     *
     * @param updateTime the value for neuedu_user.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}