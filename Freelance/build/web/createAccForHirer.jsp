
<!DOCTYPE html><!-- This site was created in Webflow. https://www.webflow.com -->
<!-- Last Published: Sun Jul 17 2022 07:50:40 GMT+0000 (Coordinated Universal Time) -->
<html data-wf-domain="phats-exceptional-site.webflow.io" data-wf-page="62d3b9d80e07aba4b5d5ec80"
  data-wf-site="62d3b9d70e07ab6b86d5ec7c" data-wf-status="1">

<head>
  <meta charset="utf-8" />
  <title>Create Account Hirer</title>
  <meta content="width=device-width, initial-scale=1" name="viewport" />
  <meta content="Webflow" name="generator" />
  <link href="https://uploads-ssl.webflow.com/62d3b9d70e07ab6b86d5ec7c/css/phats-exceptional-site.webflow.8765fbec2.css"
    rel="stylesheet" type="text/css" />
  <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif]-->
  <script
    type="text/javascript">!function (o, c) { var n = c.documentElement, t = " w-mod-"; n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch") }(window, document);</script>
  <link href="https://uploads-ssl.webflow.com/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />
  <link href="https://uploads-ssl.webflow.com/img/webclip.png" rel="apple-touch-icon" />
  <style>
    .w-webflow-badge {
        display: none !important;
    }
</style>
</head>

<body>
  <div class="page-wrapper">
    <div class="page-container">
      <div class="block-1">
        <div class="content-wrapper"><a href="#" class="brand w-inline-block"><img
              src="https://uploads-ssl.webflow.com/62d3b9d70e07ab6b86d5ec7c/62d3b9d80e07ab3e31d5ec8c_global.svg"
              width="221" alt="" class="logo-img" /></a>
          <div class="content-box">
            <h1 class="heading-1">Welcome to Freelance Website<br /></h1>
            <div class="feature-box"><img
                src="https://uploads-ssl.webflow.com/5e59340e7bb9af36b79a4c14/5e5b05550e170603cd7a7649_tag.svg" alt=""
                class="feature-icon" />
              <div class="feature-text">It&#x27;s Free, No fee to register.</div>
            </div>
            <div class="feature-box"><img
                src="https://uploads-ssl.webflow.com/5e59340e7bb9af36b79a4c14/5e5b05f02089e52bed8b12d5_dismiss.svg"
                alt="" class="feature-icon" />
              <div class="feature-text">No Require Credit Card.</div>
            </div>
            <div class="feature-box"><img
                src="https://uploads-ssl.webflow.com/5e59340e7bb9af36b79a4c14/5e5b06d60e170663c37a873a_close.svg" alt=""
                class="feature-icon" />
              <div class="feature-text">Cancel Anytime.</div>
            </div>
          </div>
          <div class="legal-box _2">
            <div class="legal-text">� 2022 Freelance web</div>
          </div>
        </div>
      </div>
    </div>
    <div class="page-container _2">
      <div class="block-2">
        <div class="form-wrapper">
          <h2 class="heading-2">Get Started!</h2>
          <div class="form-box">
            <h3 class="heading-4">Use your personal information to register</h3>
            <div class="div-block-6-copy">
              <div class="_1px-div-line"></div>
              <div class="_1px-div-line"></div>
            </div>
            <div class="w-form">
                
                <form id="email-form" name="email-form" data-name="Email Form" method="post" action="CreateHirerController" enctype="multipart/form-data">
                <div class="form-field-wrapper">
                  <div class="text-field-box">
                      <label for="UserName" class="field-label-2">User Name</label>
                      <input
                      type="text" class="text-field-2 w-input" maxlength="256" name="userName" data-name="UserName"
                      placeholder="User Name" id="UserName" required="" value="${param.userName}"/>
                      
                      <font style="color: red">${requestScope.ERROR_CREATE.userName}</font>
                      <font style="color: red">${requestScope.ERROR_CREATE.duplicate}</font>
                  </div>
                  <div class="text-field-box">
                      <label for="FullName" class="field-label-2">Full Name</label>
                      <input
                      type="text" class="text-field-2 w-input" maxlength="256" name="fullName" data-name="FullName"
                      placeholder="Full Name" id="FullName" required="" value="${param.fullName}"/>
                      
                      <font style="color: red">${requestScope.ERROR_CREATE.fullName}</font>
                  </div>
                  <div class="text-field-box">
                      <label for="Phone" class="field-label-2">Phone</label>
                      <input type="tel"
                      class="text-field-2 w-input" maxlength="256" name="phone" data-name="Phone" placeholder="Phone"
                      id="Phone" required="" value="${param.phone}"/>
                      
                      <font style="color: red">${requestScope.ERROR_CREATE.phone}</font>
                  </div>
                  <div class="text-field-box">
                      <label for="Location" class="field-label-2">Location</label>
                      <input
                      type="text" class="text-field-2 w-input" maxlength="256" name="location" data-name="Location"
                      placeholder="Name" id="Location" required="" value="${param.location}"/>
                      <font style="color: red">${requestScope.ERROR_CREATE.location}</font>
                  </div>
                  <div class="text-field-box _2">
                      <label for="Email" class="field-label-2">Email</label>
                      <input
                      type="email" class="text-field-2 w-input" maxlength="256" name="email" data-name="Email"
                      placeholder="you@email.com" id="Email" required="" value="${param.email}"/>
                      
                      <font style="color: red">${requestScope.ERROR_CREATE.email}</font>
                      <font style="color: red">${requestScope.ERROR_CREATE.emailExist}</font>
                  </div>
                  <div class="text-field-box _2">
                      <label for="Password" class="field-label-2">Password</label>
                      <input
                      type="password" class="text-field-2 w-input" maxlength="256" name="password" data-name="Password"
                      placeholder="Password" id="Password" required="" />
                      
                      <font style="color: red">${requestScope.ERROR_CREATE.password}</font>
                  </div>
                  <div class="text-field-box _2">
                      <label for="Password" class="field-label-2">Confirm Password</label>
                      <input
                      type="password" class="text-field-2 w-input" maxlength="256" name="conform" data-name="Password"
                      placeholder="Confirm Password" id="Password" required="" />
                      
                      <font style="color: red">${requestScope.ERROR_CREATE.confirm}</font>
                  </div>
                  <div class="text-field-box _2">
                      <label for="CompanyName" class="field-label-2">Company
                      Name</label>
                      <input type="text" class="text-field-2 w-input" maxlength="256" name="conpanyName"
                      data-name="CompanyName" placeholder="Company Name" id="CompanyName" required="" value="${param.conpanyName}"/>
                      <font style="color: red">${requestScope.ERROR_CREATE.conpanyName}</font>
                  </div>
                  <div class="text-field-box _2">
                      <label for="CompanyName" class="field-label-2">Upload Avatar (.jpg/.png)</label>
                      <input type="file" name="avatar" class="text-field-2 w-input" required=""/>
                      <font style="color: red">${requestScope.ERROR_CREATE.avatar}</font>
                  </div>
                </div>
                <label class="w-checkbox checkbox-field">
                  <div class="w-checkbox-input w-checkbox-input--inputType-custom checkbox"></div>
                  <input type="checkbox"
                    id="Checkbox" name="Checkbox" data-name="Checkbox" required=""
                    style="opacity:0;position:absolute;z-index:-1" /><span for="Checkbox"
                    class="checkbox-label w-form-label">I agree to the <a href="#" class="link-4">Terms &amp;
                      Conditions</a> and <a href="#" class="link-4">Privacy Policy</a></span>
                </label>
                <input type="submit" value="Create Hirer" data-wait="Please wait..."
                  class="button registration w-button" name="action"/>
              </form>
                
              <div class="success-message w-form-done">
                <div>Thank you! Your submission has been received!</div>
              </div>
              <div class="w-form-fail">
                <div>Oops! Something went wrong while submitting the form.</div>
              </div>
            </div>
            <div class="div-block-41">
                <div class="text-block-8">Already have an account? </div><a href="login.jsp" class="link-3">Login here</a>
            </div>
          </div>
        </div>
        <div class="legal-box _2-copy">
          <div class="legal-text _3">� 2020 MyBusiness Ltd. All rights reserved.</div>
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
