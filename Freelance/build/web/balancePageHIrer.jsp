
<%@page import="sample.transactionhandling.TransactionHandlingDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.hirer.HirerDTO"%>
<!DOCTYPE html><!-- This site was created in Webflow. https://www.webflow.com -->
<!-- Last Published: Thu Jul 07 2022 07:16:36 GMT+0000 (Coordinated Universal Time) -->
<html data-wf-domain="huynh-tan-phats-continue.webflow.io" data-wf-page="62c669708c32bc86179be04f"
      data-wf-site="62bdf9a94a3336c64bf4149d">

    <head>
        <meta charset="utf-8" />
        <title>Balance Page</title>
        <meta content="Balance" property="og:title" />
        <meta content="Balance" property="twitter:title" />
        <meta content="width=device-width, initial-scale=1" name="viewport" />
        <meta content="Webflow" name="generator" />
        <link
            href="https://uploads-ssl.webflow.com/62bdf9a94a3336c64bf4149d/css/huynh-tan-phats-continue.webflow.36f0dcc6c.css"
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

    <body class="body-2">
        <%
                HirerDTO hirer = (HirerDTO) session.getAttribute("USER_LOGIN");
                List<TransactionHandlingDTO> listTranHis = (List<TransactionHandlingDTO>) request.getAttribute("LIST_TRANSACTION_HITORY");
            %>
        <div data-collapse="medium" data-animation="default" data-duration="400" data-easing="ease" data-easing2="ease"
             role="banner" class="navigation-2 seeker w-nav">
            <div class="navigation-container-2">
                <div class="navigation-menu-2"><a href="MainController?action=ViewHirerDashboard" class="brand-2 w-nav-brand"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628aeb849e24d09f04fa55e0_logo.png"
                            loading="lazy" alt="" class="logo-image biglogo" /></a>
                    <div class="nav-search-wrapper-2">
                        <div class="nav-icon-search-2"><img
                                src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/6296b474e000b451cf79e812_search-white.svg"
                                loading="lazy" alt="" /></div>
                        <div class="nav-search-input-2">
                            <div class="w-form">
                                <form id="email-form-2" name="email-form-2" data-name="Email Form 2" method="get"><input
                                        type="text" class="search-input-2 w-input" maxlength="256" name="name-2"
                                        data-name="Name 2" placeholder="" id="name-2" /><input type="submit" value="Submit"
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
                    <div class="div-block-3">
                        <div data-hover="true" data-delay="0" class="link-4 nav-link w-dropdown">
                            <div class="dropdown-toggle-2 w-dropdown-toggle">
                                <div class="text-block-22">My Job</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="postAJob.jsp"
                                                                            class="dropdown-link-nav w-dropdown-link">Post a Job</a>
                                                                        <a href="MainController?action=ViewContractOfHirer"
                                                                            class="dropdown-link-nav w-dropdown-link">All contract</a>
                                                                        <a href="#"
                                                                            class="dropdown-link-nav w-dropdown-link">Hire</a></nav>
                        </div>
                        <div data-hover="true" data-delay="0" class="link-4 nav-link w-dropdown">
                            <div class="dropdown-toggle-3 w-dropdown-toggle">
                                <div class="text-block-22">Find Talent</div>
                            </div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="#"
                                                                            class="dropdown-moi-qua-troi-moi w-dropdown-link">Find Talent</a></nav>
                        </div>
                    </div><a href="#" class="link-block w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d693684f77e4900d5de82_send.png"
                            loading="lazy" alt="" class="image-15" /></a><a href="#" class="w-inline-block"><img
                            src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d69352ef8ea1801f37308_bell.png"
                            loading="lazy" alt="" /></a>
                    <div class="navigation-button-wrapper">
                        <div data-hover="false" data-delay="0" class="w-dropdown">
                            <div class="dropdown-toggle w-dropdown-toggle"><img
                                    src="uploads/<%= hirer.getAvatar() %>"
                                    loading="lazy" width="90" alt="" class="avatar-img-nav" /></div>
                            <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewHirerProfile"
                                                                            class="dropdown-link w-dropdown-link">My Profile</a>
                                                                        <a href="MainController?action=ViewBalanceHirerSeeker"
                                                                            class="dropdown-link w-dropdown-link">My Balance</a>
                                                                        <a href="MainController?action=Logout"
                                                                            class="dropdown-link w-dropdown-link">Log out</a></nav>
                        </div>
                    </div>
                </div>
                <div class="menu-button w-nav-button">
                    <div class="w-icon-nav-menu"></div>
                </div>
            </div>
        </div>
        <div class="container w-container">
            
            <h1 class="heading-16">Hello <%= hirer.getFullName()%></h1>
            <div class="wrapper">
                <div class="balance">
                    <div class="top-balance">
                        <div class="left-top">
                            <h3 class="heading-17">My Balance</h3>
                        </div>
                        <div class="right-top">
                            <div class="withdrawn-money-wrapper"><a data-w-id="bae3e80d-5f78-1075-82a6-9143124bbe44"
                                                                    href="#" class="link-block-2 w-inline-block"><img
                                        src="https://uploads-ssl.webflow.com/62bdf9a94a3336c64bf4149d/62c6718859806d42f52ed2b7_withdraw%20(1).png"
                                        loading="lazy" alt="" class="image-16" />
                                    <div class="div-block-62">
                                        <div class="text-block-44"><strong>Withdrawn</strong></div>
                                    </div>
                                </a></div>
                            <div class="add-money-wrapper"><a data-w-id="471e52da-6b9a-90aa-713f-907a7249bbdb" href="#"
                                                              class="link-block-3 w-inline-block"><img
                                        src="https://uploads-ssl.webflow.com/62bdf9a94a3336c64bf4149d/62c673367979bbd706d8534f_icons8-add-dollar-64.png"
                                        loading="lazy" height="50" alt="" />
                                    <div class="div-block-63">
                                        <div class="text-block-45"><strong>Add</strong></div>
                                    </div>
                                </a></div>
                        </div>
                    </div>
                    <div class="down-balance">
                        <h1 class="paymentamount">$<%= hirer.getBalance()%> USD</h1>
                    </div>
                    <span style="padding-left: 5%;color:red">${ERROR_NOT_ENOUGH_MONEY}</span>
                </div>
                <div class="transactions">
                    <h3 class="heading-18">Transactions</h3>
                    <div class="transaction-list-wrapper">
                        <div class="transaction-list">

                            <%
                                if (listTranHis.size() != 0) {
                                    for (TransactionHandlingDTO elem : listTranHis) {
                            %>
                            <div class="transaction">
                                <div class="name-date-money">
                                    <div class="text-block-46"><%= elem.getAmountMonney()%>$ --- <%= elem.getDateCreate()%></div>
                                </div>
                                <div class="status">
                                    <div class="text-block-47" style="width: 150px;">
                                        <%
                                            if (elem.getStatus() == false) {
                                        %>
                                        Processing
                                        <%
                                        } else {
                                        %>
                                        Done - <%= elem.getDateDone()%>
                                        <%
                                            }
                                        %>
                                    </div>
                                </div>
                            </div>
                            <%
                                }
                            } else {
                            %>
                            <div class="transaction">
                                <div class="name-date-money">
                                    <div class="text-block-46">There is no transaction at all</div>
                                </div>
                            </div>
                            <%
                                }
                            %>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div style="display:none;opacity:0" class="withdrawn-popup">
            <div class="div-block-65">
                <div class="text-block-48">Enter The Money To Withdraw</div>
                <div class="w-form">
                    <form action="MainController" id="email-form-3" name="email-form-3" data-name="Email Form 3" method="get" class="form">
                        <input
                            type="number" class="w-input" maxlength="256" data-name="Name 3" placeholder=""
                            id="name-3" name="moneyCashout" min="0" required=""/>

                        <input type="submit" value="Cash out" name="action" data-wait="Please wait..."
                               class="submit-button-3 w-button" />

                        <a data-w-id="2dc40167-5fe5-fa29-c882-10e6ccb8d876" href="#"
                           class="button-7 w-button">Cancel </a>
                    </form>
                    <div class="w-form-done">
                        <div>Thank you! Your submission has been received!</div>
                    </div>
                    <div class="w-form-fail">
                        <div>Oops! Something went wrong while submitting the form.</div>
                    </div>
                </div>
            </div>
        </div>
        <div style="display:none;opacity:0" class="add-popup">
            <div class="div-block-65">
                <div class="text-block-48-copy">Enter The Money To Add</div>
                <div class="w-form">
                    <form action="MainController" method="POST" id="email-form-3" name="email-form-3" data-name="Email Form 3" class="form">
                        <input name="moneyRecharge" min="0" required=""
                               type="number" class="w-input" maxlength="256"  data-name="Name 3" placeholder=""
                               id="name-3" />

                        <input type="submit" value="Recharge" name="action" data-wait="Please wait..."
                               class="submit-button-3 w-button" />

                        <a data-w-id="30400f6f-c41c-b94c-ba8e-ef92d22a8a35" href="#"
                           class="button-7 w-button">Cancel </a>
                    </form>
                    <div class="w-form-done">
                        <div>Thank you! Your submission has been received!</div>
                    </div>
                    <div class="w-form-fail">
                        <div>Oops! Something went wrong while submitting the form.</div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62bdf9a94a3336c64bf4149d"
                type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
        <script src="https://uploads-ssl.webflow.com/62bdf9a94a3336c64bf4149d/js/webflow.de4336cbe.js"
        type="text/javascript"></script>
        <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
    </body>

</html>