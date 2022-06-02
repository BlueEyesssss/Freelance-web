<%-- 
    Document   : login
    Created on : May 23, 2022, 4:13:35 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html data-wf-domain="hirer-log-in.webflow.io" data-wf-page="62903a220cbd631dc8729d3d"
    data-wf-site="62903a220cbd63721d729d3c">

<head>
    <meta charset="utf-8" />
    <title>Hirer Log in</title>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Webflow" name="generator" />
    <link href="https://uploads-ssl.webflow.com/62903a220cbd63721d729d3c/css/hirer-log-in.webflow.7278f4e9a.css"
        rel="stylesheet" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
    <script
        type="text/javascript">WebFont.load({ google: { families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"] } });</script>
    <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif]-->
    <script
        type="text/javascript">!function (o, c) { var n = c.documentElement, t = " w-mod-"; n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch") }(window, document);</script>
    <link href="https://uploads-ssl.webflow.com/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <link href="https://uploads-ssl.webflow.com/img/webclip.png" rel="apple-touch-icon" />
</head>

<body class="body">
    <div>
        <div class="menu-bar"><img
                src="https://uploads-ssl.webflow.com/62903a220cbd63721d729d3c/62903aa372aeee46371c5d69_myLogo%201.png"
                loading="lazy" alt="" class="image-9" /></div>
    </div>
    <div class="section wf-section">
        <div class="w-container">
            <div class="main">
                <div class="log-in-to-collab">
                    <div class="text-block-9">Log in to Colllab</div>
                </div>
                <div class="form-block w-form">
                    <form action="MainController" id="email-form" name="email-form" data-name="Email Form" method="get" class="form"><label
                            for="name" class="username">Username or Email</label><input type="text"
                            class="username-type w-input" maxlength="256" name="userName" data-name="Name"
                            placeholder="Username/Email" id="name" required="" />
                            <label for="email"
                            class="password">Password</label><input  class="password-type w-input"
                            maxlength="256" name="password" data-name="Email" placeholder="Password" id="email"
                            required="" type="password"/>
                    <div class="w-form-done">
                        <div>Thank you! Your submission has been received!</div>
                    </div>
                    <div class="w-form-fail">
                        <div>Oops! Something went wrong while submitting the form.</div>
                    </div>
                </div>
                <div><button type="submit" name="action" value="Login"class="log-in"><a class="button w-button">Log in</a></button> </div>
                </form>
                <div class="text-block-11">Or</div>
                <div class="or"><a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/Freelance/LoginGoogleController&response_type=code
		   &client_id=540837116728-5a0vpu4mt0ll88qmcb76m7l9ulltkbqu.apps.googleusercontent.com&approval_prompt=force" class="button-6 w-button">Continue with Google</a></div>
                <div class="google"></div>
                <div class="dont-have-account">
                    <div class="text-block-13">Don&#x27;t have an account ?</div><a href="createAcc.jsp"
                        class="button-8 w-button">Sign Up</a>
                </div>
            </div>
        </div>
    </div>
    <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62903a220cbd63721d729d3c"
        type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
    <script src="https://uploads-ssl.webflow.com/62903a220cbd63721d729d3c/js/webflow.a46a2f8e7.js"
        type="text/javascript"></script>
    <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>

</html>
