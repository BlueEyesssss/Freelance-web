<%@page import="sample.hirer.HirerDTO"%>
<!DOCTYPE html>

<html data-wf-domain="upwork-7e964a.webflow.io" data-wf-page="6296b682f8b462fb53aec689"
      data-wf-site="628aea177e2bdc5cebb3b655" data-wf-status="1">

    <head>
        <meta charset="utf-8" />
        <title>Proposal</title>
        <meta content="Proposal" property="og:title" />
        <meta content="Proposal" property="twitter:title" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Webflow" name="generator" />
        <link href="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/css/upwork-7e964a.webflow.49a706ff0.css"
              rel="stylesheet" type="text/css" />
        <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
        <script
        type="text/javascript">WebFont.load({google: {families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"]}});</script>
        <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif]-->
        <script
        type="text/javascript">!function (o, c) {
                var n = c.documentElement, t = " w-mod-";
                n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch")
            }(window, document);</script>
        <link href="https://uploads-ssl.webflow.com/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />
        <link href="https://uploads-ssl.webflow.com/img/webclip.png" rel="apple-touch-icon" />
        <style>
            .w-webflow-badge {
                display: none !important;
            }
        </style>
    </head>

    <body class="user-body">

        <%
                HirerDTO loginUser = (HirerDTO) session.getAttribute("USER_LOGIN");

    %>
        
        <div data-collapse="medium" data-animation="default" data-duration="400" data-easing="ease" data-easing2="ease"
             role="banner" class="navigation seeker hirer w-nav">
            <div class="navigation-container">
                <div class="navigation-menu"><a href="MainController?action=ViewHirerDashboard" class="brand w-nav-brand"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628aeb849e24d09f04fa55e0_logo.png"
                            loading="lazy" alt="" class="logo-image biglogo" /></a>
                    <div class="nav-search-wrapper">
                        <div class="nav-icon-search"><img
                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296b474e000b451cf79e812_search-white.svg"
                                loading="lazy" alt="" /></div>
                        <div class="nav-search-input">
                            <div class="w-form">
                                <form id="email-form-2" name="email-form-2" data-name="Email Form 2" method="get"><input
                                        type="text" class="search-input w-input" maxlength="256" name="name"
                                        data-name="Name" placeholder="" id="name" /><input type="submit" value="Submit"
                                        data-wait="Please wait..." class="submit-button-2 w-button" /></form>
                                <div class="w-form-done">
                                    <div>Thank you! Your submission has been received!</div>
                                </div>
                                <div class="w-form-fail">
                                    <div>Oops! Something went wrong while submitting the form.</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="icon-wrapper">
                    <div>
                        <div data-hover="true" data-delay="0" class="link nav-link w-dropdown">
                            <div class="dropdown-toggle-2 w-dropdown-toggle">
                                <div class="text-block-22">My Job</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="postAJob.jsp"
                                                                            class="dropdown-link-nav w-dropdown-link">Post a job</a><a href="MainController?action=ViewContractOfHirer"
                                                                            class="dropdown-link-nav w-dropdown-link">All Contracts</a><a href="#"
                                                                            class="dropdown-link-nav w-dropdown-link">Hire</a></nav>
                        </div>
                        <div data-hover="true" data-delay="0" class="link nav-link w-dropdown">
                            <div class="dropdown-toggle-3 w-dropdown-toggle">
                                <div class="text-block-22">Find Talent</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="#"
                                                                            class="dropdown-link-nav w-dropdown-link">Find Talent</a></nav>
                        </div>
                    </div><a href="#" class="w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d693684f77e4900d5de82_send.png"
                            loading="lazy" alt="" class="image-3" /></a><a href="#" class="w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d69352ef8ea1801f37308_bell.png"
                            loading="lazy" alt="" /></a>
                    <div class="navigation-button-wrapper">
                        <div data-hover="false" data-delay="0" class="w-dropdown">
                            <div class="dropdown-toggle w-dropdown-toggle">
                                <img
                                    src="<%= loginUser.getAvatar() %>"
                                    loading="lazy" width="90"
                                    srcset="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n-p-500.jpeg 500w, https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d85e7b6d2c143c7d9d3cd_240528174_4134217460021195_5113676912781388161_n.jpeg 960w"
                                    sizes="(max-width: 479px) 100vw, (max-width: 767px) 42.373046875px, 6vw" alt=""
                                    class="avatar-img-nav" /></div>
                            <nav class="dropdown-list w-dropdown-list">
                                <a href="MainController?action=ViewHirerProfile" class="dropdown-link w-dropdown-link">My
                                    Profile</a>
                                <a href="MainController?action=ViewBalanceHirerSeeker" class="dropdown-link w-dropdown-link">My Balance</a>
                                <a href="MainController?action=Logout"  class="dropdown-link w-dropdown-link">Log out</a>
                            </nav>
                        </div>
                    </div>
                </div>
                <div class="menu-button w-nav-button">
                    <div class="w-icon-nav-menu"></div>
                </div>
            </div>
        </div>

        <div class="responsive-section wf-section">
            <div class="container-1200 w-container">
                <div class="div-block-155">
                    <h1 class="heading-131">Confirm Paying</h1>
                    <div class="text-block-160"></div>

                    <form action="ExecutePaymentServlet" method="post">
                        
                        <input type="hidden" name="paymentId" value="${param.paymentId}" />
                        <input type="hidden" name="PayerID" value="${param.PayerID}" />
                        <button type="submit" value="Pay Now" >
                                <a class="main-button confirm-payment w-button">Pay now</a>
                        </button>
                        
                    </form>




                </div>
            </div>
        </div>
        <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=628aea177e2bdc5cebb3b655"
                type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
        <script src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/js/webflow.34546492c.js"
        type="text/javascript"></script>
        <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
    </body>

</html>