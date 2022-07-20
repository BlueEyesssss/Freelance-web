<%-- 
    Document   : activeProjectPage
    Created on : Jun 28, 2022, 8:56:33 AM
    Author     : Admin
--%>

<%@page import="sample.seeker.SeekerDTO"%>
<%@page import="java.time.LocalDate"%>
<%@page import="sample.project.ProjectDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><!-- This site was created in Webflow. https://www.webflow.com -->
<!-- Last Published: Tue Jun 28 2022 00:52:13 GMT+0000 (Coordinated Universal Time) -->
<html data-wf-domain="huynh-tan-phats-fantabulous-site.webflow.io" data-wf-page="62b8f507305c15ea8c9e4b97"
    data-wf-site="62aa7d13e81bc5858eb14b7e">

<head>
    <meta charset="utf-8" />
    <title>Project Page</title>
    <meta content="haha" property="og:title" />
    <meta content="haha" property="twitter:title" />
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <meta content="Webflow" name="generator" />
    <link
        href="https://uploads-ssl.webflow.com/62aa7d13e81bc5858eb14b7e/css/huynh-tan-phats-fantabulous-site.webflow.fcf87305a.css"
        rel="stylesheet" type="text/css" />
    <script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.26/webfont.js" type="text/javascript"></script>
    <script
        type="text/javascript">WebFont.load({ google: { families: ["Montserrat:100,100italic,200,200italic,300,300italic,400,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic"] } });</script>
    <!--[if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif]-->
    <script
        type="text/javascript">!function (o, c) { var n = c.documentElement, t = " w-mod-"; n.className += t + "js", ("ontouchstart" in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch") }(window, document);</script>
    <link href="https://uploads-ssl.webflow.com/img/favicon.ico" rel="shortcut icon" type="image/x-icon" />
    <link href="https://uploads-ssl.webflow.com/62aa7d13e81bc5858eb14b7e/62b0483852fa1b7b5fdeaf3a_internet.png"
        rel="apple-touch-icon" />
        <style>
            .w-webflow-badge {
                display: none !important;
            }
        </style>
</head>

<body class="body-2">
    <%
        ProjectDTO project = (ProjectDTO) request.getAttribute("ACTIVE_PROJECT");
        int proposalID = (int) request.getAttribute("PROPOSAL_ID");
        LocalDate localDate = LocalDate.now();
        SeekerDTO loginUser = (SeekerDTO) session.getAttribute("USER_LOGIN");
        
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
                            <div class="text-block-22">Find Work</div>
                        </div>
                        <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=Search Job By Name&search="
                                class="dropdown-link-nav w-dropdown-link">Find Work</a><a href="MainController?action=ViewProposal"
                                  class="dropdown-link-nav w-dropdown-link">Proposals</a></nav>
                    </div>
                    <div data-hover="true" data-delay="0" class="link-4 nav-link w-dropdown">
                        <div class="dropdown-toggle-3 w-dropdown-toggle">
                            <div class="text-block-22">My Job</div>
                            
                        </div>
                        <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewMyJob"
                                class="dropdown-moi-qua-troi-moi w-dropdown-link">My Job</a>
                                <a href="MainController?action=ViewContract"
                                class="dropdown-moi-qua-troi-moi w-dropdown-link">All Contracts</a>
                        </nav>
                    </div>
                </div><a href="#" class="link-block w-inline-block"><img
                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d693684f77e4900d5de82_send.png"
                        loading="lazy" alt="" class="image-15" /></a><a href="#" class="w-inline-block"><img
                        src="https://uploads-ssl.webflow.com/628aea177e2bdc5cebb3b655/628d69352ef8ea1801f37308_bell.png"
                        loading="lazy" alt="" /></a>
                <div class="navigation-button-wrapper">
                    <div data-hover="false" data-delay="0" class="w-dropdown">
                        <div class="dropdown-toggle w-dropdown-toggle"><img
                                src=<%= loginUser.getAvatar() %>
                                loading="lazy" width="90" alt="" class="avatar-img-nav" /></div>
                        <nav class="dropdown-list-2 w-dropdown-list"><a href="MainController?action=ViewSeekerProfile"
                                class="dropdown-link w-dropdown-link">My Profile</a>
                                <a href="MainController?action=ViewBalanceHirerSeeker&role=seeker"
                                class="dropdown-link w-dropdown-link">My Balance</a><a href="MainController?action=Logout"
                                class="dropdown-link w-dropdown-link">Log out</a></nav>
                    </div>
                </div>
            </div>
            <div class="menu-button w-nav-button">
                <div class="w-icon-nav-menu"></div>
            </div>
        </div>
    </div>
    <div class="div-block-50">
        <h1 class="heading-13">Active Job Detail</h1>
        <div class="div-block-30-copy">
            <div class="div-block-31">
                <h3 class="heading-10"><%= project.getProjectName() %></h3>
                <div class="text-block-34">Posted <%= localDate.getDayOfYear() - project.getCreatedDate().getDayOfYear()%> days ago</div>
                <div class="text-block-34"><%= project.getLocation() %></div>
                <div class="div-block-34">
                    <div class="div-block-35">
                        <div class="div-block-39">
                            <div class="text-block-38"><strong class="bold-text-2"><%= project.getHoursPerWeek() %> Hours per week</strong></div>
                        </div>
                        <div class="div-block-39">Hourly</div>
                    </div>
                    <div class="div-block-36">
                        <div class="div-block-39"><strong class="bold-text-3"><%= project.getDurationText() %></strong></div>
                        <div class="div-block-39">Project Length</div>
                    </div>
                    <div class="div-block-37">
                        <div class="div-block-39"><strong><%= project.getComplexity() %></strong></div>
                        <div class="div-block-39">Understanding</div>
                    </div>
                    <div class="div-block-38">
                        <div class="div-block-39"><strong class="bold-text-4"><%= project.getPaymentAmount() %>$</strong></div>
                        <div class="div-block-39">Budget</div>
                    </div>
                </div>
                <div class="div-block-42">
                    <p class="paragraph-2"><%= project.getDescription() %></p>
                </div>
                <h4 class="heading-11">Skill and Expertise</h4>
                <div class="div-block-40">
                    <div class="list-skill-copy">
                        
                        <%
                                            for (String skill : project.getSkillneed()) {
                                        %>
                                        <div class="skill-wrapper">
                                            <div class="text-block-26"><%= skill%></div>
                                        </div>
                                        <div style="width: 10px">
                                        </div>


                                        <%
                                            }
                                        %>
                    </div>
                </div>
            </div>
            <div class="div-block-32">
                <div class="div-block-41">
                    <h4 class="heading-12">About the Client</h4>
                    <div class="text-block-39"><strong>Company: Fsoft</strong></div>
                    <div class="text-block-39-copy">Viet Nam</div>
                    <div class="text-block-39"><strong>2 jobs posted</strong></div>
                    <div class="text-block-39-copy">The total number of Job Posted</div>
                    <div class="text-block-39">Member since 2022-05-22</div>
                </div>
                <div class="div-block-59"><a data-w-id="98f9af84-39b4-500c-98cf-505d5cf5e9b5" href="#"
                        class="button-5 w-button">Submit For Payment</a><a
                        data-w-id="366a6e82-bcfa-de97-1e39-2383d5fe37bc" href="#" class="button-6 w-button">Cancel This
                        Project</a></div>
            </div>
        </div>
    </div>
    <div style="display:none;opacity:0" class="submit-for-payment">
        <div class="div-block-60">
            <h3 class="heading-17">Submit for payment</h3>
            <div class="form-block w-form">
                <!-- dang sua code cho nay-->
                <form action="SubmitForPaymentController" method="post" enctype="multipart/form-data" id="email-form-3" name="email-form-3" data-name="Email Form 3" redirect="#" data-redirect="#"
                    method="get"><label for="name-3">Link</label><input name="link" type="text" class="w-input" maxlength="256"
                                                                    name="name-3" data-name="Name 3" placeholder="" id="name-3" required=""/>
                    <label
                        for="message">Message</label><input name="message" type="text" class="w-input" maxlength="256" name="email"
                              data-name="Email" placeholder="" id="message" required=""/>
                        <input type="file" name="file" style="display: block">
                        <input type="hidden" name="proposalID" value=<%= proposalID %>>
                        <input type="submit" value="Submit" 
                        data-wait="Please wait..." class="submit-button-4 w-button" /><a
                        data-w-id="dc566ad9-cfde-e623-d49c-404997a643f5" href="#" class="button-7 w-button">Cancel</a>
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
    <div style="display:none;opacity:0" class="cancel-this-project">
        <div class="div-block-60-copy">
            <h3 class="heading-17">Are you sure you want to cancel this project?</h3><a href="MainController?action=CancelProjectOfSeeker&proposalID=<%= proposalID %>"
                class="button-8 w-button">Yes</a><a data-w-id="1994efc5-3099-bb0c-929a-cb7828f38b84" href="#"
                class="button-9 w-button">No </a>
        </div>
    </div>
    <script src="https://d3e54v103j8qbb.cloudfront.net/js/jquery-3.5.1.min.dc5e7f18c8.js?site=62aa7d13e81bc5858eb14b7e"
        type="text/javascript" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
        crossorigin="anonymous"></script>
    <script src="https://uploads-ssl.webflow.com/62aa7d13e81bc5858eb14b7e/js/webflow.517b051cd.js"
        type="text/javascript"></script>
    <!--[if lte IE 9]><script src="//cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif]-->
</body>

</html>
