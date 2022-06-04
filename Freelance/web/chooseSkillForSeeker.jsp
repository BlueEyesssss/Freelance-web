
<%@page import="sample.skill.SkillDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html data-wf-domain="seeker-create.webflow.io" data-wf-page="6299da110bd09eda88c831c3"
    data-wf-site="6299706694ea0f3cf2e5325f">

<head>
    <meta charset="utf-8" />
    <title>Choose Skill Page</title>
    <meta content="Not Found" property="og:title" />
    <meta content="Not Found" property="twitter:title" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Webflow" name="generator" />
    <link href="https://uploads-ssl.webflow.com/6299706694ea0f3cf2e5325f/css/seeker-create.webflow.53fcaab18.css"
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

<body class="body-2">
    <%
            List<SkillDTO> listSkill = (List<SkillDTO>)session.getAttribute("LIST_SKILL");
        %>
        
    <div data-animation="default" data-collapse="medium" data-duration="400" data-easing="ease" data-easing2="ease"
        role="banner" class="navbar-2 w-nav">
        <div class="container-3 w-container"><a href="#" class="w-nav-brand"><img
                    src="https://uploads-ssl.webflow.com/6299706694ea0f3cf2e5325f/629970786d4c6879931356b0_myLogo%201.png"
                    loading="lazy" alt="" /></a>
            <div class="w-nav-button">
                <div class="w-icon-nav-menu"></div>
            </div>
        </div>
    </div>
    <div class="container-4 w-container">
        <div class="hello-seeker-wrapped">
            <div class="hello-seeker">Hello Seeker! What skills do you have ?</div>
        </div>
        <div class="div-block">
            <form action="MainController">
            <div class="w-form">
                <!--<form id="email-form" name="email-form" data-name="Email Form" method="get">-->
                <%
                for (SkillDTO skill : listSkill) {
                        %>
                        <label class="w-checkbox skill-check">
                            <input type="checkbox" id="checkbox" name="skillID" data-name="Checkbox" class="w-checkbox-input" value="<%= skill.getSkillID()%>"/>
                            <span class="html w-form-label" for="skillID"><%= skill.getSkillName()%> </span>
                        </label>
            <%
                    }
            %>

                <div class="w-form-done">
                    <div>Thank you! Your submission has been received!</div>
                </div>
                <div class="w-form-fail">
                    <div>Oops! Something went wrong while submitting the form.</div>
                </div>
                <div class="div-block-2"><button type="submit" value="Create Seeker" name="action"><a class="create-seeker-button w-button">Create Seeker</a></button></div>
            </div>
            </form>
        </div>
    </div>
    <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=6299706694ea0f3cf2e5325f"
        type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
    <script src="https://uploads-ssl.webflow.com/6299706694ea0f3cf2e5325f/js/webflow.7f48192d4.js"
        type="text/javascript"></script>
    <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>

</html>