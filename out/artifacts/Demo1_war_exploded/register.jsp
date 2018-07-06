<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="com.waxx.domain.User" %>
<%@ page import="com.waxx.service.UserService" %>
<%@ page import="ch2.util.Generator" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>注册</title>
</head>
<body  bgcolor="#DAF9FE">
<%
    String uid=request.getParameter("uid");
    String password=request.getParameter("password");
    String confirmPassword=request.getParameter("confirmPassword");
    String email=request.getParameter("email");
    int gender=Integer.parseInt(request.getParameter("gender"));
    String question=request.getParameter("question");
    String answer=request.getParameter("answer");
    String realName=request.getParameter("realName");
    String tel=request.getParameter("tel");
    if(uid==null || password.trim().equals("") ||
            password.trim().equals("") ||confirmPassword==null ||
            confirmPassword.trim().equals("") || email==null || email.trim().equals("") ||
            question==null || question.equals("") || answer==null || answer.equals("")){
        request.setAttribute("errMsg","请将必填的数据填写完整!");
%>
<jsp:forward page="error.jsp"/>
<%
}else if(!password.equals(confirmPassword)){
    request.setAttribute("errMsg","两次密码不匹配!");
%>
<jsp:forward page="error.jsp"/>
<%
    }
    UserService service=new UserService();
    boolean isExist=service.checkUid(uid);
    if(isExist){
        request.setAttribute("errMsg","用户名已经存在！");
%>
<jsp:forward page="error.jsp"/>
<%}
    User user=new User();
    user.setUid(uid);
    user.setPassword(password);
    user.setEmail(email);
    user.setGender(gender);
    user.setQuestion(question);
    user.setAnswer(answer);
    user.setTel(tel);
    user.setRealName(realName);
    String validateCode=Generator.getEmailCode();
    user.setValidateCode(validateCode);
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    service.addUser(user,basePath);
%>
</body>
</html>