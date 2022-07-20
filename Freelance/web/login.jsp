<%-- 
    Document   : login
    Created on : May 23, 2022, 4:13:35 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><!-- This site was created in Webflow. https://www.webflow.com -->
<!-- Last Published: Mon Jul 18 2022 01:38:24 GMT+0000 (Coordinated Universal Time) -->
<html data-wf-domain="phats-exceptional-site.webflow.io" data-wf-page="62d3b9d80e07ab5531d5ec82"
  data-wf-site="62d3b9d70e07ab6b86d5ec7c" data-wf-status="1">

<head>
  <meta charset="utf-8" />
  <title>Login Page</title>
  <meta content="Untitled" property="og:title" />
  <meta content="Untitled" property="twitter:title" />
  <meta content="width=device-width, initial-scale=1" name="viewport" />
  <meta content="Webflow" name="generator" />
  <link href="https://uploads-ssl.webflow.com/62d3b9d70e07ab6b86d5ec7c/css/phats-exceptional-site.webflow.232fa16df.css"
    rel="stylesheet" type="text/css" />
  <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif]-->
  <script
    type="text/javascript">!function (o, c) { var n = c.documentElement, t = " w-mod-"; n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch") }(window, document);</script>
  <link href="https://uploads-ssl.webflow.com/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />
  <link href="https://uploads-ssl.webflow.com/img/webclip.png" rel="apple-touch-icon" />
</head>

<body>
  <div class="page-wrapper">
    <div class="page-container">
      <div class="block-1">
        <div class="content-wrapper"><a href="#" class="brand w-inline-block"><img
              src="https://uploads-ssl.webflow.com/62d3b9d70e07ab6b86d5ec7c/62d3b9d80e07ab3e31d5ec8c_global.svg"
              width="221" alt="" class="logo-img" /></a>
          <div class="content-box">
            <h1 class="heading-1">The choice of a new generation<br /></h1>
            <div class="feature-box"><img
                src="https://uploads-ssl.webflow.com/5e59340e7bb9af36b79a4c14/5e5b05550e170603cd7a7649_tag.svg" alt=""
                class="feature-icon" />
              <div class="feature-text">It&#x27;s Free.</div>
            </div>
            <div class="feature-box"><img
                src="https://uploads-ssl.webflow.com/5e59340e7bb9af36b79a4c14/5e5b05f02089e52bed8b12d5_dismiss.svg"
                alt="" class="feature-icon" />
              <div class="feature-text">No Credit Card.</div>
            </div>
            <div class="feature-box"><img
                src="https://uploads-ssl.webflow.com/5e59340e7bb9af36b79a4c14/5e5b06d60e170663c37a873a_close.svg" alt=""
                class="feature-icon" />
              <div class="feature-text">Cancel Anytime.</div>
            </div>
          </div>
          <div class="legal-box _2">
            <div class="legal-text">© 2022 FreelanceWeb Ltd. All rights reserved.</div>
          </div>
        </div>
      </div>
    </div>
    <div class="page-container _2">
      <div class="block-2">
        <div class="form-wrapper">
          <h2 class="heading-2">Login to Freelance<br /></h2>
          <div class="form-box">
            <h3 class="heading-4">Use your social profile to login</h3>
            <div class="social-box"><a href="https://accounts.google.com/o/oauth2/auth?scope=email%20profile%20openid&redirect_uri=http://localhost:8080/Freelance/LoginGoogleController&response_type=code
              &client_id=540837116728-5a0vpu4mt0ll88qmcb76m7l9ulltkbqu.apps.googleusercontent.com&approval_prompt=force" class="social-login w-inline-block"><img
                  src="https://uploads-ssl.webflow.com/62d3b9d70e07ab6b86d5ec7c/62d3b9d80e07ab0517d5ec8d_G.png" alt=""
                  class="image" />
                <div class="div-block-2">
                  <div class="text-block-9">Google</div>
                </div>
              </a></div>
            <div class="div-block-6-copy">
              <div class="_1px-div-line"></div>
              <h3 class="heading-4">Or</h3>
              <div class="_1px-div-line"></div>
            </div>
            <div class="w-form">
              <form action="MainController" id="email-form" name="email-form" data-name="Email Form" method="get">
                <div class="form-field-wrapper">
                  <div class="text-field-box _2"><label for="Email" class="field-label-2">User Name</label><input
                      type="text" class="text-field-2 w-input" maxlength="256" name="userName" data-name="Email"
                      placeholder="you@email.com" id="Email" required="" /></div>
                  <div class="text-field-box _2"><label for="Password" class="field-label-2">Password</label><input
                      type="password" class="text-field-2 w-input" maxlength="256" name="password" data-name="Password"
                      placeholder="Password" id="Password" required="" /></div>
                </div><label class="w-checkbox checkbox-field">
                  <div class="w-checkbox-input w-checkbox-input--inputType-custom checkbox"></div><input type="checkbox"
                    id="Checkbox" name="Checkbox" data-name="Checkbox" required=""
                    style="opacity:0;position:absolute;z-index:-1" /><span for="Checkbox"
                    class="checkbox-label w-form-label">I agree to the <a href="#" class="link-4">Terms &amp;
                      Conditions</a> and <a href="#" class="link-4">Privacy Policy</a></span>
                </label><input type="submit" name="action" value="Login" data-wait="Please wait..."
                  class="button registration w-button" />
              </form>
              <div class="w-form-done">
                <div>Thank you! Your submission has been received!</div>
              </div>
              <div class="w-form-fail">
                <div>Oops! Something went wrong while submitting the form.</div>
              </div>
            </div>
            <h3 style="color: red; text-align: center">${requestScope.LOGIN_ERROR}</h2>
            <div class="div-block-41">
              <div class="text-block-8">Don&#x27;t have an account yet? </div><a href="createAcc.jsp" class="link-3">Sign up now</a>
            </div>
          </div>
        </div>
        <div class="legal-box _2-copy">
          <div class="legal-text _3">© 2022 FreelanceWeb Holding SA. All rights reserved.</div>
        </div>
      </div>
    </div>
  </div>
  <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62d3b9d70e07ab6b86d5ec7c"
    type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
    crossorigin="anonymous"></script>
  <script src="https://uploads-ssl.webflow.com/62d3b9d70e07ab6b86d5ec7c/js/webflow.b05994d78.js"
    type="text/javascript"></script>
  <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>

</html>
