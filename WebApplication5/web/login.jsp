

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
            
            <link type="text/css" rel="stylesheet" href="/WebApplication5/javax.faces.resource/jsfcrud.css.xhtml?ln=css" />
            <link type="text/css" rel="stylesheet" href="/WebApplication5/javax.faces.resource/bootstrap/css/bootstrap.css.xhtml" />
            
            
            

    </head>
    <body>
        <h1>Login</h1>
        <form action="j_security_check" method="POST">
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="input-group">
                            <span class="input-group-addon">Login</span>
                            <input id="login" class="form-control" type="text" name="j_username">
                        </div>
                    </div>
                </div>
                <br/>
                <div class="row">
                    <div class="col-lg-6">
                        <div class="input-group">
                            <span class="input-group-addon">Password</span>
                            <input id="login_password" class="form-control" type="password" name="j_password">
                        </div>
                    </div>
                </div>
                <br/>
                <input id="login_valid" class="btn btn-success" type="submit" value="Login">
            </div>
         </form>
    </body>
</html>
