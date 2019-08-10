<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
        <title> Domino </title>
        <style>
            html {
                font-size: 16px;
                align-content: center;
                text-align: center;
                background-color: #EEEEEE;
            }

            label {
                text-align: unset;
                font-size: 16px;
            }

            input {
                width: 100%;
            }

            input[type=text] {
                padding: 12px 20px;
                margin: 8px 0;
                box-sizing: border-box;
                border: 3px solid #BBBBBB;
                -webkit-transition: 0.5s;
                transition: 0.5s;
                outline: none;
            }

            input[type=submit] {
                width: unset;
            }

            input[type=text]:focus {
                border: 3px solid #333333;
            }

            input[type=submit]{
                padding: 12px 20px;
                margin: 8px 0;
                box-sizing: border-box;
                background-color: #BBBBBB;
                color: #333333;
                outline: none;
                border: 0;
            }

            input[type=submit]:focus{
                background-color: #333333;
                color: #BBBBBB;
            }

            .center {
                margin: auto;
                width: 20%;
                padding: 10px;
            }

            h4 {
                font-size: 16px;
            }

            h4:focus-visible {
                text-decoration: underline;
                text-decoration-color: #0000ff;
            }
        </style>
    </head>
    <body>
    <h1>Domino</h1>
    <div class="center">
        <h4>Sing in</h4>
        <form method="post">
            <label for="name">Name</label>
            <input type="text" name="name" id="name" value="enter name">
            <label for="password">Password</label>
            <input type="text" name="password" id="password" value="enter password">
            <input type="submit" value="sign in">
        </form>
    </div>
    </body>
</html>
