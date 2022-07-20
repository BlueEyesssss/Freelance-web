
<!DOCTYPE html>
<html data-wf-domain="seeker-create.webflow.io" data-wf-page="6299706694ea0f0359e53260"
    data-wf-site="6299706694ea0f3cf2e5325f">

<head>
    <meta charset="utf-8" />
    <title>Seeker Create</title>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Webflow" name="generator" />
    <link href="https://uploads-ssl.webflow.com/6299706694ea0f3cf2e5325f/css/seeker-create.webflow.d31b785e1.css"
        rel="stylesheet" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
    <script
        type="text/javascript">WebFont.load({ google: { families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"] } });</script>
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

<body class="body">
    <div class="header">
        <div data-animation="default" data-collapse="medium" data-duration="400" data-easing="ease" data-easing2="ease"
            role="banner" class="navbar w-nav">
            <div class="container w-container"><a href="#" class="w-nav-brand"><img
                        src="https://uploads-ssl.webflow.com/6299706694ea0f3cf2e5325f/629970786d4c6879931356b0_myLogo%201.png"
                        loading="lazy" width="62" alt="" class="image" /></a></div>
        </div>
    </div>
    <form method="post" action="NextChooseSkillController" enctype="multipart/form-data">
    
    <div class="container-2 w-container">
        <div class="create-account">
            <div class="create-text">Create Account For Seeker</div>
        </div>
        <div class="input-field">
            <div class="w-form">
<!--                <form id="email-form-2" name="email-form-2" data-name="Email Form 2" method="get" >-->
                    <label for="userName" class="text">UserName</label>
                    <input placeholder="User name" maxlength="5000" id="field" type="text"
                        name="userName" data-name="field" class="input-username w-input" required="" value="${param.userName}"></input>
                        <font style="color: red">${requestScope.ERROR_CREATE.userName}</font>
                        <font style="color: red">${requestScope.ERROR_CREATE.duplicate}</font>
                    <label for="password"
                        class="text">Password</label>
                    <input placeholder="Password" maxlength="5000" id="field-2" type="password"
                        name="password" data-name="field" class="input-password w-input" required=""></input>
                    <font style="color: red">${requestScope.ERROR_CREATE.password}</font>
<!--                </form>-->
                <div class="w-form-done">
                    <div>Thank you! Your submission has been received!</div>
                </div>
                <div class="w-form-fail">
                    <div>
                        
                    </div>
                </div>
            </div>
            <div class="w-form">
                <!--<form id="email-form-3" name="email-form-3" data-name="Email Form 3" method="get">-->
                    <label for="conform"
                        class="text">Confirm Password</label>
                    <input placeholder="Confirm password" maxlength="5000" type="password"
                        id="field-3" name="conform" data-name="field" 
                        class="input-confirm-password w-input" required=""></input>
                        <font style="color: red">${requestScope.ERROR_CREATE.confirm}</font>
                    
                     <label for="fullName" class="text">Full Name</label>
                     <input placeholder="Full name" maxlength="5000" id="field-4" name="fullName" type="text"
                        data-name="field" class="input-fullname w-input" required="" value="${param.fullName}"></input>
                        <font style="color: red">${requestScope.ERROR_CREATE.fullName}</font>
                     <!--</form>-->
                <div class="w-form-done">
                    <div>Thank you! Your submission has been received!</div>
                </div>
                <div class="w-form-fail">
                    <div>Oops! Something went wrong while submitting the form.</div>
                </div>
            </div>
            <div class="w-form">
                <!--<form id="email-form-4" name="email-form-4" data-name="Email Form 4" method="get">-->
                    <label for="email"
                        class="text">Email</label>
                    <input placeholder="Email@gmail.com" maxlength="5000" id="field-5"
                        name="email" data-name="field" class="input-email w-input" type="text" value="${param.email}" required=""></input>
                        <font style="color: red">${requestScope.ERROR_CREATE.email}</font>
                        <font style="color: red">${requestScope.ERROR_CREATE.emailExist}</font>
                    <label for="phone"
                        class="text">PhoneNumber</label>
                    <input placeholder="Phone number" maxlength="5000"
                        id="field-6" name="phone" data-name="field" class="input-phonenumber w-input" type="text" value="${param.phone}" required=""></input>
                        <font style="color: red">${requestScope.ERROR_CREATE.phone}</font>
                    <!--</form>-->
                <div class="w-form-done">
                    <div>Thank you! Your submission has been received!</div>
                </div>
                <div class="w-form-fail">
                    <div>Oops! Something went wrong while submitting the form.</div>
                </div>
            </div>
            <div class="w-form">
                <!--<form id="email-form-5" name="email-form-5" data-name="Email Form 5" method="get">-->
                    <label for="location"
                        class="text">Location</label>
                    <input placeholder="Location" maxlength="5000" id="field-7"
                        name="location" data-name="field" class="input-location w-input" type="text" value="${param.location}" required=""></input>
                      <font style="color: red">${requestScope.ERROR_CREATE.location}</font>  
                    <label for="balance"
                        class="text">Balance</label>
                    <input placeholder="Balance" maxlength="5000" id="field-8"
                         data-name="field" class="textarea w-input"
                        type="number" name="balance" value="0" required="" min="0" readonly=""></input>
                <!--</form>-->
                <div class="w-form-done">
                    <div>Thank you! Your submission has been received!</div>
                </div>
                <div class="w-form-fail">
                    <div>Oops! Something went wrong while submitting the form.</div>
                </div>
            </div>
            <div class="w-form">
                <!--<form id="email-form-6" name="email-form-6" data-name="Email Form 6" method="get">-->
                    <label for="overview"
                        class="text">Overview</label>
                    <input placeholder="" maxlength="5000" id="field-12"
                         data-name="field" class="overview-input w-input"
                        type="text" name="overview" value="${param.overview}" required=""></input>
                    <font style="color: red">${requestScope.ERROR_CREATE.overview}</font>     
                    <label
                        for="moneyPerHour" class="text">MoneyPerHour</label>
                    <input placeholder="money per hour"
                        maxlength="5000" id="field-10"  data-name="field"
                        class="input-money-per-hour w-input"
                        type="number" name="moneyPerHour" value="${param.moneyPerHour}" required="" min="0"></input>
                <!--</form>-->
                <div class="w-form-done">
                    <div>Thank you! Your submission has been received!</div>
                </div>
                <div class="w-form-fail">
                    <div>Oops! Something went wrong while submitting the form.</div>
                </div>
            </div>
            <div class="w-form">
            <!--<form id="email-form-7" name="email-form-7" data-name="Email Form 7" method="get">-->
                <label for="major"
                    class="text">Major</label>
                <input placeholder="Major" maxlength="5000" id="field-13"
                     data-name="field" class="input-major w-input"
                    type="text" name="major" value="${param.major}" required=""></input>
                <font style="color: red">${requestScope.ERROR_CREATE.major}</font>
            <!--</form>-->
            <div class="w-form-done">
                <div>Thank you! Your submission has been received!</div>
            </div>
            <div class="w-form-fail">
                <div>Oops! Something went wrong while submitting the form.</div>
            </div>
        </div>
        <div class="w-form">
                <!--<form id="email-form-8" name="email-form-8" data-name="Email Form 8" method="get">-->
                    <label for="education"
                        class="text">Education</label>
                    <input placeholder="" maxlength="5000" id="field-14"
                         data-name="field" class="input-education w-input"
                        type="text" name="education" value="${param.education}" required=""></input>
                        <font style="color: red">${requestScope.ERROR_CREATE.education}</font>
                    
                <!--</form>-->
                <div class="w-form-done">
                    <div>Thank you! Your submission has been received!</div>
                </div>
                <div class="w-form-fail">
                    <div>Oops! Something went wrong while submitting the form.</div>
                </div>
            </div>
                <div class="w-form">
                <!--<form id="email-form-10" name="email-form-10" data-name="Email Form 10" method="get">-->
                    <label for="titileBio"
                        class="text">TitleBio</label>
                    <input placeholder="" maxlength="5000" id="field-15" 
                        data-name="field" class="input-titlebio w-input"
                        type="text" name="titileBio" value="${param.titileBio}" required=""></input>
                    <font style="color: red">${requestScope.ERROR_CREATE.titileBio}</font>
                <!--</form>-->
                <div class="w-form-done">
                    <div>Thank you! Your submission has been received!</div>
                </div>
                <div class="w-form-fail">
                    <div>Oops! Something went wrong while submitting the form.</div>
                </div>
            </div>
            <div class="w-form">
                <!--<form id="email-form-10" name="email-form-10" data-name="Email Form 10" method="get">-->
                    <label for="avatar"
                        class="text">Upload Avatar (.jpg/.png)</label>
                    <input placeholder="" maxlength="5000" id="field-17" 
                        data-name="field" class="input-avatar w-input"
                        type="file" name="avatar" ></input>
                    <font style="color: red">${requestScope.ERROR_CREATE.avatar}</font>
                <!--</form>-->
                <div class="w-form-done">
                    <div>Thank you! Your submission has been received!</div>
                </div>
                <div class="w-form-fail">
                    <div>Oops! Something went wrong while submitting the form.</div>
                </div>
            </div>
            <div class="degree-wrapped">
                <div class="w-form">
                    <!--<form id="email-form-9" name="email-form-9" data-name="Email Form 9" method="get" class="form">-->
                        <label
                            for="degree" class="text">Degree </label>
                        <select id="field-16" name="degree"
                            data-name="Field 16" class="select-field w-select">
                            <option value="None">None</option>
                            <option value="College degree">College degree</option>
                            <option value="University degree">University degree</option>
                            <option value="Master's degree">Master's degree</option>
                        </select>
                    <!--</form>-->
                    <div class="w-form-done">
                        <div>Thank you! Your submission has been received!</div>
                    </div>
                    <div class="w-form-fail">
                        <div>Oops! Something went wrong while submitting the form.</div>
                    </div>
                </div>
            </div>
                <div class="next-wrapper"><button type="submit" value="Next" name="action"><a class="next-button w-button">Next</a></button></div>
        </div>
        
        
    </div>
    </form>
    <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=6299706694ea0f3cf2e5325f"
        type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
    <script src="https://uploads-ssl.webflow.com/6299706694ea0f3cf2e5325f/js/webflow.7f48192d4.js"
        type="text/javascript"></script>
    <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>

</html>